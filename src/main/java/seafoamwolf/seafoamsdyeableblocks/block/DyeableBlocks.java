package seafoamwolf.seafoamsdyeableblocks.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;

public class DyeableBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SeafoamsDyeableBlocks.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SeafoamsDyeableBlocks.MODID);
	
	public static final Block[] CONCRETE = new Block[]{
		Blocks.WHITE_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.BLACK_CONCRETE, Blocks.BLUE_CONCRETE,
		Blocks.BROWN_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE,
		Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIME_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.ORANGE_CONCRETE,
		Blocks.PINK_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.RED_CONCRETE, Blocks.YELLOW_CONCRETE
	};

	public static final Block[] WOOL = new Block[]{
		Blocks.WHITE_WOOL, Blocks.GRAY_WOOL, Blocks.BLACK_WOOL, Blocks.BLUE_WOOL,
		Blocks.BROWN_WOOL, Blocks.CYAN_WOOL, Blocks.GREEN_WOOL, Blocks.LIGHT_BLUE_WOOL,
		Blocks.LIGHT_GRAY_WOOL, Blocks.LIME_WOOL, Blocks.MAGENTA_WOOL, Blocks.ORANGE_WOOL,
		Blocks.PINK_WOOL, Blocks.PURPLE_WOOL, Blocks.RED_WOOL, Blocks.YELLOW_WOOL
	};

	public static final Block[] TERRACOTTA = new Block[]{
		Blocks.WHITE_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.BLACK_TERRACOTTA, Blocks.BLUE_TERRACOTTA,
		Blocks.BROWN_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA,
		Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.ORANGE_TERRACOTTA,
		Blocks.PINK_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.YELLOW_TERRACOTTA
	};

	public static final Block[] PLANKS = new Block[]{
		Blocks.OAK_PLANKS, Blocks.BIRCH_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.JUNGLE_PLANKS,
		Blocks.DARK_OAK_PLANKS, Blocks.ACACIA_PLANKS,
		Blocks.CRIMSON_PLANKS, Blocks.WARPED_PLANKS,
		Blocks.MANGROVE_PLANKS
	};

	public static final Block[] GLOWSTONE = new Block[]{
		Blocks.GLOWSTONE
	};

	public static final Block[] BRICKS = new Block[]{
		Blocks.BRICKS
	};

	public static final DyeableBlockRegister DYEABLE_CONCRETE = new DyeableBlockRegister("dyeable_concrete",
		BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE), CONCRETE);

	public static final DyeableBlockRegister DYEABLE_WOOL = new DyeableBlockRegister("dyeable_wool",
		BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL), WOOL);

	public static final DyeableBlockRegister DYEABLE_TERRACOTTA = new DyeableBlockRegister("dyeable_terracotta",
		BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA), TERRACOTTA);
	
	public static final DyeableBlockRegister DYEABLE_PLANKS = new DyeableBlockRegister("dyeable_planks",
		BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), PLANKS);
	
	public static final DyeableBlockRegister DYEABLE_GLOWSTONE = new DyeableBlockRegister("dyeable_glowstone",
		BlockBehaviour.Properties.copy(Blocks.GLOWSTONE), GLOWSTONE);

	public static final DyeableBlockRegister DYEABLE_BRICKS = new DyeableBlockRegister("dyeable_bricks",
		BlockBehaviour.Properties.copy(Blocks.BRICKS), BRICKS);

	public static final RegistryObject<BlockEntityType<DyeableBlockEntity>> DYEABLE_BLOCK_ENTITY =
		BLOCK_ENTITY_TYPES.register("dyeable_block_entity", () ->
			BlockEntityType.Builder.of(DyeableBlockEntity::new,
				DYEABLE_CONCRETE.Block.get(), DYEABLE_WOOL.Block.get(),
				DYEABLE_TERRACOTTA.Block.get(), DYEABLE_PLANKS.Block.get(),
				DYEABLE_GLOWSTONE.Block.get(), DYEABLE_BRICKS.Block.get()
			).build(null));
}