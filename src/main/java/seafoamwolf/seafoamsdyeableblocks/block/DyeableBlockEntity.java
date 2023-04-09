package seafoamwolf.seafoamsdyeableblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import  net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class DyeableBlockEntity extends BlockEntity {
    public static final int DEFAULT_COLOR = 16777215;

	private int color = DEFAULT_COLOR;
	private String originalBlockId;

	public DyeableBlockEntity(BlockPos pos, BlockState state) {
		super(DyeableBlocks.DYEABLE_BLOCK_ENTITY.get(), pos, state);
		this.originalBlockId = ForgeRegistries.BLOCKS.getKey(state.getBlock()).toString();
	}

	public int getColor() {
		return this.color;
	}

	public void setColor(int newColor) {
		this.color = newColor;
		this.markUpdated();
	}

	// Original Block for Drops
	public void setOriginalBlock(Block block) {
		originalBlockId = ForgeRegistries.BLOCKS.getKey(block).toString();
	}

	public Block getOriginalBlock() {
		if (originalBlockId == null)
			return null;
		
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(originalBlockId));
	}
	
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);

        tag.putInt("color", this.color);
		tag.putString("original_block", originalBlockId);
	}

	public void load(CompoundTag tag) {
		super.load(tag);

		this.color = tag.getInt("color");
		this.originalBlockId = tag.getString("original_block");
	}

	// Stack Data (from Decorated Pot)
    public ItemStack ApplyNBT(ItemStack itemStack) {
        CompoundTag nbtCompound = new CompoundTag();
        saveAdditional(nbtCompound);
		
        BlockItem.setBlockEntityData(itemStack, DyeableBlocks.DYEABLE_BLOCK_ENTITY.get(), nbtCompound);

        return itemStack;
    }

	
	public void readNbtFromStack(ItemStack stack) {
        CompoundTag nbtCompound = BlockItem.getBlockEntityData(stack);

        if (nbtCompound != null)
            load(nbtCompound);
    }

	public CompoundTag getUpdateTag() {
		CompoundTag tag = new CompoundTag();
		saveAdditional(tag);
		return tag;
	}

	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
	
	private void markUpdated() {
		this.setChanged();

		Level level = this.getLevel();

		if (level != null)
			level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
	}
}