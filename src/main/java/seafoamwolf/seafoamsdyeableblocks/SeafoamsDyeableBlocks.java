package seafoamwolf.seafoamsdyeableblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.commands.DyeableCommands;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableItems;

public class SeafoamsDyeableBlocks implements ModInitializer {
	public static final String MOD_ID = "seafoamsdyeableblocks";

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier(MOD_ID, "item_group"), () -> new ItemStack(DyeableItems.COLOR_ESSENCE));
	
	@Override
	public void onInitialize() {
		DyeableBlocks.register();
		DyeableItems.register();
		DyeableCommands.register();
	}
}
