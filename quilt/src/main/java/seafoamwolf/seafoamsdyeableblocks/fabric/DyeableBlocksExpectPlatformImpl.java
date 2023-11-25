package seafomwolf.seafoamsdyeableblocks.fabric;

import seafomwolf.seafoamsdyeableblocks.DyeableBlocksExpectPlatform;
import org.quiltmc.loader.api.QuiltLoader;

import java.nio.file.Path;

public class DyeableBlocksPlatformImpl {
    /**
     * This is our actual method to {@link DyeableBlocksPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return QuiltLoader.getConfigDir();
    }
}
