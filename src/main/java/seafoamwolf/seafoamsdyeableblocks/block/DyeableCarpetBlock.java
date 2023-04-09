package seafoamwolf.seafoamsdyeableblocks.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;

public class DyeableCarpetBlock extends CarpetBlock implements DyeableBlockInterface {
	public DyeableCarpetBlock(BlockBehaviour.Properties settings) {
		super(settings);
        
        SeafoamsDyeableBlocks.DYEABLE_BLOCKS.add(this);
	}
	
	@Nullable
	@Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return dyedCreateBlockEntity(pos, state);
    }

	public void setPlacedBy(Level world, BlockPos pos, BlockState blockState, @Nullable LivingEntity entity, ItemStack item) {
        dyedSetPlacedBy(world, pos, blockState, entity, item);
		super.setPlacedBy(world, pos, blockState, entity, item);
	}
	
	public static void dropResources(BlockState state, Level level, BlockPos pos, @Nullable BlockEntity blockEntity, Entity entity, ItemStack stack2) {
		if (level instanceof ServerLevel) {
            DyeableBlockEntity dyeableBlockEntity = (DyeableBlockEntity)blockEntity;

            if (dyeableBlockEntity == null)
                return;

            Block droppedBlock = dyeableBlockEntity.getOriginalBlock();
            ItemStack droppedStack;

            if (droppedBlock != null) {
                droppedStack = new ItemStack(droppedBlock);
            } else {
                droppedStack = new ItemStack(state.getBlock());
                droppedStack = dyeableBlockEntity.ApplyNBT(droppedStack);
            }

            popResource(level, pos, droppedStack);

            state.spawnAfterBreak((ServerLevel)level, pos, stack2, false);
        }
    }

	@Override
	public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {      
		dyedPlayerDestroy(world, player, pos, state, blockEntity, stack);
		dropResources(state, world, pos, blockEntity, player, stack);
    }

	@Override
	public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
		return dyedGetCloneItemStack(world, pos, state);
    }

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return dyedUse(state, level, pos, player, hand, hit);
	 }
}