package dev.diamond.smes.mixin;

import dev.diamond.smes.minigame.MinigameManager;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

    @Shadow private float tickTime;

    @Inject(method = "tick", at = @At("TAIL"))
    public void smes$tick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        MinigameManager.getInstance().tick(this.tickTime);
    }
}
