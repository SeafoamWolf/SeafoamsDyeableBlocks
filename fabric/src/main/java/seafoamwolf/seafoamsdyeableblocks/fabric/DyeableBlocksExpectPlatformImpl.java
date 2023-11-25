package seafoamwolf.seafoamsdyeableblocks.fabric;

import seafoamwolf.seafoamsdyeableblocks.DyeableBlocksExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class DyeableBlocksExpectPlatformImpl {
    /**
     * This is our actual method to {@link DyeableBlocksExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
