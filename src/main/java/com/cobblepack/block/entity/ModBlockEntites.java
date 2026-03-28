package com.cobblepack.block.entity;

import com.cobblepack.CobblepackAdditions;
import com.cobblepack.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntites {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CobblepackAdditions.MOD_ID);

    public static final Supplier<BlockEntityType<AutoPressBlockEntity>> AUTO_PRESS_BE =
            BLOCK_ENTITIES.register("auto_press_be", () -> BlockEntityType.Builder.of(
                    AutoPressBlockEntity::new, ModBlocks.AUTO_PRESS.get()).build(null));
    public static final Supplier<BlockEntityType<ReinforcedAutoPressBlockEntity>> REINFORCED_AUTO_PRESS_BE =
            BLOCK_ENTITIES.register("reinforced_auto_press_be", () -> BlockEntityType.Builder.of(
                    ReinforcedAutoPressBlockEntity::new, ModBlocks.REINFORCED_AUTO_PRESS.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}