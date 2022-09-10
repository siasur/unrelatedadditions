package me.siasur.unrelatedadditions.utils;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public class Blocks {

        public static final TagKey<Block> MINEABLE_WITH_HAMMER = tag("mineable/hammer");
        public static final TagKey<Block> FLAGS = tag("flags");
        public static final TagKey<Block> OAK_FLAGS = tag("flags/oak");
        public static final TagKey<Block> NEEDS_BRONZE_TOOL = forgeTag("needs_bronze_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(UnrelatedAdditions.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name)
        {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public class Items {

        public static final TagKey<Item> MAGNET_BLACKLIST = forgeTag("magnet_blacklist");
        public static final TagKey<Item> FLAGS = tag("flags");
        public static final TagKey<Item> OAK_FLAGS = tag("flags/oak");
        public static final TagKey<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(UnrelatedAdditions.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name)
        {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

}
