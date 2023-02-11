package seafoamwolf.seafoamsdyeableblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableItems;

public class SeafoamsDyeableBlocks implements ModInitializer {
	public static final String MOD_ID = "seafoamsdyeableblocks";

	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(
		new Identifier(MOD_ID, "item_group"))
		.icon(() -> new ItemStack(DyeableItems.COLOR_ESSENCE))
		.build();
	
	@Override
	public void onInitialize() {
		DyeableBlocks.register();
		DyeableItems.register();
	}
}
