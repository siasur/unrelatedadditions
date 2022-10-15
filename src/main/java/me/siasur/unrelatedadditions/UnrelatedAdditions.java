package me.siasur.unrelatedadditions;

import com.mojang.logging.LogUtils;
import me.siasur.unrelatedadditions.block.ModBlocks;
import me.siasur.unrelatedadditions.block.entity.ModBlockEntities;
import me.siasur.unrelatedadditions.block.entity.renderer.DryingRackBlockEntityRenderer;
import me.siasur.unrelatedadditions.fluid.ModFluidTypes;
import me.siasur.unrelatedadditions.fluid.ModFluids;
import me.siasur.unrelatedadditions.item.ModItems;
import me.siasur.unrelatedadditions.recipe.ModRecipeSerializers;
import me.siasur.unrelatedadditions.recipe.ModRecipeTypes;
import me.siasur.unrelatedadditions.utils.BlockHitSideDetection;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UnrelatedAdditions.MODID)
public class UnrelatedAdditions
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "unrelatedadditions";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public UnrelatedAdditions()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModRecipeTypes.register(modEventBus);
        ModRecipeSerializers.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        BlockHitSideDetection.register(MinecraftForge.EVENT_BUS);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.DRYING_RACK.get(), DryingRackBlockEntityRenderer::new);
        }
    }


    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(UnrelatedAdditions.MODID, path);
    }
}
