package seafoamwolf.seafoamsdyeableblocks.data;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.Item;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockInterface;

public class DyeableLists {
    public static List<DyeableBlockInterface> dyeableBlocks = new ArrayList<DyeableBlockInterface>();
    public static List<Item> dyeableItems = new ArrayList<Item>();

    public static void registerDyeableBlock(DyeableBlockInterface block) {
        dyeableBlocks.add(block);
    }

    public static void registerDyeableItem(Item item) {
        dyeableItems.add(item);
        
        // Register cleaning the item in a Cauldron
        CauldronInteraction.WATER.put(item, CauldronInteraction.DYED_ITEM);
    }

    public static boolean isBlockDyeable(DyeableBlockInterface block) {
        return dyeableBlocks.contains(block);
    }

    public static boolean isItemDyeable(Item item) {
        return dyeableItems.contains(item);
    }
}