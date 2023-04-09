package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public interface DyeableBlockItemInterface extends DyeableLeatherItem {
    public static final int DEFAULT_COLOR = 16777215;

    @Override
    default public boolean hasCustomColor(ItemStack stack) {
        CompoundTag nbtCompound = BlockItem.getBlockEntityData(stack);
        return nbtCompound != null && nbtCompound.contains(TAG_COLOR, 99);
    }

    @Override
    default public int getColor(ItemStack stack) {
        //stack.getNbt().putInt("HideFlags", 64);

        CompoundTag nbtCompound = BlockItem.getBlockEntityData(stack);

        if (nbtCompound != null && nbtCompound.contains(TAG_COLOR, 99))
            return nbtCompound.getInt(TAG_COLOR);
        
        return DEFAULT_COLOR;
    }

    @Override
    default public void clearColor(ItemStack stack) {
        CompoundTag nbtCompound = BlockItem.getBlockEntityData(stack);

        if (nbtCompound != null && nbtCompound.contains(TAG_COLOR))
            nbtCompound.remove(TAG_COLOR);
    }

    @Override
    default public void setColor(ItemStack stack, int color) {
        CompoundTag nbtCompound = BlockItem.getBlockEntityData(stack);

        if (nbtCompound != null)
            nbtCompound.putInt(TAG_COLOR, color);
    }
}

