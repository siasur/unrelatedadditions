package me.siasur.unrelatedadditions.utils;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class VectorHelper {

    public static Vec3 entityCenter(Entity entity) {
        return new Vec3(entity.getX(), entity.getY() + (entity.getBbHeight()/2), entity.getZ());
    }

}
