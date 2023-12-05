package seafoamwolf.seafoamsdyeableblocks.fabric;

import seafoamwolf.seafoamsdyeableblocks.fabriclike.DyeableBlocksFabricLike;
import net.fabricmc.api.ModInitializer;

public class DyeableBlocksFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        DyeableBlocksFabricLike.init();
    }
}
