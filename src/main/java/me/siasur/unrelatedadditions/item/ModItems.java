package me.siasur.unrelatedadditions.item;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.inventory.ModCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UnrelatedAdditions.MODID);

    public static final RegistryObject<Item> Tiny_Coal = ITEMS.register("tiny_coal",
            () -> new FuelItem(new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_UNRELATEDADDITIONS),
                    FuelItem.DEFAULT_COAL_BURN_TIME / FuelItem.TINY_COAL_DIVISOR
            ));

    public static final RegistryObject<Item> Tiny_Charcoal = ITEMS.register("tiny_charcoal",
            () -> new FuelItem(new Item.Properties()
                    .tab(ModCreativeModeTab.TAB_UNRELATEDADDITIONS),
                    FuelItem.DEFAULT_COAL_BURN_TIME / FuelItem.TINY_COAL_DIVISOR
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
