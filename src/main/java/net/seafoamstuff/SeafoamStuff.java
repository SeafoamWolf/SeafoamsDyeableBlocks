package net.seafoamstuff;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import net.seafoamstuff.items.SeafoamItems;
import net.seafoamstuff.blocks.SeafoamBlocks;
import net.seafoamstuff.world.SeafoamWorldGen;

public class SeafoamStuff implements ModInitializer {
	public static final String MOD_ID = "seafoamstuff";

	public static final ItemGroup SEAFOAM_STUFF = FabricItemGroupBuilder.create(
		new Identifier(MOD_ID, "seafoam_group"))
		.icon(() -> new ItemStack(SeafoamItems.SEAFOAMIUM_INGOT)) // This uses the model of the new material you created as an icon, but you can reference to whatever you like
		.build();
	
	@Override
	public void onInitialize() {
		SeafoamBlocks.register();
		SeafoamItems.register();
		SeafoamWorldGen.register();
	}
}
