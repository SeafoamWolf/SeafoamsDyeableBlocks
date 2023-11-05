package seafoamwolf.seafoamsdyeableblocks.fabric.item;

import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public interface DyeableItemInterface extends DyeableItem {
    public static final int DEFAULT_COLOR = 16777215;

    @Override
    default public boolean hasColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);
        return nbtCompound != null && nbtCompound.contains(COLOR_KEY, NbtElement.NUMBER_TYPE);
    }

    @Override
    default public int getColor(ItemStack stack) {
        //stack.getNbt().putInt("HideFlags", 64);

        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);

        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY, NbtElement.NUMBER_TYPE))
            return nbtCompound.getInt(COLOR_KEY);
        
        return DEFAULT_COLOR;
    }

    @Override
    default public void removeColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);

        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY))
            nbtCompound.remove(COLOR_KEY);
    }

    @Override
    default public void setColor(ItemStack stack, int color) {
        NbtCompound nbtCompound = stack.getOrCreateSubNbt(DISPLAY_KEY);
        nbtCompound.putInt(COLOR_KEY, color);
    }
}

