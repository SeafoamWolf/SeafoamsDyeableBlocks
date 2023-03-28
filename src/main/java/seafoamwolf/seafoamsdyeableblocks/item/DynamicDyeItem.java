package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockEntity;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockRegister;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlocks;

public class DynamicDyeItem extends DyedItem {
	private static final DyeableBlockRegister[] AFFECTED_BLOCKS = {
		DyeableBlocks.DYEABLE_WOOL, DyeableBlocks.DYEABLE_CONCRETE, DyeableBlocks.DYEABLE_TERRACOTTA,
		DyeableBlocks.DYEABLE_PLANKS, DyeableBlocks.DYEABLE_GLOWSTONE, DyeableBlocks.DYEABLE_BRICKS
	};

	public DynamicDyeItem(Properties properties) {
		super(properties);
    }

	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		BlockPos pos = context.getClickedPos();
		ItemStack handItem = context.getItemInHand();
		Player player = context.getPlayer();

		if (player == null || pos == null)
			return InteractionResult.PASS;

		BlockState blockStateAt = world.getBlockState(pos);
		Block blockAt = blockStateAt.getBlock();

		for (DyeableBlockRegister dyeableBlock : AFFECTED_BLOCKS) {
			for (Block originalBlock : dyeableBlock.OriginalBlocks) {
				if (originalBlock != blockAt) // Only continue if block is in list!!! Done for less tabbing.
					continue;

				int dyeColor = ((DynamicDyeItem)handItem.getItem()).getColor(handItem);
				
				world.setBlock(pos, dyeableBlock.Block.get().defaultBlockState(), 16);

				BlockEntity entity = world.getBlockEntity(pos);

				if (entity != null && entity instanceof DyeableBlockEntity)
					((DyeableBlockEntity)entity).setColor(dyeColor);

				if (!player.isCreative())
					handItem.setDamageValue(handItem.getDamageValue() + 1);

				player.playSound(SoundEvents.DYE_USE, 1, 1);

				return InteractionResult.SUCCESS;
			}
		}

        return InteractionResult.PASS;
    }
}