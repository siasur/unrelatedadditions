package me.siasur.unrelatedadditions.item;

import me.siasur.unrelatedadditions.inventory.ModCreativeModeTab;
import me.siasur.unrelatedadditions.utils.BlockHitSideDetection;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class ExcavatorTool extends DiggerItem {

    private static float _DAMAGE = 1f;
    private static float _ATTACKSPEED = -2.8f;
    private static float DURABILITY_MULTIPLIER = 5;

    private TagKey<Block> targetTag;

    private static CreativeModeTab _ADDITIONAL_CREATIVE_TAB = ModCreativeModeTab.TAB_UNRELATEDADDITIONS;

    public ExcavatorTool(Tier toolTier, Properties properties, TagKey<Block> targetTag) {
        super(_DAMAGE, _ATTACKSPEED, toolTier, targetTag, properties.durability(Math.round(toolTier.getUses() * DURABILITY_MULTIPLIER)));
        this.targetTag = targetTag;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
        if (player.level.isClientSide || !(player instanceof ServerPlayer serverPlayer)) {
            return super.onBlockStartBreak(itemstack, pos, player);
        }

        ServerLevel level = serverPlayer.getLevel();
        Direction hitSide = BlockHitSideDetection.getHitSideByPlayer(serverPlayer);
        BlockState blockState = level.getBlockState(pos);

        if (!blockState.is(targetTag))
            return super.onBlockStartBreak(itemstack, pos, serverPlayer);

        // Get all BlockPositions around the broken block with respect to the hitSide
        Iterable<BlockPos> additionalPositions = getBlocksToBreak(pos, hitSide);

        for (BlockPos additionalPos : additionalPositions) {
            BlockState additionalState = level.getBlockState(additionalPos);

            if (additionalState.isAir() || !additionalState.is(targetTag))
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

    private Set<BlockPos> getBlocksToBreak(BlockPos pos, Direction hitSide) {
        Set<BlockPos> others = new HashSet<>();
        others.add(pos);

        EnumSet<Direction> xDirections = EnumSet.of(Direction.WEST, Direction.EAST);
        EnumSet<Direction> yDirections = EnumSet.of(Direction.DOWN, Direction.UP);
        EnumSet<Direction> zDirections = EnumSet.of(Direction.NORTH, Direction.SOUTH);

        int radius = 1;

        if (xDirections.contains(hitSide)) {
            IntStream.rangeClosed(-radius, radius).forEach(z -> {
                IntStream.rangeClosed(-radius, radius).forEach(y -> {
                    if (z != 0 || y != 0) {
                        others.add(pos.offset(0, y, z));
                    }
                });
            });
        } else if (yDirections.contains(hitSide)) {
            IntStream.rangeClosed(-radius, radius).forEach(x -> {
                IntStream.rangeClosed(-radius, radius).forEach(z -> {
                    if (x != 0 || z != 0) {
                        others.add(pos.offset(x, 0, z));
                    }
                });
            });
        } else if (zDirections.contains(hitSide)) {
            IntStream.rangeClosed(-radius, radius).forEach(x -> {
                IntStream.rangeClosed(-radius, radius).forEach(y -> {
                    if (x != 0 || y != 0) {
                        others.add(pos.offset(x, y, 0));
                    }
                });
            });
        } else {
            return Collections.emptySet();
        }

        return others;
    }

//    private List<BlockPos> getBlocksToBreak(BlockPos pos, Direction hitSide) {
//
//        List<BlockPos> others = new ArrayList<>();
//
//        others.add(pos);
//
//        switch (hitSide) {
//            case UP:
//            case DOWN:
//                others.add(pos.north());
//                others.add(pos.south());
//                others.add(pos.east());
//                others.add(pos.west());
//                others.add(pos.north().east());
//                others.add(pos.north().west());
//                others.add(pos.south().east());
//                others.add(pos.south().west());
//                break;
//            case NORTH:
//            case SOUTH:
//                others.add(pos.west());
//                others.add(pos.east());
//                others.add(pos.below());
//                others.add(pos.above());
//                others.add(pos.west().above());
//                others.add(pos.east().above());
//                others.add(pos.west().below());
//                others.add(pos.east().below());
//                break;
//            case EAST:
//            case WEST:
//                others.add(pos.north());
//                others.add(pos.south());
//                others.add(pos.below());
//                others.add(pos.above());
//                others.add(pos.north().above());
//                others.add(pos.south().above());
//                others.add(pos.north().below());
//                others.add(pos.south().below());
//                break;
//            default:
//                return Collections.EMPTY_LIST;
//        }

//        return others;
//    }
}
