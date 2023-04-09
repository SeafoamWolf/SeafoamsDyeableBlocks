package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;

public class DyeableItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SeafoamsDyeableBlocks.MODID);
    
    public static final RegistryObject<Item> COLOR_ESSENCE = ITEMS.register("color_essence", () ->
        new Item(new Item.Properties().tab(SeafoamsDyeableBlocks.ITEM_TAB)));

    public static final RegistryObject<PaintbrushItem> PAINTBRUSH = ITEMS.register("paintbrush", () ->
        new PaintbrushItem(new Item.Properties().durability(256).tab(SeafoamsDyeableBlocks.ITEM_TAB)));

    public static final RegistryObject<PaintbrushItem> NETHERITE_PAINTBRUSH = ITEMS.register("netherite_paintbrush", () ->
        new PaintbrushItem(new Item.Properties().durability(2048).tab(SeafoamsDyeableBlocks.ITEM_TAB)));
    
    public static void register() {
        CauldronInteraction.WATER.put(PAINTBRUSH.get(), CauldronInteraction.DYED_ITEM);
        CauldronInteraction.WATER.put(NETHERITE_PAINTBRUSH.get(), CauldronInteraction.DYED_ITEM);
    }
}