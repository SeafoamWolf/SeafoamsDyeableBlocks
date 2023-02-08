package net.seafoamstuff.items;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.recipe.Ingredient;

public class CosmeticArmorMaterial implements ArmorMaterial {
	private static final int[] BASE_DURABILITY = new int[] { 13, 15, 16, 11 };
	private static final int[] PROTECTION_VALUES = new int[] { 0, 0, 0, 0 };

	private String textureName;

	public CosmeticArmorMaterial(String name) {
		super();

		textureName = name;
	}
 
	@Override
	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * 100;
	}
 
	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return PROTECTION_VALUES[slot.getEntitySlotId()];
	}
 
	@Override
	public int getEnchantability() {
		return 0;
	}
 
	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
	}
 
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.STRING);
	}
 
	@Override
	public String getName() {
		return textureName;
	}
 
	@Override
	public float getToughness() {
		return 0.0F;
	}
	
	@Override
	public float getKnockbackResistance() {
		return 0.0F;
	}
}