package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public interface DyeableItemInterface extends DyeableLeatherItem {
    int DEFAULT_COLOR = 16777215;

    @Override
    default int getColor(ItemStack stack) {
        CompoundTag compoundtag = stack.getTagElement(TAG_DISPLAY);
        return compoundtag != null && compoundtag.contains(TAG_COLOR, 99) ? compoundtag.getInt(TAG_COLOR) : DEFAULT_COLOR;
    }
}

