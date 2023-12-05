package seafoamwolf.seafoamsdyeableblocks.fabric;

import org.quiltmc.loader.api.QuiltLoader;

import java.nio.file.Path;

public class DyeableBlocksExpectPlatformImpl {
    /**
     * This is our actual method to {@link DyeableBlocksPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return QuiltLoader.getConfigDir();
    }
}
