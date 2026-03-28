package com.cobblepack.datagen;

import com.cobblepack.CobblepackAdditions;
import com.cobblepack.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CobblepackAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PLATED_IRON_BLOCK.get())
                .add(ModBlocks.HEAVY_IRON_BLOCK.get())
                .add(ModBlocks.REINFORCED_IRON_BLOCK.get())
                .add(ModBlocks.REINFORCED_ALLOY_BLOCK.get())
                .add(ModBlocks.AUTO_PRESS.get())
                .add(ModBlocks.REINFORCED_AUTO_PRESS.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PLATED_IRON_BLOCK.get())
                .add(ModBlocks.HEAVY_IRON_BLOCK.get())
                .add(ModBlocks.AUTO_PRESS.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.REINFORCED_IRON_BLOCK.get())
                .add(ModBlocks.REINFORCED_ALLOY_BLOCK.get())
                .add(ModBlocks.REINFORCED_AUTO_PRESS.get());
    }
}
