package me.siasur.unrelatedadditions.item;

import me.siasur.unrelatedadditions.utils.VectorHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AngelBlockItem extends BlockItem {

    public static final String PLACEMENT_HINT_TOOLTIP_KEY = "tooltip.unrelatedadditions.angelblock_placement";

    public AngelBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        Vec3 target = player.getPosition(1).subtract(0, 1, 0);
        BlockPos position = VectorHelper.toBlockPos(target);

        BlockHitResult hitResult = new BlockHitResult(target, player.getDirection(), position, true);
        BlockPlaceContext placeContext = new BlockPlaceContext(level, null, hand, itemStack, hitResult);
        InteractionResult placeResult = this.place(placeContext);
        return new InteractionResultHolder(placeResult, itemStack);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable(PLACEMENT_HINT_TOOLTIP_KEY));
    }
}
