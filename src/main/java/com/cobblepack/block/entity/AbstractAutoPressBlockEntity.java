package com.cobblepack.block.entity;

import com.cobblepack.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractAutoPressBlockEntity extends BlockEntity implements MenuProvider {

    public final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    protected static final int FUEL_SLOT = 0;
    protected static final int INPUT_SLOT = 1;
    protected static final int OUTPUT_SLOT = 2;

    protected int progress = 0;
    protected int burnDuration = 0;

    protected int fuelCounter = 0;
    protected final int fuelChecker = 20;

    protected final ContainerData data;

    public AbstractAutoPressBlockEntity(net.minecraft.world.level.block.entity.BlockEntityType<?> type,
                                        BlockPos pos,
                                        BlockState state) {
        super(type, pos, state);

        this.data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> progress;
                    case 1 -> getMaxProgress();
                    case 2 -> burnDuration;
                    case 3 -> getMaxBurnTime();
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0 -> progress = value;
                    case 2 -> burnDuration = value;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    // -------------------------
    // ABSTRACT METHODS
    // -------------------------

    protected abstract boolean hasRecipe();

    protected abstract ItemStack getRecipeOutput(RecipeHolder<? extends Recipe<?>> recipeHolder);

    protected abstract int getOutputSlot();

    protected abstract void craftItem();

    protected abstract int getMaxProgress();

    protected abstract int getMaxBurnTime();

    protected abstract Component getMachineName();

    @Nullable
    protected abstract AbstractContainerMenu createMenu(int id, Inventory inventory);

    // -------------------------
    // LOGIC
    // -------------------------

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide()) return;

        fuelCounter++;
        if (fuelCounter >= fuelChecker) {
            fuelCounter = 0;

            ItemStack fuelStack = itemHandler.getStackInSlot(FUEL_SLOT);
            int fuelValue = getFuelValue(fuelStack);

            if (!fuelStack.isEmpty() && fuelValue > 0 && burnDuration < getMaxBurnTime()) {
                burnDuration = Math.min(getMaxBurnTime(), burnDuration + fuelValue);
                fuelStack.shrink(1);
                setChanged(level, pos, state);
            }
        }

        if (!hasRecipe()) {
            progress = 0;
            return;
        }

        if (burnDuration <= 0) {
            progress = 0;
            return;
        }

        progress++;
        burnDuration--;

        if (progress >= getMaxProgress()) {
            craftItem();
            progress = 0;
        }

        setChanged(level, pos, state);
    }

    protected boolean canInsertAmount(int count) {
        ItemStack stack = itemHandler.getStackInSlot(getOutputSlot());

        int maxCount = stack.isEmpty() ? 64 : stack.getMaxStackSize();
        int currentCount = stack.getCount();

        return maxCount >= currentCount + count;
    }

    protected boolean canInsertItem(ItemStack output) {
        ItemStack stack = itemHandler.getStackInSlot(getOutputSlot());

        return stack.isEmpty() || stack.getItem() == output.getItem();
    }

    protected int getFuelValue(ItemStack stack) {
        if (stack.is(ModItems.OIL)) return 200;
        if (stack.is(ModItems.OIL_CONCENTRATE)) return 400;
        return 0;
    }

    // -------------------------
    // UTILITY
    // -------------------------

    public void drops() {
        if (level == null) return;

        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(level, worldPosition, inventory);
    }

    public float getFuelProgress() {
        return (float) burnDuration / (float) getMaxBurnTime();
    }

    @Override
    public Component getDisplayName() {
        return getMachineName();
    }

    // -------------------------
    // SAVE / LOAD
    // -------------------------

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("progress", progress);
        tag.putInt("burn_duration", burnDuration);

        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        progress = tag.getInt("progress");
        burnDuration = tag.getInt("burn_duration");
    }

    // -------------------------
    // MENU
    // -------------------------

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return createMenu(id, inventory);
    }

    // -------------------------
    // SYNC
    // -------------------------

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
