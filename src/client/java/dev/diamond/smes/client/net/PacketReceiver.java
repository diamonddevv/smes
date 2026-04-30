package dev.diamond.smes.client.net;

import dev.diamond.smes.client.menu.MinigameMenu;
import dev.diamond.smes.net.ClientboundOpenMinigameMenuPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;

public class PacketReceiver {


    public static void registerReceivers() {
        ClientPlayNetworking.registerGlobalReceiver(ClientboundOpenMinigameMenuPacket.TYPE, (payload, context) -> {
            Minecraft.getInstance().setScreen(new MinigameMenu());
        });
    }


}
