package seafoamwolf.seafoamsdyeableblocks.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import seafoamwolf.seafoamsdyeableblocks.SeafoamsDyeableBlocks;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockEntity;
import seafoamwolf.seafoamsdyeableblocks.block.DyeableBlockInterface;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class PaintbrushItem extends DyedItem {
	public PaintbrushItem(Properties properties) {
		super(properties);
    }
	
	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
		return ingredient.is(DyeableItems.COLOR_ESSENCE.get());
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

		BlockState blockStateAt = world.getBlockState(pos);
		Block blockAt = blockStateAt.getBlock();

		if (!player.isCrouching()) {
			for (Block dyeableBlock : SeafoamsDyeableBlocks.DYEABLE_BLOCKS) {
				TagKey<Block> resourceLocation = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(ForgeRegistries.BLOCKS.getKey(dyeableBlock) + "_replacable"));

				System.out.println(ForgeRegistries.BLOCKS.getKey(dyeableBlock) + "_replacable");
				
				if (!blockStateAt.is(resourceLocation))
					continue;

				int dyeColor = ((PaintbrushItem)handItem.getItem()).getColor(handItem);
				
				world.setBlock(pos, dyeableBlock.defaultBlockState(), 16);

				BlockEntity entity = world.getBlockEntity(pos);

				if (entity != null && entity instanceof DyeableBlockEntity)
					((DyeableBlockEntity)entity).setColor(dyeColor);

				if (!player.isCreative())
					handItem.setDamageValue(handItem.getDamageValue() + 1);

				player.playSound(SoundEvents.DYE_USE, 1, 1);

				return InteractionResult.SUCCESS;
			}
			// Pick blocks if item is a netherite paintbrush
		} else if (handItem.getItem() == DyeableItems.NETHERITE_PAINTBRUSH.get()) {
			int newColor = 0;

			if (blockAt instanceof DyeableBlockInterface) {
				BlockEntity blockEntity = world.getBlockEntity(pos);

				if (blockEntity == null || !(blockEntity instanceof DyeableBlockEntity))
					return InteractionResult.PASS;

				newColor = ((DyeableBlockEntity)blockEntity).getColor();
			} else {
				newColor = blockStateAt.getMapColor(world, pos).col;
			}

			if (getColor(handItem) == newColor)
				return InteractionResult.PASS;

			setColor(handItem, newColor);

			if (!player.isCreative())
				handItem.setDamageValue(handItem.getDamageValue() + 1);
			
			player.playSound(SoundEvents.DYE_USE, 1, 1);
		}

        return InteractionResult.PASS;
    }
}