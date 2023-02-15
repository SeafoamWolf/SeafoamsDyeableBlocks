package seafoamwolf.seafoamsdyeableblocks.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item.Properties;

import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableItems;

public class DyeableBlockRegister {
    public final RegistryObject<DyeableBlock> Block;
    public final RegistryObject<DyeableBlockItem> Item;

    public DyeableBlockRegister(String blockId, BlockBehaviour.Properties properties) {
        Block = DyeableBlocks.BLOCKS.register(blockId, () ->
            new DyeableBlock(properties));
        
        Item = DyeableItems.ITEMS.register(blockId, () ->
            new DyeableBlockItem(Block.get(), new Properties().tab(SeafoamsDyeableBlocks.ITEM_TAB)));
        
        SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(this);
    }
}