package seafoamwolf.seafoamsdyeableblocks.block;

import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class DyeableBlockRegister {
    public final Block Block;
    public final BlockItem Item;
    public final Block[] OriginalBlocks;

    public DyeableBlockRegister(String blockId, FabricBlockSettings blockSettings, Block[] originalBlocks) {
        Block = new DyeableBlock(blockSettings);
        Item = new DyeableBlockItem(Block, new FabricItemSettings());
        OriginalBlocks = originalBlocks;

        Identifier id = new Identifier(SeafoamsDyeableBlocks.MOD_ID, blockId);

        Registry.register(Registries.BLOCK, id, Block);
		Registry.register(Registries.ITEM, id, Item);

        ItemGroupEvents.modifyEntriesEvent(SeafoamsDyeableBlocks.ITEM_GROUP).register(content -> {
            content.add(Item);
        });
    }
}