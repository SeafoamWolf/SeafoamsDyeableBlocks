package seafoamwolf.seafoamsdyeableblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;

import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
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
			int color = 16777215;

			NbtCompound tag = item.getOrCreateSubNbt("display");

			if (tag.contains("color")) {
				color = tag.getInt("color");
			}
			
			((DyeableBlockEntity)blockEntity).setColor(color);
		}

		super.onPlaced(world, pos, blockState, entity, item);
	}

	public static void dropStacks(BlockState state, World world, BlockPos pos, @Nullable BlockEntity blockEntity, Entity entity, ItemStack stack2) {
        if (world instanceof ServerWorld) {
            getDroppedStacks(state, (ServerWorld)world, pos, blockEntity, entity, stack2).forEach(stack -> dropStack(world, pos, ApplyNBT(blockEntity, stack)));
            state.onStacksDropped((ServerWorld)world, pos, stack2, false);
        }
    }

	private static ItemStack ApplyNBT(@Nullable BlockEntity blockEntity, ItemStack stack) {
		stack.getOrCreateSubNbt("display").putInt("color", ((DyeableBlockEntity)blockEntity).getColor());
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
		stack.getOrCreateSubNbt("display").putInt("color", ((DyeableBlockEntity)world.getBlockEntity(pos)).getColor());

        return stack;
    }

	@Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DyeableBlockEntity(pos, state);
    }
}