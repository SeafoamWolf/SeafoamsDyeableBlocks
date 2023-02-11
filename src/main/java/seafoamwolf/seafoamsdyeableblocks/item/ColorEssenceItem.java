package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.item.ItemStack;

public class ColorEssenceItem extends TooltippedItem {
	public ColorEssenceItem(Settings settings, String itemId) {
		super(settings, itemId);
	}

    public ItemStack getRecipeRemainder(ItemStack stack) {
        if (stack.getMaxDamage() > 1000) {
            // Unbreakable
            return stack.copy();
        } else if (stack.getDamage() < stack.getMaxDamage() - 1) {
            ItemStack moreDamaged = stack.copy();
            moreDamaged.setDamage(stack.getDamage() + 1);

            return moreDamaged;
        }

        return ItemStack.EMPTY;
	}
}