package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public interface DyeableItemInterface extends DyeableItem {
    public static final int DEFAULT_COLOR = 16777215;

    @Override
    default public int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);

        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY, NbtElement.NUMBER_TYPE)) {
            stack.getNbt().putInt("HideFlags", 64);
            return nbtCompound.getInt(COLOR_KEY);
        }
        
        return DEFAULT_COLOR;
    }
}

