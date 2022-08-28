package me.siasur.unrelatedadditions.block;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.inventory.ModCreativeModeTab;
import me.siasur.unrelatedadditions.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UnrelatedAdditions.MODID);

    public static RegistryObject<Block> COMPRESSED_ANDESITE = registerBlock("compressed_andesite", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> COMPRESSED_COBBLED_DEEPSLATE = registerBlock("compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> COMPRESSED_COBBLESTONE = registerBlock("compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> COMPRESSED_DIORITE = registerBlock("compressed_diorite", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DIORITE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> COMPRESSED_DIRT = registerBlock("compressed_dirt", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> COMPRESSED_GRANITE = registerBlock("compressed_granite", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.GRANITE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> COMPRESSED_GRAVEL = registerBlock("compressed_gravel", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.GRAVEL)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> COMPRESSED_RED_SAND = registerBlock("compressed_red_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RED_SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> COMPRESSED_SAND = registerBlock("compressed_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> DOUBLE_COMPRESSED_COBBLED_DEEPSLATE = registerBlock("double_compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> DOUBLE_COMPRESSED_COBBLESTONE = registerBlock("double_compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> DOUBLE_COMPRESSED_DIRT = registerBlock("double_compressed_dirt", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> DOUBLE_COMPRESSED_GRAVEL = registerBlock("double_compressed_gravel", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.GRAVEL)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> DOUBLE_COMPRESSED_RED_SAND = registerBlock("double_compressed_red_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RED_SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> DOUBLE_COMPRESSED_SAND = registerBlock("double_compressed_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> QUADRUPLE_COMPRESSED_COBBLED_DEEPSLATE = registerBlock("quadruple_compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> QUADRUPLE_COMPRESSED_COBBLESTONE = registerBlock("quadruple_compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> QUINTUPLE_COMPRESSED_COBBLED_DEEPSLATE = registerBlock("quintuple_compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> QUINTUPLE_COMPRESSED_COBBLESTONE = registerBlock("quintuple_compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> SEXTUPLE_COMPRESSED_COBBLED_DEEPSLATE = registerBlock("sextuple_compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> SEXTUPLE_COMPRESSED_COBBLESTONE = registerBlock("sextuple_compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> TRIPLE_COMPRESSED_COBBLED_DEEPSLATE = registerBlock("triple_compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> TRIPLE_COMPRESSED_COBBLESTONE = registerBlock("triple_compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> TRIPLE_COMPRESSED_DIRT = registerBlock("triple_compressed_dirt", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> TRIPLE_COMPRESSED_RED_SAND = registerBlock("triple_compressed_red_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RED_SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<Block> TRIPLE_COMPRESSED_SAND = registerBlock("triple_compressed_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier, CreativeModeTab tab) {
        RegistryObject<T> block = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, block, tab);

        return block;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}