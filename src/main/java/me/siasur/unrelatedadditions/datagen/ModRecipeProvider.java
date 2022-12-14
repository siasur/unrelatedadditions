package me.siasur.unrelatedadditions.datagen;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.block.ModBlocks;
import me.siasur.unrelatedadditions.datagen.builder.recipe.DryingRecipeBuilder;
import me.siasur.unrelatedadditions.item.ExcavatorTool;
import me.siasur.unrelatedadditions.item.ModItems;
import me.siasur.unrelatedadditions.utils.ModTags;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.common.crafting.conditions.TagEmptyCondition;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeConsumer) {

        ShapelessRecipeBuilder.shapeless(ModItems.TINY_COAL.get(), 8)
                .requires(Items.COAL)
                .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                .save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(Items.COAL)
                .requires(ModItems.TINY_COAL.get(), 8)
                .unlockedBy(getHasName(ModItems.TINY_COAL.get()), has(ModItems.TINY_COAL.get()))
                .save(recipeConsumer, new ResourceLocation(UnrelatedAdditions.MODID, getConversionRecipeName(Items.COAL, ModItems.TINY_COAL.get())));

        ShapelessRecipeBuilder.shapeless(ModItems.TINY_CHARCOAL.get(), 8)
                .requires(Items.CHARCOAL)
                .unlockedBy(getHasName(Items.CHARCOAL), has(Items.CHARCOAL))
                .save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(Items.CHARCOAL)
                .requires(ModItems.TINY_CHARCOAL.get(), 8)
                .unlockedBy(getHasName(ModItems.TINY_CHARCOAL.get()), has(ModItems.TINY_CHARCOAL.get()))
                .save(recipeConsumer, new ResourceLocation(UnrelatedAdditions.MODID, getConversionRecipeName(Items.CHARCOAL, ModItems.TINY_CHARCOAL.get())));

        compressedBlocks(recipeConsumer
                , Blocks.COBBLESTONE
                , ModBlocks.COMPRESSED_COBBLESTONE.get()
                , ModBlocks.DOUBLE_COMPRESSED_COBBLESTONE.get()
                , ModBlocks.TRIPLE_COMPRESSED_COBBLESTONE.get()
                , ModBlocks.QUADRUPLE_COMPRESSED_COBBLESTONE.get()
                , ModBlocks.QUINTUPLE_COMPRESSED_COBBLESTONE.get()
                , ModBlocks.SEXTUPLE_COMPRESSED_COBBLESTONE.get()
        );
        compressedBlocks(recipeConsumer
                , Blocks.COBBLED_DEEPSLATE
                , ModBlocks.COMPRESSED_COBBLED_DEEPSLATE.get()
                , ModBlocks.DOUBLE_COMPRESSED_COBBLED_DEEPSLATE.get()
                , ModBlocks.TRIPLE_COMPRESSED_COBBLED_DEEPSLATE.get()
                , ModBlocks.QUADRUPLE_COMPRESSED_COBBLED_DEEPSLATE.get()
                , ModBlocks.QUINTUPLE_COMPRESSED_COBBLED_DEEPSLATE.get()
                , ModBlocks.SEXTUPLE_COMPRESSED_COBBLED_DEEPSLATE.get()
        );
        compressedBlocks(recipeConsumer
                , Blocks.SAND
                , ModBlocks.COMPRESSED_SAND.get()
                , ModBlocks.DOUBLE_COMPRESSED_SAND.get()
                , ModBlocks.TRIPLE_COMPRESSED_SAND.get()
        );
        compressedBlocks(recipeConsumer
                , Blocks.RED_SAND
                , ModBlocks.COMPRESSED_RED_SAND.get()
                , ModBlocks.DOUBLE_COMPRESSED_RED_SAND.get()
                , ModBlocks.TRIPLE_COMPRESSED_RED_SAND.get()
        );
        compressedBlocks(recipeConsumer
                , Blocks.DIRT
                , ModBlocks.COMPRESSED_DIRT.get()
                , ModBlocks.DOUBLE_COMPRESSED_DIRT.get()
                , ModBlocks.TRIPLE_COMPRESSED_DIRT.get()
        );
        compressedBlocks(recipeConsumer
                , Blocks.GRAVEL
                , ModBlocks.COMPRESSED_GRAVEL.get()
                , ModBlocks.DOUBLE_COMPRESSED_GRAVEL.get()
        );
        compressedBlocks(recipeConsumer
                , Blocks.GRANITE
                , ModBlocks.COMPRESSED_GRANITE.get()
        );
        compressedBlocks(recipeConsumer
                , Blocks.ANDESITE
                , ModBlocks.COMPRESSED_ANDESITE.get()
        );
        compressedBlocks(recipeConsumer
                , Blocks.DIORITE
                , ModBlocks.COMPRESSED_DIORITE.get()
        );

        hammerTool(recipeConsumer, ModItems.WOODEN_HAMMER.get(), ItemTags.PLANKS, Items.STICK);
        hammerTool(recipeConsumer, ModItems.STONE_HAMMER.get(), ItemTags.STONE_TOOL_MATERIALS, Items.COBBLESTONE);
        hammerTool(recipeConsumer, ModItems.IRON_HAMMER.get(), Tags.Items.INGOTS_IRON, Items.IRON_INGOT);
        conditionalHammerTool(recipeConsumer, ModItems.BRONZE_HAMMER, ModTags.Items.INGOTS_BRONZE, new NotCondition(new TagEmptyCondition(ModTags.Items.INGOTS_BRONZE.location())));
        hammerTool(recipeConsumer, ModItems.GOLDEN_HAMMER.get(), Tags.Items.INGOTS_GOLD, Items.GOLD_INGOT);
        hammerTool(recipeConsumer, ModItems.DIAMOND_HAMMER.get(), Tags.Items.GEMS_DIAMOND, Items.DIAMOND);

        spadeTool(recipeConsumer, ModItems.WOODEN_SPADE.get(), ItemTags.PLANKS, Items.STICK);
        spadeTool(recipeConsumer, ModItems.STONE_SPADE.get(), ItemTags.STONE_TOOL_MATERIALS, Items.COBBLESTONE);
        spadeTool(recipeConsumer, ModItems.IRON_SPADE.get(), Tags.Items.INGOTS_IRON, Items.IRON_INGOT);
        conditionalSpadeTool(recipeConsumer, ModItems.BRONZE_SPADE, ModTags.Items.INGOTS_BRONZE, new NotCondition(new TagEmptyCondition(ModTags.Items.INGOTS_BRONZE.location())));
        spadeTool(recipeConsumer, ModItems.GOLDEN_SPADE.get(), Tags.Items.INGOTS_GOLD, Items.GOLD_INGOT);
        spadeTool(recipeConsumer, ModItems.DIAMOND_SPADE.get(), Tags.Items.GEMS_DIAMOND, Items.DIAMOND);

        ShapedRecipeBuilder.shaped(ModItems.MAGNET.get())
                .define('L', Tags.Items.GEMS_LAPIS)
                .define('I', Tags.Items.INGOTS_IRON)
                .define('E', Tags.Items.ENDER_PEARLS)
                .define('R', Tags.Items.DUSTS_REDSTONE)
                .pattern("LI ")
                .pattern("IEI")
                .pattern("IIR")
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.ANGEL_BLOCK.get())
                .define('G', Tags.Items.INGOTS_GOLD)
                .define('O', Items.OBSIDIAN)
                .define('F', Items.FEATHER)
                .pattern("GOG")
                .pattern("OFO")
                .pattern("GOG")
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(recipeConsumer);

        oakFlagFromWool(recipeConsumer, ModBlocks.WHITE_OAK_FLAG.get(), Blocks.WHITE_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.ORANGE_OAK_FLAG.get(), Blocks.ORANGE_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.MAGENTA_OAK_FLAG.get(), Blocks.MAGENTA_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.LIGHT_BLUE_OAK_FLAG.get(), Blocks.LIGHT_BLUE_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.YELLOW_OAK_FLAG.get(), Blocks.YELLOW_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.LIME_OAK_FLAG.get(), Blocks.LIME_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.PINK_OAK_FLAG.get(), Blocks.PINK_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.GRAY_OAK_FLAG.get(), Blocks.GRAY_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.LIGHT_GRAY_OAK_FLAG.get(), Blocks.LIGHT_GRAY_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.CYAN_OAK_FLAG.get(), Blocks.CYAN_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.PURPLE_OAK_FLAG.get(), Blocks.PURPLE_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.BLUE_OAK_FLAG.get(), Blocks.BLUE_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.BROWN_OAK_FLAG.get(), Blocks.BROWN_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.GREEN_OAK_FLAG.get(), Blocks.GREEN_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.RED_OAK_FLAG.get(), Blocks.RED_WOOL);
        oakFlagFromWool(recipeConsumer, ModBlocks.BLACK_OAK_FLAG.get(), Blocks.BLACK_WOOL);

        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.ORANGE_OAK_FLAG.get(), Tags.Items.DYES_ORANGE);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.MAGENTA_OAK_FLAG.get(), Tags.Items.DYES_MAGENTA);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.LIGHT_BLUE_OAK_FLAG.get(), Tags.Items.DYES_LIGHT_BLUE);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.YELLOW_OAK_FLAG.get(), Tags.Items.DYES_YELLOW);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.LIME_OAK_FLAG.get(), Tags.Items.DYES_LIME);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.PINK_OAK_FLAG.get(), Tags.Items.DYES_PINK);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.GRAY_OAK_FLAG.get(), Tags.Items.DYES_GRAY);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.LIGHT_GRAY_OAK_FLAG.get(), Tags.Items.DYES_LIGHT_GRAY);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.CYAN_OAK_FLAG.get(), Tags.Items.DYES_CYAN);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.PURPLE_OAK_FLAG.get(), Tags.Items.DYES_PURPLE);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.BLUE_OAK_FLAG.get(), Tags.Items.DYES_BLUE);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.BROWN_OAK_FLAG.get(), Tags.Items.DYES_BROWN);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.GREEN_OAK_FLAG.get(), Tags.Items.DYES_GREEN);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.RED_OAK_FLAG.get(), Tags.Items.DYES_RED);
        coloredOakFlagFromWhiteFlagAndDye(recipeConsumer, ModBlocks.BLACK_OAK_FLAG.get(), Tags.Items.DYES_BLACK);

        ShapedRecipeBuilder.shaped(ModBlocks.ROPE_LADDER.get(), 6)
                .define('_', Tags.Items.RODS_WOODEN)
                .define('I', Tags.Items.STRING)
                .pattern("I_I")
                .pattern("I_I")
                .pattern("I_I")
                .unlockedBy("has_sticks", has(Tags.Items.RODS_WOODEN))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.XP_DRAIN.get(), 1)
                .define('#', Blocks.IRON_BARS)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_iron_bars", has(Items.IRON_BARS))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.XP_SHOWER.get(), 1)
                .define('I', Tags.Items.INGOTS_IRON)
                .define('O', Items.OBSIDIAN)
                .pattern("III")
                .pattern("  O")
                .unlockedBy("has_iron_ingots", has(Tags.Items.INGOTS_IRON))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.DRYING_RACK.get(), 2)
                .define('S', Blocks.OAK_SLAB)
                .pattern("SSS")
                .unlockedBy("has_oak_slab", has(Blocks.OAK_SLAB))
                .save(recipeConsumer);

        dryingRecipe(recipeConsumer, Items.DEAD_BRAIN_CORAL, Items.BRAIN_CORAL, 50);
        dryingRecipe(recipeConsumer, Items.DEAD_BUBBLE_CORAL, Items.BUBBLE_CORAL, 50);
        dryingRecipe(recipeConsumer, Items.DEAD_FIRE_CORAL, Items.FIRE_CORAL, 50);
        dryingRecipe(recipeConsumer, Items.DEAD_HORN_CORAL, Items.HORN_CORAL, 50);
        dryingRecipe(recipeConsumer, Items.DEAD_TUBE_CORAL, Items.TUBE_CORAL, 50);
        dryingRecipe(recipeConsumer, Items.DEAD_BRAIN_CORAL_FAN, Items.BRAIN_CORAL_FAN, 50);
        dryingRecipe(recipeConsumer, Items.DEAD_BUBBLE_CORAL_FAN, Items.BUBBLE_CORAL_FAN, 50);
        dryingRecipe(recipeConsumer, Items.DEAD_FIRE_CORAL_FAN, Items.FIRE_CORAL_FAN, 50);
        dryingRecipe(recipeConsumer, Items.DEAD_HORN_CORAL_FAN, Items.HORN_CORAL_FAN, 50);
        dryingRecipe(recipeConsumer, Items.DEAD_TUBE_CORAL_FAN, Items.TUBE_CORAL_FAN, 50);
        dryingRecipe(recipeConsumer, Items.SPONGE, Items.WET_SPONGE, 40 * 20);
        dryingRecipe(recipeConsumer, Items.SLIME_BALL, Items.HONEY_BOTTLE, 16 * 20);
        dryingRecipe(recipeConsumer, Items.LEATHER, Items.ROTTEN_FLESH, 200, getConversionByDryingRecipeName(Items.LEATHER, Items.ROTTEN_FLESH));
        dryingRecipe(recipeConsumer, Items.LEATHER, Items.COOKED_BEEF, 200, getConversionByDryingRecipeName(Items.LEATHER, Items.COOKED_BEEF));
        dryingRecipe(recipeConsumer, Items.LEATHER, Items.COOKED_PORKCHOP, 200, getConversionByDryingRecipeName(Items.LEATHER, Items.COOKED_PORKCHOP));
        dryingRecipe(recipeConsumer, Items.LEATHER, Items.COOKED_MUTTON, 200, getConversionByDryingRecipeName(Items.LEATHER, Items.COOKED_MUTTON));
    }

    protected void dryingRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, ItemLike input, int dryingTime) {
        dryingRecipe(recipeConsumer, result, input, dryingTime, null);
    }

    protected void dryingRecipe(Consumer<FinishedRecipe> recipeConsumer, ItemLike result, ItemLike input, int dryingTime, @Nullable String recipeName) {
        DryingRecipeBuilder.drying(result, dryingTime).from(input).save(recipeConsumer, recipeName != null ? recipeName : getDryingRecipeName(result));
    }

    protected void oakFlagFromWool(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, ItemLike wool) {
        ShapedRecipeBuilder
                .shaped(output)
                .define('B', Blocks.OAK_SLAB)
                .define('P', Tags.Items.RODS_WOODEN)
                .define('W', wool)
                .group("oak_flag")
                .pattern("PW")
                .pattern("P ")
                .pattern("B ")
                .unlockedBy(getHasName(wool), has(wool))
                .save(recipeConsumer);
    }

    protected void coloredOakFlagFromWhiteFlagAndDye(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, TagKey<Item> dye) {
        ShapelessRecipeBuilder
                .shapeless(output)
                .requires(ModBlocks.WHITE_OAK_FLAG.get())
                .requires(dye)
                .group("dyed_oak_flag")
                .unlockedBy(getHasName(ModBlocks.WHITE_OAK_FLAG.get()), has(ModBlocks.WHITE_OAK_FLAG.get()))
                .save(recipeConsumer, getConversionRecipeModLoc(output, ModBlocks.WHITE_OAK_FLAG.get()));
    }

    protected void hammerTool(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, TagKey<Item> material, @Nullable ItemLike unlockMaterial) {
        var builder = ShapedRecipeBuilder
                .shaped(output)
                .define('S', Tags.Items.RODS_WOODEN)
                .define('#', material)
                .pattern("###")
                .pattern("#S#")
                .pattern(" S ");

        if (unlockMaterial != null) {
            builder.unlockedBy(getHasName(unlockMaterial), has(unlockMaterial));
        }
        else {
            builder.unlockedBy("has_" + material.location().getPath(), has(material));
        }

        builder.save(recipeConsumer);
    }

    protected void conditionalHammerTool(Consumer<FinishedRecipe> recipeConsumer, RegistryObject<ExcavatorTool> output, TagKey<Item> material, ICondition condition) {
        var outLoc = output.getId();
        ConditionalRecipe.builder()
                .addCondition(condition)
                .addRecipe(
                        ShapedRecipeBuilder
                                .shaped(output.get())
                                .define('S', Tags.Items.RODS_WOODEN)
                                .define('#', material)
                                .pattern("###")
                                .pattern("#S#")
                                .pattern(" S ")
                                .unlockedBy("has_" + material.location().getPath(), has(material))
                        ::save
                )
                .generateAdvancement(new ResourceLocation(outLoc.getNamespace(), "recipes/unrelatedadditions/" + outLoc.getPath()))
                .build(recipeConsumer, new ResourceLocation(UnrelatedAdditions.MODID, outLoc.getPath()));
    }

    protected void spadeTool(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, TagKey<Item> material, @Nullable ItemLike unlockMaterial) {
        var builder = ShapedRecipeBuilder
                .shaped(output)
                .define('S', Tags.Items.RODS_WOODEN)
                .define('#', material)
                .pattern(" S ")
                .pattern("#S#")
                .pattern("###");

        if (unlockMaterial != null) {
            builder.unlockedBy(getHasName(unlockMaterial), has(unlockMaterial));
        }
        else {
            builder.unlockedBy("has_" + material.location().getPath(), has(material));
        }

        builder.save(recipeConsumer);
    }

    protected void conditionalSpadeTool(Consumer<FinishedRecipe> recipeConsumer, RegistryObject<ExcavatorTool> output, TagKey<Item> material, ICondition condition) {
        var outLoc = output.getId();
        ConditionalRecipe.builder()
                .addCondition(condition)
                .addRecipe(
                        ShapedRecipeBuilder
                                .shaped(output.get())
                                .define('S', Tags.Items.RODS_WOODEN)
                                .define('#', material)
                                .pattern(" S ")
                                .pattern("#S#")
                                .pattern("###")
                                .unlockedBy("has_" + material.location().getPath(), has(material))
                                ::save
                )
                .generateAdvancement(new ResourceLocation(outLoc.getNamespace(), "recipes/unrelatedadditions/" + outLoc.getPath()))
                .build(recipeConsumer, new ResourceLocation(UnrelatedAdditions.MODID, outLoc.getPath()));
    }

    protected void compressedBlocks(Consumer<FinishedRecipe> recipeConsumer, ItemLike baseItemLike, ItemLike... compressionChain) {
        ItemLike previousStage = baseItemLike;

        for (ItemLike currentStage: compressionChain) {
            ShapelessRecipeBuilder
                    .shapeless(previousStage, 9)
                    .requires(currentStage)
                    .group("decompression")
                    .unlockedBy(getHasName(currentStage), has(currentStage))
                    .save(recipeConsumer, getConversionRecipeModLoc(previousStage, currentStage));

            ShapedRecipeBuilder
                    .shaped(currentStage)
                    .define('#', previousStage)
                    .pattern("###")
                    .pattern("###")
                    .pattern("###")
                    .group("compression")
                    .unlockedBy(getHasName(previousStage), has(MinMaxBounds.Ints.atLeast(9), previousStage))
                    .save(recipeConsumer);

            previousStage = currentStage;
        }
    }

    protected ResourceLocation getConversionRecipeModLoc(ItemLike result, ItemLike source) {
        return new ResourceLocation(UnrelatedAdditions.MODID, getConversionRecipeName(result, source));
    }

    protected static String getConversionByDryingRecipeName(ItemLike pResult, ItemLike pIngredient) {
        return getItemName(pResult) + "_from_drying_" + getItemName(pIngredient);
    }

    private String getDryingRecipeName(ItemLike pItemLike) {
        return getItemName(pItemLike) + "_from_drying";
    }
}
