package me.siasur.unrelatedadditions.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;

public class RopeLadderBlock extends LadderBlock {
    public RopeLadderBlock(Properties p_54345_) {
        super(p_54345_);
    }

    private boolean canAttachTo(BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        BlockState blockstate = blockGetter.getBlockState(blockPos);
        return blockstate.isFaceSturdy(blockGetter, blockPos, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        Direction attachDirection = blockState.getValue(FACING);
        BlockState above = levelReader.getBlockState(blockPos.above());
        return (above.is(this) && blockState.getValue(FACING).equals(above.getValue(FACING))) || this.canAttachTo(levelReader, blockPos.relative(attachDirection.getOpposite()), attachDirection);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return super.getStateForPlacement(blockPlaceContext);
//        if (!blockPlaceContext.replacingClickedOnBlock()) {
//            BlockState blockstate = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().relative(blockPlaceContext.getClickedFace().getOpposite()));
//            if (blockstate.is(this) && blockstate.getValue(FACING) == blockPlaceContext.getClickedFace()) {
//                return null;
//            }
//        }
//
//        BlockState placeBlockState = this.defaultBlockState();
//        LevelReader levelreader = blockPlaceContext.getLevel();
//        BlockPos blockpos = blockPlaceContext.getClickedPos();
//        BlockPos abovePos = blockPlaceContext.getClickedPos().above();
//        BlockState above = levelreader.getBlockState(abovePos);
//        FluidState fluidstate = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
//
//        if (above.is(this.asBlock())) {
//            return placeBlockState.setValue(FACING, above.getValue(FACING)).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
//        } else {
//            for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
//                if (direction.getAxis().isHorizontal()) {
//                    if (placeBlockState.canSurvive(levelreader, blockpos)) {
//                        return placeBlockState.setValue(FACING, direction.getOpposite()).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
//                    }
//                }
//            }
//        }
//
//        return null;
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState blockState) {
        return super.getPistonPushReaction(blockState);
    }


}
