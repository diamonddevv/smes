package dev.diamond.smes.net;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.diamond.smes.Smes;
import dev.diamond.smes.data.MinigameResourceLoader;
import dev.diamond.smes.minigame.MinigameEntry;
import dev.diamond.smes.minigame.MinigameEntryDisplay;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

import java.util.List;

public record ClientboundOpenMinigameMenuPacket(List<PacketDatum> data) implements CustomPacketPayload {

    public static final Identifier ID = Smes.id("open_minigame_menu");
    public static final Type<ClientboundOpenMinigameMenuPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundOpenMinigameMenuPacket> CODEC = StreamCodec.composite(
            PacketDatum.STREAM_CODEC_LIST,
            ClientboundOpenMinigameMenuPacket::data,
            ClientboundOpenMinigameMenuPacket::new
    );

    public static ClientboundOpenMinigameMenuPacket createPacket() {

        List<PacketDatum> data = MinigameResourceLoader.MINIGAMES
                .values()
                .stream()
                .map(entry -> new PacketDatum(entry.getId(), entry.getVisuals()))
                .toList();
        return new ClientboundOpenMinigameMenuPacket(data);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public record PacketDatum(Identifier id, MinigameEntryDisplay display) {
        public static final Codec<PacketDatum> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Identifier.CODEC.fieldOf("id").forGetter(PacketDatum::id),
                MinigameEntryDisplay.CODEC.fieldOf("display").forGetter(PacketDatum::display)
        ).apply(instance, PacketDatum::new));

        public static final StreamCodec<ByteBuf, List<PacketDatum>> STREAM_CODEC_LIST = ByteBufCodecs.fromCodec(CODEC.listOf());
    }
}
