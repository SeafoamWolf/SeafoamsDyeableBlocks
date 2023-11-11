package seafoamwolf.seafoamsdyeableblocks.fabric.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.fabric.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.fabric.data.DyeableLists;
import seafoamwolf.seafoamsdyeableblocks.fabric.registry.ItemRegistry;

public class DyeableItems {
    public static Item COLOR_ESSENCE = new Item(new FabricItemSettings());
    public static PaintbrushItem PAINTBRUSH = new PaintbrushItem(new FabricItemSettings().maxDamage(256), "paintbrush");
    public static PaintbrushItem NETHERITE_PAINTBRUSH = new PaintbrushItem(new FabricItemSettings().maxDamage(2048), "netherite_paintbrush");
    public static DyeSpongeItem DYE_SPONGE = new DyeSpongeItem(new FabricItemSettings().maxDamage(256), "dye_sponge");

    public static void register() {
        String modid = SeafoamsDyeableBlocks.MOD_ID;

        registerItem(COLOR_ESSENCE, new Identifier(modid, "color_essence"));
        registerItem(PAINTBRUSH, new Identifier(modid, "paintbrush"));
        registerItem(NETHERITE_PAINTBRUSH, new Identifier(modid, "netherite_paintbrush"));
        registerItem(DYE_SPONGE, new Identifier(modid, "dye_sponge"));

        DyeableLists.registerDyeableItem(PAINTBRUSH);
        DyeableLists.registerDyeableItem(NETHERITE_PAINTBRUSH);
    }

    private static void registerItem(Item item, Identifier identifier) {
        ItemRegistry.registerDefaultItem(identifier, item);
        ItemGroupEvents.modifyEntriesEvent(SeafoamsDyeableBlocks.ITEM_GROUP_KEY).register(content -> { content.add(item); });
    }
}