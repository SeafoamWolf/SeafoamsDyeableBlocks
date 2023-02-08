package seafoamwolf.seafoamsdyeableblocks.blocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;

public class DyeableBlockEntity extends BlockEntity {
    public static final int DEFAULT_COLOR = 16777215;

	private int color;

	public DyeableBlockEntity(BlockPos pos, BlockState state) {
		super(DyeableBlocks.DYEABLE_BLOCK_ENTITY, pos, state);
		this.color = DEFAULT_COLOR;
	}

	public void setColor(int newColor) {
		this.color = newColor;
	}

	public int getColor() {
		return this.color;
	}

	// Serialize the BlockEntity
    @Override
    public void writeNbt(NbtCompound tag) {
        tag.putInt("color", this.color);
        super.writeNbt(tag);
    }

	// Deserialize the BlockEntity
	@Override
	public void readNbt(NbtCompound tag) {
		super.readNbt(tag);
		this.color = tag.getInt("color");
	}

	@Override
	public Packet<ClientPlayPacketListener> toUpdatePacket() {
		return BlockEntityUpdateS2CPacket.create(this);
	}

	@Override
	public NbtCompound toInitialChunkDataNbt() {
		return createNbt();
	}

	public Object getRenderAttachmentData() {
		return this;
	}
}