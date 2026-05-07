package dev.diamond.smes.minigames.test;

import com.mojang.serialization.Codec;
import dev.diamond.smes.Smes;
import dev.diamond.smes.minigame.Minigame;
import dev.diamond.smes.minigame.Setting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;

public class TestMinigame extends Minigame {

    public static final Setting<Integer> TIME_SECONDS = new Setting<>("time_seconds", Codec.INT, 300, Integer.class);
    public static final Setting<Component> COMPONENT_SETTING = new Setting<>("name", ComponentSerialization.CODEC, Component.empty(), Component.class);

    @Override
    public void init() {
        super.init();

        int i = getSettingValue(TIME_SECONDS);
        Smes.LOGGER.info(String.valueOf(i));

        Smes.LOGGER.info(getSettingValue(COMPONENT_SETTING).getString());
    }

    @Override
    public Setting<?>[] getSettings() {
        return new Setting[] {
                TIME_SECONDS,
                COMPONENT_SETTING
        };
    }
}
