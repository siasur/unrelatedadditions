package me.siasur.unrelatedadditions.recipe;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeSerializers {


    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, UnrelatedAdditions.MODID);

    public static final RegistryObject<RecipeSerializer<DryingRecipe>> DRYING = RECIPE_TYPES.register("drying", DryingRecipe.Serializer::new);

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }


}
