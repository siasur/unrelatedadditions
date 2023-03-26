package me.siasur.unrelatedadditions.block.entity;

import me.siasur.unrelatedadditions.config.UnrelatedAdditionsCommonConfig;
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

    private int tickCounter = 0;
    private boolean onTop = false;

    public XPDrainBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.XP_DRAIN.get(), pPos, pBlockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState ignored, XPDrainBlockEntity pEntity) {
        if (level.isClientSide()) return;

        ServerPlayer playerOnTop = getValidPlayerOnTop(level, blockPos);
        IFluidHandler tankBelow = getTankBelow(level, blockPos);

        if (playerOnTop == null || tankBelow == null) {
            pEntity.onTop = false;
            pEntity.tickCounter = 0;
            return;
        }

        int pointsToTake = scaleConversion(UnrelatedAdditionsCommonConfig.LIQUID_XP_LIQUEFACTION_SPEED.get(), playerOnTop.totalExperience, pEntity.tickCounter++);
        int juiceToProduce = calculateJuiceOutput(pointsToTake, UnrelatedAdditionsCommonConfig.LIQUID_XP_CONVERSION_RATE.get());

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
        return conversionRatio * pointsToTake;
    }

    private static ServerPlayer getValidPlayerOnTop(Level level, BlockPos blockPos) {
        ServerPlayer nullEntity = null;
        return level.getEntities(nullEntity, new AABB(blockPos), (Entity e) -> e instanceof ServerPlayer p && p.totalExperience > 0).stream().map(e -> (ServerPlayer) e).findFirst().orElse(nullEntity);
    }

    private static IFluidHandler getTankBelow(Level level, BlockPos blockPos) {
        BlockPos below = blockPos.below();
        BlockEntity entity = level.getBlockEntity(below);

        if (entity == null) return null;

        return entity.getCapability(ForgeCapabilities.FLUID_HANDLER, Direction.UP).resolve().orElse(null);

    }

    /**
     * Returns the amount of experience points to convert based on the time the player has been standing on the drain
     * Starts at 0 and increases exponentially based on the time the player has been standing on the drain
     * <p>
     * The formula is: <code>min(target, totalExperience, time^1.9 / 80)</code>
     * </p>
     *
     * @param target          The maximum amount of experience points to convert per tick
     * @param totalExperience The total amount of experience points the player has
     * @param time            The time in ticks since the player has been standing on the drain
     * @return The amount of experience points to convert
     */
    private static int scaleConversion(int target, int totalExperience, int time) {

        int max = Math.min(target, totalExperience);
        return (int) Math.min(max, Math.pow(time, 1.9) / 80);
    }
}
