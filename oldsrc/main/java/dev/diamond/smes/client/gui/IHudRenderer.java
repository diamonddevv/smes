package dev.diamond.smes.client.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;

public interface IHudRenderer {
    ArrayList<IHudRenderer> HUD_RENDERERS = new ArrayList<>();

    void onHudRender(DrawContext ctx, float tickDelta, MinecraftClient client, TextRenderer textRenderer);
}
