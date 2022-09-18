package me.siasur.unrelatedadditions.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class XPDrainBlock extends Block {

    public XPDrainBlock(Properties pProperties) {
        super(pProperties);
    }

    private static final VoxelShape SHAPE = Shapes.create(0, 0, 0, 1, 0.0625, 1);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
