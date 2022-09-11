package me.siasur.unrelatedadditions.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

public class RopeLadderBlock extends LadderBlock {
    public RopeLadderBlock(Properties properties) {
        super(properties);
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
    public @NotNull BlockState updateShape(BlockState self, Direction direction, BlockState neighbor, LevelAccessor levelAccessor, BlockPos selfPos, BlockPos neighborPos) {
        if (self.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(selfPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return !this.canSurvive(self, levelAccessor, selfPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(self, direction, neighbor, levelAccessor, selfPos, neighborPos);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        Direction attachDirection = blockState.getValue(FACING);
        BlockState above = levelReader.getBlockState(blockPos.above());
        return (above.is(this) && blockState.getValue(FACING).equals(above.getValue(FACING))) || this.canAttachTo(levelReader, blockPos.relative(attachDirection.getOpposite()), attachDirection);
    }
}
