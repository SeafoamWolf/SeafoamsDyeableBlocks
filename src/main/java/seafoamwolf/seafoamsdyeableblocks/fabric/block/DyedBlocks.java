package seafoamwolf.seafoamsdyeableblocks.fabric.block;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.fabric.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.fabric.data.DyeableLists;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class DyedBlocks {
	// Blocks

	public static DyedBlock DYEABLE_CONCRETE = new DyedBlock(Blocks.WHITE_CONCRETE);
	public static DyedStairsBlock DYEABLE_CONCRETE_STAIRS = new DyedStairsBlock(Blocks.WHITE_CONCRETE);
	public static DyedSlabBlock DYEABLE_CONCRETE_SLAB = new DyedSlabBlock(Blocks.WHITE_CONCRETE);

	public static DyedBlock DYEABLE_WOOL = new DyedBlock(Blocks.WHITE_WOOL);
	public static DyedStairsBlock DYEABLE_WOOL_STAIRS = new DyedStairsBlock(Blocks.WHITE_WOOL);
	public static DyedSlabBlock DYEABLE_WOOL_SLAB = new DyedSlabBlock(Blocks.WHITE_WOOL);
	public static DyedCarpetBlock DYEABLE_CARPET = new DyedCarpetBlock(Blocks.WHITE_CARPET);

	public static DyedBlock DYEABLE_BRICKS = new DyedBlock(Blocks.BRICKS);
	public static DyedStairsBlock DYEABLE_BRICK_STAIRS = new DyedStairsBlock(Blocks.BRICK_STAIRS);
	public static DyedSlabBlock DYEABLE_BRICK_SLAB = new DyedSlabBlock(Blocks.BRICK_SLAB);

	public static DyedBlock DYEABLE_TERRACOTTA = new DyedBlock(Blocks.WHITE_TERRACOTTA);
	public static DyedStairsBlock DYEABLE_TERRACOTTA_STAIRS = new DyedStairsBlock(Blocks.WHITE_TERRACOTTA);
	public static DyedSlabBlock DYEABLE_TERRACOTTA_SLAB = new DyedSlabBlock(Blocks.WHITE_TERRACOTTA);

	public static DyedBlock DYEABLE_PLANKS = new DyedBlock(Blocks.OAK_PLANKS);
	public static DyedStairsBlock DYEABLE_PLANK_STAIRS = new DyedStairsBlock(Blocks.OAK_STAIRS);
	public static DyedSlabBlock DYEABLE_PLANK_SLAB = new DyedSlabBlock(Blocks.OAK_SLAB);

	public static DyedStainedGlassBlock DYEABLE_STAINED_GLASS = new DyedStainedGlassBlock(Blocks.WHITE_STAINED_GLASS);
	public static DyedStainedGlassPaneBlock DYEABLE_STAINED_GLASS_PANE = new DyedStainedGlassPaneBlock(Blocks.WHITE_STAINED_GLASS_PANE);

	public static DyedBlock DYEABLE_GLOWSTONE = new DyedBlock(Blocks.GLOWSTONE);
	public static DyedPaneBlock DYEABLE_IRON_BARS = new DyedPaneBlock(Blocks.IRON_BARS);

	public static DyedPillarBlock DYEABLE_STRIPPED_LOG = new DyedPillarBlock(Blocks.STRIPPED_OAK_LOG);
	public static DyedPillarBlock DYEABLE_STRIPPED_WOOD = new DyedPillarBlock(Blocks.STRIPPED_OAK_WOOD);
	
	public static BlockEntityType<DyedBlockEntity> DYEABLE_BLOCK_ENTITY;
	
	public static void register() {
		FabricBlockEntityTypeBuilder<DyedBlockEntity> blockEntityBuilder = FabricBlockEntityTypeBuilder.create(DyedBlockEntity::new);
		Class<?> thisClass;

		try {
			DyedBlocks thisObject = new DyedBlocks();
			thisClass = Class.forName(thisObject.getClass().getName());
	
			Field[] aClassFields = thisClass.getDeclaredFields();

			for(Field f : aClassFields){
				Object value = f.get(null);

				if (!(value instanceof Block)) {
					continue;
				}

				if (value instanceof DyedBlockInterface) {
					System.out.println(f.getName());

					DyedBlockRegister blockRegister = new DyedBlockRegister(f.getName().toLowerCase(), (Block)value);
					DyeableLists.registerDyeableBlock(blockRegister);
					blockEntityBuilder.addBlock((Block)value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DYEABLE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
			new Identifier(SeafoamsDyeableBlocks.MOD_ID, "dyeable_block_entity"),
			blockEntityBuilder.build(null));
	}
}