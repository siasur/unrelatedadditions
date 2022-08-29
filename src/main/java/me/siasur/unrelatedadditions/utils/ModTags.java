package me.siasur.unrelatedadditions.utils;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public class Blocks {

        public static final TagKey<Block> MINEABLE_WITH_HAMMER = BlockTags.create(new ResourceLocation(UnrelatedAdditions.MODID, "mineable/hammer"));

    }

}
