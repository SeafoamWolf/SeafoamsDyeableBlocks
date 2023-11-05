package seafoamwolf.seafoamsdyeableblocks.fabric.client.item;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.minecraft.item.Item;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyeableItems;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyedItem;

@Environment(value=EnvType.CLIENT)
public class DyedItemClient {
	public static void register() {
        List<Item> dyeableItems = DyeableItems.GetDyeable();
		
		dyeableItems.forEach((item) -> ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
            ((tintIndex == 1 ? ((DyedItem)stack.getItem()).getColor(stack) : 16777215)), item));
	}
}
