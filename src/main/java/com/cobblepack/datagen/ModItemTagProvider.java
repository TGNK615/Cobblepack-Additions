package com.cobblepack.datagen;

import com.cobblepack.CobblepackAdditions;
import com.cobblepack.item.ModItems;
import com.cobblepack.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CobblepackAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.APRICORN_PASTES)
                .add(
                        ModItems.RED_APRICORN_PASTE.get(),
                        ModItems.BLUE_APRICORN_PASTE.get(),
                        ModItems.YELLOW_APRICORN_PASTE.get(),
                        ModItems.GREEN_APRICORN_PASTE.get(),
                        ModItems.PINK_APRICORN_PASTE.get(),
                        ModItems.WHITE_APRICORN_PASTE.get(),
                        ModItems.BLACK_APRICORN_PASTE.get()
                );
    }
}

