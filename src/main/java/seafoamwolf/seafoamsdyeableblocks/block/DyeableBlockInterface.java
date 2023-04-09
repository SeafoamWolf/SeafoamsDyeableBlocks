package seafoamwolf.seafoamsdyeableblocks.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableBlockItem;
import seafoamwolf.seafoamsdyeableblocks.item.PaintbrushItem;

public interface DyeableBlockInterface extends EntityBlock {
	default public void dyedSetPlacedBy(Level world, BlockPos pos, BlockState blockState, @Nullable LivingEntity entity, ItemStack itemStack) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

		if (blockEntity != null && blockEntity instanceof DyeableBlockEntity)
            ((DyeableBlockEntity)blockEntity).setColor(((DyeableBlockItem)itemStack.getItem()).getColor(itemStack));
	}

	default public void dyedPlayerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        player.awardStat(Stats.BLOCK_MINED.get(state.getBlock()));
		player.causeFoodExhaustion(0.005F);
    }

	default public ItemStack dyedGetCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
		DyeableBlockEntity dyeableBlockEntity = (DyeableBlockEntity)(world.getBlockEntity(pos));

		if (dyeableBlockEntity == null)
			return null;

		ItemStack stack = new ItemStack(state.getBlock());
        stack = dyeableBlockEntity.ApplyNBT(stack);

        return stack;
    }

    default public BlockEntity dyedCreateBlockEntity(BlockPos pos, BlockState state) {
        return new DyeableBlockEntity(pos, state);
    }

    default public InteractionResult dyedUse(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ItemStack handItem = player.getItemInHand(hand);
		
		if (handItem.getItem() instanceof PaintbrushItem) {
			BlockEntity entity = level.getBlockEntity(pos);

			if (entity == null || !(entity instanceof DyeableBlockEntity))
				return InteractionResult.PASS;
				
			int dyeColor = ((PaintbrushItem)handItem.getItem()).getColor(handItem);
			int blockColor = ((DyeableBlockEntity)entity).getColor();

			if (dyeColor != blockColor) {
				player.playSound(SoundEvents.DYE_USE, 1, 1);
				
				((DyeableBlockEntity)entity).setColor(dyeColor);

				if (!player.isCreative())
					handItem.setDamageValue(handItem.getDamageValue() + 1);

				return InteractionResult.SUCCESS;
			}
		}

        return InteractionResult.PASS;
    }
}