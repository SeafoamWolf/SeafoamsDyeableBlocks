package seafoamwolf.seafoamsdyeableblocks.client.blocks;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.Item;

import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockEntity;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockRegister;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableItems;
import seafoamwolf.seafoamsdyeableblocks.item.DyedItem;

@Environment(value=EnvType.CLIENT)
public class DyeableBlocksClient {
	public static void register() {
        List<DyeableBlockRegister> dyeableBlocks = DyeableBlocks.GetDyeable();
        List<Item> dyeableItems = DyeableItems.GetDyeable();

		dyeableBlocks.forEach((block) -> ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
			BlockEntity blockEntity = view.getBlockEntity(pos);
			int color = 16777215;

			if (blockEntity != null && blockEntity instanceof DyeableBlockEntity)
				color = ((DyeableBlockEntity)blockEntity).getColor();
			
			return color;
		}, block.Block));

		dyeableBlocks.forEach((block) -> ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
            ((DyeableBlockItem)stack.getItem()).getColor(stack), block.Item));

		dyeableItems.forEach((item) -> ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
            ((DyedItem)stack.getItem()).getColor(stack), item));
	}
}
