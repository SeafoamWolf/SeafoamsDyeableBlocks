package seafoamwolf.seafoamsdyeableblocks.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import seafoamwolf.seafoamsdyeableblocks.item.DynamicDyeItem;

public class DyeableBlock extends Block implements EntityBlock {
	public DyeableBlock(BlockBehaviour.Properties settings) {
		super(settings);
	}
	
	@Nullable
	@Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DyeableBlockEntity(pos, state);
    }

	public void setPlacedBy(Level world, BlockPos pos, BlockState blockState, @Nullable LivingEntity entity, ItemStack item) {
		BlockEntity blockEntity = world.getBlockEntity(pos);

		if (blockEntity != null && blockEntity instanceof DyeableBlockEntity) {
			DyeableBlockEntity dyeableEntity = (DyeableBlockEntity)blockEntity;
			CompoundTag tag = item.getOrCreateTagElement("display");
			
			dyeableEntity.setColor(tag.contains("color") ? tag.getInt("color") : 16777215);
		}

		super.setPlacedBy(world, pos, blockState, entity, item);
	}
	
	public static void dropResources(BlockState state, Level level, BlockPos pos, @Nullable BlockEntity blockEntity, Entity entity, ItemStack stack2) {
        if (level instanceof ServerLevel) {
            getDrops(state, (ServerLevel)level, pos, blockEntity, entity, stack2).forEach(stack ->
				popResource(level, pos, ApplyNBT(blockEntity, stack)));
			
            state.spawnAfterBreak((ServerLevel)level, pos, stack2, false);
        }
    }

	private static ItemStack ApplyNBT(@Nullable BlockEntity blockEntity, ItemStack stack) {
		DyeableBlockEntity dyeableEntity = (DyeableBlockEntity)blockEntity;

		if (dyeableEntity != null)
			stack.getOrCreateTagElement("display").putInt("color",
				dyeableEntity.getColor());
		
		return stack;
	}

	@Override
	public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        player.awardStat(Stats.BLOCK_MINED.get(this));
		player.causeFoodExhaustion(0.005F);
		dropResources(state, world, pos, blockEntity, player, stack);
    }

	@Override
	public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
		ItemStack stack = new ItemStack(this);
		DyeableBlockEntity dyeableEntity = (DyeableBlockEntity)(world.getBlockEntity(pos));

		if (dyeableEntity != null)
			stack.getOrCreateTagElement("display").putInt("color",
				dyeableEntity.getColor());

        return stack;
    }

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ItemStack handItem = player.getItemInHand(hand);
		
		if (handItem.getItem() instanceof DynamicDyeItem) {
			BlockEntity entity = level.getBlockEntity(pos);
	
			if (entity == null || !(entity instanceof DyeableBlockEntity))
				return InteractionResult.PASS;

			int dyeColor = ((DynamicDyeItem)handItem.getItem()).getColor(handItem);
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