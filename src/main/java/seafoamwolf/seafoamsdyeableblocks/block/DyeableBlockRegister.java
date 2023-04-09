package seafoamwolf.seafoamsdyeableblocks.block;

import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.tag.TagKey;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class DyeableBlockRegister {
    public final Block Block;
    public final BlockItem Item;
    public final TagKey<Block> OriginalBlocks;

    public DyeableBlockRegister(String blockId, Block dyeableBlock) {
        Block = dyeableBlock;
        Item = new DyeableBlockItem(Block, new FabricItemSettings().group(SeafoamsDyeableBlocks.ITEM_GROUP));
        OriginalBlocks = TagKey.of(Registry.BLOCK.getKey(), new Identifier(SeafoamsDyeableBlocks.MOD_ID, blockId + "_replacable"));

        Identifier id = new Identifier(SeafoamsDyeableBlocks.MOD_ID, blockId);

        Registry.register(Registry.BLOCK, id, Block);
		Registry.register(Registry.ITEM, id, Item);
    }
}