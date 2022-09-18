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

        this.add(ModBlocks.ANGEL_BLOCK.get(), noDrop()); // Handled in code due to special "pickup"

        this.dropSelf(ModBlocks.WHITE_OAK_FLAG     .get());
        this.dropSelf(ModBlocks.ORANGE_OAK_FLAG    .get());
        this.dropSelf(ModBlocks.MAGENTA_OAK_FLAG   .get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_OAK_FLAG.get());
        this.dropSelf(ModBlocks.YELLOW_OAK_FLAG    .get());
        this.dropSelf(ModBlocks.LIME_OAK_FLAG      .get());
        this.dropSelf(ModBlocks.PINK_OAK_FLAG      .get());
        this.dropSelf(ModBlocks.GRAY_OAK_FLAG      .get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_OAK_FLAG.get());
        this.dropSelf(ModBlocks.CYAN_OAK_FLAG      .get());
        this.dropSelf(ModBlocks.PURPLE_OAK_FLAG    .get());
        this.dropSelf(ModBlocks.BLUE_OAK_FLAG      .get());
        this.dropSelf(ModBlocks.BROWN_OAK_FLAG     .get());
        this.dropSelf(ModBlocks.GREEN_OAK_FLAG     .get());
        this.dropSelf(ModBlocks.RED_OAK_FLAG       .get());
        this.dropSelf(ModBlocks.BLACK_OAK_FLAG     .get());

        this.dropSelf(ModBlocks.ROPE_LADDER.get());

        this.dropSelf(ModBlocks.XP_DRAIN.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
