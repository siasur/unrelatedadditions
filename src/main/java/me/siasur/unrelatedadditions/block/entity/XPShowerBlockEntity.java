package me.siasur.unrelatedadditions.block.entity;

import me.siasur.unrelatedadditions.block.XPShowerBlock;
import me.siasur.unrelatedadditions.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class XPShowerBlockEntity extends BlockEntity {

    public static final int PLAYER_DETECTION_RANGE = 3;

    public static final int CONVERSION_SPEED = 10;

    public XPShowerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.XP_SHOWER.get(), pPos, pBlockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, XPShowerBlockEntity pEntity) {
        if (level.isClientSide()) return;

        ServerPlayer playerBelow = getValidPlayerBelow(level, blockPos);
        IFluidHandler connectedTank = getConnectedTank(level, blockState, blockPos);

        if (playerBelow == null || connectedTank == null) return;

        int fluidToTake = CONVERSION_SPEED * XPDrainBlockEntity.CONVERSION_RATIO;
        FluidStack toBeTaken = new FluidStack(ModFluids.SOURCE_XP_JUICE.get(), fluidToTake);

        FluidStack wouldTake = connectedTank.drain(toBeTaken, IFluidHandler.FluidAction.SIMULATE);

        if (!wouldTake.isEmpty()) {
            int orbsToSpawn = Math.floorDiv(wouldTake.getAmount(), XPDrainBlockEntity.CONVERSION_RATIO);
            Vec3 spawnPoint = getOrbSpawnLocation(blockPos);
            ExperienceOrb orbs = new ExperienceOrb(level, spawnPoint.x, spawnPoint.y, spawnPoint.z, orbsToSpawn);

            connectedTank.drain(wouldTake, IFluidHandler.FluidAction.EXECUTE);
            level.addFreshEntity(orbs);
        }
    }

    private static ServerPlayer getValidPlayerBelow(Level level, BlockPos blockPos) {
        BlockPos blockPos1 = blockPos.below(PLAYER_DETECTION_RANGE);

        AABB area = new AABB(Math.min(blockPos.getX(), blockPos1.getX()), Math.min(blockPos.getY(), blockPos1.getY()), Math.min(blockPos.getZ(), blockPos1.getZ()), Math.max(blockPos.getX(), blockPos1.getX()) + 1, Math.max(blockPos.getY(), blockPos1.getY()) + 1, Math.max(blockPos.getZ(), blockPos1.getZ()) + 1);

        ServerPlayer nullPlayer = null;
        return level.getEntities(nullPlayer, area, (Entity e) -> e instanceof ServerPlayer p).stream().map(e -> (ServerPlayer) e).findFirst().orElse(nullPlayer);

    }

    private static IFluidHandler getConnectedTank(Level level, BlockState blockState, BlockPos blockPos) {
        BlockPos neighbour = blockPos.relative(blockState.getValue(XPShowerBlock.FACING));
        BlockEntity entity = level.getBlockEntity(neighbour);

        if (entity == null) return null;

        return entity.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, blockState.getValue(XPShowerBlock.FACING).getOpposite()).resolve().orElseGet(() -> null);
    }

    private static Vec3 getOrbSpawnLocation(BlockPos blockPos) {

        double x = blockPos.getX() + .5;
        double y = blockPos.getY() + .1;
        double z = blockPos.getZ() + .5;

        return new Vec3(x, y, z);
    }
}
