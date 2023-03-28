package seafoamwolf.seafoamsdyeableblocks.item;

import java.util.List;
import java.util.ArrayList;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;

public class DyeableItems {
	private static List<Item> dyeable = new ArrayList<Item>();

    public static TooltippedItem MONOCHROME_DYE;
    public static TooltippedItem WARM_DYE;
    public static TooltippedItem COOL_DYE;
    public static ColorEssenceItem COLOR_ESSENCE;
    public static ColorEssenceItem MASTER_COLOR_ESSENCE;

    public static DynamicDyeItem DYNAMIC_DYE;

    public static void register() {
        // NORMAL ITEMS

        COLOR_ESSENCE = Registry.register(Registries.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "color_essence"),
            new ColorEssenceItem(new FabricItemSettings().maxDamage(128).rarity(Rarity.RARE), "color_essence"));

        MASTER_COLOR_ESSENCE = Registry.register(Registries.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "master_color_essence"),
            new ColorEssenceItem(new FabricItemSettings().maxDamage(1024).rarity(Rarity.EPIC), "master_color_essence"));
        
        // DYEABLE

        DYNAMIC_DYE = Registry.register(Registries.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "dynamic_dye"),
            new DynamicDyeItem(new FabricItemSettings().maxDamage(1024), "dynamic_dye"));

        dyeable.add(DYNAMIC_DYE);
        
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(DYNAMIC_DYE, CauldronBehavior.CLEAN_DYEABLE_ITEM);

        ItemGroupEvents.modifyEntriesEvent(SeafoamsDyeableBlocks.ITEM_GROUP).register(content -> {
            content.add(COLOR_ESSENCE);
            content.add(MASTER_COLOR_ESSENCE);
            content.add(DYNAMIC_DYE);
        });
    }

	public static List<Item> GetDyeable() {
		return dyeable;
	}
}