package me.siasur.unrelatedadditions.block;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FlagPoleBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {

    private final static VoxelShape POLE_SHAPE = Block.box(6, 0, 6, 10, 16, 10);

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public FlagPoleBlock(Properties properties) {
        super(properties);

        registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.FALSE).setValue(LIT, Boolean.FALSE));
    }

    protected boolean canBeLit(BlockState blockState) {
        return blockState.getValue(LIT).equals(Boolean.FALSE) && blockState.getValue(WATERLOGGED).equals(Boolean.TRUE);
    }

    @Override
    public @NotNull ItemStack pickupBlock(LevelAccessor level, BlockPos blockPos, BlockState blockState) {
        if (blockState.getValue(BlockStateProperties.WATERLOGGED)) {
            level.setBlock(blockPos, blockState.setValue(BlockStateProperties.WATERLOGGED, Boolean.FALSE).setValue(LIT, Boolean.FALSE), 3);
            if (!blockState.canSurvive(level, blockPos)) {
                level.destroyBlock(blockPos, true);
            }

            return new ItemStack(Items.WATER_BUCKET);
        } else {
            return ItemStack.EMPTY;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        ItemStack usedItem = player.getItemInHand(hand);
        boolean isUsingGlowInk = usedItem.is(Items.GLOW_INK_SAC);
        boolean canModifyBlock = player.getAbilities().mayBuild;
        boolean canBeLit = canBeLit(blockState);
        boolean shouldLightUp = isUsingGlowInk && canModifyBlock && canBeLit;

        if (level.isClientSide) {
            return shouldLightUp ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }

        if (shouldLightUp) {
            level.playSound(null, blockPos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS, 1f, 1f);
            level.setBlock(blockPos, blockState.setValue(LIT, Boolean.TRUE), UPDATE_ALL);
            if (player instanceof ServerPlayer serverPlayer)
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, usedItem);

            if (!player.isCreative()) {
                usedItem.shrink(1);
            }

            player.awardStat(Stats.ITEM_USED.get(usedItem.getItem()));


            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING)
                .add(WATERLOGGED)
                .add(LIT);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState updateShape(BlockState self, Direction direction, BlockState neighbor, LevelAccessor levelAccessor, BlockPos selfPos, BlockPos neighborPos) {
        if (self.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(selfPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return direction == Direction.DOWN && !this.canSurvive(self, levelAccessor, selfPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(self, direction, neighbor, levelAccessor, selfPos, neighborPos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canSurvive(BlockState p_57499_, LevelReader p_57500_, BlockPos p_57501_) {
        return canSupportCenter(p_57500_, p_57501_.below(), Direction.UP);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        BlockPos blockpos = placeContext.getClickedPos();
        FluidState fluidstate = placeContext.getLevel().getFluidState(blockpos);
        return this.defaultBlockState()
                .setValue(FACING, placeContext.getHorizontalDirection().getClockWise())
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return POLE_SHAPE;
    }

}
