package seafoamwolf.seafoamsdyeableblocks.item;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.util.Formatting;
import net.minecraft.util.Language;
import net.minecraft.world.World;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.text.Text;

public class TooltippedItem extends Item {
    private final String ITEM_ID;

	public TooltippedItem(Settings settings, String itemId) {
		super(settings);
        ITEM_ID = itemId;
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        Language language = Language.getInstance();

        for (int i = 0; i < 10; i++) {
            String key = "item.seafoamsdyeableblocks." + ITEM_ID + ".tooltip" + Integer.toString(i);

            if (language.get(key).equals(key))
                break;
            
            tooltip.add(Text.translatable("item.seafoamsdyeableblocks." + ITEM_ID + ".tooltip" + Integer.toString(i)).formatted(Formatting.GRAY));
        }
	}
}