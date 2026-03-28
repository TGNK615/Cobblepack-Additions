package com.cobblepack.datagen;

import com.cobblepack.CobblepackAdditions;
import com.cobblepack.block.ModBlocks;
import com.cobblepack.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Map;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CobblepackAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        /* -------------------- ITEMS -------------------- */

        withExistingParent(ModItems.RED_APRICORN_PASTE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/paste/red_apricorn_paste");
        withExistingParent(ModItems.BLUE_APRICORN_PASTE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/paste/blue_apricorn_paste");
        withExistingParent(ModItems.YELLOW_APRICORN_PASTE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/paste/yellow_apricorn_paste");
        withExistingParent(ModItems.GREEN_APRICORN_PASTE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/paste/green_apricorn_paste");
        withExistingParent(ModItems.PINK_APRICORN_PASTE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/paste/pink_apricorn_paste");
        withExistingParent(ModItems.BLACK_APRICORN_PASTE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/paste/black_apricorn_paste");
        withExistingParent(ModItems.WHITE_APRICORN_PASTE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/paste/white_apricorn_paste");
        
        withExistingParent(ModItems.RED_APRICORN_BREW.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/brew/red_apricorn_brew");
        withExistingParent(ModItems.BLUE_APRICORN_BREW.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/brew/blue_apricorn_brew");
        withExistingParent(ModItems.YELLOW_APRICORN_BREW.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/brew/yellow_apricorn_brew");
        withExistingParent(ModItems.GREEN_APRICORN_BREW.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/brew/green_apricorn_brew");
        withExistingParent(ModItems.PINK_APRICORN_BREW.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/brew/pink_apricorn_brew");
        withExistingParent(ModItems.BLACK_APRICORN_BREW.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/brew/black_apricorn_brew");
        withExistingParent(ModItems.WHITE_APRICORN_BREW.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/apricorn/brew/white_apricorn_brew");

        withExistingParent(ModItems.GREAT_BALL_ALLOY.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/alloy/great_alloy");
        withExistingParent(ModItems.SPORT_BALL_ALLOY.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/alloy/sport_alloy");
        withExistingParent(ModItems.DUSK_BALL_ALLOY.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/alloy/dusk_alloy");
        withExistingParent(ModItems.LUXURY_BALL_ALLOY.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/alloy/luxury_alloy");
        withExistingParent(ModItems.ULTRA_BALL_ALLOY.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/alloy/ultra_alloy");
        withExistingParent(ModItems.TIMER_BALL_ALLOY.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/alloy/timer_alloy");
        withExistingParent(ModItems.REPEAT_BALL_ALLOY.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/alloy/repeat_alloy");
        withExistingParent(ModItems.QUICK_BALL_ALLOY.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/alloy/quick_alloy");

        withExistingParent(ModItems.GREAT_BALL_PLATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/plate/great_plate");
        withExistingParent(ModItems.SPORT_BALL_PLATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/plate/sport_plate");
        withExistingParent(ModItems.DUSK_BALL_PLATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/plate/dusk_plate");
        withExistingParent(ModItems.LUXURY_BALL_PLATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/plate/luxury_plate");
        withExistingParent(ModItems.ULTRA_BALL_PLATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/plate/ultra_plate");
        withExistingParent(ModItems.TIMER_BALL_PLATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/plate/timer_plate");
        withExistingParent(ModItems.REPEAT_BALL_PLATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/plate/repeat_plate");
        withExistingParent(ModItems.QUICK_BALL_PLATE.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/plate/quick_plate");
        
        withExistingParent(ModItems.GREAT_BALL_LID.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/lid/great_lid");
        withExistingParent(ModItems.SPORT_BALL_LID.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/lid/sport_lid");
        withExistingParent(ModItems.DUSK_BALL_LID.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/lid/dusk_lid");
        withExistingParent(ModItems.LUXURY_BALL_LID.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/lid/luxury_lid");
        withExistingParent(ModItems.ULTRA_BALL_LID.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/lid/ultra_lid");
        withExistingParent(ModItems.TIMER_BALL_LID.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/lid/timer_lid");
        withExistingParent(ModItems.REPEAT_BALL_LID.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/lid/repeat_lid");
        withExistingParent(ModItems.QUICK_BALL_LID.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/pokeball/lid/quick_lid");

        basicItem(ModItems.OIL.get());
        basicItem(ModItems.OIL_CONCENTRATE.get());
        basicItem(ModItems.REINFORCEMENT_PASTE.get());
    }
}
