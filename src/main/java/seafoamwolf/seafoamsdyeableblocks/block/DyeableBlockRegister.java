package seafoamwolf.seafoamsdyeableblocks.block;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;

public class DyeableBlockRegister {
    public final Block Block;
    public final BlockItem Item;
    public final Block[] OriginalBlocks;

    public DyeableBlockRegister(String blockId, FabricBlockSettings blockSettings, Block[] originalBlocks) {
        Block = new DyeableBlock(blockSettings);
        Item = new DyeableBlockItem(Block, new FabricItemSettings().group(SeafoamsDyeableBlocks.ITEM_GROUP));
        OriginalBlocks = originalBlocks;

        Identifier id = new Identifier(SeafoamsDyeableBlocks.MOD_ID, blockId);

        Registry.register(Registry.BLOCK, id, Block);
		Registry.register(Registry.ITEM, id, Item);
    }
}