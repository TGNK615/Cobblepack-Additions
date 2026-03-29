package com.cobblepack.block.entity;

import com.cobblepack.item.ModItems;
import com.cobblepack.screen.custom.ReinforcedAutoPressMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class ReinforcedAutoPressBlockEntity extends AbstractAutoPressBlockEntity {

    public ReinforcedAutoPressBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntites.REINFORCED_AUTO_PRESS_BE.get(), pos, state);
    }

    @Override
    protected boolean hasRecipe() {

        ItemStack input = itemHandler.getStackInSlot(INPUT_SLOT);
        ItemStack output = itemHandler.getStackInSlot(OUTPUT_SLOT);

        if (input.getItem() != ModItems.GREAT_BALL_ALLOY.get() || input.getCount() < 5) {
            return false;
        }

        if (output.isEmpty()) return true;
        if (!output.is(ModItems.GREAT_BALL_PLATE.get())) return false;

        return output.getCount() + 3 <= output.getMaxStackSize();
    }

    @Override
    protected int getOutputSlot() {
        return OUTPUT_SLOT;
    }

    @Override
    protected void craftItem() {
        ItemStack input = itemHandler.getStackInSlot(INPUT_SLOT);
        ItemStack output = itemHandler.getStackInSlot(OUTPUT_SLOT);

        input.shrink(5);

        if (output.isEmpty()) {
            itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(ModItems.GREAT_BALL_PLATE.get(), 3));
        } else {
            output.grow(3);
        }
    }

    @Override
    protected int getMaxProgress() {
        return 200;
    }

    @Override
    protected int getMaxBurnTime() {
        return 1600;
    }

    @Override
    protected Component getMachineName() {
        return Component.translatable("block.cpack_additions.reinforced_auto_press");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new ReinforcedAutoPressMenu(id, inventory, this, this.data);
    }
}
