package me.siasur.unrelatedadditions.item;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.block.ModBlocks;
import me.siasur.unrelatedadditions.config.UnrelatedAdditionsCommonConfig;
import me.siasur.unrelatedadditions.fluid.ModFluids;
import me.siasur.unrelatedadditions.inventory.ModCreativeModeTab;
import me.siasur.unrelatedadditions.utils.ModTags;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UnrelatedAdditions.MODID);

    public static final RegistryObject<Item> TINY_COAL = ITEMS.register("tiny_coal",
            () -> new FuelItem(new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_UNRELATEDADDITIONS),
                    FuelItem.DEFAULT_COAL_BURN_TIME / FuelItem.TINY_COAL_DIVISOR
            ));

    public static final RegistryObject<Item> TINY_CHARCOAL = ITEMS.register("tiny_charcoal",
            () -> new FuelItem(new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_UNRELATEDADDITIONS),
                    FuelItem.DEFAULT_COAL_BURN_TIME / FuelItem.TINY_COAL_DIVISOR
            ));

    public static final RegistryObject<ExcavatorTool> WOODEN_HAMMER = registerHammer("wooden_hammer", Tiers.WOOD,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );
    public static final RegistryObject<ExcavatorTool> STONE_HAMMER = registerHammer("stone_hammer", Tiers.STONE,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );
    public static final RegistryObject<ExcavatorTool> IRON_HAMMER = registerHammer("iron_hammer", Tiers.IRON,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );
    public static final RegistryObject<ExcavatorTool> BRONZE_HAMMER = registerHammer("bronze_hammer", CustomTiers.BRONZE,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );
    public static final RegistryObject<ExcavatorTool> GOLDEN_HAMMER = registerHammer("golden_hammer", Tiers.GOLD,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );
    public static final RegistryObject<ExcavatorTool> DIAMOND_HAMMER = registerHammer("diamond_hammer", Tiers.DIAMOND,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );

    public static final RegistryObject<ExcavatorTool> WOODEN_SPADE = registerSpade("wooden_spade", Tiers.WOOD,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );
    public static final RegistryObject<ExcavatorTool> STONE_SPADE = registerSpade("stone_spade", Tiers.STONE,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );
    public static final RegistryObject<ExcavatorTool> IRON_SPADE = registerSpade("iron_spade", Tiers.IRON,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );
    public static final RegistryObject<ExcavatorTool> BRONZE_SPADE = registerSpade("bronze_spade", CustomTiers.BRONZE,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );
    public static final RegistryObject<ExcavatorTool> GOLDEN_SPADE = registerSpade("golden_spade", Tiers.GOLD,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );
    public static final RegistryObject<ExcavatorTool> DIAMOND_SPADE = registerSpade("diamond_spade", Tiers.DIAMOND,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );

    public static final RegistryObject<MagnetItem> MAGNET = ITEMS.register("magnet",
            () -> new MagnetItem(new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_UNRELATEDADDITIONS)
                    .stacksTo(1)
            ));

    public static final RegistryObject<AngelBlockItem> ANGEL_BLOCK = ITEMS.register("angel_block",
            () -> new AngelBlockItem(ModBlocks.ANGEL_BLOCK.get(), new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_UNRELATEDADDITIONS)
            ));

    public static final RegistryObject<RopeLadderBlockItem> ROPE_LADDER = ITEMS.register("rope_ladder",
            () -> new RopeLadderBlockItem(ModBlocks.ROPE_LADDER.get(), new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_UNRELATEDADDITIONS)
            ));

    public static final RegistryObject<BucketItem> XP_JUICE_BUCKET = ITEMS.register("xp_juice_bucket",
            () -> new BucketItem(ModFluids.SOURCE_XP_JUICE, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_UNRELATEDADDITIONS)
                    .stacksTo(1)
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static RegistryObject<ExcavatorTool> registerHammer(String name, Tier tier, Item.Properties properties) {
        return ITEMS.register(name,
                () ->
                        new ExcavatorTool(tier, properties.stacksTo(1), ModTags.Blocks.MINEABLE_WITH_HAMMER,
                                UnrelatedAdditionsCommonConfig.HAMMER_BREAKING_RADIUS
                        ));
    }
    private static RegistryObject<ExcavatorTool> registerSpade(String name, Tier tier, Item.Properties properties) {
        return ITEMS.register(name,
                () ->
                        new ExcavatorTool(tier, properties.stacksTo(1), ModTags.Blocks.MINEABLE_WITH_SPADE,
                                UnrelatedAdditionsCommonConfig.SPADE_BREAKING_RADIUS));
    }
}
