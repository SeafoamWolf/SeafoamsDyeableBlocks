package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ColorEssenceItem extends Item {
	public ColorEssenceItem(Properties properties) {
		super(properties);
	}

    public ItemStack getRecipeRemainder(ItemStack stack) {
        if (stack.getMaxDamage() > 1000) {
            // Unbreakable
            return stack.copy();
        } else if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
            ItemStack moreDamaged = stack.copy();
            moreDamaged.setDamageValue(stack.getDamageValue() + 1);

            return moreDamaged;
        }

        return ItemStack.EMPTY;
	}
}