package dev.diamond.smes.net;

import dev.diamond.smes.Smes;
import dev.diamond.smes.minigame.MinigameEntryDisplay;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

import java.util.List;

public record ClientboundOpenMinigameMenuPacket(List<MinigameEntryDisplay> displays) implements CustomPacketPayload {
    public static final Identifier ID = Smes.id("open_minigame_menu");
    public static final Type<ClientboundOpenMinigameMenuPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundOpenMinigameMenuPacket> CODEC = StreamCodec.composite(
            MinigameEntryDisplay.STREAM_CODEC_LIST,
            ClientboundOpenMinigameMenuPacket::displays,
            ClientboundOpenMinigameMenuPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
