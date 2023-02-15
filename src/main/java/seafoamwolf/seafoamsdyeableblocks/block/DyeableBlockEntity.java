package seafoamwolf.seafoamsdyeableblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import  net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DyeableBlockEntity extends BlockEntity {
    public static final int DEFAULT_COLOR = 16777215;

	private int color = DEFAULT_COLOR;

	public DyeableBlockEntity(BlockPos pos, BlockState state) {
		super(DyeableBlocks.DYEABLE_BLOCK_ENTITY.get(), pos, state);
	}

	public void setColor(int newColor) {
		this.color = newColor;
		this.markUpdated();
	}

	public int getColor() {
		return this.color;
	}

	private void saveColor(CompoundTag tag) {
		CompoundTag display;
		
		if (tag.contains("display")) {
			display = tag.getCompound("display");
		} else {
			display = new CompoundTag();
			tag.put("display", display);
		}

		display.putInt("color", color);
	}

	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		this.saveColor(tag);
	}

	public void load(CompoundTag tag) {
		super.load(tag);

		if (tag.contains("display"))
			this.color = tag.getCompound("display").getInt("color");
	}

	public CompoundTag getUpdateTag() {
		CompoundTag tag = new CompoundTag();
		this.saveColor(tag);
		return tag;
	}

	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
	
	private void markUpdated() {
		this.setChanged();
		this.getLevel().sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
	}
}