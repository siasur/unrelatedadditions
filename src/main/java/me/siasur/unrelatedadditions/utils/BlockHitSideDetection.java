package me.siasur.unrelatedadditions.utils;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** This class is used to get the side of the block that was hit by the player. */
public class BlockHitSideDetection {

    private static final Map<UUID, Direction> DIRECTION_MAP = new HashMap<>();

    public static void register(IEventBus forgeEventBus) {
        forgeEventBus.addListener(BlockHitSideDetection::onLeftClickBlock);
        forgeEventBus.addListener(BlockHitSideDetection::onPlayerLoggedOutEvent);
    }

    private static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        DIRECTION_MAP.put(event.getEntity().getUUID(), event.getFace());
    }

    private static void onPlayerLoggedOutEvent (PlayerEvent.PlayerLoggedOutEvent event) {
        DIRECTION_MAP.remove(event.getEntity().getUUID());
    }

    public static Direction getHitSideByPlayer(Player player) {
        return DIRECTION_MAP.getOrDefault(player.getUUID(), Direction.DOWN);
    }

}
