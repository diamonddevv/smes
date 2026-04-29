package dev.diamond.smes.registry;

import dev.diamond.smes.SmesMod;
import dev.diamond.smes.minigame.game.TestMinigame;
import net.diamonddev.libgenetics.common.api.v1.interfaces.RegistryInitializer;
import net.minecraft.registry.Registry;

public class InitMinigames implements RegistryInitializer {

    public static TestMinigame TEST = new TestMinigame();

    @Override
    public void register() {
        Registry.register(InitRegistries.MINIGAMES, SmesMod.id("test"), TEST);
    }
}
