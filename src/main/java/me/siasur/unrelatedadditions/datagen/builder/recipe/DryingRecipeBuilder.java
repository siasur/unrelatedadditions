package me.siasur.unrelatedadditions.datagen.builder.recipe;

import com.google.gson.JsonObject;
import me.siasur.unrelatedadditions.recipe.DryingRecipe;
import me.siasur.unrelatedadditions.recipe.ModRecipeSerializers;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class DryingRecipeBuilder implements RecipeBuilder {

    private final Item result;
    private Ingredient ingredient;
    private final int dryingTime;

    public DryingRecipeBuilder(ItemLike result, int dryingTime) {
        this.result = result.asItem();
        this.dryingTime = dryingTime;
    }

    public static DryingRecipeBuilder drying(ItemLike result) {
        return new DryingRecipeBuilder(result, DryingRecipe.DEFAULT_DRYINGTIME);
    }

    public static DryingRecipeBuilder drying(ItemLike result, int dryingTime) {
        return new DryingRecipeBuilder(result, dryingTime);
    }

    public DryingRecipeBuilder from(TagKey<Item> tag) {
        this.ingredient = Ingredient.of(tag);
        return this;
    }

    public DryingRecipeBuilder from(ItemLike itemLike) {
        this.ingredient = Ingredient.of(itemLike);
        return this;
    }

    public DryingRecipeBuilder from(Ingredient ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    @Override
    public DryingRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        // Doesn't show up in the vanilla recipe book so no need for advancement
        return this;
    }

    @Override
    public DryingRecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        pFinishedRecipeConsumer.accept(new DryingRecipeBuilder.Result(pRecipeId, result, ingredient, dryingTime));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private Item result;
        private Ingredient ingredient;
        private int dryingTime;

        public Result(ResourceLocation id, Item result, Ingredient ingredient, int dryingTime) {
            this.id = id;
            this.result = result;
            this.ingredient = ingredient;
            this.dryingTime = dryingTime;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            pJson.add("ingredient", this.ingredient.toJson());
            pJson.addProperty("result", Registry.ITEM.getKey(this.result).toString());
            pJson.addProperty("dryingtime", dryingTime);
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ModRecipeSerializers.DRYING.get();
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
