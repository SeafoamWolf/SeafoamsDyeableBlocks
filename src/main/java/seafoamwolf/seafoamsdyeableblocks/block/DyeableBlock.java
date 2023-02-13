package seafoamwolf.seafoamsdyeableblocks.block;

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
import seafoamwolf.seafoamsdyeableblocks.item.DynamicDyeItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;

import org.jetbrains.annotations.Nullable;

public class DyeableBlock extends Block implements BlockEntityProvider {
	public DyeableBlock(Settings settings) {
		super(settings);
	}

	public void onPlaced(World world, BlockPos pos, BlockState blockState, LivingEntity entity, ItemStack item) {
		BlockEntity blockEntity = world.getBlockEntity(pos);

		if (blockEntity instanceof DyeableBlockEntity) {
			DyeableBlockEntity dyeableEntity = (DyeableBlockEntity)blockEntity;
			NbtCompound tag = item.getOrCreateSubNbt("display");
			
			dyeableEntity.setColor(tag.contains("color") ? tag.getInt("color") : 16777215, entity);
		}

		super.onPlaced(world, pos, blockState, entity, item);
	}
	
	public static void dropStacks(BlockState state, World world, BlockPos pos, @Nullable BlockEntity blockEntity, Entity entity, ItemStack stack2) {
        if (world instanceof ServerWorld) {
            getDroppedStacks(state, (ServerWorld)world, pos, blockEntity, entity, stack2).forEach(stack ->
				dropStack(world, pos, ApplyNBT(blockEntity, stack)));
			
            state.onStacksDropped((ServerWorld)world, pos, stack2, false);
        }
    }

	private static ItemStack ApplyNBT(@Nullable BlockEntity blockEntity, ItemStack stack) {
		DyeableBlockEntity dyeableEntity = (DyeableBlockEntity)blockEntity;

		stack.getOrCreateSubNbt("display").putInt("color",
			dyeableEntity.getColor());
		
		return stack;
	}

	@Override
	public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        player.incrementStat(Stats.MINED.getOrCreateStat(this));
        player.addExhaustion(0.005f);

        dropStacks(state, world, pos, blockEntity, player, stack);
    }

	@Override
	public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
		ItemStack stack = new ItemStack(this);
		DyeableBlockEntity dyeableEntity = (DyeableBlockEntity)(world.getBlockEntity(pos));

		stack.getOrCreateSubNbt("display").putInt("color",
			dyeableEntity.getColor());

        return stack;
    }

	@Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DyeableBlockEntity(pos, state);
    }

	@Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack handItem = player.getStackInHand(hand);
		BlockEntity entity = world.getBlockEntity(pos);

		if (entity == null || !(entity instanceof DyeableBlockEntity))
			return ActionResult.PASS;
		
		if (handItem.getItem() instanceof DynamicDyeItem) {
			int dyeColor = ((DynamicDyeItem)handItem.getItem()).getColor(handItem);
			int blockColor = ((DyeableBlockEntity)entity).getColor();

			if (dyeColor != blockColor) {
				player.playSound(SoundEvents.ITEM_DYE_USE, 1, 1);
				((DyeableBlockEntity)entity).setColor(dyeColor, player);

				state.updateNeighbors(world, pos, Block.NOTIFY_ALL);

				handItem.setDamage(handItem.getDamage() + 1);

				return ActionResult.SUCCESS;
			}
		}

        return ActionResult.PASS;
    }
}