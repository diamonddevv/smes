package dev.diamond.smes;

import dev.diamond.smes.registry.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmesMod implements ModInitializer {

	public static final String modid = "smes";
	public static final Logger LOGGER = LoggerFactory.getLogger("SMES");


	public static final Identifier PLACEHOLDER_SPRITE = id("textures/ui/common/placeholder.png");
	@Override
	public void onInitialize() {
		long start = System.currentTimeMillis();
		//
		new InitRegistries().register();
		new InitMinigames().register();

		new InitCommand().register();

		new InitRules().register();

		new InitResourceManager().register();

		new InitPackets().register();

		EventListeners.onDisconnectServer();

		//
		long initTime = System.currentTimeMillis() - start;
		LOGGER.info("Mod " + modid + " initialized in " + initTime + " millisecond(s)!");
	}

	public static Identifier id(String path) {
		return new Identifier(modid, path);
	}

}
