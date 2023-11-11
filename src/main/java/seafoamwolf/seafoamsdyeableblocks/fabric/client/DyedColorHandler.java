package seafoamwolf.seafoamsdyeableblocks.fabric.client;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.Item;
import net.minecraft.client.render.RenderLayer;
import seafoamwolf.seafoamsdyeableblocks.fabric.block.DyedBlockEntity;
import seafoamwolf.seafoamsdyeableblocks.fabric.block.DyedBlockRegister;
import seafoamwolf.seafoamsdyeableblocks.fabric.block.DyedBlocks;
import seafoamwolf.seafoamsdyeableblocks.fabric.data.DyeableLists;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyeableBlockItem;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyedItem;

@Environment(value=EnvType.CLIENT)
public class DyedColorHandler {
    public static void register() {
        registerBlocks();
        registerItems();
    }

    private static void registerBlocks() {
        List<DyedBlockRegister> dyeableBlocks = DyeableLists.dyeableBlocks;

		// Allow the texture to work right
		BlockRenderLayerMap.INSTANCE.putBlock(DyedBlocks.DYEABLE_BRICKS, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(DyedBlocks.DYEABLE_BRICK_STAIRS, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(DyedBlocks.DYEABLE_BRICK_SLAB, RenderLayer.getCutoutMipped());

		BlockRenderLayerMap.INSTANCE.putBlock(DyedBlocks.DYEABLE_IRON_BARS, RenderLayer.getCutoutMipped());

		BlockRenderLayerMap.INSTANCE.putBlock(DyedBlocks.DYEABLE_STAINED_GLASS, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(DyedBlocks.DYEABLE_STAINED_GLASS_PANE, RenderLayer.getTranslucent());

		dyeableBlocks.forEach((block) -> ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
			BlockEntity blockEntity = view.getBlockEntity(pos);

			if (blockEntity != null && blockEntity instanceof DyedBlockEntity) {
				return ((DyedBlockEntity)blockEntity).getColor();
			}
			
			return 16777215;
		}, block.Block));

		dyeableBlocks.forEach((block) -> ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
             ((tintIndex == 1 ? ((DyeableBlockItem)stack.getItem()).getColor(stack) : 16777215))
		, block.Item));
    }

    private static void registerItems() {
        List<Item> dyeableItems = DyeableLists.dyeableItems;
		
		dyeableItems.forEach((item) -> ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
            ((tintIndex == 1 ? ((DyedItem)stack.getItem()).getColor(stack) : 16777215)), item));
    }
}
