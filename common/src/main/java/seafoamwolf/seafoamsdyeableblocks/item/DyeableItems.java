package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.world.item.Item;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.data.DyeableLists;

public class DyeableItems {
    public static final Item COLOR_ESSENCE = new Item(new Item.Properties().arch$tab(SeafoamsDyeableBlocks.ITEM_TAB));

    public static final PaintbrushItem PAINTBRUSH = new PaintbrushItem(new Item.Properties().arch$tab(SeafoamsDyeableBlocks.ITEM_TAB).durability(256));
    public static final PaintbrushItem NETHERITE_PAINTBRUSH = new PaintbrushItem(new Item.Properties().arch$tab(SeafoamsDyeableBlocks.ITEM_TAB).durability(2048));

    public static final DyeSpongeItem DYE_SPONGE =  new DyeSpongeItem(new Item.Properties().arch$tab(SeafoamsDyeableBlocks.ITEM_TAB).durability(256));

    public static void init() {
        SeafoamsDyeableBlocks.ITEMS.register("color_essence", () -> COLOR_ESSENCE);
        SeafoamsDyeableBlocks.ITEMS.register("paintbrush", () -> PAINTBRUSH);
        SeafoamsDyeableBlocks.ITEMS.register("netherite_paintbrush", () -> NETHERITE_PAINTBRUSH);
        SeafoamsDyeableBlocks.ITEMS.register("dye_sponge", () -> DYE_SPONGE);
        
        SeafoamsDyeableBlocks.ITEMS.register();

        DyeableLists.registerDyeableItem(PAINTBRUSH);
        DyeableLists.registerDyeableItem(NETHERITE_PAINTBRUSH);
    }
}
