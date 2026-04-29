package dev.diamond.smes.registry;

import dev.diamond.smes.SmesMod;
import dev.diamond.smes.minigame.Minigame;
import net.diamonddev.libgenetics.common.api.v1.interfaces.RegistryInitializer;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.registry.Registry;

public class InitRegistries implements RegistryInitializer {
    public static Registry<Minigame> MINIGAMES;


    @Override
    public void register() {
        MINIGAMES = FabricRegistryBuilder.createSimple(
                Minigame.class,
                SmesMod.id("minigames")
        ).buildAndRegister();

    }
}
