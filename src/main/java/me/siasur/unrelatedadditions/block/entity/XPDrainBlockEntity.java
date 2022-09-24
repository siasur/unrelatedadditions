package me.siasur.unrelatedadditions.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;

public class XPDrainBlockEntity extends BlockEntity {

    /**
     * Amount of experience points that get taken per tick.
     */
    private static final int CONVERSION_SPEED = 2;

    /**
     * mB of XP Juice that get generated per experience point
     */
    private static final int CONVERSION_RATIO = 144;

    private int tickCounter = 0;
    private boolean onTop = false;

    private int content = 0;

    public XPDrainBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.XP_DRAIN.get(), pPos, pBlockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, XPDrainBlockEntity pEntity) {
        if (level.isClientSide())
            return;

        ServerPlayer playerOnTop = getValidPlayerOnTop(level, blockPos);

        if (playerOnTop == null) {
            pEntity.onTop = false;
            pEntity.tickCounter = 0;
            return;
        }
        int pointsToTake = scaleConversion(CONVERSION_SPEED, playerOnTop.totalExperience, pEntity.tickCounter++);
        int juiceToProduce = calculateJuiceOutput(pointsToTake, CONVERSION_RATIO);

        if (juiceToProduce > 0) {
            playerOnTop.giveExperiencePoints(-pointsToTake);
            pEntity.content += juiceToProduce;
        }

        playerOnTop.sendSystemMessage(Component.literal("%d Experience Juice".formatted(pEntity.content)));

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

    private static int scaleConversion(int ration, int totalExperience, int time) {
        return Math.min(CONVERSION_SPEED, totalExperience);
    }
}
