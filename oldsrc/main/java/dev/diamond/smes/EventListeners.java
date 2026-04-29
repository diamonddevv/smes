package dev.diamond.smes;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public class EventListeners {
    public static void onDisconnectServer() {
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
        });
    }
    public static void onWorldTickClient() {
        ClientTickEvents.START_WORLD_TICK.register((world) -> {
        });
    }

    public static void onDisconnectClient() {
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
        });
    }
}
