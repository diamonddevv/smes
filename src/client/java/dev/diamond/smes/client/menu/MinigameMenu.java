package dev.diamond.smes.client.menu;

import dev.diamond.smes.Smes;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class MinigameMenu extends Screen {

    private static final Identifier BACKGROUND = Smes.id("textures/gui/minigame_menu.png");
    private static final Component TITLE = Component.translatable("smes.ui.minigame.title");

    private final int imageW;
    private final int imageH;
    private final int titleLabelX;
    private final int titleLabelY;
    private int xo;
    private int yo;

    public MinigameMenu() {
        super(TITLE);
        this.imageW = 256;
        this.imageH = 256;

        this.titleLabelX = 8;
        this.titleLabelY = 6;
    }

    @Override
    protected void init() {
        super.init();

        this.xo = (this.width  - this.imageW) / 2;
        this.yo = (this.height - this.imageH) / 2;
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractRenderState(graphics, mouseX, mouseY, a);
        graphics.text(this.font, this.title, this.xo + this.titleLabelX, this.yo + this.titleLabelY, -12566464, false);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        graphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.xo, this.yo, 0.0F, 0.0F, this.imageW, this.imageH, 256, 256);
    }
}
