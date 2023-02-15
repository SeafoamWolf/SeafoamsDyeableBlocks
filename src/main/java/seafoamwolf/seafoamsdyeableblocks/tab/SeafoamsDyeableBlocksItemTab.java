package seafoamwolf.seafoamsdyeableblocks.tab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableItems;

public class SeafoamsDyeableBlocksItemTab extends CreativeModeTab {
    public SeafoamsDyeableBlocksItemTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(DyeableItems.COLOR_ESSENCE.get());
    }
}