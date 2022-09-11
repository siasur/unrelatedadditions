package me.siasur.unrelatedadditions.datagen;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.block.ModBlocks;
import me.siasur.unrelatedadditions.utils.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, UnrelatedAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COMPRESSED_COBBLESTONE.get())
                .add(ModBlocks.DOUBLE_COMPRESSED_COBBLESTONE.get())
                .add(ModBlocks.TRIPLE_COMPRESSED_COBBLESTONE.get())
                .add(ModBlocks.QUADRUPLE_COMPRESSED_COBBLESTONE.get())
                .add(ModBlocks.QUINTUPLE_COMPRESSED_COBBLESTONE.get())
                .add(ModBlocks.SEXTUPLE_COMPRESSED_COBBLESTONE.get())
                .add(ModBlocks.COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(ModBlocks.DOUBLE_COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(ModBlocks.TRIPLE_COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(ModBlocks.QUADRUPLE_COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(ModBlocks.QUINTUPLE_COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(ModBlocks.SEXTUPLE_COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(ModBlocks.COMPRESSED_SAND.get())
                .add(ModBlocks.DOUBLE_COMPRESSED_SAND.get())
                .add(ModBlocks.TRIPLE_COMPRESSED_SAND.get())
                .add(ModBlocks.COMPRESSED_RED_SAND.get())
                .add(ModBlocks.DOUBLE_COMPRESSED_RED_SAND.get())
                .add(ModBlocks.TRIPLE_COMPRESSED_RED_SAND.get())
                .add(ModBlocks.COMPRESSED_DIRT.get())
                .add(ModBlocks.DOUBLE_COMPRESSED_DIRT.get())
                .add(ModBlocks.TRIPLE_COMPRESSED_DIRT.get())
                .add(ModBlocks.COMPRESSED_GRAVEL.get())
                .add(ModBlocks.DOUBLE_COMPRESSED_GRAVEL.get())
                .add(ModBlocks.COMPRESSED_GRANITE.get())
                .add(ModBlocks.COMPRESSED_ANDESITE.get())
                .add(ModBlocks.COMPRESSED_DIORITE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(ModTags.Blocks.OAK_FLAGS);

        this.tag(ModTags.Blocks.MINEABLE_WITH_HAMMER).addTag(BlockTags.MINEABLE_WITH_PICKAXE).add(Blocks.GLOWSTONE);

        this.tag(ModTags.Blocks.MINEABLE_WITH_SPADE).addTag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(ModTags.Blocks.OAK_FLAGS)
                .add(ModBlocks.WHITE_OAK_FLAG.get())
                .add(ModBlocks.ORANGE_OAK_FLAG.get())
                .add(ModBlocks.MAGENTA_OAK_FLAG.get())
                .add(ModBlocks.LIGHT_BLUE_OAK_FLAG.get())
                .add(ModBlocks.YELLOW_OAK_FLAG.get())
                .add(ModBlocks.LIME_OAK_FLAG.get())
                .add(ModBlocks.PINK_OAK_FLAG.get())
                .add(ModBlocks.GRAY_OAK_FLAG.get())
                .add(ModBlocks.LIGHT_GRAY_OAK_FLAG.get())
                .add(ModBlocks.CYAN_OAK_FLAG.get())
                .add(ModBlocks.PURPLE_OAK_FLAG.get())
                .add(ModBlocks.BLUE_OAK_FLAG.get())
                .add(ModBlocks.BROWN_OAK_FLAG.get())
                .add(ModBlocks.GREEN_OAK_FLAG.get())
                .add(ModBlocks.RED_OAK_FLAG.get())
                .add(ModBlocks.BLACK_OAK_FLAG.get());

        this.tag(ModTags.Blocks.FLAGS).addTag(ModTags.Blocks.OAK_FLAGS);

        this.tag(BlockTags.CLIMBABLE).add(ModBlocks.ROPE_LADDER.get());
    }
}