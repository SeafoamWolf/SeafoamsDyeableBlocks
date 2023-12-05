package seafoamwolf.seafoamsdyeableblocks.quilt;

import seafoamwolf.seafoamsdyeableblocks.fabriclike.DyeableBlocksFabricLike;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class DyeableBlocksQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        DyeableBlocksFabricLike.init();
    }
}
