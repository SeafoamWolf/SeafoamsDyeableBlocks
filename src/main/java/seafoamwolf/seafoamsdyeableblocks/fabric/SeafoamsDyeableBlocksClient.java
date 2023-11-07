package seafoamwolf.seafoamsdyeableblocks.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import seafoamwolf.seafoamsdyeableblocks.fabric.client.DyedColorHandler;

@Environment(value=EnvType.CLIENT)
public class SeafoamsDyeableBlocksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		DyedColorHandler.register();
	}
}