package seafoamwolf.seafoamsdyeableblocks.fabric.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;

import net.minecraft.world.World;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.DyeableBlockItem;
import seafoamwolf.seafoamsdyeableblocks.fabric.item.PaintbrushItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;

import org.jetbrains.annotations.Nullable;

public interface DyeableBlockInterface extends BlockEntityProvider {
	default public void dyedOnPlaced(World world, BlockPos pos, BlockState blockState, LivingEntity entity, ItemStack itemStack) {
		BlockEntity blockEntity = world.getBlockEntity(pos);

		if (blockEntity != null && blockEntity instanceof DyeableBlockEntity)
            ((DyeableBlockEntity)blockEntity).setColor(((DyeableBlockItem)itemStack.getItem()).getColor(itemStack), entity);
    }
	
	default public ItemStack getItemStack(BlockState state, World world, BlockPos pos, @Nullable BlockEntity blockEntity, Entity entity, ItemStack stack2) {
        if (!(world instanceof ServerWorld))
            return null;
        
        DyeableBlockEntity dyeableBlockEntity = (DyeableBlockEntity)blockEntity;
        Block droppedBlock = dyeableBlockEntity.getOriginalBlock();
        ItemStack droppedStack;

        if (droppedBlock != null) {
            droppedStack = new ItemStack(droppedBlock);
        } else {
            droppedStack = new ItemStack(state.getBlock());
        }

        return droppedStack;
    }

	default public void dyedAfterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        player.incrementStat(Stats.MINED.getOrCreateStat(state.getBlock()));
        player.addExhaustion(0.005f);
    }

	default public ItemStack dyedGetPickStack(BlockView world, BlockPos pos, BlockState state) {
		DyeableBlockEntity dyeableBlockEntity = (DyeableBlockEntity)(world.getBlockEntity(pos));

		ItemStack stack = new ItemStack(state.getBlock());
        stack = dyeableBlockEntity.ApplyNBT(stack);

        return stack;
    }

    default public BlockEntity dyedCreateBlockEntity(BlockPos pos, BlockState state) {
        return new DyeableBlockEntity(pos, state);
    }

    default public ActionResult dyedOnUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack handItem = player.getStackInHand(hand);
		
		if (handItem.getItem() instanceof PaintbrushItem) {
			BlockEntity entity = world.getBlockEntity(pos);

			if (entity == null || !(entity instanceof DyeableBlockEntity))
				return ActionResult.PASS;
				
			int dyeColor = ((PaintbrushItem)handItem.getItem()).getColor(handItem);
			int blockColor = ((DyeableBlockEntity)entity).getColor();

			if (dyeColor != blockColor) {
				player.playSound(SoundEvents.ITEM_DYE_USE, 1, 1);
				
				((DyeableBlockEntity)entity).setColor(dyeColor, player);

				state.updateNeighbors(world, pos, Block.NOTIFY_ALL);

				if (!player.isCreative())
					handItem.setDamage(handItem.getDamage() + 1);

				return ActionResult.SUCCESS;
			}
		}

        return ActionResult.PASS;
    }
}