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
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockRegister;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlocks;

public class DynamicDyeItem extends DyedItem {
	public DynamicDyeItem(Settings settings, String itemId) {
		super(settings, itemId);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		BlockPos pos = context.getBlockPos();
		ItemStack handItem = context.getStack();
		PlayerEntity player = context.getPlayer();

		BlockState blockStateAt = world.getBlockState(pos);
		Block blockAt = blockStateAt.getBlock();

		for (DyeableBlockRegister dyeableBlock : DyeableBlocks.GetDyeable()) {
			for (Block originalBlock : dyeableBlock.OriginalBlocks) {
				if (originalBlock != blockAt) // Only continue if block is in list!!! Done for less tabbing.
					continue;
				
				int dyeColor = ((DynamicDyeItem)handItem.getItem()).getColor(handItem);

				world.setBlockState(pos, dyeableBlock.Block.getDefaultState(), Block.FORCE_STATE);
				((DyeableBlockEntity)world.getBlockEntity(pos)).setColor(dyeColor, player);
				world.getBlockState(pos).updateNeighbors(world, pos, Block.NOTIFY_ALL);

				if (!player.isCreative())
					handItem.setDamage(handItem.getDamage() + 1);

				player.playSound(SoundEvents.ITEM_DYE_USE, 1, 1);

				return ActionResult.SUCCESS;
			}
		}

        return ActionResult.PASS;
    }
}