package seafoamwolf.seafoamsdyeableblocks;

import net.fabricmc.api.ClientModInitializer;

import seafoamwolf.seafoamsdyeableblocks.client.blocks.DyeableBlocksClient;

public class SeafoamsDyeableBlocksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		DyeableBlocksClient.register();
	}
}
