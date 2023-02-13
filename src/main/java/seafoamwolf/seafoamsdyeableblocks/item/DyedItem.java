package seafoamwolf.seafoamsdyeableblocks.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class DyedItem extends TooltippedItem implements DyeableItemInterface {
    public DyedItem(Settings settings, String itemId) {
		super(settings, itemId);
    }

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.literal("#" + Integer.toHexString(getColor(stack)).toUpperCase()).formatted(Formatting.ITALIC, Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
	}
}