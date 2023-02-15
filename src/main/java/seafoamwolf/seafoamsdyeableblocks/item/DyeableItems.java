package seafoamwolf.seafoamsdyeableblocks.item;

import java.util.List;
import java.util.ArrayList;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
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

        MONOCHROME_DYE = Registry.register(Registry.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "monochrome_dye"),
            new TooltippedItem(new FabricItemSettings().group(SeafoamsDyeableBlocks.ITEM_GROUP), "monochrome_dye"));

        WARM_DYE = Registry.register(Registry.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "warm_dye"),
            new TooltippedItem(new FabricItemSettings().group(SeafoamsDyeableBlocks.ITEM_GROUP), "warm_dye"));

        COOL_DYE = Registry.register(Registry.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "cool_dye"),
            new TooltippedItem(new FabricItemSettings().group(SeafoamsDyeableBlocks.ITEM_GROUP), "cool_dye"));

        COLOR_ESSENCE = Registry.register(Registry.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "color_essence"),
            new ColorEssenceItem(new FabricItemSettings().maxDamage(128).rarity(Rarity.RARE).group(SeafoamsDyeableBlocks.ITEM_GROUP), "color_essence"));

        MASTER_COLOR_ESSENCE = Registry.register(Registry.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "master_color_essence"),
            new ColorEssenceItem(new FabricItemSettings().maxDamage(1024).rarity(Rarity.EPIC).group(SeafoamsDyeableBlocks.ITEM_GROUP), "master_color_essence"));
        
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