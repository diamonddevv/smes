package dev.diamond.smes.mixin;

import dev.diamond.smes.client.gui.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    @Shadow @Final private MinecraftClient client;

    @Shadow public abstract TextRenderer getTextRenderer();

    @Inject(method = "render", at = @At("HEAD"))
    private void smes$drawHudElements(DrawContext ctx, float tickDelta, CallbackInfo ci) {
        if (!client.options.hudHidden) {
            IHudRenderer.HUD_RENDERERS.forEach(hr -> {
                hr.onHudRender(ctx, tickDelta, client, getTextRenderer());
            });
        }
    }

}
