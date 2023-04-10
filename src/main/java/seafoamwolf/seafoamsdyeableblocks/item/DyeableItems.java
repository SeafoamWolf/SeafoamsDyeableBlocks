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
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;

public class DyeableItems {
	private static List<Item> dyeable = new ArrayList<Item>();

    public static Item COLOR_ESSENCE;
    public static PaintbrushItem PAINTBRUSH;
    public static PaintbrushItem NETHERITE_PAINTBRUSH;

    public static void register() {
        // NORMAL ITEMS

        COLOR_ESSENCE = Registry.register(Registries.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "color_essence"),
            new Item(new FabricItemSettings()));
        
        // DYEABLE

        PAINTBRUSH = Registry.register(Registries.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "paintbrush"),
            new PaintbrushItem(new FabricItemSettings().maxDamage(256), "paintbrush"));

        NETHERITE_PAINTBRUSH = Registry.register(Registries.ITEM,
            new Identifier(SeafoamsDyeableBlocks.MOD_ID, "netherite_paintbrush"),
            new PaintbrushItem(new FabricItemSettings().maxDamage(2048), "netherite_paintbrush"));

        dyeable.add(PAINTBRUSH);
        dyeable.add(NETHERITE_PAINTBRUSH);
        
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(PAINTBRUSH, CauldronBehavior.CLEAN_DYEABLE_ITEM);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(NETHERITE_PAINTBRUSH, CauldronBehavior.CLEAN_DYEABLE_ITEM);

        ItemGroupEvents.modifyEntriesEvent(SeafoamsDyeableBlocks.ITEM_GROUP).register(content -> {
            content.add(COLOR_ESSENCE);
            content.add(PAINTBRUSH);
            content.add(NETHERITE_PAINTBRUSH);
        });
    }

	public static List<Item> GetDyeable() {
		return dyeable;
	}
}