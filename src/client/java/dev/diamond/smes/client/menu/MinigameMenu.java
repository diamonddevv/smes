package dev.diamond.smes.client.menu;

import dev.diamond.smes.Smes;
import dev.diamond.smes.minigame.MinigameEntryDisplay;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.SpriteIconButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import java.util.List;

public class MinigameMenu extends Screen {

    private static final Identifier BACKGROUND = Smes.id("textures/gui/minigame_menu.png");

    private static final Identifier SPRITE_SCROLL_BUTTON_LEFT = Smes.idmc("icon/left.png");
    private static final Identifier SPRITE_SCROLL_BUTTON_RIGHT = Smes.idmc("icon/right.png");


    private static final Component TITLE = Component.translatable("smes.ui.minigame.title");

    private static final int IMAGE_WIDTH = 256;
    private static final int IMAGE_HEIGHT = 256-48;
    private static final int TITLE_OFFSET_X = 8;
    private static final int TITLE_OFFSET_Y = 6;
    private static final int GAME_IMAGE_OFFSET_X = 64;
    private static final int GAME_IMAGE_OFFSET_Y = 48;
    private static final int GAME_IMAGE_W = 128;
    private static final int GAME_IMAGE_H = 64;
    private static final int SCROLL_BUTTON_OFFSET_X = 10;

    private final List<MinigameEntryDisplay> displays;
    private int displayIndex;
    private int xo;
    private int yo;

    private Button leftScrollButton;
    private Button rightScrollButton;

    public MinigameMenu(List<MinigameEntryDisplay> displays) {
        super(TITLE);

        this.displays = displays;
        this.displayIndex = 0;
    }

    @Override
    protected void init() {
        super.init();

        this.xo = (this.width  - IMAGE_WIDTH) / 2;
        this.yo = (this.height - IMAGE_HEIGHT) / 2;

        this.leftScrollButton = this.addRenderableWidget(SpriteIconButton
                .builder(Component.translatable("smes.ui.minigame.left"), btn -> {
                    this.displayIndex -= 1;
                    this.wrapDisplayIndex();
                    }, true)
                .sprite(SPRITE_SCROLL_BUTTON_LEFT, 16, 16)
                .size(16, 16)
                .build()
        );
        this.leftScrollButton.setPosition(
                this.xo + GAME_IMAGE_OFFSET_X - 16 - SCROLL_BUTTON_OFFSET_X,
                this.yo + GAME_IMAGE_OFFSET_Y - 8 + (GAME_IMAGE_H / 2)
        );


        this.rightScrollButton = this.addRenderableWidget(SpriteIconButton
                .builder(Component.translatable("smes.ui.minigame.right"), btn -> {
                    this.displayIndex += 1;
                    this.wrapDisplayIndex();
                }, true)
                .sprite(SPRITE_SCROLL_BUTTON_RIGHT, 16, 16)
                .size(16, 16)
                .build()
        );
        this.rightScrollButton.setPosition(
                this.xo + GAME_IMAGE_OFFSET_X + SCROLL_BUTTON_OFFSET_X + GAME_IMAGE_W,
                this.yo + GAME_IMAGE_OFFSET_Y - 8 + (GAME_IMAGE_H / 2)
        );

    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractRenderState(graphics, mouseX, mouseY, a);
        graphics.text(this.font, this.title, this.xo + TITLE_OFFSET_X, this.yo + TITLE_OFFSET_Y, -12566464, false);

        this.drawGame(graphics);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        graphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.xo, this.yo, 0.0f, 0.0f, IMAGE_WIDTH, IMAGE_HEIGHT, 256, 256);
    }


    public void drawGame(GuiGraphicsExtractor graphics) {
        if (!this.displays.isEmpty()) {
            MinigameEntryDisplay display = this.displays.get(this.displayIndex);

            graphics.blit(RenderPipelines.GUI_TEXTURED, display.getImagePath(), this.xo + GAME_IMAGE_OFFSET_X, this.yo + GAME_IMAGE_OFFSET_Y, 0f, 0f, GAME_IMAGE_W, GAME_IMAGE_H, GAME_IMAGE_W, GAME_IMAGE_H);

            int w = this.font.width(display.getTitle());

            graphics.text(this.font, display.getTitle(), this.xo + GAME_IMAGE_OFFSET_X + (GAME_IMAGE_W - w) / 2, this.yo + GAME_IMAGE_OFFSET_Y + GAME_IMAGE_H + TITLE_OFFSET_Y, -12566464, false);
        }
    }

    private void wrapDisplayIndex() {
        if (this.displayIndex < 0) {
            this.displayIndex = this.displays.size() - 1;
        } else if (this.displayIndex >= this.displays.size()) {
            this.displayIndex = 0;
        }
    }
}
