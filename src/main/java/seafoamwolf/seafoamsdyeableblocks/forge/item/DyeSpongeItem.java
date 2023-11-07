package seafoamwolf.seafoamsdyeableblocks.forge.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import seafoamwolf.seafoamsdyeableblocks.forge.block.DyeableBlockEntity;

public class DyeSpongeItem extends Item {
	public DyeSpongeItem(Properties properties) {
		super(properties);
    }
	
	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
		return ingredient.is(Items.SPONGE);
	}
	
	@Override
	public boolean isRepairable(ItemStack stack) {
	   return canRepair && isDamageable(stack);
	}

	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		BlockPos pos = context.getClickedPos();
		ItemStack handItem = context.getItemInHand();
		Player player = context.getPlayer();

		if (player == null || pos == null)
			return InteractionResult.PASS;

		if (!player.isCrouching()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			
			if (blockEntity != null && blockEntity instanceof DyeableBlockEntity) {
				DyeableBlockEntity dyedBlockEntity = (DyeableBlockEntity)blockEntity;

				BlockState blockStateAt = world.getBlockState(pos);
				Block originalBlock = dyedBlockEntity.getOriginalBlock();

				world.setBlock(pos, originalBlock.withPropertiesOf(blockStateAt), 16);

				if (!player.isCreative())
					handItem.setDamageValue(handItem.getDamageValue() + 1);

				player.playSound(SoundEvents.BUCKET_EMPTY, 1, 1);

				return InteractionResult.SUCCESS;
			}
		}

        return InteractionResult.PASS;
    }
}