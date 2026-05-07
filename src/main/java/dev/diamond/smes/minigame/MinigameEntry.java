package dev.diamond.smes.minigame;

import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.diamond.smes.data.MinigameResourceLoader;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;

import java.util.List;

public class MinigameEntry {


    public static final Codec<MinigameEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            MinigameEntryDisplay.CODEC.fieldOf("display").forGetter(MinigameEntry::getVisuals),
            Minigame.CODEC.fieldOf("type").forGetter(MinigameEntry::getType),
            ExtraCodecs.JSON.fieldOf("settings").forGetter(MinigameEntry::getSettingsObject)
    ).apply(instance, MinigameEntry::new));



    private final MinigameEntryDisplay display;
    private final Minigame type;
    private final JsonElement settingsObject;

    public Identifier id;

    public MinigameEntry(MinigameEntryDisplay display, Minigame type, JsonElement settingsObject) {
        this.display = display;
        this.type = type;
        this.settingsObject = settingsObject;
    }


    public Identifier getId() {
        return id;
    }
    public MinigameEntryDisplay getVisuals() {
        return display;
    }
    public Minigame getType() {
        return type;
    }
    public JsonElement getSettingsObject() {
        return settingsObject;
    }


}
