package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ColorEssenceItem extends Item {
	public ColorEssenceItem(Properties properties) {
		super(properties);
	}
    
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    public ItemStack getCraftingRemainingItem(ItemStack stack) {;
        System.out.println("0");
        
        if (stack.getMaxDamage() > 1000) {
            // Unbreakable
            return stack.copy();
        } else {
            int damage = stack.getDamageValue();
            System.out.println("a");

            if (damage < stack.getMaxDamage() - 1) {
                System.out.println("b");
                ItemStack moreDamaged = stack.copy();
                moreDamaged.setDamageValue(damage + 1);

                return moreDamaged;
            }
        }

        return ItemStack.EMPTY;
	}
}