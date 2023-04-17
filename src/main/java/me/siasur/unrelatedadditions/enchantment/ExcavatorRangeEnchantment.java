package me.siasur.unrelatedadditions.enchantment;

import me.siasur.unrelatedadditions.config.UnrelatedAdditionsCommonConfig;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class ExcavatorRangeEnchantment extends Enchantment {

    protected ExcavatorRangeEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, CustomEnchantmentCategories.EXCAVATOR_TOOL, pApplicableSlots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isTreasureOnly() {
        return UnrelatedAdditionsCommonConfig.RANGE_ENCHANTMENT_IS_OBTAINABLE.get();
    }
}
