package seafoamwolf.seafoamsdyeableblocks.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;

public class DyeableBlockEntity extends BlockEntity {
    public static final int DEFAULT_COLOR = 16777215;

	private int color;

	public DyeableBlockEntity(BlockPos pos, BlockState state) {
		super(DyeableBlocks.DYEABLE_BLOCK_ENTITY, pos, state);
		this.color = DEFAULT_COLOR;
	}

	public void setColor(int newColor, LivingEntity user) {
		this.color = newColor;
		
		this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(user, this.getCachedState()));
		this.updateListeners();
	}

	public int getColor() {
		return this.color;
	}

	// Serialize the BlockEntity
    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        tag.putInt("color", this.color);
    }

	// Deserialize the BlockEntity
	@Override
	public void readNbt(NbtCompound tag) {
		super.readNbt(tag);
		this.color = tag.getInt("color");
	}

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        NbtCompound nbtCompound = new NbtCompound();
        this.writeNbt(nbtCompound);
        return nbtCompound;
    }

    private void updateListeners() {
        this.markDirty();
        this.getWorld().updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), Block.NOTIFY_ALL);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
}