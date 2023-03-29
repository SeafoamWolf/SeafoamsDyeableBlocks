package seafoamwolf.seafoamsdyeableblocks.item;

import java.util.List;
import java.util.ArrayList;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;

public class DyeableItems {
	private static List<Item> dyeable = new ArrayList<Item>();

    public static Item COLOR_ESSENCE;
    public static DynamicDyeItem DYNAMIC_DYE;

    public static void register() {
        // NORMAL ITEMS

        COLOR_ESSENCE = Registry.register(Registry.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "color_essence"),
            new Item(new FabricItemSettings().group(SeafoamsDyeableBlocks.ITEM_GROUP)));
        
        // DYEABLE

        DYNAMIC_DYE = Registry.register(Registry.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "dynamic_dye"),
            new DynamicDyeItem(new FabricItemSettings().maxDamage(1024).group(SeafoamsDyeableBlocks.ITEM_GROUP), "dynamic_dye"));

        dyeable.add(DYNAMIC_DYE);
        
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(DYNAMIC_DYE, CauldronBehavior.CLEAN_DYEABLE_ITEM);
    }

	public static List<Item> GetDyeable() {
		return dyeable;
	}
}