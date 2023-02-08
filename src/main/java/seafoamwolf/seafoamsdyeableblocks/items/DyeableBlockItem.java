package seafoamwolf.seafoamsdyeableblocks.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.DyeableItem;
import net.minecraft.nbt.NbtCompound;

public class DyeableBlockItem extends BlockItem implements DyeableItem {
	public DyeableBlockItem(Block block, Settings settings) {
		super(block, settings);
	}

	@Override
	public int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);

        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY, 99)) {
            return nbtCompound.getInt(COLOR_KEY);
		} else {
			return 16777215;
		}
    }
}