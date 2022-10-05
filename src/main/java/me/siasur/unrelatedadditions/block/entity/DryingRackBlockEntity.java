package me.siasur.unrelatedadditions.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.world.Containers.dropItemStack;

public class DryingRackBlockEntity extends BlockEntity {

    private static final String NBT_INVENTORY_KEY = "inventory";

    private final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        public int getSlotLimit(int slot) {
            return 1;
        }
    };

    public DryingRackBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.DRYING_RACK.get(), pPos, pBlockState);
    }

    private LazyOptional<ItemStackHandler> lazyItemStackHandler = LazyOptional.empty();

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return lazyItemStackHandler.cast();

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemStackHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemStackHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put(NBT_INVENTORY_KEY, itemHandler.serializeNBT());

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        itemHandler.deserializeNBT(pTag.getCompound(NBT_INVENTORY_KEY));
    }

    public void dropContent(Level pLevel, BlockPos pPos) {

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            dropItemStack(pLevel, (double) pPos.getX(), (double) pPos.getY(), (double) pPos.getZ(), itemHandler.getStackInSlot(i));
        }

        markUpdated();
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, DryingRackBlockEntity e) {

    }

    public boolean putItem(ItemStack itemStack) {
        if (!itemHandler.getStackInSlot(0).isEmpty())
            return false;

        itemHandler.insertItem(0, itemStack.split(1), false);
        markUpdated();
        return true;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag retTag = new CompoundTag();
        saveAdditional(retTag);
        return retTag;
    }

    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    public ItemStack getRenderStack() {
        return itemHandler.getStackInSlot(0);
    }
}
