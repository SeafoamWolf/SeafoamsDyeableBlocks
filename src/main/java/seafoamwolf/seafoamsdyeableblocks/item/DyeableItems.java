package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;

public class DyeableItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SeafoamsDyeableBlocks.MODID);

    public static final RegistryObject<Item> MONOCHROME_DYE = ITEMS.register("monochrome_dye", () ->
        new Item(new Item.Properties().tab(SeafoamsDyeableBlocks.ITEM_TAB)));
    
    public static final RegistryObject<Item> WARM_DYE = ITEMS.register("warm_dye", () ->
        new Item(new Item.Properties().tab(SeafoamsDyeableBlocks.ITEM_TAB)));

    public static final RegistryObject<Item> COOL_DYE = ITEMS.register("cool_dye", () ->
        new Item(new Item.Properties().tab(SeafoamsDyeableBlocks.ITEM_TAB)));
    
    public static final RegistryObject<ColorEssenceItem> COLOR_ESSENCE = ITEMS.register("color_essence", () ->
        new ColorEssenceItem(new Item.Properties().durability(128).rarity(Rarity.RARE).tab(SeafoamsDyeableBlocks.ITEM_TAB)));

    public static final RegistryObject<ColorEssenceItem> MASTER_COLOR_ESSENCE = ITEMS.register("master_color_essence", () ->
        new ColorEssenceItem(new Item.Properties().durability(1024).rarity(Rarity.EPIC).tab(SeafoamsDyeableBlocks.ITEM_TAB)));

    public static final RegistryObject<DynamicDyeItem> DYNAMIC_DYE = ITEMS.register("dynamic_dye", () ->
        new DynamicDyeItem(new Item.Properties().durability(1024).tab(SeafoamsDyeableBlocks.ITEM_TAB)));;

    public static void register() {
        CauldronInteraction.WATER.put(DYNAMIC_DYE.get(), CauldronInteraction.DYED_ITEM);
    }
}