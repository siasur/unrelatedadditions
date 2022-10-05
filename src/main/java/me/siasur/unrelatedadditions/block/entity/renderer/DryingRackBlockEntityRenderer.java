package me.siasur.unrelatedadditions.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import me.siasur.unrelatedadditions.block.entity.DryingRackBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class DryingRackBlockEntityRenderer implements BlockEntityRenderer<DryingRackBlockEntity> {

    public DryingRackBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(DryingRackBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        ItemStack itemStack = pBlockEntity.getRenderStack();
        pPoseStack.pushPose();
        pPoseStack.scale(0.95f, 0.95f, 1);

        switch (pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case NORTH -> {
                pPoseStack.translate(0.525f, 0.5f, 0.06f);
                pPoseStack.mulPose(Vector3f.YP.rotationDegrees(0));
            }
            case SOUTH -> {
                pPoseStack.translate(0.525f, 0.5f, 1-0.06f);
                pPoseStack.mulPose(Vector3f.YP.rotationDegrees(180));
            }
            case WEST -> {
                pPoseStack.translate(0.06f, 0.5f, 0.5f);
                pPoseStack.mulPose(Vector3f.YP.rotationDegrees(90));
            }
            case EAST -> {
                pPoseStack.translate(1-0.06f, 0.5f, 0.5f);
                pPoseStack.mulPose(Vector3f.YP.rotationDegrees(270));
            }
        }

        itemRenderer.renderStatic(itemStack, ItemTransforms.TransformType.GUI, getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
        pPoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos blockPos) {
        return LightTexture.pack(
                level.getBrightness(LightLayer.BLOCK, blockPos),
                level.getBrightness(LightLayer.SKY, blockPos)
        );
    }
}
