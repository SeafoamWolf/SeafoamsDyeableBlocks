package net.seafoamstuff.items;

import net.minecraft.item.Item;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.seafoamstuff.SeafoamStuff;

public class SeafoamItems {
	// Items
    public static final Item RAW_SEAFOAMIUM = new Item(new Item.Settings().group(SeafoamStuff.SEAFOAM_STUFF));
    public static final Item SEAFOAMIUM_INGOT = new Item(new Item.Settings().group(SeafoamStuff.SEAFOAM_STUFF));

	// Armor
	public static final ArmorMaterial INVISIBLE_ARMOR_MATERIAL = new CosmeticArmorMaterial("invisible");
    public static final Item INVISIBLE_HELMET = new ArmorItem(INVISIBLE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(SeafoamStuff.SEAFOAM_STUFF));
    public static final Item INVISIBLE_CHESTPLATE = new ArmorItem(INVISIBLE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(SeafoamStuff.SEAFOAM_STUFF));
    public static final Item INVISIBLE_LEGGINGS = new ArmorItem(INVISIBLE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(SeafoamStuff.SEAFOAM_STUFF));
    public static final Item INVISIBLE_BOOTS = new ArmorItem(INVISIBLE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(SeafoamStuff.SEAFOAM_STUFF));

	public static final ArmorMaterial PURO_ARMOR_MATERIAL = new CosmeticArmorMaterial("puro");
    public static final Item PURO_MASK = new ArmorItem(PURO_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(SeafoamStuff.SEAFOAM_STUFF));

	public static final ArmorMaterial SEAFOAM_TAIL_MATERIAL = new CosmeticArmorMaterial("seafoam");
    public static final Item SEAFOAM_TAIL = new ArmorItem(SEAFOAM_TAIL_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(SeafoamStuff.SEAFOAM_STUFF));

	public static void register() {
		// Items
        Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "raw_seafoamium"), RAW_SEAFOAMIUM);
        Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "seafoamium_ingot"), SEAFOAMIUM_INGOT);

		// Armor
		Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "invisible_helmet"), INVISIBLE_HELMET);
		Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "invisible_chestplate"), INVISIBLE_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "invisible_leggings"), INVISIBLE_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "invisible_boots"), INVISIBLE_BOOTS);

		Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "puro_mask"), PURO_MASK);
		Registry.register(Registry.ITEM, new Identifier(SeafoamStuff.MOD_ID, "seafoam_tail"), SEAFOAM_TAIL);
	}
}
