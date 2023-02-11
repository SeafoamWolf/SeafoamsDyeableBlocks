package seafoamwolf.seafoamsdyeableblocks.block;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class DyeableBlocks {
	// Blocks
	private static List<DyeableBlockRegister> dyeable = new ArrayList<DyeableBlockRegister>();
	
	public static BlockEntityType<DyeableBlockEntity> DYEABLE_BLOCK_ENTITY;

	public static DyeableBlockRegister DYEABLE_CONCRETE;
	public static DyeableBlockRegister DYEABLE_CONCRETE_POWDER;
	public static DyeableBlockRegister DYEABLE_WOOL;

	public static void register() {
		DYEABLE_CONCRETE = new DyeableBlockRegister("dyeable_concrete",
			FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE));

		DYEABLE_WOOL = new DyeableBlockRegister("dyeable_wool",
			FabricBlockSettings.copyOf(Blocks.WHITE_WOOL));
		
		dyeable.add(DYEABLE_CONCRETE);
		dyeable.add(DYEABLE_WOOL);
		
		DYEABLE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
			new Identifier(SeafoamsDyeableBlocks.MOD_ID, "dyeable_block_entity"),
			FabricBlockEntityTypeBuilder.create(DyeableBlockEntity::new,
			dyeable.get(0).Block, dyeable.get(1).Block
			).build(null));
	}

	public static List<DyeableBlockRegister> GetDyeable() {
		return dyeable;
	}
}