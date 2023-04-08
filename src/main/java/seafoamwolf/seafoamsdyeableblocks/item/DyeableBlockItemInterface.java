package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public interface DyeableBlockItemInterface extends DyeableItem {
    public static final int DEFAULT_COLOR = 16777215;

    @Override
    default public boolean hasColor(ItemStack stack) {
        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);
        return nbtCompound != null && nbtCompound.contains(COLOR_KEY, NbtElement.NUMBER_TYPE);
    }

    @Override
    default public int getColor(ItemStack stack) {
        //stack.getNbt().putInt("HideFlags", 64);

        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);

        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY, NbtElement.NUMBER_TYPE))
            return nbtCompound.getInt(COLOR_KEY);
        
        return DEFAULT_COLOR;
    }

    @Override
    default public void removeColor(ItemStack stack) {
        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);

        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY))
            nbtCompound.remove(COLOR_KEY);
    }

    @Override
    default public void setColor(ItemStack stack, int color) {
        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);

        if (nbtCompound != null)
            nbtCompound.putInt(COLOR_KEY, color);
    }
}

