package me.siasur.unrelatedadditions.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class RopeLadderBlockItem extends BlockItem {
    public RopeLadderBlockItem(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    @Override
    public InteractionResult place(BlockPlaceContext placeContext) {
        if (!placeContext.canPlace()) {
            return InteractionResult.FAIL;
        }

        BlockState placementState = this.getPlacementState(placeContext);
        if (placementState == null) {
            return InteractionResult.FAIL;
        }

        boolean placeSuccess = this.placeBlock(placeContext, placementState);
        if (!placeSuccess) {
            return InteractionResult.FAIL;
        }

        BlockPos blockpos = placeContext.getClickedPos();
        Level level = placeContext.getLevel();
        Player player = placeContext.getPlayer();
        ItemStack itemstack = placeContext.getItemInHand();
        BlockState actualState = level.getBlockState(blockpos);

        if (actualState.is(placementState.getBlock())) {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
            }
        }

        int limit = itemstack.getCount();
        int count = 1;
        if (limit > 1)
        {
            BlockPos nextBlockPos = blockpos.below();
            boolean continuePlacing;
            do {
                // Check block below
                BlockState nextBlockState = level.getBlockState(nextBlockPos);
                boolean canReplaceBlock = nextBlockState.getBlock().canBeReplaced(nextBlockState, placeContext);
                // Place Rope Ladder when possible
                continuePlacing = canReplaceBlock && level.setBlock(nextBlockPos, placementState, Block.UPDATE_ALL_IMMEDIATE);

                nextBlockPos = nextBlockPos.below();
            } while (continuePlacing && ++count < limit);
        }

        level.gameEvent(GameEvent.BLOCK_PLACE, blockpos, GameEvent.Context.of(player, actualState));
        SoundType soundtype = actualState.getSoundType(level, blockpos, player);
        level.playSound(player, blockpos, this.getPlaceSound(actualState, level, blockpos, player), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
        if (player == null || !player.getAbilities().instabuild) {
            itemstack.shrink(count);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
