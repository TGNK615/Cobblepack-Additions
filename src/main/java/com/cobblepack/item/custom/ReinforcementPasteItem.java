package com.cobblepack.item.custom;

import com.cobblepack.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class ReinforcementPasteItem extends Item {
    public static final Map<Block, Block> REINFORCEABLE_MAP =
            Map.of(
                    Blocks.IRON_BLOCK, ModBlocks.PLATED_IRON_BLOCK.get(),
                    ModBlocks.PLATED_IRON_BLOCK.get(), ModBlocks.HEAVY_IRON_BLOCK.get(),
                    ModBlocks.HEAVY_IRON_BLOCK.get(), ModBlocks.REINFORCED_IRON_BLOCK.get(),
                    ModBlocks.REINFORCED_IRON_BLOCK.get(), ModBlocks.REINFORCED_ALLOY_BLOCK.get(),
                    ModBlocks.AUTO_PRESS.get(), ModBlocks.REINFORCED_AUTO_PRESS.get()
            );

    public ReinforcementPasteItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(REINFORCEABLE_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide) {
                level.setBlockAndUpdate(context.getClickedPos(), REINFORCEABLE_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().shrink(1);

                level.playSound(null, context.getClickedPos(), SoundEvents.SLIME_SQUISH, SoundSource.NEUTRAL);
            }
        }

        return super.useOn(context);
    }
}
