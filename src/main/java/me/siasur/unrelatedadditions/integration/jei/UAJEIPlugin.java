package me.siasur.unrelatedadditions.integration.jei;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.recipe.DryingRecipe;
import me.siasur.unrelatedadditions.recipe.ModRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class UAJEIPlugin implements IModPlugin {

    public static mezz.jei.api.recipe.RecipeType<DryingRecipe> JEI_DRYING_RECIPE_TYPE = DryingRecipeCategory.RECIPE_TYPE;

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(UnrelatedAdditions.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new DryingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(DryingRecipeCategory.RECIPE_DISPLAY_ITEM, JEI_DRYING_RECIPE_TYPE);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<DryingRecipe> dryingRecipes = recipeManager.getAllRecipesFor(ModRecipeTypes.DRYING.get());
        registration.addRecipes(JEI_DRYING_RECIPE_TYPE, dryingRecipes);
    }
}
