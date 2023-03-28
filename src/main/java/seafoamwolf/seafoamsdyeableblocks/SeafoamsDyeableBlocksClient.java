package seafoamwolf.seafoamsdyeableblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import seafoamwolf.seafoamsdyeableblocks.client.blocks.DyeableBlocksClient;

@Environment(value=EnvType.CLIENT)
public class SeafoamsDyeableBlocksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		DyeableBlocksClient.register();
	}
}