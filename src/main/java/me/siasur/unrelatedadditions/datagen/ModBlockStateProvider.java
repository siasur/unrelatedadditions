package me.siasur.unrelatedadditions.datagen;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.block.FlagPoleBlock;
import me.siasur.unrelatedadditions.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

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

        logBlock(ModBlocks.ANGEL_BLOCK.get());

        ResourceLocation oakPoleLoc = new ResourceLocation(UnrelatedAdditions.MODID, "block/oak_flagpole");
        flagPoleBlock(ModBlocks.WHITE_OAK_FLAG     .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.WHITE_WOOL).getPath()));
        flagPoleBlock(ModBlocks.ORANGE_OAK_FLAG    .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.ORANGE_WOOL).getPath()));
        flagPoleBlock(ModBlocks.MAGENTA_OAK_FLAG   .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.MAGENTA_WOOL).getPath()));
        flagPoleBlock(ModBlocks.LIGHT_BLUE_OAK_FLAG.get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.LIGHT_BLUE_WOOL).getPath()));
        flagPoleBlock(ModBlocks.YELLOW_OAK_FLAG    .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.YELLOW_WOOL).getPath()));
        flagPoleBlock(ModBlocks.LIME_OAK_FLAG      .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.LIME_WOOL).getPath()));
        flagPoleBlock(ModBlocks.PINK_OAK_FLAG      .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.PINK_WOOL).getPath()));
        flagPoleBlock(ModBlocks.GRAY_OAK_FLAG      .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.GRAY_WOOL).getPath()));
        flagPoleBlock(ModBlocks.LIGHT_GRAY_OAK_FLAG.get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.LIGHT_GRAY_WOOL).getPath()));
        flagPoleBlock(ModBlocks.CYAN_OAK_FLAG      .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.CYAN_WOOL).getPath()));
        flagPoleBlock(ModBlocks.PURPLE_OAK_FLAG    .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.PURPLE_WOOL).getPath()));
        flagPoleBlock(ModBlocks.BLUE_OAK_FLAG      .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.BLUE_WOOL).getPath()));
        flagPoleBlock(ModBlocks.BROWN_OAK_FLAG     .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.BROWN_WOOL).getPath()));
        flagPoleBlock(ModBlocks.GREEN_OAK_FLAG     .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.GREEN_WOOL).getPath()));
        flagPoleBlock(ModBlocks.RED_OAK_FLAG       .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.RED_WOOL).getPath()));
        flagPoleBlock(ModBlocks.BLACK_OAK_FLAG     .get(), oakPoleLoc, new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.BLACK_WOOL).getPath()));

        horizontalBlock(ModBlocks.ROPE_LADDER.get(), models().withExistingParent(ModBlocks.ROPE_LADDER.getKey().location().getPath(),mcLoc("block/ladder"))
                .texture("texture", modLoc("block/rope_ladder"))
                .renderType(mcLoc("cutout"))
        );

        simpleBlock(ModBlocks.XP_DRAIN.get(), models().getExistingFile(modLoc("block/xp_drain")));

    }

    protected void flagPoleBlock(FlagPoleBlock block, ResourceLocation poleTexture, ResourceLocation flagTexture) {
        ResourceLocation blockLoc = ForgeRegistries.BLOCKS.getKey(block);
        ModelFile flagPoleModelFile = models().withExistingParent(blockLoc.toString(), new ResourceLocation(UnrelatedAdditions.MODID, "block/flag_pole"))
                .texture("pole", poleTexture)
                .texture("flag", flagTexture);

        horizontalBlock(block, flagPoleModelFile);
    }
}
