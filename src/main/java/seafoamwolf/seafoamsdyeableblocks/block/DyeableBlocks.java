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

	public static final RegistryObject<DyeableBlock> DYEABLE_CONCRETE = DyeableBlocks.BLOCKS.register("dyeable_concrete", () ->
		new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
	
	public static final RegistryObject<DyeableStairBlock> DYEABLE_CONCRETE_STAIRS = DyeableBlocks.BLOCKS.register("dyeable_concrete_stairs", () ->
		new DyeableStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
	
	public static final RegistryObject<DyeableSlabBlock> DYEABLE_CONCRETE_SLAB = DyeableBlocks.BLOCKS.register("dyeable_concrete_slab", () ->
		new DyeableSlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
	

	public static final RegistryObject<DyeableBlock> DYEABLE_WOOL = DyeableBlocks.BLOCKS.register("dyeable_wool", () ->
		new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

	public static final RegistryObject<DyeableStairBlock> DYEABLE_WOOL_STAIRS = DyeableBlocks.BLOCKS.register("dyeable_wool_stairs", () ->
		new DyeableStairBlock(Blocks.WHITE_WOOL.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

	public static final RegistryObject<DyeableSlabBlock> DYEABLE_WOOL_SLAB = DyeableBlocks.BLOCKS.register("dyeable_wool_slab", () ->
		new DyeableSlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	
	public static final RegistryObject<DyeableCarpetBlock> DYEABLE_CARPET = DyeableBlocks.BLOCKS.register("dyeable_carpet", () ->
		new DyeableCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	

	public static final RegistryObject<DyeableBlock> DYEABLE_BRICKS = DyeableBlocks.BLOCKS.register("dyeable_bricks", () ->
		new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));

	public static final RegistryObject<DyeableStairBlock> DYEABLE_BRICK_STAIRS = DyeableBlocks.BLOCKS.register("dyeable_brick_stairs", () ->
		new DyeableStairBlock(Blocks.BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BRICKS)));

	public static final RegistryObject<DyeableSlabBlock> DYEABLE_BRICK_SLAB = DyeableBlocks.BLOCKS.register("dyeable_brick_slab", () ->
		new DyeableSlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
	

	public static final RegistryObject<DyeableBlock> DYEABLE_TERRACOTTA = DyeableBlocks.BLOCKS.register("dyeable_terracotta", () ->
		new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA)));

	public static final RegistryObject<DyeableStairBlock> DYEABLE_TERRACOTTA_STAIRS = DyeableBlocks.BLOCKS.register("dyeable_terracotta_stairs", () ->
		new DyeableStairBlock(Blocks.WHITE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA)));

	public static final RegistryObject<DyeableSlabBlock> DYEABLE_TERRACOTTA_SLAB = DyeableBlocks.BLOCKS.register("dyeable_terracotta_slab", () ->
		new DyeableSlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA)));

	
	public static final RegistryObject<DyeableBlock> DYEABLE_PLANKS = DyeableBlocks.BLOCKS.register("dyeable_planks", () ->
		new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

	public static final RegistryObject<DyeableStairBlock> DYEABLE_PLANK_STAIRS = DyeableBlocks.BLOCKS.register("dyeable_plank_stairs", () ->
		new DyeableStairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

	public static final RegistryObject<DyeableSlabBlock> DYEABLE_PLANK_SLAB = DyeableBlocks.BLOCKS.register("dyeable_plank_slab", () ->
		new DyeableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

	
	public static final RegistryObject<DyeableBlock> DYEABLE_GLOWSTONE = DyeableBlocks.BLOCKS.register("dyeable_glowstone", () ->
		new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE)));

	public static final RegistryObject<DyeablePaneBlock> DYEABLE_IRON_BARS = DyeableBlocks.BLOCKS.register("dyeable_iron_bars", () ->
		new DyeablePaneBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS)));


	public static final RegistryObject<DyeableStainedGlassBlock> DYEABLE_STAINED_GLASS = DyeableBlocks.BLOCKS.register("dyeable_stained_glass", () ->
		new DyeableStainedGlassBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)));

	public static final RegistryObject<DyeableStainedGlassPaneBlock> DYEABLE_STAINED_GLASS_PANE = DyeableBlocks.BLOCKS.register("dyeable_stained_glass_pane", () ->
		new DyeableStainedGlassPaneBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)));

	
	public static final RegistryObject<BlockEntityType<DyeableBlockEntity>> DYEABLE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("dyeable_block_entity", () -> BlockEntityType.Builder.of(DyeableBlockEntity::new,
		DYEABLE_CONCRETE.get(), DYEABLE_CONCRETE_STAIRS.get(), DYEABLE_CONCRETE_SLAB.get(),
		DYEABLE_WOOL.get(), DYEABLE_WOOL_STAIRS.get(), DYEABLE_WOOL_SLAB.get(), DYEABLE_CARPET.get(),
		DYEABLE_BRICKS.get(), DYEABLE_BRICK_STAIRS.get(), DYEABLE_BRICK_SLAB.get(),
		DYEABLE_TERRACOTTA.get(), DYEABLE_TERRACOTTA_STAIRS.get(), DYEABLE_TERRACOTTA_SLAB.get(),
		DYEABLE_PLANKS.get(), DYEABLE_PLANK_STAIRS.get(), DYEABLE_PLANK_SLAB.get(),
		DYEABLE_GLOWSTONE.get(), DYEABLE_IRON_BARS.get(),
		DYEABLE_STAINED_GLASS.get(), DYEABLE_STAINED_GLASS_PANE.get()
	).build(null));

	/*public static void register() {
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_CONCRETE.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_CONCRETE_STAIRS.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_CONCRETE_SLAB.get());

		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_WOOL.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_WOOL_STAIRS.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_WOOL_SLAB.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_CARPET.get());

		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_BRICKS.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_BRICK_STAIRS.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_BRICK_SLAB.get());

		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_TERRACOTTA.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_TERRACOTTA_STAIRS.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_TERRACOTTA_SLAB.get());
		
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_PLANKS.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_PLANK_STAIRS.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_PLANK_SLAB.get());
		
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_GLOWSTONE.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_IRON_BARS.get());
		
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_STAINED_GLASS.get());
		SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(DYEABLE_STAINED_GLASS_PANE.get());
	}*/
}