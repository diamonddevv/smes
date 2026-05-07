package dev.diamond.smes.net;

import com.google.gson.JsonElement;
import dev.diamond.smes.data.MinigameResourceLoader;
import dev.diamond.smes.minigame.Minigame;
import dev.diamond.smes.minigame.MinigameEntry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class ServerPacketReceiver {

    public static void registerReceivers() {
        ServerPlayNetworking.registerGlobalReceiver(ServerboundLoadMinigamePacket.TYPE, (payload, context) -> {
            MinigameEntry entry = MinigameResourceLoader.MINIGAMES.get(payload.id());

            Minigame type = entry.getType();
            JsonElement settingsElement = entry.getSettingsObject();
            type.decodeSettings(settingsElement.getAsJsonObject());

            type.init();
        });
    }


}
