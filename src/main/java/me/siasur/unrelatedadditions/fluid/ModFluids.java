package me.siasur.unrelatedadditions.fluid;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.block.ModBlocks;
import me.siasur.unrelatedadditions.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, UnrelatedAdditions.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_XP_JUICE = FLUIDS.register("xp_juice",
            () -> new ForgeFlowingFluid.Source(ModFluids.XP_JUICE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_XP_JUICE = FLUIDS.register("flowing_xp_juice",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.XP_JUICE_PROPERTIES));

    private static final ForgeFlowingFluid.Properties XP_JUICE_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.XP_JUICE_FLUID_TYPE, SOURCE_XP_JUICE, FLOWING_XP_JUICE)
            .slopeFindDistance(3)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.XP_JUICE)
            .bucket(ModItems.XP_JUICE_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}
