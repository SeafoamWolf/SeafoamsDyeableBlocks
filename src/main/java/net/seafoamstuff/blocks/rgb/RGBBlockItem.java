package net.seafoamstuff.blocks.rgb;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;

public class RGBBlockItem extends BlockItem implements DyeableItem {
	public RGBBlockItem(Block block, Settings settings) {
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