package seafoamwolf.seafoamsdyeableblocks.fabric.block;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.fabric.SeafoamsDyeableBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class DyeableBlocks {
	// Blocks
	private static List<DyeableBlockRegister> dyeable = new ArrayList<DyeableBlockRegister>();
	
	public static BlockEntityType<DyeableBlockEntity> DYEABLE_BLOCK_ENTITY;

	public static DyeableBlockRegister DYEABLE_CONCRETE;
	public static DyeableBlockRegister DYEABLE_CONCRETE_STAIRS;
	public static DyeableBlockRegister DYEABLE_CONCRETE_SLAB;

	public static DyeableBlockRegister DYEABLE_WOOL;
	public static DyeableBlockRegister DYEABLE_WOOL_STAIRS;
	public static DyeableBlockRegister DYEABLE_WOOL_SLAB;
	public static DyeableBlockRegister DYEABLE_CARPET;

	public static DyeableBlockRegister DYEABLE_BRICKS;
	public static DyeableBlockRegister DYEABLE_BRICK_STAIRS;
	public static DyeableBlockRegister DYEABLE_BRICK_SLAB;

	public static DyeableBlockRegister DYEABLE_TERRACOTTA;
	public static DyeableBlockRegister DYEABLE_TERRACOTTA_STAIRS;
	public static DyeableBlockRegister DYEABLE_TERRACOTTA_SLAB;
	
	public static DyeableBlockRegister DYEABLE_PLANKS;
	public static DyeableBlockRegister DYEABLE_PLANK_STAIRS;
	public static DyeableBlockRegister DYEABLE_PLANK_SLAB;

	public static DyeableBlockRegister DYEABLE_GLOWSTONE;
	public static DyeableBlockRegister DYEABLE_IRON_BARS;

	public static DyeableBlockRegister DYEABLE_STAINED_GLASS;
	public static DyeableBlockRegister DYEABLE_STAINED_GLASS_PANE;

	public static DyeableBlockRegister DYEABLE_STRIPPED_LOG;
	public static DyeableBlockRegister DYEABLE_STRIPPED_WOOD;
	
	public static void register() {
		// CONCRETE

		DYEABLE_CONCRETE = new DyeableBlockRegister("dyeable_concrete",
			new DyeableBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE)));
		
		DYEABLE_CONCRETE_STAIRS = new DyeableBlockRegister("dyeable_concrete_stairs",
			new DyeableStairsBlock(DYEABLE_CONCRETE.Block.getDefaultState(), FabricBlockSettings.copyOf(DYEABLE_CONCRETE.Block)));

		DYEABLE_CONCRETE_SLAB = new DyeableBlockRegister("dyeable_concrete_slab",
			new DyeableSlabBlock(FabricBlockSettings.copyOf(DYEABLE_CONCRETE.Block)));

		// WOOL
		
		DYEABLE_WOOL = new DyeableBlockRegister("dyeable_wool",
			new DyeableBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
		
		DYEABLE_WOOL_STAIRS = new DyeableBlockRegister("dyeable_wool_stairs",
			new DyeableStairsBlock(DYEABLE_WOOL.Block.getDefaultState(), FabricBlockSettings.copyOf(DYEABLE_WOOL.Block)));

		DYEABLE_WOOL_SLAB = new DyeableBlockRegister("dyeable_wool_slab",
			new DyeableSlabBlock(FabricBlockSettings.copyOf(DYEABLE_WOOL.Block)));

		DYEABLE_CARPET = new DyeableBlockRegister("dyeable_carpet",
			new DyeableCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET)));

		// BRICKS
		
		DYEABLE_BRICKS = new DyeableBlockRegister("dyeable_bricks",
			new DyeableBlock(FabricBlockSettings.copyOf(Blocks.BRICKS)));
		
		DYEABLE_BRICK_STAIRS = new DyeableBlockRegister("dyeable_brick_stairs",
			new DyeableStairsBlock(DYEABLE_BRICKS.Block.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BRICK_STAIRS)));

		DYEABLE_BRICK_SLAB = new DyeableBlockRegister("dyeable_brick_slab",
			new DyeableSlabBlock(FabricBlockSettings.copyOf(Blocks.BRICK_SLAB)));
		
		// TERRACOTTA

		DYEABLE_TERRACOTTA = new DyeableBlockRegister("dyeable_terracotta",
			new DyeableBlock(FabricBlockSettings.copyOf(Blocks.TERRACOTTA)));
		
		DYEABLE_TERRACOTTA_STAIRS = new DyeableBlockRegister("dyeable_terracotta_stairs",
			new DyeableStairsBlock(DYEABLE_TERRACOTTA.Block.getDefaultState(), FabricBlockSettings.copyOf(Blocks.TERRACOTTA)));

		DYEABLE_TERRACOTTA_SLAB = new DyeableBlockRegister("dyeable_terracotta_slab",
			new DyeableSlabBlock(FabricBlockSettings.copyOf(Blocks.TERRACOTTA)));
		
		// STAINED GLASS
		
		DYEABLE_STAINED_GLASS = new DyeableBlockRegister("dyeable_stained_glass",
			new DyeableStainedGlassBlock(FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS)));

		DYEABLE_STAINED_GLASS_PANE = new DyeableBlockRegister("dyeable_stained_glass_pane",
			new DyeableStainedGlassPaneBlock(FabricBlockSettings.copyOf(Blocks.WHITE_STAINED_GLASS_PANE)));

		// PLANKS

		DYEABLE_PLANKS = new DyeableBlockRegister("dyeable_planks",
			new DyeableBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

		DYEABLE_PLANK_STAIRS = new DyeableBlockRegister("dyeable_plank_stairs",
			new DyeableStairsBlock(DYEABLE_PLANKS.Block.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

		DYEABLE_PLANK_SLAB = new DyeableBlockRegister("dyeable_plank_slab",
			new DyeableSlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

		// STRIPPED LOGS
		
		DYEABLE_STRIPPED_LOG = new DyeableBlockRegister("dyeable_stripped_log",
			new DyeablePillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));

		DYEABLE_STRIPPED_WOOD = new DyeableBlockRegister("dyeable_stripped_wood",
			new DyeablePillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
		
		// Other

		DYEABLE_GLOWSTONE = new DyeableBlockRegister("dyeable_glowstone",
			new DyeableBlock(FabricBlockSettings.copyOf(Blocks.GLOWSTONE)));

		DYEABLE_IRON_BARS = new DyeableBlockRegister("dyeable_iron_bars",
			new DyeablePaneBlock(FabricBlockSettings.copyOf(Blocks.IRON_BARS)));
		
		dyeable.add(DYEABLE_CONCRETE);
		dyeable.add(DYEABLE_CONCRETE_STAIRS);
		dyeable.add(DYEABLE_CONCRETE_SLAB);

		dyeable.add(DYEABLE_WOOL);
		dyeable.add(DYEABLE_WOOL_STAIRS);
		dyeable.add(DYEABLE_WOOL_SLAB);
		dyeable.add(DYEABLE_CARPET);

		dyeable.add(DYEABLE_BRICKS);
		dyeable.add(DYEABLE_BRICK_STAIRS);
		dyeable.add(DYEABLE_BRICK_SLAB);

		dyeable.add(DYEABLE_TERRACOTTA);
		dyeable.add(DYEABLE_TERRACOTTA_STAIRS);
		dyeable.add(DYEABLE_TERRACOTTA_SLAB);
		
		dyeable.add(DYEABLE_PLANKS);
		dyeable.add(DYEABLE_PLANK_STAIRS);
		dyeable.add(DYEABLE_PLANK_SLAB);

		dyeable.add(DYEABLE_GLOWSTONE);

		dyeable.add(DYEABLE_IRON_BARS);

		dyeable.add(DYEABLE_STAINED_GLASS);
		dyeable.add(DYEABLE_STAINED_GLASS_PANE);

		dyeable.add(DYEABLE_STRIPPED_LOG);
		dyeable.add(DYEABLE_STRIPPED_WOOD);
		
		DYEABLE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
			new Identifier(SeafoamsDyeableBlocks.MOD_ID, "dyeable_block_entity"),
			FabricBlockEntityTypeBuilder.create(DyeableBlockEntity::new,
			DYEABLE_CONCRETE.Block, DYEABLE_CONCRETE_STAIRS.Block, DYEABLE_CONCRETE_SLAB.Block,
			DYEABLE_WOOL.Block, DYEABLE_WOOL_STAIRS.Block, DYEABLE_WOOL_SLAB.Block, DYEABLE_CARPET.Block,
			DYEABLE_BRICKS.Block, DYEABLE_BRICK_STAIRS.Block, DYEABLE_BRICK_SLAB.Block,
			DYEABLE_TERRACOTTA.Block, DYEABLE_TERRACOTTA_STAIRS.Block, DYEABLE_TERRACOTTA_SLAB.Block,
			DYEABLE_PLANKS.Block, DYEABLE_PLANK_STAIRS.Block, DYEABLE_PLANK_SLAB.Block,
			DYEABLE_STRIPPED_LOG.Block, DYEABLE_STRIPPED_WOOD.Block,
			DYEABLE_GLOWSTONE.Block, DYEABLE_IRON_BARS.Block,
			DYEABLE_STAINED_GLASS.Block, DYEABLE_STAINED_GLASS_PANE.Block
		).build(null));
	}

	public static List<DyeableBlockRegister> GetDyeable() {
		return dyeable;
	}
}