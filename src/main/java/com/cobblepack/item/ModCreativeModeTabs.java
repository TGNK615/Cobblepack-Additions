package com.cobblepack.item;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblepack.CobblepackAdditions;
import com.cobblepack.block.ModBlocks;
import com.cobblepack.util.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CobblepackAdditions.MOD_ID);
    
    public static final Supplier<CreativeModeTab> PROCESSED_APRICORN_TAB = CREATIVE_MODE_TAB.register("processed_apricorn_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RED_APRICORN_PASTE.get()))
                    .title(Component.translatable("creativetab.cpack_additions.processed_apricorn"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RED_APRICORN_PASTE);
                        output.accept(ModItems.BLUE_APRICORN_PASTE);
                        output.accept(ModItems.YELLOW_APRICORN_PASTE);
                        output.accept(ModItems.GREEN_APRICORN_PASTE);
                        output.accept(ModItems.PINK_APRICORN_PASTE);
                        output.accept(ModItems.BLACK_APRICORN_PASTE);
                        output.accept(ModItems.WHITE_APRICORN_PASTE);
                        
                        output.accept(ModItems.RED_APRICORN_BREW);
                        output.accept(ModItems.BLUE_APRICORN_BREW);
                        output.accept(ModItems.YELLOW_APRICORN_BREW);
                        output.accept(ModItems.GREEN_APRICORN_BREW);
                        output.accept(ModItems.PINK_APRICORN_BREW);
                        output.accept(ModItems.BLACK_APRICORN_BREW);
                        output.accept(ModItems.WHITE_APRICORN_BREW);
                    }).build());

    public static final Supplier<CreativeModeTab> MACHINERY = CREATIVE_MODE_TAB.register("machinery_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OIL.get()))
                    .title(Component.translatable("creativetab.cpack_additions.machinery"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.AUTO_PRESS);
                        output.accept(ModBlocks.REINFORCED_AUTO_PRESS);
                        output.accept(ModItems.REINFORCEMENT_PASTE);
                        output.accept(ModItems.OIL);
                        output.accept(ModItems.OIL_CONCENTRATE);
                        output.accept(ModItems.REINFORCED_ALLOY);
                        output.accept(ModItems.CARBON_FIBER);
                        output.accept(ModItems.CARBON_STEEL);
                    }).build());

    public static final Supplier<CreativeModeTab> BALL_PARTS = CREATIVE_MODE_TAB.register("ball_parts",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GREAT_BALL_ALLOY.get()))
                    .title(Component.translatable("creativetab.cpack_additions.ball_parts"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GREAT_BALL_ALLOY.get());
                        output.accept(ModItems.SPORT_BALL_ALLOY.get());
                        output.accept(ModItems.DUSK_BALL_ALLOY.get());
                        output.accept(ModItems.LUXURY_BALL_ALLOY.get());
                        output.accept(ModItems.ULTRA_BALL_ALLOY.get());
                        output.accept(ModItems.TIMER_BALL_ALLOY.get());
                        output.accept(ModItems.REPEAT_BALL_ALLOY.get());
                        output.accept(ModItems.QUICK_BALL_ALLOY.get());

                        output.accept(ModItems.GREAT_BALL_PLATE.get());
                        output.accept(ModItems.SPORT_BALL_PLATE.get());
                        output.accept(ModItems.DUSK_BALL_PLATE.get());
                        output.accept(ModItems.LUXURY_BALL_PLATE.get());
                        output.accept(ModItems.ULTRA_BALL_PLATE.get());
                        output.accept(ModItems.TIMER_BALL_PLATE.get());
                        output.accept(ModItems.REPEAT_BALL_PLATE.get());
                        output.accept(ModItems.QUICK_BALL_PLATE.get());

                        output.accept(ModItems.GREAT_BALL_LID.get());
                        output.accept(ModItems.SPORT_BALL_LID.get());
                        output.accept(ModItems.DUSK_BALL_LID.get());
                        output.accept(ModItems.LUXURY_BALL_LID.get());
                        output.accept(ModItems.ULTRA_BALL_LID.get());
                        output.accept(ModItems.TIMER_BALL_LID.get());
                        output.accept(ModItems.REPEAT_BALL_LID.get());
                        output.accept(ModItems.QUICK_BALL_LID.get());
                    }).build());
    
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
