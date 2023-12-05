package seafoamwolf.seafoamsdyeableblocks.forge;

import dev.architectury.platform.forge.EventBuses;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SeafoamsDyeableBlocks.MOD_ID)
public class DyeableBlocksForge {
    public DyeableBlocksForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(SeafoamsDyeableBlocks.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        SeafoamsDyeableBlocks.init();
    }
}
