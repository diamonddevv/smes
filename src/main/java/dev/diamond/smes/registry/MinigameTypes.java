package dev.diamond.smes.registry;

import dev.diamond.smes.Smes;
import dev.diamond.smes.minigames.test.TestMinigame;
import dev.diamond.smes.util.SmesRegistries;
import net.minecraft.core.Registry;

public class MinigameTypes {

    public static TestMinigame TEST = new TestMinigame();

    public static void register() {
        Registry.register(SmesRegistries.MINIGAMES, Smes.id("test"), TEST);
    }

}
