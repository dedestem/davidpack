package net.davidnet.davidtech;

import net.davidnet.davidtech.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Davidtech implements ModInitializer {
	public static final String MOD_ID = "davidtech";

	// Logger for the mod
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Log initialization steps
		LOGGER.info("Welcome {} to Fabric!", MOD_ID);

		// Register items
		LOGGER.info("Registering Items!");
		ModItems.registerAll();

		// Register item groups
		LOGGER.info("Registering Item Groups");
		ModItems.registerItemGroupEntries();

		// Wait until server Start
		LOGGER.info("Waiting for Server Start");
		ServerLifecycleEvents.SERVER_STARTED.register(this::onServerStart);
	}

	// On Server Start / World
	private void onServerStart(MinecraftServer server) {
		LOGGER.info("Server / World Started");
	}
}
