package me.siasur.unrelatedadditions.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class AngelBlock extends RotatedPillarBlock {
    public AngelBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (level.isClientSide || player.isCreative()) {
            return super.onDestroyedByPlayer(state, level, pos, player, false, fluid);
        }

        player.addItem(new ItemStack(this.asItem()));
        return super.onDestroyedByPlayer(state, level, pos, player, false, fluid);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return this.defaultBlockState();
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState;
    }
}
