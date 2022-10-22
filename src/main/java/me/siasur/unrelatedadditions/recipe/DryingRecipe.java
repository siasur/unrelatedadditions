package me.siasur.unrelatedadditions.recipe;

import com.google.gson.JsonObject;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static me.siasur.unrelatedadditions.UnrelatedAdditions.modLoc;

public class DryingRecipe implements Recipe<SimpleContainer> {

    public static final String JSON_KEY_RESULT = "result";
    public static final String JSON_KEY_INGREDIENT = "ingredient";
    public static final String JSON_KEY_DURATION = "dryingtime";
    public static final int DEFAULT_DRYINGTIME = 600;

    private final ResourceLocation id;
    private final ItemStack result;
    private final Ingredient ingredient;
    private final int dryingTime;

    public DryingRecipe(ResourceLocation id, ItemStack result, Ingredient ingredient, int dryingTime) {
        this.id = id;
        this.result = result;
        this.ingredient = ingredient;
        this.dryingTime = dryingTime;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return !pLevel.isClientSide() && ingredient.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return result;
    }

    public Ingredient getIngredient() {return ingredient; }

    public int getDryingTime() {
        return this.dryingTime;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.DRYING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.DRYING.get();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class Serializer implements RecipeSerializer<DryingRecipe> {
        public static final ResourceLocation ID = modLoc("drying");

        @Override
        public DryingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack out;
            if (pSerializedRecipe.get(JSON_KEY_RESULT).isJsonObject()) {
                out = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, JSON_KEY_RESULT));
            } else {
                String resultName = GsonHelper.getAsString(pSerializedRecipe, JSON_KEY_RESULT);
                ResourceLocation resourcelocation = new ResourceLocation(resultName);
                out = new ItemStack(Registry.ITEM.getOptional(resourcelocation)
                        .orElseThrow(() -> new IllegalStateException("Item: " + resultName + " does not exist")));
            }

            Ingredient in = Ingredient.fromJson(pSerializedRecipe.get(JSON_KEY_INGREDIENT));
            int duration = GsonHelper.getAsInt(pSerializedRecipe, JSON_KEY_DURATION, DryingRecipe.DEFAULT_DRYINGTIME);

            return new DryingRecipe(pRecipeId, out, in, duration);
        }

        @Override
        public @Nullable DryingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            ItemStack out = pBuffer.readItem();
            Ingredient in = Ingredient.fromNetwork(pBuffer);
            int duration = pBuffer.readInt();

            return new DryingRecipe(pRecipeId, out, in, duration);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, DryingRecipe pRecipe) {
            pBuffer.writeItemStack(pRecipe.result, false);
            pRecipe.ingredient.toNetwork(pBuffer);
            pBuffer.writeInt(pRecipe.dryingTime);
        }
    }

}
