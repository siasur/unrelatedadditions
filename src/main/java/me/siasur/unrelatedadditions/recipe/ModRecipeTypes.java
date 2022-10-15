package me.siasur.unrelatedadditions.recipe;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static me.siasur.unrelatedadditions.UnrelatedAdditions.modLoc;

public class ModRecipeTypes {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, UnrelatedAdditions.MODID);

    public static final RegistryObject<RecipeType<DryingRecipe>> DRYING = RECIPE_TYPES.register("drying", () -> RecipeType.simple(modLoc("drying")));

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }

}
