package me.siasur.unrelatedadditions.item;

import me.siasur.unrelatedadditions.inventory.ModCreativeModeTab;
import me.siasur.unrelatedadditions.utils.BlockHitSideDetection;
import me.siasur.unrelatedadditions.utils.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HammerItem extends DiggerItem {

    private static float _DAMAGE = 1f;
    private static float _ATTACKSPEED = -2.8f;
    private static float DURABILITY_MULTIPLIER = 5;

    private static CreativeModeTab _ADDITIONAL_CREATIVE_TAB = ModCreativeModeTab.TAB_UNRELATEDADDITIONS;

    public HammerItem(Tier toolTier, Properties properties) {
        super(_DAMAGE, _ATTACKSPEED, toolTier, ModTags.Blocks.MINEABLE_WITH_HAMMER, properties.durability(Math.round(toolTier.getUses()*DURABILITY_MULTIPLIER)));
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
        if (player.level.isClientSide || !(player instanceof ServerPlayer serverPlayer)) {
            return super.onBlockStartBreak(itemstack, pos, player);
        }

        ServerLevel level = serverPlayer.getLevel();
        Direction hitSide = BlockHitSideDetection.getHitSideByPlayer(serverPlayer);
        BlockState blockState = level.getBlockState(pos);

        if(!blockState.is(ModTags.Blocks.MINEABLE_WITH_HAMMER))
            return super.onBlockStartBreak(itemstack, pos, serverPlayer);

        // Get all BlockPositions around the broken block with respect to the hitSide
        Iterable<BlockPos> additionalPositions = getAdditionalBlocks(pos, hitSide);

        for (BlockPos additionalPos: additionalPositions) {
            BlockState additionalState = level.getBlockState(additionalPos);

            if (additionalState.isAir() || !additionalState.is(ModTags.Blocks.MINEABLE_WITH_HAMMER))
                continue;

            float destroySpeed = additionalState.getDestroySpeed(level, additionalPos);
            if (destroySpeed == -1)
                continue;

            int experience = ForgeHooks.onBlockBreakEvent(level, serverPlayer.gameMode.getGameModeForPlayer(), serverPlayer, additionalPos);
            if (experience == -1)
                continue;

            Block block = additionalState.getBlock();
            BlockEntity tileEntity = level.getBlockEntity(additionalPos);


            if (player.isCreative()) {
                if (additionalState.onDestroyedByPlayer(level, additionalPos, player, false, additionalState.getFluidState())) {
                    block.destroy(level, additionalPos, additionalState);
                }
            } else {

                if (additionalState.onDestroyedByPlayer(level, additionalPos, player, true, additionalState.getFluidState())) {
                block.destroy(level, additionalPos, additionalState);
                block.playerDestroy(level, player, additionalPos, additionalState, tileEntity, itemstack);
                itemstack.mineBlock(level, additionalState, additionalPos, serverPlayer);

                    if (experience > 0) {
                        block.popExperience(level, additionalPos, experience);
                    }
                }

            }
        }

        return true;
    }
    @Override
    protected boolean allowedIn(CreativeModeTab creativeTab) {
        if (creativeTab.equals(_ADDITIONAL_CREATIVE_TAB)) {
            return true;
        }

        return super.allowedIn(creativeTab);
    }

    private List<BlockPos> getAdditionalBlocks(BlockPos pos, Direction hitSide) {

        List<BlockPos> others = new ArrayList<>();

        others.add(pos);

        switch (hitSide) {
            case UP:
            case DOWN:
                others.add(pos.north());
                others.add(pos.south());
                others.add(pos.east());
                others.add(pos.west());
                others.add(pos.north().east());
                others.add(pos.north().west());
                others.add(pos.south().east());
                others.add(pos.south().west());
                break;
            case NORTH:
            case SOUTH:
                others.add(pos.west());
                others.add(pos.east());
                others.add(pos.below());
                others.add(pos.above());
                others.add(pos.west().above());
                others.add(pos.east().above());
                others.add(pos.west().below());
                others.add(pos.east().below());
                break;
            case EAST:
            case WEST:
                others.add(pos.north());
                others.add(pos.south());
                others.add(pos.below());
                others.add(pos.above());
                others.add(pos.north().above());
                others.add(pos.south().above());
                others.add(pos.north().below());
                others.add(pos.south().below());
                break;
            default:
                return Collections.EMPTY_LIST;
        }

        return others;
    }
}
