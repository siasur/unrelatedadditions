package me.siasur.unrelatedadditions.block;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.inventory.ModCreativeModeTab;
import me.siasur.unrelatedadditions.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UnrelatedAdditions.MODID);
    private static final String COMPRESSION_TOOLTIP_KEY = "tooltip.unrelatedadditions.compressedblock";

    public static RegistryObject<Block> COMPRESSED_COBBLESTONE = registerBlock("compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(9));
    public static RegistryObject<Block> DOUBLE_COMPRESSED_COBBLESTONE = registerBlock("double_compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(81));
    public static RegistryObject<Block> TRIPLE_COMPRESSED_COBBLESTONE = registerBlock("triple_compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(729));
    public static RegistryObject<Block> QUADRUPLE_COMPRESSED_COBBLESTONE = registerBlock("quadruple_compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(6561));
    public static RegistryObject<Block> QUINTUPLE_COMPRESSED_COBBLESTONE = registerBlock("quintuple_compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(59049));
    public static RegistryObject<Block> SEXTUPLE_COMPRESSED_COBBLESTONE = registerBlock("sextuple_compressed_cobblestone", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(531441));
    public static RegistryObject<Block> COMPRESSED_COBBLED_DEEPSLATE = registerBlock("compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(9));
    public static RegistryObject<Block> DOUBLE_COMPRESSED_COBBLED_DEEPSLATE = registerBlock("double_compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(81));
    public static RegistryObject<Block> TRIPLE_COMPRESSED_COBBLED_DEEPSLATE = registerBlock("triple_compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(729));
    public static RegistryObject<Block> QUADRUPLE_COMPRESSED_COBBLED_DEEPSLATE = registerBlock("quadruple_compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(6561));
    public static RegistryObject<Block> QUINTUPLE_COMPRESSED_COBBLED_DEEPSLATE = registerBlock("quintuple_compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(59049));
    public static RegistryObject<Block> SEXTUPLE_COMPRESSED_COBBLED_DEEPSLATE = registerBlock("sextuple_compressed_cobbled_deepslate", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(531441));
    public static RegistryObject<Block> COMPRESSED_DIRT = registerBlock("compressed_dirt", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(9));
    public static RegistryObject<Block> DOUBLE_COMPRESSED_DIRT = registerBlock("double_compressed_dirt", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(81));
    public static RegistryObject<Block> TRIPLE_COMPRESSED_DIRT = registerBlock("triple_compressed_dirt", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(729));
    public static RegistryObject<Block> COMPRESSED_SAND = registerBlock("compressed_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(9));
    public static RegistryObject<Block> DOUBLE_COMPRESSED_SAND = registerBlock("double_compressed_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(81));
    public static RegistryObject<Block> TRIPLE_COMPRESSED_SAND = registerBlock("triple_compressed_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(729));
    public static RegistryObject<Block> COMPRESSED_RED_SAND = registerBlock("compressed_red_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RED_SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(9));
    public static RegistryObject<Block> DOUBLE_COMPRESSED_RED_SAND = registerBlock("double_compressed_red_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RED_SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(81));
    public static RegistryObject<Block> TRIPLE_COMPRESSED_RED_SAND = registerBlock("triple_compressed_red_sand", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.RED_SAND)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(729));
    public static RegistryObject<Block> COMPRESSED_GRAVEL = registerBlock("compressed_gravel", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.GRAVEL)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(9));
    public static RegistryObject<Block> DOUBLE_COMPRESSED_GRAVEL = registerBlock("double_compressed_gravel", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.GRAVEL)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(81));
    public static RegistryObject<Block> COMPRESSED_ANDESITE = registerBlock("compressed_andesite", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(9));
    public static RegistryObject<Block> COMPRESSED_DIORITE = registerBlock("compressed_diorite", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DIORITE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(9));
    public static RegistryObject<Block> COMPRESSED_GRANITE = registerBlock("compressed_granite", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.GRANITE)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS, getCompressionTooltip(9));

    public static RegistryObject<AngelBlock> ANGEL_BLOCK = BLOCKS.register("angel_block", () -> new AngelBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).instabreak().lightLevel((state) -> 8)));

    public static RegistryObject<FlagPoleBlock> WHITE_OAK_FLAG      = registerBlock("white_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)       .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> ORANGE_OAK_FLAG     = registerBlock("orange_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)      .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> MAGENTA_OAK_FLAG    = registerBlock("magenta_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)     .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> LIGHT_BLUE_OAK_FLAG = registerBlock("light_blue_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)  .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> YELLOW_OAK_FLAG     = registerBlock("yellow_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)      .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> LIME_OAK_FLAG       = registerBlock("lime_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)        .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> PINK_OAK_FLAG       = registerBlock("pink_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)        .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> GRAY_OAK_FLAG       = registerBlock("gray_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)        .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> LIGHT_GRAY_OAK_FLAG = registerBlock("light_gray_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)  .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> CYAN_OAK_FLAG       = registerBlock("cyan_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)        .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> PURPLE_OAK_FLAG     = registerBlock("purple_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)      .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> BLUE_OAK_FLAG       = registerBlock("blue_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)        .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> BROWN_OAK_FLAG      = registerBlock("brown_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)       .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> GREEN_OAK_FLAG      = registerBlock("green_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)       .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> RED_OAK_FLAG        = registerBlock("red_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)         .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);
    public static RegistryObject<FlagPoleBlock> BLACK_OAK_FLAG      = registerBlock("black_oak_flag", () -> new FlagPoleBlock(BlockBehaviour.Properties.of(Material.WOOD)       .lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 4 : 0).noOcclusion().strength(.75f).sound(SoundType.WOOD)), ModCreativeModeTab.TAB_UNRELATEDADDITIONS);

    public static RegistryObject<RopeLadderBlock> ROPE_LADDER_BLOCK = BLOCKS.register("rope_ladder_block", () -> new RopeLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(0.4F).sound(SoundType.LADDER).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier, CreativeModeTab tab) {
        return registerBlock(name, blockSupplier, tab, null);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier, CreativeModeTab tab, @Nullable Component toolTip) {
        RegistryObject<T> block = BLOCKS.register(name, blockSupplier);
        if (toolTip == null) {
            registerBlockItem(name, block, tab);
        } else {
            registerBlockItemWithTooltip(name, block, tab, toolTip);
        }

        return block;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItemWithTooltip(String name, RegistryObject<T> block, CreativeModeTab tab, Component toolTip) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack p_40572_, @org.jetbrains.annotations.Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
                p_40574_.add(toolTip);
                super.appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
            }
        });
    }

    private static Component getCompressionTooltip(int amount) {
        return Component.translatable(COMPRESSION_TOOLTIP_KEY, amount);
    }

    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}
