package me.siasur.unrelatedadditions.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class VectorHelper {

    public static Vec3 entityCenter(Entity entity) {
        return new Vec3(entity.getX(), entity.getY() + (entity.getBbHeight()/2), entity.getZ());
    }

    public static BlockPos toBlockPos(Vec3 vector) {
        Vec3 floored = floor(vector);
        return new BlockPos(floored.x(), floored.y(), floored.z());
    }

    public static Vec3 floor(Vec3 vector) {
        return new Vec3(Math.floor(vector.x()), Math.floor(vector.y()), Math.floor(vector.z()));
    }

}
