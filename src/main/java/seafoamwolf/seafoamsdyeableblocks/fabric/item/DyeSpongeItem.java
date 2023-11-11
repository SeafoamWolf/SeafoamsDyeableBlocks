package seafoamwolf.seafoamsdyeableblocks.fabric.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import seafoamwolf.seafoamsdyeableblocks.fabric.block.DyedBlockEntity;

public class DyeSpongeItem extends TooltippedItem {
	public DyeSpongeItem(Settings settings, String itemId) {
		super(settings, itemId);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return ingredient.isOf(Items.SPONGE);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		BlockPos pos = context.getBlockPos();
		ItemStack handItem = context.getStack();
		PlayerEntity player = context.getPlayer();

		if (!player.isSneaking()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);

			if (blockEntity != null && blockEntity instanceof DyedBlockEntity) {
				DyedBlockEntity dyedBlockEntity = (DyedBlockEntity)blockEntity;

				BlockState blockStateAt = world.getBlockState(pos);
				Block originalBlock = dyedBlockEntity.getOriginalBlock();

				world.setBlockState(pos, originalBlock.getStateWithProperties(blockStateAt), Block.FORCE_STATE);
				world.getBlockState(pos).updateNeighbors(world, pos, Block.NOTIFY_ALL);

				if (!player.isCreative())
					handItem.setDamage(handItem.getDamage() + 1);

				player.playSound(SoundEvents.ITEM_BUCKET_EMPTY, 1, 1);

				return ActionResult.SUCCESS;
			}
		}

        return ActionResult.PASS;
    }
}