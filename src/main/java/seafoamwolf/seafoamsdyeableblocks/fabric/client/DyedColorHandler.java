package seafoamwolf.seafoamsdyeableblocks.fabric.client;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.Item;
import net.minecraft.client.render.RenderLayer;
import seafoamwolf.seafoamsdyeableblocks.fabric.block.DyeableBlockEntity;
import seafoamwolf.seafoamsdyeableblocks.fabric.block.DyeableBlockRegister;
import seafoamwolf.seafoamsdyeableblocks.fabric.block.DyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyeableBlockItem;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyeableItems;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyedItem;

@Environment(value=EnvType.CLIENT)
public class DyedColorHandler {
    public static void register() {
        registerBlocks();
        registerItems();
    }

    private static void registerBlocks() {
        List<DyeableBlockRegister> dyeableBlocks = DyeableBlocks.GetDyeable();

		// Allow the texture to work right
		BlockRenderLayerMap.INSTANCE.putBlock(DyeableBlocks.DYEABLE_BRICKS.Block, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(DyeableBlocks.DYEABLE_BRICK_STAIRS.Block, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(DyeableBlocks.DYEABLE_BRICK_SLAB.Block, RenderLayer.getCutoutMipped());

		BlockRenderLayerMap.INSTANCE.putBlock(DyeableBlocks.DYEABLE_IRON_BARS.Block, RenderLayer.getCutoutMipped());

		BlockRenderLayerMap.INSTANCE.putBlock(DyeableBlocks.DYEABLE_STAINED_GLASS.Block, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(DyeableBlocks.DYEABLE_STAINED_GLASS_PANE.Block, RenderLayer.getTranslucent());

		dyeableBlocks.forEach((block) -> ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
			int color = 16777215;

			BlockEntity blockEntity = view.getBlockEntity(pos);

			if (blockEntity != null && blockEntity instanceof DyeableBlockEntity)
				color = ((DyeableBlockEntity)blockEntity).getColor();
			
			return color;
		}, block.Block));

		dyeableBlocks.forEach((block) -> ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
            ((DyeableBlockItem)stack.getItem()).getColor(stack), block.Item));
    }

    private static void registerItems() {
        List<Item> dyeableItems = DyeableItems.GetDyeable();
		
		dyeableItems.forEach((item) -> ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
            ((tintIndex == 1 ? ((DyedItem)stack.getItem()).getColor(stack) : 16777215)), item));
    }
}
