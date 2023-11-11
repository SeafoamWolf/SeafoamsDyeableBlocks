package seafoamwolf.seafoamsdyeableblocks.fabric.block;

import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.fabric.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.fabric.registry.BlockRegistry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class DyedBlockRegister {
    public final Block Block;
    public final BlockItem Item;
    public final TagKey<Block> OriginalBlocks;

    public DyedBlockRegister(String blockId, Block dyeableBlock) {
        Block = dyeableBlock;
        Item = BlockRegistry.registerDefaultBlock(blockId, Block);
        OriginalBlocks = TagKey.of(RegistryKeys.BLOCK, new Identifier(SeafoamsDyeableBlocks.MOD_ID, blockId + "_replacable"));

        ItemGroupEvents.modifyEntriesEvent(SeafoamsDyeableBlocks.ITEM_GROUP_KEY).register(content -> { content.add(Item); });
    }
}