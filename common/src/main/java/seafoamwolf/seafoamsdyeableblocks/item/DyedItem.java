package seafoamwolf.seafoamsdyeableblocks.item;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class DyedItem extends Item implements DyeableLeatherItem {
    public DyedItem(Properties properties) {
		super(properties);
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
