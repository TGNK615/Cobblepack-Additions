package com.cobblepack.util;

import com.cobblepack.CobblepackAdditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CobblepackAdditions.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MACHINE_FUELS = createTag("machine_fuels");

        public static final TagKey<Item> BALL_ALLOYS = createTag("ball_alloys");
        public static final TagKey<Item> PLATES = createTag("plates");
        public static final TagKey<Item> BALL_LIDS = createTag("ball_lids");

        public static final TagKey<Item> APRICORN_PASTES = createTag("apricorn_pastes");
        public static final TagKey<Item> APRICORN_BREWS = createTag("apricorn_brews");


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CobblepackAdditions.MOD_ID, name));
        }
    }
}