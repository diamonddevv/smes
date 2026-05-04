package dev.diamond.smes.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import dev.diamond.smes.Smes;
import dev.diamond.smes.minigame.MinigameEntry;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MinigameResourceLoader implements ResourceManagerReloadListener {

    public static final String ROOT = "minigames";
    public static final String EXT = ".json";
    public static final ArrayList<MinigameEntry> MINIGAMES = new ArrayList<>();

    public static final MinigameResourceLoader INSTANCE = new MinigameResourceLoader();

    private MinigameResourceLoader() {}

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        // clear cache
        MINIGAMES.clear();

        Gson gson = new Gson();


        for (Identifier location : resourceManager.listResources(ROOT, p -> true).keySet()) {
            if (resourceManager.getResource(location).isPresent()) {
                // consume
                try (InputStream stream = resourceManager.getResource(location).get().open()) {

                    byte[] bytes = stream.readAllBytes();
                    String s = new String(bytes, StandardCharsets.UTF_8);
                    JsonObject data = gson.fromJson(s, JsonObject.class);

                    String fixedPath = location.getPath().substring(ROOT.length() + 1, location.getPath().length() - EXT.length());
                    Identifier id = Identifier.fromNamespaceAndPath(location.getNamespace(), fixedPath);

                    MinigameEntry.CODEC
                            .parse(JsonOps.INSTANCE, data)
                            .resultOrPartial(Smes.LOGGER::error)
                            .ifPresent(entry -> {
                                Smes.LOGGER.info("registered minigame {}", id);
                                MINIGAMES.add(entry);
                            });

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }



}
