package com.cobblepack.screen.custom;

import com.cobblepack.CobblepackAdditions;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AutoPressScreen extends AbstractContainerScreen<AutoPressMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(CobblepackAdditions.MOD_ID,"textures/gui/press/auto_press_gui.png");
    private static final ResourceLocation ARROW_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(CobblepackAdditions.MOD_ID,"textures/gui/arrow_progress.png");
    private static final ResourceLocation FUEL_GAUGE_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(CobblepackAdditions.MOD_ID,"textures/gui/fuel_gauge.png");

    public AutoPressScreen(AutoPressMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
        renderFuelGauge(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(ARROW_TEXTURE,x + 72, y + 35, 0, 0, menu.getScaledArrowProgress(), 16, 24, 16);
        }
    }


    private void renderFuelGauge(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isBurning()) {
            guiGraphics.blit(FUEL_GAUGE_TEXTURE, x + 78, y + 67, 0, 0, menu.getScaledFuel(), 5, 46, 5);
        }
    }


    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}