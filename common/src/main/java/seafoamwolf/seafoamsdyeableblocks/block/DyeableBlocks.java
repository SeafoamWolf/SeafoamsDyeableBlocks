package seafoamwolf.seafoamsdyeableblocks.block;

import java.lang.reflect.Field;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.block.entity.DyeableBlockEntity;
import seafoamwolf.seafoamsdyeableblocks.block.types.*;
import seafoamwolf.seafoamsdyeableblocks.data.DyeableLists;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;

public class DyeableBlocks {
	public static final DyeableBlock DYEABLE_CONCRETE = new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE));
	public static final DyeableStairBlock DYEABLE_CONCRETE_STAIRS = new DyeableStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE));
	public static final DyeableSlabBlock DYEABLE_CONCRETE_SLAB = new DyeableSlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE));
	

	public static final DyeableBlock DYEABLE_WOOL = new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL));
	public static final DyeableStairBlock DYEABLE_WOOL_STAIRS = new DyeableStairBlock(Blocks.WHITE_WOOL.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL));
	public static final DyeableSlabBlock DYEABLE_WOOL_SLAB = new DyeableSlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL));

	public static final DyeableCarpetBlock DYEABLE_CARPET = new DyeableCarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL));
	

	public static final DyeableBlock DYEABLE_BRICKS = new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS));
	public static final DyeableStairBlock DYEABLE_BRICK_STAIRS = new DyeableStairBlock(Blocks.BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BRICKS));
	public static final DyeableSlabBlock DYEABLE_BRICK_SLAB = new DyeableSlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS));
	

	public static final DyeableBlock DYEABLE_TERRACOTTA = new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA));
	public static final DyeableStairBlock DYEABLE_TERRACOTTA_STAIRS = new DyeableStairBlock(Blocks.WHITE_TERRACOTTA.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA));
	public static final DyeableSlabBlock DYEABLE_TERRACOTTA_SLAB = new DyeableSlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA));

	
	public static final DyeableBlock DYEABLE_PLANKS = new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
	public static final DyeableStairBlock DYEABLE_PLANK_STAIRS = new DyeableStairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
	public static final DyeableSlabBlock DYEABLE_PLANK_SLAB = new DyeableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));

	
	public static final DyeableBlock DYEABLE_GLOWSTONE = new DyeableBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE));

	public static final DyeableIronBarsBlock DYEABLE_IRON_BARS = new DyeableIronBarsBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS));


	public static final DyeableStainedGlassBlock DYEABLE_STAINED_GLASS = new DyeableStainedGlassBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS));
	public static final DyeableStainedGlassPaneBlock DYEABLE_STAINED_GLASS_PANE = new DyeableStainedGlassPaneBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE));

	public static final DyeableRotatedPillarBlock DYEABLE_STRIPPED_LOG = new DyeableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG));
	public static final DyeableRotatedPillarBlock DYEABLE_STRIPPED_WOOD = new DyeableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD));
    
    public static final BlockEntityType<DyeableBlockEntity> DYEABLE_BLOCK_ENTITY_TYPE = BlockEntityType.Builder.of(DyeableBlockEntity::new).build(null);

    public static void init() {
		registerBlocks();
		
		SeafoamsDyeableBlocks.BLOCK_ENTITY_TYPE.register("dyeable_blocks", () -> DYEABLE_BLOCK_ENTITY_TYPE);

		SeafoamsDyeableBlocks.BLOCKS.register();
		SeafoamsDyeableBlocks.BLOCK_ENTITY_TYPE.register();
    }

	private static void registerBlocks() {
		Class<?> thisClass;

		try {
			DyeableBlocks thisObject = new DyeableBlocks();
			thisClass = Class.forName(thisObject.getClass().getName());
	
			Field[] aClassFields = thisClass.getDeclaredFields();

			for(Field f : aClassFields){
				Object value = f.get(null);

				if (!(value instanceof Block)) {
					continue;
				}

				if (value instanceof DyeableBlockInterface) {
					registerDyeableBlock(f.getName().toLowerCase(), (Block)value);
					DyeableLists.registerDyeableBlock((DyeableBlockInterface)value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void registerDyeableBlock(String id, Block block) {
        SeafoamsDyeableBlocks.BLOCKS.register(id, () -> block);
        SeafoamsDyeableBlocks.ITEMS.register(id, () -> new DyeableBlockItem(block, new Item.Properties().arch$tab(SeafoamsDyeableBlocks.ITEM_TAB)));
	}
}
