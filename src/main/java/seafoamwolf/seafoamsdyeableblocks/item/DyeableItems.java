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

    public static final RegistryObject<DynamicDyeItem> DYNAMIC_DYE = ITEMS.register("dynamic_dye", () ->
        new DynamicDyeItem(new Item.Properties().durability(1024).tab(SeafoamsDyeableBlocks.ITEM_TAB)));;

    public static void register() {
        CauldronInteraction.WATER.put(DYNAMIC_DYE.get(), CauldronInteraction.DYED_ITEM);
    }
}