package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockEntity;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockInterface;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockRegister;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlocks;

public class PaintbrushItem extends DyedItem {
	public PaintbrushItem(Settings settings, String itemId) {
		super(settings, itemId);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return ingredient.isOf(DyeableItems.COLOR_ESSENCE);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		BlockPos pos = context.getBlockPos();
		ItemStack handItem = context.getStack();
		PlayerEntity player = context.getPlayer();

		BlockState blockStateAt = world.getBlockState(pos);
		Block blockAt = blockStateAt.getBlock();

		if (!player.isSneaking()) {
			for (DyeableBlockRegister dyeableBlock : DyeableBlocks.GetDyeable()) {
				if (!blockStateAt.isIn(dyeableBlock.OriginalBlocks))
					continue;
					
				int dyeColor = ((PaintbrushItem)handItem.getItem()).getColor(handItem);

				world.setBlockState(pos, dyeableBlock.Block.getStateWithProperties(blockStateAt), Block.FORCE_STATE);

				DyeableBlockEntity blockEntity = (DyeableBlockEntity)world.getBlockEntity(pos);

				blockEntity.setOriginalBlock(blockAt);
				blockEntity.setColor(dyeColor, player);
				
				world.getBlockState(pos).updateNeighbors(world, pos, Block.NOTIFY_ALL);

				if (!player.isCreative())
					handItem.setDamage(handItem.getDamage() + 1);

				player.playSound(SoundEvents.ITEM_DYE_USE, 1, 1);

				return ActionResult.SUCCESS;
			}
			// Pick blocks if item is a netherite paintbrush
		} else if (handItem.getItem() == DyeableItems.NETHERITE_PAINTBRUSH) {
			int newColor = 0;

			if (blockAt instanceof DyeableBlockInterface) {
				BlockEntity blockEntity = world.getBlockEntity(pos);

				if (blockEntity == null || !(blockEntity instanceof DyeableBlockEntity))
					return ActionResult.PASS;

				newColor = ((DyeableBlockEntity)blockEntity).getColor();
			} else {
				newColor = blockAt.getDefaultMapColor().color;
			}

			if (getColor(handItem) == newColor)
				return ActionResult.PASS;

			setColor(handItem, newColor);

			if (!player.isCreative())
				handItem.setDamage(handItem.getDamage() + 1);
			
			player.playSound(SoundEvents.ITEM_DYE_USE, 1, 1);
		}

        return ActionResult.PASS;
    }
}