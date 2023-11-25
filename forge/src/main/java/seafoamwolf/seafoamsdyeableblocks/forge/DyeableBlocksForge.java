package net.seafoamsdyeableblocks.forge;

import dev.architectury.platform.forge.EventBuses;
import net.seafoamsdyeableblocks.DyeableBlocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DyeableBlocks.MOD_ID)
public class DyeableBlocksForge {
    public DyeableBlocksForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(DyeableBlocks.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        DyeableBlocks.init();
    }
}
