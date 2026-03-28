package com.cobblepack.datagen;

import com.cobblepack.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.HEAVY_IRON_BLOCK.get());
        dropSelf(ModBlocks.PLATED_IRON_BLOCK.get());
        dropSelf(ModBlocks.REINFORCED_IRON_BLOCK.get());
        dropSelf(ModBlocks.REINFORCED_ALLOY_BLOCK.get());

        dropSelf(ModBlocks.AUTO_PRESS.get());
        dropSelf(ModBlocks.REINFORCED_AUTO_PRESS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
