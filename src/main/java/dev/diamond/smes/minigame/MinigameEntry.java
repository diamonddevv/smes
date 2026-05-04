package dev.diamond.smes.minigame;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.diamond.smes.data.MinigameResourceLoader;

import java.util.List;

public class MinigameEntry {

    public static final Codec<MinigameEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            MinigameEntryDisplay.CODEC.fieldOf("display").forGetter(MinigameEntry::getVisuals)
    ).apply(instance, MinigameEntry::new));



    private final MinigameEntryDisplay display;

    public MinigameEntry(MinigameEntryDisplay display) {
        this.display = display;
    }

    public MinigameEntryDisplay getVisuals() {
        return display;
    }


    public static List<MinigameEntryDisplay> getDisplays() {
        return MinigameResourceLoader.MINIGAMES.stream().map(MinigameEntry::getVisuals).toList();
    }
}
