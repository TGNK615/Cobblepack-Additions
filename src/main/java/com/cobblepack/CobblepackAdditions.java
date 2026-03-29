package com.cobblepack;

import com.cobblepack.recipes.ModRecipes;
import com.cobblepack.block.ModBlocks;
import com.cobblepack.block.entity.ModBlockEntites;
import com.cobblepack.item.ModCreativeModeTabs;
import com.cobblepack.item.ModItems;
import com.cobblepack.screen.ModMenuTypes;
import com.cobblepack.screen.custom.AutoPressScreen;
import com.cobblepack.screen.custom.ReinforcedAutoPressScreen;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(CobblepackAdditions.MOD_ID)
public class CobblepackAdditions {
    public static final String MOD_ID = "cpack_additions";

    public static final Logger LOGGER = LogUtils.getLogger();

    public CobblepackAdditions(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::registerScreens); // MOD bus (correct)

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModBlockEntites.register(modEventBus);
        ModRecipes.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.PLATED_IRON_BLOCK);
            event.accept(ModBlocks.HEAVY_IRON_BLOCK);
            event.accept(ModBlocks.REINFORCED_IRON_BLOCK);
            event.accept(ModBlocks.REINFORCED_ALLOY_BLOCK);
        }
    }

    private void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.AUTO_PRESS_MENU.get(), AutoPressScreen::new);
        event.register(ModMenuTypes.REINFORCED_AUTO_PRESS_MENU.get(), ReinforcedAutoPressScreen::new);
    }
}
