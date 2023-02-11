package seafoamwolf.seafoamsdyeableblocks.item;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.DyeableItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Formatting;

import net.minecraft.world.World;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.text.Text;

public class DyeableCustomItem extends TooltippedItem implements DyeableItem {
	public DyeableCustomItem(Settings settings, String itemId) {
		super(settings, itemId);
	}
	
	@Override
	public int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);
		int color = 16777215;

        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY, 99))
            color = nbtCompound.getInt(COLOR_KEY);
		
		return color;
    }

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.literal("#" + Integer.toHexString(getColor(stack)).toUpperCase()).formatted(Formatting.ITALIC, Formatting.GRAY));
	}
}