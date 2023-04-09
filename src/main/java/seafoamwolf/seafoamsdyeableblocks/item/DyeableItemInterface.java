package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public interface DyeableItemInterface extends DyeableLeatherItem {
    public static final int DEFAULT_COLOR = 16777215;

    @Override
    default public boolean hasCustomColor(ItemStack stack) {
        CompoundTag nbtCompound = stack.getTagElement(TAG_DISPLAY);
        return nbtCompound != null && nbtCompound.contains(TAG_COLOR, 99);
    }

    @Override
    default public int getColor(ItemStack stack) {
        //stack.getNbt().putInt("HideFlags", 64);

        CompoundTag nbtCompound = stack.getTagElement(TAG_DISPLAY);

        if (nbtCompound != null && nbtCompound.contains(TAG_COLOR, 99))
            return nbtCompound.getInt(TAG_COLOR);
        
        return DEFAULT_COLOR;
    }

    @Override
    default public void clearColor(ItemStack stack) {
        CompoundTag nbtCompound = stack.getTagElement(TAG_DISPLAY);

        if (nbtCompound != null && nbtCompound.contains(TAG_COLOR))
            nbtCompound.remove(TAG_COLOR);
    }

    @Override
    default public void setColor(ItemStack stack, int color) {
        CompoundTag nbtCompound = stack.getOrCreateTagElement(TAG_DISPLAY);
        nbtCompound.putInt(TAG_COLOR, color);
    }
}

