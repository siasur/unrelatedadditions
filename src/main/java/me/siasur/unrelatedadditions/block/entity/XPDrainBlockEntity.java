package me.siasur.unrelatedadditions.block.entity;

import me.siasur.unrelatedadditions.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class XPDrainBlockEntity extends BlockEntity {

    /**
     * Amount of experience points that get taken per tick.
     */
    public static final int CONVERSION_SPEED = 2;

    /**
     * mB of XP Juice that get generated per experience point
     */
    public static final int CONVERSION_RATIO = 16;

    private int tickCounter = 0;
    private boolean onTop = false;

    public XPDrainBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.XP_DRAIN.get(), pPos, pBlockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, XPDrainBlockEntity pEntity) {
        if (level.isClientSide()) return;

        ServerPlayer playerOnTop = getValidPlayerOnTop(level, blockPos);
        IFluidHandler tankBelow = getTankBelow(level, blockPos);

        if (playerOnTop == null || tankBelow == null) {
            pEntity.onTop = false;
            pEntity.tickCounter = 0;
            return;
        }

        int pointsToTake = scaleConversion(CONVERSION_SPEED, playerOnTop.totalExperience, pEntity.tickCounter++);
        int juiceToProduce = calculateJuiceOutput(pointsToTake, CONVERSION_RATIO);

        if (juiceToProduce > 0) {
            FluidStack createdXPJuice = new FluidStack(ModFluids.SOURCE_XP_JUICE.get(), juiceToProduce);
            int wouldAdd = tankBelow.fill(createdXPJuice, IFluidHandler.FluidAction.SIMULATE);

            if (wouldAdd == juiceToProduce) {
                playerOnTop.giveExperiencePoints(-pointsToTake);
                tankBelow.fill(createdXPJuice, IFluidHandler.FluidAction.EXECUTE);
            }
        }

        if (!pEntity.onTop) {
            pEntity.onTop = true;
        }
    }

    private static int calculateJuiceOutput(int pointsToTake, int conversionRatio) {
        return CONVERSION_RATIO * pointsToTake;
    }

    private static ServerPlayer getValidPlayerOnTop(Level level, BlockPos blockPos) {
        ServerPlayer nullEntity = null;
        return level.getEntities(nullEntity, new AABB(blockPos), (Entity e) -> e instanceof ServerPlayer p && p.totalExperience > 0).stream().map(e -> (ServerPlayer) e).findFirst().orElse(nullEntity);
    }

    private static IFluidHandler getTankBelow(Level level, BlockPos blockPos) {
        BlockPos below = blockPos.below();
        BlockEntity entity = level.getBlockEntity(below);

        if (entity == null) return null;

        return entity.getCapability(ForgeCapabilities.FLUID_HANDLER, Direction.UP).resolve().orElseGet(() -> null);
    }

    private static int scaleConversion(int ration, int totalExperience, int time) {
        return Math.min(CONVERSION_SPEED, totalExperience);
    }
}
