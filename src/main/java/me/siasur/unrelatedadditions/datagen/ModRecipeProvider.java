package me.siasur.unrelatedadditions.datagen;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.block.ModBlocks;
import me.siasur.unrelatedadditions.item.ModItems;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
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
        hammerTool(recipeConsumer, ModItems.GOLDEN_HAMMER.get(), Tags.Items.INGOTS_GOLD, Items.GOLD_INGOT);
        hammerTool(recipeConsumer, ModItems.DIAMOND_HAMMER.get(), Tags.Items.GEMS_DIAMOND, Items.DIAMOND);

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
    }

    protected void hammerTool(Consumer<FinishedRecipe> recipeConsumer, ItemLike output, TagKey<Item> material, ItemLike unlockMaterial) {
        ShapedRecipeBuilder
                .shaped(output)
                .define('S', Tags.Items.RODS_WOODEN)
                .define('#', material)
                .pattern("###")
                .pattern("#S#")
                .pattern(" S ")
                .unlockedBy(getHasName(unlockMaterial), has(unlockMaterial))
                .save(recipeConsumer);
    }

    protected void compressedBlocks(Consumer<FinishedRecipe> recipeConsumer, ItemLike baseItemLike, ItemLike... compressionChain) {
        ItemLike previousStage = baseItemLike;

        for (ItemLike currentStage: compressionChain) {
            ShapelessRecipeBuilder
                    .shapeless(previousStage, 9)
                    .requires(currentStage)
                    .group("decompression")
                    .unlockedBy(getHasName(currentStage), has(currentStage))
                    .save(recipeConsumer, new ResourceLocation(UnrelatedAdditions.MODID, getConversionRecipeName(previousStage, currentStage)));

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
}
