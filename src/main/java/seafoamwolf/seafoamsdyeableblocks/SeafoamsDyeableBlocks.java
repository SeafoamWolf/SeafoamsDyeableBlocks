package seafoamwolf.seafoamsdyeableblocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import seafoamwolf.seafoamsdyeableblocks.blocks.DyeableBlocks;

public class SeafoamsDyeableBlocks implements ModInitializer {
	public static final String MOD_ID = "seafoamsdyeableblocks";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ItemGroup SEAFOAMS_DYEABLE_BLOCKS_TAB = FabricItemGroup.builder(
		new Identifier(MOD_ID, "item_group")).icon(() -> new ItemStack(Items.DIAMOND)).build();
	
	@Override
	public void onInitialize() {
		DyeableBlocks.register();
	}
}
