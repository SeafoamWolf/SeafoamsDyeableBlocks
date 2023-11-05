package seafoamwolf.seafoamsdyeableblocks.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.fabric.block.DyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.fabric.commands.DyeableCommands;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyeableItems;

public class SeafoamsDyeableBlocks implements ModInitializer {
	public static final String MOD_ID = "seafoamsdyeableblocks";

	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(DyeableItems.COLOR_ESSENCE))
		.displayName(Text.translatable("item_group.seafoamsdyeableblocks.item_tab"))
		.build();
	
	public static RegistryKey<ItemGroup> ITEM_GROUP_KEY;
	
	@Override
	public void onInitialize() {
		ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(MOD_ID, "item_group"));

		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, ITEM_GROUP);
		
		DyeableBlocks.register();
		DyeableItems.register();
		
		DyeableCommands.register();
	}
}
