package me.siasur.unrelatedadditions.item;

import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.Nullable;

public class RopeLadderBlockItem extends BlockItem {
    public RopeLadderBlockItem(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    @Nullable
    @Override
    public BlockPlaceContext updatePlacementContext(BlockPlaceContext placeContext) {
        BlockState clicked = placeContext.getLevel().getBlockState(placeContext.getClickedPos());

        return clicked.is(this.getBlock()) ? BlockPlaceContext.at(placeContext, placeContext.getClickedPos(), Direction.DOWN) : placeContext;
    }

    @Override
    public InteractionResult place(BlockPlaceContext placeContext) {
        int maxAmount = placeContext.getItemInHand().getCount();
        var originalPlace = super.place(placeContext);
        if (!originalPlace.equals(InteractionResult.FAIL) && maxAmount > 1) {
            Direction dir = placeContext.getLevel().getBlockState(placeContext.getClickedPos()).getValue(BlockStateProperties.HORIZONTAL_FACING);
            InteractionResult nextPlace;
            BlockPlaceContext nextContext = placeContext;
            int count = 1;
            do {
                nextContext = BlockPlaceContext.at(nextContext, nextContext.getClickedPos(), Direction.DOWN);
                nextPlace = super.place(nextContext);
                count += 1;
            } while (!nextPlace.equals(InteractionResult.FAIL) && count < maxAmount);
        }

        return originalPlace;
    }
}
