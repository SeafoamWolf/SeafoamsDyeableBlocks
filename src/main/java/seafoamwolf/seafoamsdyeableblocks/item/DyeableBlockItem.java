package seafoamwolf.seafoamsdyeableblocks.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemStack;

public class DyeableBlockItem extends BlockItem implements DyeableBlockItemInterface {
	public DyeableBlockItem(Block block, Properties properties) {
		super(block, properties);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
		String hex = Integer.toHexString(getColor(stack)).toUpperCase();
		int digitsShort = 6 - hex.length();

		if (digitsShort > 0)
			for (int i = 0; i < digitsShort; i++)
				hex = "0" + hex;
		
		tooltip.add(Component.literal("#" + hex).withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));
		
        super.appendHoverText(stack, world, tooltip, context);
	}
}