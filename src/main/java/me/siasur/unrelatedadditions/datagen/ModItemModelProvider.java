package me.siasur.unrelatedadditions.datagen;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, UnrelatedAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerAllBlockItemModels();

        simpleItem(ModItems.TINY_COAL.get());
        simpleItem(ModItems.TINY_CHARCOAL.get());

        handheldItem(ModItems.WOODEN_HAMMER.get());
        handheldItem(ModItems.STONE_HAMMER.get());
        handheldItem(ModItems.IRON_HAMMER.get());
        handheldItem(ModItems.BRONZE_HAMMER.get());
        handheldItem(ModItems.GOLDEN_HAMMER.get());
        handheldItem(ModItems.DIAMOND_HAMMER.get());

        simpleItem(ModItems.MAGNET.get());
    }

    private void registerAllBlockItemModels() {
        ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).filter(item -> item instanceof BlockItem).forEach(item -> blockItem(item));
    }

    protected ItemModelBuilder handheldItem(Item item) {
        return handheldItem(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)));
    }

    protected ItemModelBuilder simpleItem(Item item) {
        return simpleItem(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)));
    }

    protected ItemModelBuilder blockItem(Item blockItem) {
        return blockItem(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(blockItem)));
    }

    protected ItemModelBuilder blockItem(ResourceLocation item) {
        return withExistingParent(item.toString(), new ResourceLocation(item.getNamespace(), "block/" + item.getPath()));
    }

    protected ItemModelBuilder handheldItem(ResourceLocation item)
    {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()));
    }

    protected ItemModelBuilder simpleItem(ResourceLocation item)
    {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()));
    }

}
