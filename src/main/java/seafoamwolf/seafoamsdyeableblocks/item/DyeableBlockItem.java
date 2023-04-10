package seafoamwolf.seafoamsdyeableblocks.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;
import net.minecraft.text.*;

import net.minecraft.world.World;
import net.minecraft.client.item.TooltipContext;

public class DyeableBlockItem extends BlockItem implements DyeableBlockItemInterface {
	public DyeableBlockItem(Block block, Settings settings) {
		super(block, settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		String hex = Integer.toHexString(getColor(stack)).toUpperCase();
		int digitsShort = 6 - hex.length();

		if (digitsShort > 0)
			for (int i = 0; i < digitsShort; i++)
				hex = "0" + hex;

		tooltip.add(Text.of("#" + hex).getWithStyle(Style.EMPTY.withColor(Formatting.GRAY).withItalic(true)).get(0));
        super.appendTooltip(stack, world, tooltip, context);
	}
}