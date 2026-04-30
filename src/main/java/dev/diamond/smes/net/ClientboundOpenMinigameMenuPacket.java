package dev.diamond.smes.net;

import dev.diamond.smes.Smes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record ClientboundOpenMinigameMenuPacket() implements CustomPacketPayload {
    public static final Identifier ID = Smes.id("open_minigame_menu");
    public static final Type<ClientboundOpenMinigameMenuPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundOpenMinigameMenuPacket> CODEC = Packets.providerCodec(ClientboundOpenMinigameMenuPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
