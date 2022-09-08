package me.siasur.unrelatedadditions.utils;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    private static String MODID = UnrelatedAdditions.MODID;

    public class Blocks {

        public static final TagKey<Block> MINEABLE_WITH_HAMMER = BlockTags.create(new ResourceLocation(MODID, "mineable/hammer"));

        public static final TagKey<Block> FLAGS = BlockTags.create(new ResourceLocation(MODID, "flags"));
        public static final TagKey<Block> OAK_FLAGS = BlockTags.create(new ResourceLocation(MODID, "flags/oak"));

    }

    public class Items {

        public static final TagKey<Item> MAGNET_BLACKLIST = ItemTags.create(new ResourceLocation("forge", "magnet_blacklist"));

        public static final TagKey<Item> FLAGS = ItemTags.create(new ResourceLocation(MODID, "flags"));
        public static final TagKey<Item> OAK_FLAGS = ItemTags.create(new ResourceLocation(MODID, "flags/oak"));

    }

}
