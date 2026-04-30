package dev.diamond.smes.net;

import dev.diamond.smes.util.Provider;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class Packets {

    public static <T> StreamCodec<RegistryFriendlyByteBuf, T> providerCodec(Provider<T> provider) {
        return StreamCodec.of(
                (buf, thing) -> {},
                (buf) -> provider.provide()
        );
    }

    public static void register() {
        PayloadTypeRegistry.clientboundPlay().register(ClientboundOpenMinigameMenuPacket.TYPE, ClientboundOpenMinigameMenuPacket.CODEC);
    }


}
