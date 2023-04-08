package seafoamwolf.seafoamsdyeableblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import seafoamwolf.seafoamsdyeableblocks.client.block.DyedBlockClient;
import seafoamwolf.seafoamsdyeableblocks.client.item.DyedItemClient;

@Environment(value=EnvType.CLIENT)
public class SeafoamsDyeableBlocksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		DyedBlockClient.register();
		DyedItemClient.register();
	}
}