package seafoamwolf.seafoamsdyeableblocks.block;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class DyeableBlocks {
	// Blocks
	private static List<DyeableBlockRegister> dyeable = new ArrayList<DyeableBlockRegister>();
	
	public static BlockEntityType<DyeableBlockEntity> DYEABLE_BLOCK_ENTITY;

	public static DyeableBlockRegister DYEABLE_CONCRETE;
	public static DyeableBlockRegister DYEABLE_WOOL;
	public static DyeableBlockRegister DYEABLE_PLANKS;
	public static DyeableBlockRegister DYEABLE_GLOWSTONE;
	public static DyeableBlockRegister DYEABLE_BRICKS;
	public static DyeableBlockRegister DYEABLE_TERRACOTTA;

	public static void register() {
		Block[] CONCRETE = new Block[]{
			Blocks.WHITE_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BLACK_CONCRETE, Blocks.BLUE_CONCRETE,
			Blocks.BROWN_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE,
			Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIME_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.ORANGE_CONCRETE,
			Blocks.PINK_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.RED_CONCRETE, Blocks.YELLOW_CONCRETE
		};
		
		Block[] WOOL = new Block[]{
			Blocks.WHITE_WOOL, Blocks.GRAY_WOOL, Blocks.BLACK_WOOL, Blocks.BLUE_WOOL,
			Blocks.BROWN_WOOL, Blocks.CYAN_WOOL, Blocks.GREEN_WOOL, Blocks.LIGHT_BLUE_WOOL,
			Blocks.LIGHT_GRAY_WOOL, Blocks.LIME_WOOL, Blocks.MAGENTA_WOOL, Blocks.ORANGE_WOOL,
			Blocks.PINK_WOOL, Blocks.PURPLE_WOOL, Blocks.RED_WOOL, Blocks.YELLOW_WOOL
		};

		Block[] TERRACOTTA = new Block[]{
			Blocks.WHITE_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.BLACK_TERRACOTTA, Blocks.BLUE_TERRACOTTA,
			Blocks.BROWN_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA,
			Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.ORANGE_TERRACOTTA,
			Blocks.PINK_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.YELLOW_TERRACOTTA
		};
		
		Block[] PLANKS = new Block[]{
			Blocks.OAK_PLANKS, Blocks.BIRCH_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.JUNGLE_PLANKS,
			Blocks.DARK_OAK_PLANKS, Blocks.ACACIA_PLANKS,
			Blocks.CRIMSON_PLANKS, Blocks.WARPED_PLANKS,
			Blocks.MANGROVE_PLANKS
		};
		
		Block[] GLOWSTONE = new Block[]{
			Blocks.GLOWSTONE
		};
		
		Block[] BRICKS = new Block[]{
			Blocks.BRICKS
		};

		DYEABLE_CONCRETE = new DyeableBlockRegister("dyeable_concrete",
			FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE), CONCRETE);

		DYEABLE_WOOL = new DyeableBlockRegister("dyeable_wool",
			FabricBlockSettings.copyOf(Blocks.WHITE_WOOL), WOOL);

		DYEABLE_TERRACOTTA = new DyeableBlockRegister("dyeable_terracotta",
			FabricBlockSettings.copyOf(Blocks.TERRACOTTA), TERRACOTTA);

		DYEABLE_PLANKS = new DyeableBlockRegister("dyeable_planks",
			FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), PLANKS);

		DYEABLE_GLOWSTONE = new DyeableBlockRegister("dyeable_glowstone",
			FabricBlockSettings.copyOf(Blocks.GLOWSTONE), GLOWSTONE);

		DYEABLE_BRICKS = new DyeableBlockRegister("dyeable_bricks",
			FabricBlockSettings.copyOf(Blocks.BRICKS), BRICKS);
		
		dyeable.add(DYEABLE_CONCRETE);
		dyeable.add(DYEABLE_WOOL);
		dyeable.add(DYEABLE_TERRACOTTA);
		dyeable.add(DYEABLE_PLANKS);
		dyeable.add(DYEABLE_GLOWSTONE);
		dyeable.add(DYEABLE_BRICKS);
		
		DYEABLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
			new Identifier(SeafoamsDyeableBlocks.MOD_ID, "dyeable_block_entity"),
			FabricBlockEntityTypeBuilder.create(DyeableBlockEntity::new,
			dyeable.get(0).Block, dyeable.get(1).Block,
			dyeable.get(2).Block, dyeable.get(3).Block,
			dyeable.get(4).Block, dyeable.get(5).Block
		).build(null));
	}

	public static List<DyeableBlockRegister> GetDyeable() {
		return dyeable;
	}
}