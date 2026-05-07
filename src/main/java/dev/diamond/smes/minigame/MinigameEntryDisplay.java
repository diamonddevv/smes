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

public record MinigameEntryDisplay(Component title, Identifier imagePath) {

    public static final Codec<MinigameEntryDisplay> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ComponentSerialization.CODEC.fieldOf("title").forGetter(MinigameEntryDisplay::title),
            Identifier.CODEC.fieldOf("image").forGetter(MinigameEntryDisplay::imagePath)
    ).apply(instance, MinigameEntryDisplay::new));



}
