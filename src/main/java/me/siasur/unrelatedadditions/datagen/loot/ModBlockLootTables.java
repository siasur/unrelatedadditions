package me.siasur.unrelatedadditions.datagen.loot;

import me.siasur.unrelatedadditions.block.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.COMPRESSED_COBBLESTONE.get());
        this.dropSelf(ModBlocks.DOUBLE_COMPRESSED_COBBLESTONE.get());
        this.dropSelf(ModBlocks.TRIPLE_COMPRESSED_COBBLESTONE.get());
        this.dropSelf(ModBlocks.QUADRUPLE_COMPRESSED_COBBLESTONE.get());
        this.dropSelf(ModBlocks.QUINTUPLE_COMPRESSED_COBBLESTONE.get());
        this.dropSelf(ModBlocks.SEXTUPLE_COMPRESSED_COBBLESTONE.get());

        this.dropSelf(ModBlocks.COMPRESSED_COBBLED_DEEPSLATE.get());
        this.dropSelf(ModBlocks.DOUBLE_COMPRESSED_COBBLED_DEEPSLATE.get());
        this.dropSelf(ModBlocks.TRIPLE_COMPRESSED_COBBLED_DEEPSLATE.get());
        this.dropSelf(ModBlocks.QUADRUPLE_COMPRESSED_COBBLED_DEEPSLATE.get());
        this.dropSelf(ModBlocks.QUINTUPLE_COMPRESSED_COBBLED_DEEPSLATE.get());
        this.dropSelf(ModBlocks.SEXTUPLE_COMPRESSED_COBBLED_DEEPSLATE.get());

        this.dropSelf(ModBlocks.COMPRESSED_SAND.get());
        this.dropSelf(ModBlocks.DOUBLE_COMPRESSED_SAND.get());
        this.dropSelf(ModBlocks.TRIPLE_COMPRESSED_SAND.get());

        this.dropSelf(ModBlocks.COMPRESSED_RED_SAND.get());
        this.dropSelf(ModBlocks.DOUBLE_COMPRESSED_RED_SAND.get());
        this.dropSelf(ModBlocks.TRIPLE_COMPRESSED_RED_SAND.get());

        this.dropSelf(ModBlocks.COMPRESSED_DIRT.get());
        this.dropSelf(ModBlocks.DOUBLE_COMPRESSED_DIRT.get());
        this.dropSelf(ModBlocks.TRIPLE_COMPRESSED_DIRT.get());

        this.dropSelf(ModBlocks.COMPRESSED_GRAVEL.get());
        this.dropSelf(ModBlocks.DOUBLE_COMPRESSED_GRAVEL.get());

        this.dropSelf(ModBlocks.COMPRESSED_GRANITE.get());

        this.dropSelf(ModBlocks.COMPRESSED_ANDESITE.get());

        this.dropSelf(ModBlocks.COMPRESSED_DIORITE.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
