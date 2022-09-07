package me.siasur.unrelatedadditions.datagen;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, UnrelatedAdditions.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.COMPRESSED_COBBLESTONE.get());
        simpleBlock(ModBlocks.DOUBLE_COMPRESSED_COBBLESTONE.get());
        simpleBlock(ModBlocks.TRIPLE_COMPRESSED_COBBLESTONE.get());
        simpleBlock(ModBlocks.QUADRUPLE_COMPRESSED_COBBLESTONE.get());
        simpleBlock(ModBlocks.QUINTUPLE_COMPRESSED_COBBLESTONE.get());
        simpleBlock(ModBlocks.SEXTUPLE_COMPRESSED_COBBLESTONE.get());
        simpleBlock(ModBlocks.COMPRESSED_COBBLED_DEEPSLATE.get());
        simpleBlock(ModBlocks.DOUBLE_COMPRESSED_COBBLED_DEEPSLATE.get());
        simpleBlock(ModBlocks.TRIPLE_COMPRESSED_COBBLED_DEEPSLATE.get());
        simpleBlock(ModBlocks.QUADRUPLE_COMPRESSED_COBBLED_DEEPSLATE.get());
        simpleBlock(ModBlocks.QUINTUPLE_COMPRESSED_COBBLED_DEEPSLATE.get());
        simpleBlock(ModBlocks.SEXTUPLE_COMPRESSED_COBBLED_DEEPSLATE.get());
        simpleBlock(ModBlocks.COMPRESSED_SAND.get());
        simpleBlock(ModBlocks.DOUBLE_COMPRESSED_SAND.get());
        simpleBlock(ModBlocks.TRIPLE_COMPRESSED_SAND.get());
        simpleBlock(ModBlocks.COMPRESSED_RED_SAND.get());
        simpleBlock(ModBlocks.DOUBLE_COMPRESSED_RED_SAND.get());
        simpleBlock(ModBlocks.TRIPLE_COMPRESSED_RED_SAND.get());
        simpleBlock(ModBlocks.COMPRESSED_DIRT.get());
        simpleBlock(ModBlocks.DOUBLE_COMPRESSED_DIRT.get());
        simpleBlock(ModBlocks.TRIPLE_COMPRESSED_DIRT.get());
        simpleBlock(ModBlocks.COMPRESSED_GRAVEL.get());
        simpleBlock(ModBlocks.DOUBLE_COMPRESSED_GRAVEL.get());
        simpleBlock(ModBlocks.COMPRESSED_GRANITE.get());
        simpleBlock(ModBlocks.COMPRESSED_ANDESITE.get());
        simpleBlock(ModBlocks.COMPRESSED_DIORITE.get());
    }
}
