package dev.diamond.smes.net;

import dev.diamond.smes.Smes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record ServerboundLoadMinigamePacket(Identifier id) implements CustomPacketPayload {
    public static final Identifier ID = Smes.id("load_minigame");
    public static final Type<ServerboundLoadMinigamePacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundLoadMinigamePacket> CODEC = StreamCodec.composite(
            Identifier.STREAM_CODEC, ServerboundLoadMinigamePacket::id, ServerboundLoadMinigamePacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
