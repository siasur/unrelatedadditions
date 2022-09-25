package me.siasur.unrelatedadditions.fluid;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, UnrelatedAdditions.MODID);

    public static final RegistryObject<XPJuiceFluidType> XP_JUICE_FLUID_TYPE = FLUID_TYPES.register("xp_juice", () -> new XPJuiceFluidType());

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

}
