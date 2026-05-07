package dev.diamond.smes.minigame;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import dev.diamond.smes.Smes;

public record Setting<T>(String name, Codec<T> codec, T def, Class<T> clazz) {
    public T decodeFrom(JsonObject object) {
        T value = def();
        if (object.has(name())) {
            JsonElement field = object.get(name());
            value = codec()
                    .parse(JsonOps.INSTANCE, field)
                    .resultOrPartial(Smes.LOGGER::error)
                    .orElseThrow();
        }
        return value;
    }


    public void encodeTo(JsonObject obj, Object value) {
        JsonElement element = codec()
                .encodeStart(JsonOps.INSTANCE, clazz().cast(value))
                .resultOrPartial(Smes.LOGGER::error)
                .orElseThrow();
        obj.add(name(), element);
    }


}
