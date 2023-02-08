package seafoamwolf.seafoamsdyeableblocks.blocks;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.block.entity.BlockEntityType;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;

public class DyeableBlocks {
	// Blocks
	private static List<DyeableBlockRegister> dyeableBlocks = new ArrayList<DyeableBlockRegister>();

	public static BlockEntityType<DyeableBlockEntity> DYEABLE_BLOCK_ENTITY;

	public static void register() {
		DYEABLE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
			new Identifier(SeafoamsDyeableBlocks.MOD_ID, "dyeable_block_entity"),
			FabricBlockEntityTypeBuilder.create(DyeableBlockEntity::new, new DyeableBlock(FabricBlockSettings.of(Material.STONE))).build(null));
		
		dyeableBlocks.add(new DyeableBlockRegister("dyeable_concrete", FabricBlockSettings.of(Material.STONE).strength(1.0f).requiresTool()));
	}

	public static List<DyeableBlockRegister> GetDyeableBlocks() {
		return dyeableBlocks;
	}
}