package me.siasur.unrelatedadditions.item;

import me.siasur.unrelatedadditions.utils.ModTags;
import me.siasur.unrelatedadditions.utils.VectorHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MagnetItem extends Item {

    private static final String TAG_KEY = "magnetized";
    private static final int RANGE = 3;
    private static final float SCALING_FACTOR = 0.45f;

    public MagnetItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, Level level, @NotNull Entity entity, int slot, boolean inHand) {
        if (level.isClientSide || !(entity instanceof LivingEntity livingEntity) || livingEntity.isSpectator())
            return;

        if (!isActive(itemStack))
            return;

        AABB areaOfEffect = entity.getBoundingBox().inflate(RANGE);
        List<ItemEntity> itemsToPull = level.getEntitiesOfClass(ItemEntity.class, areaOfEffect, this::canPullItem);

        Vec3 playerVector = entity.position().add(0, .75f, 0);
        for (ItemEntity item : itemsToPull) {
            Vec3 itemVector = VectorHelper.entityCenter(item);
            Vec3 pullVector = playerVector.subtract(itemVector).normalize();

            item.setDeltaMovement(pullVector.scale(SCALING_FACTOR));
        }
    }

    @Override
    public boolean isFoil(@NotNull ItemStack itemStack) {
        return isActive(itemStack);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!player.isShiftKeyDown())
            return new InteractionResultHolder<>(InteractionResult.PASS, itemStack);

        toggle(itemStack);

        return new InteractionResultHolder<>(InteractionResult.CONSUME, itemStack);
    }

    private boolean isActive(ItemStack itemStack) {
        CompoundTag compoundtag = itemStack.getOrCreateTag();
        return compoundtag.contains(TAG_KEY) && compoundtag.getBoolean(TAG_KEY);
    }

    private void toggle(ItemStack itemStack) {
        CompoundTag tag = itemStack.getOrCreateTag();
        if (!tag.contains(TAG_KEY))
            tag.putBoolean(TAG_KEY, true);
        else
            tag.putBoolean(TAG_KEY, !tag.getBoolean(TAG_KEY));
    }

    private boolean canPullItem(ItemEntity itemEntity) {
        boolean isNotBlacklisted = itemEntity.getItem().getTags().noneMatch( k -> k.equals(ModTags.Items.MAGNET_BLACKLIST));
        boolean hasPickupDelay = itemEntity.hasPickUpDelay();

        return isNotBlacklisted && !hasPickupDelay;
    }
}
