package me.siasur.unrelatedadditions.datagen;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.item.ModItems;
import me.siasur.unrelatedadditions.utils.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, UnrelatedAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(ModTags.Items.MAGNET_BLACKLIST).add(ModItems.MAGNET.get());
        this.tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(ModItems.WOODEN_HAMMER.get()).add(ModItems.STONE_HAMMER.get()).add(ModItems.IRON_HAMMER.get()).add(ModItems.GOLDEN_HAMMER.get()).add(ModItems.DIAMOND_HAMMER.get());
        this.tag(ItemTags.COALS).add(ModItems.TINY_COAL.get()).add(ModItems.TINY_CHARCOAL.get());

        this.copy(ModTags.Blocks.OAK_FLAGS, ModTags.Items.OAK_FLAGS);
        this.copy(ModTags.Blocks.FLAGS, ModTags.Items.FLAGS);
    }
}
