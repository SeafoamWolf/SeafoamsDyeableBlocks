package seafoamwolf.seafoamsdyeableblocks.client.blocks;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.fabricmc.fabric.api.client.rendering.v1.*;

import seafoamwolf.seafoamsdyeableblocks.blocks.DyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.blocks.DyeableBlockRegister;
import seafoamwolf.seafoamsdyeableblocks.blocks.DyeableBlockEntity;
import seafoamwolf.seafoamsdyeableblocks.items.DyeableBlockItem;

public class DyeableBlocksClient {
	@Environment(EnvType.CLIENT)
	public static void register() {
        List<DyeableBlockRegister> dyeableBlocks = DyeableBlocks.GetDyeableBlocks();

		dyeableBlocks.forEach((block) -> ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
			if (view.getBlockEntity(pos) != null) {
				return ((DyeableBlockEntity)view.getBlockEntity(pos)).getColor();
			} else {
				return 16777215;
			}
		}, block.Block));

		dyeableBlocks.forEach((block) -> ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
            ((DyeableBlockItem)stack.getItem()).getColor(stack), block.Item));
	}
}
