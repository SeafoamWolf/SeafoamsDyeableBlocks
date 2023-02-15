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
	
	public static final DyeableBlockRegister DYEABLE_CONCRETE = new DyeableBlockRegister("dyeable_concrete",
		BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE));

	public static final DyeableBlockRegister DYEABLE_WOOL = new DyeableBlockRegister("dyeable_wool",
		BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL));
	
	public static final DyeableBlockRegister DYEABLE_PLANKS = new DyeableBlockRegister("dyeable_planks",
		BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
	
	public static final DyeableBlockRegister DYEABLE_GLOWSTONE = new DyeableBlockRegister("dyeable_glowstone",
		BlockBehaviour.Properties.copy(Blocks.GLOWSTONE));

	public static final DyeableBlockRegister DYEABLE_BRICKS = new DyeableBlockRegister("dyeable_bricks",
		BlockBehaviour.Properties.copy(Blocks.BRICKS));

	public static final RegistryObject<BlockEntityType<DyeableBlockEntity>> DYEABLE_BLOCK_ENTITY =
		BLOCK_ENTITY_TYPES.register("dyeable_block_entity", () ->
			BlockEntityType.Builder.of(DyeableBlockEntity::new,
				DYEABLE_CONCRETE.Block.get(), DYEABLE_WOOL.Block.get(),
				DYEABLE_PLANKS.Block.get(), DYEABLE_GLOWSTONE.Block.get(),
				DYEABLE_BRICKS.Block.get()
			).build(null));
}