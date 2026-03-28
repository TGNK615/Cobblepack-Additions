package com.cobblepack.block;

import com.cobblepack.CobblepackAdditions;
import com.cobblepack.block.custom.AutoPressBlock;
import com.cobblepack.block.custom.ReinforcedAutoPressBlock;
import com.cobblepack.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS
            = DeferredRegister.createBlocks(CobblepackAdditions.MOD_ID);

    public static final DeferredBlock<Block> PLATED_IRON_BLOCK = registerBlock("plated_iron_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> HEAVY_IRON_BLOCK = registerBlock("heavy_iron_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(6.0f, 7.0f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> REINFORCED_IRON_BLOCK = registerBlock("reinforced_iron_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(6.0f, 7.0f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> REINFORCED_ALLOY_BLOCK = registerBlock("reinforced_alloy_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(7.0f, 8.0f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> AUTO_PRESS = registerBlock("auto_press",
            () -> new AutoPressBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> REINFORCED_AUTO_PRESS = registerBlock("reinforced_auto_press",
            () -> new ReinforcedAutoPressBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
