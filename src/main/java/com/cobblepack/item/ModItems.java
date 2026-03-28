package com.cobblepack.item;

import com.cobblepack.CobblepackAdditions;
import com.cobblepack.item.custom.ReinforcementPasteItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS
            = DeferredRegister.createItems(CobblepackAdditions.MOD_ID);

    public static final DeferredItem<Item> REINFORCEMENT_PASTE = ITEMS.register("reinforcement_paste",
            () -> new ReinforcementPasteItem(new Item.Properties().stacksTo(64)));

    public static final DeferredItem<Item> OIL = ITEMS.register("oil",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OIL_CONCENTRATE = ITEMS.register("oil_concentrate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RED_APRICORN_PASTE = ITEMS.register("red_apricorn_paste",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLUE_APRICORN_PASTE = ITEMS.register("blue_apricorn_paste",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_APRICORN_PASTE = ITEMS.register("yellow_apricorn_paste",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREEN_APRICORN_PASTE = ITEMS.register("green_apricorn_paste",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PINK_APRICORN_PASTE = ITEMS.register("pink_apricorn_paste",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLACK_APRICORN_PASTE = ITEMS.register("black_apricorn_paste",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WHITE_APRICORN_PASTE = ITEMS.register("white_apricorn_paste",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RED_APRICORN_BREW = ITEMS.register("red_apricorn_brew",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLUE_APRICORN_BREW = ITEMS.register("blue_apricorn_brew",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_APRICORN_BREW = ITEMS.register("yellow_apricorn_brew",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREEN_APRICORN_BREW = ITEMS.register("green_apricorn_brew",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PINK_APRICORN_BREW = ITEMS.register("pink_apricorn_brew",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLACK_APRICORN_BREW = ITEMS.register("black_apricorn_brew",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WHITE_APRICORN_BREW = ITEMS.register("white_apricorn_brew",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GREAT_BALL_ALLOY = ITEMS.register("great_alloy",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPORT_BALL_ALLOY = ITEMS.register("sport_alloy",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUSK_BALL_ALLOY = ITEMS.register("dusk_alloy",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LUXURY_BALL_ALLOY = ITEMS.register("luxury_alloy",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ULTRA_BALL_ALLOY = ITEMS.register("ultra_alloy",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIMER_BALL_ALLOY = ITEMS.register("timer_alloy",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> REPEAT_BALL_ALLOY = ITEMS.register("repeat_alloy",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> QUICK_BALL_ALLOY = ITEMS.register("quick_alloy",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GREAT_BALL_PLATE = ITEMS.register("great_plate",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPORT_BALL_PLATE = ITEMS.register("sport_plate",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUSK_BALL_PLATE = ITEMS.register("dusk_plate",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LUXURY_BALL_PLATE = ITEMS.register("luxury_plate",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ULTRA_BALL_PLATE = ITEMS.register("ultra_plate",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIMER_BALL_PLATE = ITEMS.register("timer_plate",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> REPEAT_BALL_PLATE = ITEMS.register("repeat_plate",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> QUICK_BALL_PLATE = ITEMS.register("quick_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GREAT_BALL_LID = ITEMS.register("great_lid",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPORT_BALL_LID = ITEMS.register("sport_lid",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUSK_BALL_LID = ITEMS.register("dusk_lid",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LUXURY_BALL_LID = ITEMS.register("luxury_lid",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ULTRA_BALL_LID = ITEMS.register("ultra_lid",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIMER_BALL_LID = ITEMS.register("timer_lid",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> REPEAT_BALL_LID = ITEMS.register("repeat_lid",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> QUICK_BALL_LID = ITEMS.register("quick_lid",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> REINFORCED_ALLOY = ITEMS.register("reinforced_alloy",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CARBON_STEEL = ITEMS.register("carbon_steel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARBON_FIBER = ITEMS.register("carbon_fiber",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
