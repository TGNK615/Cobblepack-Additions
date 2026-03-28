package com.cobblepack.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record AutoPressRecipe(Ingredient inputItem, int inputCount, ItemStack output) implements Recipe<AutoPressRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(AutoPressRecipeInput input, Level level) {
        ItemStack stack = input.getItem(1);

        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(stack) && stack.getCount() >= inputCount;
    }

    @Override
    public ItemStack assemble(AutoPressRecipeInput autoPressRecipeInput, HolderLookup.Provider registries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.AUTO_PRESS_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.AUTO_PRESS_TYPE.get();
    }

    public static class Serializer implements  RecipeSerializer<AutoPressRecipe> {
        public static final MapCodec<AutoPressRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(AutoPressRecipe::inputItem),
                Codec.INT.optionalFieldOf("input_count", 1).forGetter(AutoPressRecipe::inputCount),
                ItemStack.CODEC.fieldOf("result").forGetter(AutoPressRecipe::output)
        ).apply(inst, AutoPressRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, AutoPressRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, AutoPressRecipe::inputItem,
                        ByteBufCodecs.VAR_INT, AutoPressRecipe::inputCount,
                        ItemStack.STREAM_CODEC, AutoPressRecipe::output,
                        AutoPressRecipe::new
                );

        @Override
        public MapCodec<AutoPressRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, AutoPressRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
