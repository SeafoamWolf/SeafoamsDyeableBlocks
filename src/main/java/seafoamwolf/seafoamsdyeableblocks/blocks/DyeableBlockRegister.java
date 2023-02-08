package seafoamwolf.seafoamsdyeableblocks.blocks;

import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.block.entity.BlockEntityType;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.items.DyeableBlockItem;

public class DyeableBlockRegister {
    public final DyeableBlock Block;
    public final DyeableBlockItem Item;
    public final BlockEntityType<DyeableBlockEntity> BlockEntity;

    public DyeableBlockRegister(String blockId, FabricBlockSettings blockSettings) {
        Block = new DyeableBlock(blockSettings);
        Item = new DyeableBlockItem(Block, new FabricItemSettings());

        Identifier id = new Identifier(SeafoamsDyeableBlocks.MOD_ID, blockId);

        Registry.register(Registries.BLOCK, id, Block);
		Registry.register(Registries.ITEM, id, Item);

		BlockEntity = Registry.register(Registries.BLOCK_ENTITY_TYPE,
			new Identifier(SeafoamsDyeableBlocks.MOD_ID, blockId + "_block_entity"),
			FabricBlockEntityTypeBuilder.create(DyeableBlockEntity::new, Block).build(null));
    }
}