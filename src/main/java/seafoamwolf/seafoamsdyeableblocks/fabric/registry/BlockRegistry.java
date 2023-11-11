package seafoamwolf.seafoamsdyeableblocks.fabric.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import seafoamwolf.seafoamsdyeableblocks.fabric.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyeableBlockItem;

public class BlockRegistry {
    public static BlockItem registerDefaultBlock(String id, Block block) {
        Identifier identifier = new Identifier(SeafoamsDyeableBlocks.MOD_ID, id);

        Registry.register(Registries.BLOCK, identifier, block);
        
        BlockItem blockItem = ItemRegistry.registerDefaultBlockItem(identifier, block);

        return blockItem;
    }

    public static DyeableBlockItem registerDyedBlock(String id, Block block) {
        Identifier identifier = new Identifier(SeafoamsDyeableBlocks.MOD_ID, id);

        Registry.register(Registries.BLOCK, identifier, block);
        
        DyeableBlockItem blockItem = ItemRegistry.registerDyedBlockItem(identifier, block);

        return blockItem;
    }
}
