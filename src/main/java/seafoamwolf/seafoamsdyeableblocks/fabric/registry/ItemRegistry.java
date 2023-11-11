package seafoamwolf.seafoamsdyeableblocks.fabric.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyeableBlockItem;

public class ItemRegistry {
    public static void registerDefaultItem(Identifier identifier, Item item) {
		  Registry.register(Registries.ITEM, identifier, item);
    }

    public static BlockItem registerDefaultBlockItem(Identifier identifier, Block block) {
      BlockItem item = new BlockItem(block, new FabricItemSettings());
		  Registry.register(Registries.ITEM, identifier, item);

      return item;
    }

    public static DyeableBlockItem registerDyedBlockItem(Identifier identifier, Block block) {
      DyeableBlockItem item = new DyeableBlockItem(block, new FabricItemSettings());
		  Registry.register(Registries.ITEM, identifier, item);

      return item;
    }
}
