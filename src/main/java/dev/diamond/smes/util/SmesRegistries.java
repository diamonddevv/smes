package dev.diamond.smes.util;

import dev.diamond.smes.Smes;
import dev.diamond.smes.minigame.Minigame;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class SmesRegistries {
    public static ResourceKey<Registry<Minigame>> MINIGAME_TYPES_KEY;
    public static Registry<Minigame> MINIGAMES;

    public static void register() {
        MINIGAME_TYPES_KEY = of("minigame_types");
        MINIGAMES = create(MINIGAME_TYPES_KEY);

    }


    private static <T> Registry<T> create(ResourceKey<Registry<T>> key) {
        return FabricRegistryBuilder.create(key).buildAndRegister();
    }
    private static <T> ResourceKey<Registry<T>> of(String path) {
        return ResourceKey.createRegistryKey(Smes.id(path));
    }
}
