package seafoamwolf.seafoamsdyeableblocks.block;

import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;

public class DyeableBlockRegister {
    public final Block Block;
    public final BlockItem Item;

    public DyeableBlockRegister(String blockId, FabricBlockSettings blockSettings) {
        Block = new DyeableBlock(blockSettings);
        Item = new DyeableBlockItem(Block, new FabricItemSettings());

        Identifier id = new Identifier(SeafoamsDyeableBlocks.MOD_ID, blockId);

        Registry.register(Registries.BLOCK, id, Block);
		Registry.register(Registries.ITEM, id, Item);

        ItemGroupEvents.modifyEntriesEvent(SeafoamsDyeableBlocks.ITEM_GROUP).register(content -> {
            content.add(Item);
        });
    }
}