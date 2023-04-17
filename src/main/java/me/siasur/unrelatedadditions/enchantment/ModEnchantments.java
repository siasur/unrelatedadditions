package me.siasur.unrelatedadditions.enchantment;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, UnrelatedAdditions.MODID);

    public static RegistryObject<ExcavatorRangeEnchantment> EXCAVATOR_RANGE = ENCHANTMENTS.register("excavator_range", () -> new ExcavatorRangeEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }

}
