package me.siasur.unrelatedadditions.item;

import me.siasur.unrelatedadditions.utils.VectorHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class AngelBlockItem extends BlockItem {

    public AngelBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        Vec3 viewVec = player.getViewVector(1);
        Vec3 target = player.getEyePosition().add(viewVec);

        // I absolutely hate this... But it works, so it's going to stay until I find a better way
        while (player.getBoundingBox().intersects(new AABB(VectorHelper.floor(target), VectorHelper.floor(target).add(1, 1, 1))))
        {
            target = target.add(viewVec);
        }

        BlockPos position = VectorHelper.toBlockPos(target);
        BlockHitResult hitResult = new BlockHitResult(target, player.getDirection(), position, true);
        BlockPlaceContext placeContext = new BlockPlaceContext(level, null, hand, itemStack, hitResult);

        InteractionResult placeResult = this.place(placeContext);

        return new InteractionResultHolder(placeResult, itemStack);
    }
}
