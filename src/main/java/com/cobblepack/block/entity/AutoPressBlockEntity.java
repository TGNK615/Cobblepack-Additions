package com.cobblepack.block.entity;

import com.cobblepack.recipe.AutoPressRecipe;
import com.cobblepack.recipe.AutoPressRecipeInput;
import com.cobblepack.recipe.ModRecipes;
import com.cobblepack.screen.custom.AutoPressMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class AutoPressBlockEntity extends AbstractAutoPressBlockEntity {

    public AutoPressBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntites.AUTO_PRESS_BE.get(), pos, state);
    }

    @Override
    protected boolean hasRecipe() {
        Optional<RecipeHolder<AutoPressRecipe>> recipe = getCurrentRecipe();

        System.out.println("Recipe present: " + recipe.isPresent());

        if (recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().output();
        return canInsertAmount(output.getCount()) && canInsertItem(output);
    }

    private Optional<RecipeHolder<AutoPressRecipe>> getCurrentRecipe() {
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.AUTO_PRESS_TYPE.get(), new AutoPressRecipeInput(itemHandler.getStackInSlot(INPUT_SLOT)), level);
    }

    @Override
    protected ItemStack getRecipeOutput(RecipeHolder<? extends Recipe<?>> recipeHolder) {
        return ((AutoPressRecipe) recipeHolder.value()).output();
    }

    @Override
    protected int getOutputSlot() {
        return OUTPUT_SLOT;
    }

    @Override
    protected void craftItem() {
        Optional<RecipeHolder<AutoPressRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        itemHandler.extractItem(INPUT_SLOT, recipe.get().value().inputItem().getItems()[1].getCount(), false);
        itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(),
                itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
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
        return Component.translatable("block.cpack_additions.auto_press");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new AutoPressMenu(id, inventory, this, this.data);
    }
}
