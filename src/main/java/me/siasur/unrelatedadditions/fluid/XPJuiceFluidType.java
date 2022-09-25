package me.siasur.unrelatedadditions.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.math.Vector3f;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class XPJuiceFluidType extends FluidType {

    public static final ResourceLocation FLUID_STILL_TEXTURE = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLUID_FLOWING_TEXTURE = new ResourceLocation("block/water_flow");
    public static final ResourceLocation FLUID_OVERLAY_TEXTURE = new ResourceLocation("block/water_flow");

    public XPJuiceFluidType() {
        super(FluidType.Properties.create()
                .supportsBoating(false)
                .canHydrate(false)
                .canDrown(true)
                .canExtinguish(true)
                .canPushEntity(true)
                .canSwim(true)
                .pathType(BlockPathTypes.WATER)
                .adjacentPathType(BlockPathTypes.WATER_BORDER)
                .canConvertToSource(false)
                .fallDistanceModifier(0.1f)
                .rarity(Rarity.EPIC)
                .viscosity(250)
                .density(250)
                .temperature(5)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
        );
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public int getTintColor() {
                return 0xff93ff14;
            }

            @Override
            public ResourceLocation getStillTexture() {
                return FLUID_STILL_TEXTURE;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLUID_FLOWING_TEXTURE;
            }

            @Override
            public ResourceLocation getOverlayTexture() {
                return FLUID_OVERLAY_TEXTURE;
            }

            @Override
            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return new Vector3f( 0x93 / 255f, 0xff / 255f, 0x14/255f);
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                IClientFluidTypeExtensions.super.modifyFogRender(camera, mode, renderDistance, partialTick, nearDistance, farDistance, shape);
            }
        });
    }
}
