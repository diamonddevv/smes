package dev.diamond.smes.client.menu;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class MinigameMenu extends Screen {

    private static final Component TITLE = Component.translatable("smes.ui.minigame.title");

    public MinigameMenu() {
        super(TITLE);
    }

    @Override
    protected void init() {
        super.init();


    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractRenderState(graphics, mouseX, mouseY, a);

        graphics.text(this.font, this.title.getString(), 40, 40 - this.font.lineHeight - 10, 0xFFFFFFFF, true);

    }
}
