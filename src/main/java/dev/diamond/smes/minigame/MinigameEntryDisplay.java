package dev.diamond.smes.minigame;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;

import java.util.List;

public class MinigameEntryDisplay {

    public static final Codec<MinigameEntryDisplay> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ComponentSerialization.CODEC.fieldOf("title").forGetter(MinigameEntryDisplay::getTitle),
            Identifier.CODEC.fieldOf("image").forGetter(MinigameEntryDisplay::getImagePath)
    ).apply(instance, MinigameEntryDisplay::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, List<MinigameEntryDisplay>> STREAM_CODEC_LIST = ByteBufCodecs.fromCodecWithRegistries(CODEC.listOf());


    private final Component title;
    private final Identifier imagePath;

    public MinigameEntryDisplay(Component title, Identifier imagePath) {
        this.title = title;
        this.imagePath = imagePath;
    }

    public Component getTitle() {
        return title;
    }

    public Identifier getImagePath() {
        return this.imagePath;
    }
}
