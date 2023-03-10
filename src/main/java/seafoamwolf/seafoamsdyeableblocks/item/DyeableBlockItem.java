package seafoamwolf.seafoamsdyeableblocks.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;

import net.minecraft.world.World;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.text.Text;

public class DyeableBlockItem extends BlockItem implements DyeableItemInterface {
	public DyeableBlockItem(Block block, Settings settings) {
		super(block, settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.literal("#" + Integer.toHexString(getColor(stack)).toUpperCase()).formatted(Formatting.ITALIC, Formatting.GRAY));
	}
}