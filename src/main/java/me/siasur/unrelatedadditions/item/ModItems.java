package me.siasur.unrelatedadditions.item;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.inventory.ModCreativeModeTab;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
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

    public static final RegistryObject<HammerItem> WOODEN_HAMMER = registerHammer("wooden_hammer", Tiers.WOOD,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );

    public static final RegistryObject<HammerItem> STONE_HAMMER = registerHammer("stone_hammer", Tiers.STONE,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );

    public static final RegistryObject<HammerItem> IRON_HAMMER = registerHammer("iron_hammer", Tiers.IRON,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );

    public static final RegistryObject<HammerItem> GOLDEN_HAMMER = registerHammer("golden_hammer", Tiers.GOLD,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );

    public static final RegistryObject<HammerItem> DIAMOND_HAMMER = registerHammer("diamond_hammer", Tiers.DIAMOND,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static RegistryObject<HammerItem> registerHammer(String name, Tiers tier, Item.Properties properties) {
        return ITEMS.register(name,
                () -> new HammerItem(tier, properties
                        .stacksTo(1)
                        .durability(tier.getUses()*9)
                ));
    }
}
