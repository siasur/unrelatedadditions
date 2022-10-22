package me.siasur.unrelatedadditions.integration.jei;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.block.ModBlocks;
import me.siasur.unrelatedadditions.recipe.DryingRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class DryingRecipeCategory implements IRecipeCategory<DryingRecipe> {

    public static final RecipeType<DryingRecipe> RECIPE_TYPE = RecipeType.create(UnrelatedAdditions.MODID, "drying", DryingRecipe.class);
    public static final ItemStack RECIPE_DISPLAY_ITEM = new ItemStack(ModBlocks.DRYING_RACK.get());

    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(UnrelatedAdditions.MODID, "textures/gui/jei/drying_recipe.png");

    private final IDrawable background;
    private final IDrawable icon;

    public DryingRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.drawableBuilder(TEXTURE_LOCATION, 0, 0, 100, 60).setTextureSize(100, 60).build();
        this.icon = guiHelper.createDrawableItemStack(RECIPE_DISPLAY_ITEM);
    }

    @Override
    public RecipeType<DryingRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.unrelatedadditions.integration.jei.category.drying");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DryingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 9, 22).addIngredients(recipe.getIngredient());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 71, 22).addItemStack(recipe.getResultItem())
                .addTooltipCallback((slotView, toolTip) -> toolTip.add(Component.translatable("gui.unrelatedadditions.integration.jei.drying_time_tooltip", recipe.getDryingTime())));

    }
}
