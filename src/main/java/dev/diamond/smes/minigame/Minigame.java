package dev.diamond.smes.minigame;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import dev.diamond.smes.util.SmesRegistries;

import java.util.HashMap;

public abstract class Minigame {

    public static final Codec<Minigame> CODEC = SmesRegistries.MINIGAMES.byNameCodec();

    private final HashMap<Setting<?>, Object> settingsMap;

    public Minigame() {
        this.settingsMap = new HashMap<>();
    }

    public abstract Setting<?>[] getSettings();


    public void init() {
    }

    public <T> T getSettingValue(Setting<T> setting) {
        return setting.clazz().cast(settingsMap.get(setting));
    }

    public void decodeSettings(JsonObject obj) {
        this.settingsMap.clear();

        for (Setting<?> setting : getSettings()) {
            Object o = setting.decodeFrom(obj);
            this.settingsMap.put(setting, o);
        }
    }

    public JsonObject encodeSettings() {

        JsonObject obj = new JsonObject();

        this.settingsMap.forEach((setting, value) -> {
            setting.encodeTo(obj, value);
        });

        return obj;
    }
}
