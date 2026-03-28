package com.cobblepack.datagen;

import com.cobblepack.CobblepackAdditions;
import com.cobblepack.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CobblepackAdditions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PLATED_IRON_BLOCK);
        blockWithItem(ModBlocks.HEAVY_IRON_BLOCK);
        blockWithItem(ModBlocks.REINFORCED_IRON_BLOCK);
        blockWithItem(ModBlocks.REINFORCED_ALLOY_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
