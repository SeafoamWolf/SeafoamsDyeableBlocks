package net.seafoamstuff;

import net.fabricmc.api.ClientModInitializer;

import net.seafoamstuff.blocks.SeafoamBlocks;

public class SeafoamStuffClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		SeafoamBlocks.registerClient();
	}
}
