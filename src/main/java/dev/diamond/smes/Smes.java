package dev.diamond.smes;

import dev.diamond.smes.command.MinigameCommand;
import dev.diamond.smes.data.MinigameResourceLoader;
import dev.diamond.smes.net.Packets;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.impl.resource.ResourceLoaderImpl;
import net.fabricmc.fabric.impl.resource.loader.ResourceManagerHelperImpl;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Smes implements ModInitializer {
	public static final String MOD_ID = "smes";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		Packets.register();
		CommandRegistrationCallback.EVENT.register(MinigameCommand::register);

		ResourceLoaderImpl.get(PackType.SERVER_DATA).registerReloadListener(id("minigame"), MinigameResourceLoader.INSTANCE);

		LOGGER.info("initialised");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
	public static Identifier idmc(String path) {
		return Identifier.withDefaultNamespace(path);
	}
}