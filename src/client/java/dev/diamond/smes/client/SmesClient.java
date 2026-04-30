package dev.diamond.smes.client;

import dev.diamond.smes.client.net.PacketReceiver;
import net.fabricmc.api.ClientModInitializer;

public class SmesClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		PacketReceiver.registerReceivers();
	}
}