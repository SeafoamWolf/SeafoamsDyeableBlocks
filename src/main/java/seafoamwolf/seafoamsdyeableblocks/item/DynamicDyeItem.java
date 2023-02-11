package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.item.ItemStack;

public class DynamicDyeItem extends DyeableCustomItem {
	public DynamicDyeItem(Settings settings, String itemId) {
		super(settings, itemId);
    }

    public ItemStack getRecipeRemainder(ItemStack stack) {
        if (stack.getDamage() < stack.getMaxDamage() - 1) {
            ItemStack moreDamaged = stack.copy();
            moreDamaged.setDamage(stack.getDamage() + 1);

            return moreDamaged;
        }

        return ItemStack.EMPTY;
	}
}