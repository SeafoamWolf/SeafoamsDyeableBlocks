package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class DyeableBlockItem extends BlockItem implements DyeableItemInterface {
	public DyeableBlockItem(Block block, Properties properties) {
		super(block, properties);
	}
}