package seafoamwolf.seafoamsdyeableblocks.fabric.data;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Item;

import seafoamwolf.seafoamsdyeableblocks.fabric.block.DyedBlockRegister;

public class DyeableLists {
    public static List<DyedBlockRegister> dyeableBlocks = new ArrayList<DyedBlockRegister>();
    public static List<Item> dyeableItems = new ArrayList<Item>();

    public static void registerDyeableBlock(DyedBlockRegister block) {
        dyeableBlocks.add(block);
    }

    public static void registerDyeableItem(Item item) {
        dyeableItems.add(item);
        
        // Register cleaning the item in a Cauldron
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(item, CauldronBehavior.CLEAN_DYEABLE_ITEM);
    }

    public static boolean isBlockDyeable(DyedBlockRegister block) {
        return dyeableBlocks.contains(block);
    }

    public static boolean isItemDyeable(Item item) {
        return dyeableItems.contains(item);
    }
}
