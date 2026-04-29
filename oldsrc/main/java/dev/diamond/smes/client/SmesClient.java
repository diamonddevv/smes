package dev.diamond.smes.client;

import dev.diamond.smes.EventListeners;
import dev.diamond.smes.client.network.ClientPacketRecievers;
import net.fabricmc.api.ClientModInitializer;

public class SmesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        new ClientPacketRecievers().register();

        EventListeners.onDisconnectClient();
        EventListeners.onWorldTickClient();
    }
}
