package dev.diamond.smes.client.gui;

import dev.diamond.smes.math.SimpleVec2i;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public abstract class HudRenderTextIconImpl implements IHudRenderer {

    public abstract TextureWrapper getTexture();
    public abstract Text getText();
    public abstract SimpleVec2i getDrawPosition();

    public abstract boolean shouldDraw();

    @Override
    public void onHudRender(DrawContext ctx, float tickDelta, MinecraftClient client, TextRenderer textRenderer) {
        if (shouldDraw()) {
            ctx.drawTexture(getTexture().path(), getDrawPosition().getX(), getDrawPosition().getY(), getTexture().u(), getTexture().v(), getTexture().w(), getTexture().h());
            ctx.drawTextWithShadow(textRenderer, getText(), getDrawPosition().getX() + getTexture().w() + 10, getDrawPosition().getY() + getTexture().h() / 2, 0xff);
        }
    }
}
