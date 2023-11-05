package seafoamwolf.seafoamsdyeableblocks.fabric.block;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registries;

public class DyeableBlockEntity extends BlockEntity {
    public static final int DEFAULT_COLOR = 16777215;

	private int color;
	private String originalBlockId;

	public DyeableBlockEntity(BlockPos pos, BlockState state) {
		super(DyeableBlocks.DYEABLE_BLOCK_ENTITY, pos, state);
		this.color = DEFAULT_COLOR;
		this.originalBlockId = Registries.BLOCK.getId(state.getBlock()).toString();
	}

	public int getColor() {
		return this.color;
	}

	public void setColor(int newColor, LivingEntity user) {
		this.color = newColor;
		
		this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(user, this.getCachedState()));
		this.updateListeners();
	}

	// Original Block for Drops
	public void setOriginalBlock(Block block) {
		originalBlockId = Registries.BLOCK.getId(block).toString();
	}

	public Block getOriginalBlock() {
		if (originalBlockId == "")
			return null;
		
		return Registries.BLOCK.get(new Identifier(originalBlockId));
	}

	// Serialize the BlockEntity
    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);

        tag.putInt("color", this.color);
		tag.putString("original_block", originalBlockId);
    }

	// Deserialize the BlockEntity
	@Override
	public void readNbt(NbtCompound tag) {
		super.readNbt(tag);

		this.color = tag.getInt("color");
		this.originalBlockId = tag.getString("original_block");
	}
	
	// Stack Data (from Decorated Pot)
    public ItemStack ApplyNBT(ItemStack itemStack) {
        NbtCompound nbtCompound = new NbtCompound();
        writeNbt(nbtCompound);
		
        BlockItem.setBlockEntityNbt(itemStack, DyeableBlocks.DYEABLE_BLOCK_ENTITY, nbtCompound);

        return itemStack;
    }

	public void readNbtFromStack(ItemStack stack) {
        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);

        if (nbtCompound != null)
            this.readNbt(nbtCompound);
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