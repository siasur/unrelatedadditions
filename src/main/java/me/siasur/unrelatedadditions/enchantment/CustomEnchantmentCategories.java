package me.siasur.unrelatedadditions.enchantment;

import me.siasur.unrelatedadditions.item.ExcavatorTool;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CustomEnchantmentCategories {

    public static EnchantmentCategory EXCAVATOR_TOOL = EnchantmentCategory.create("EXCAVATOR", item -> (item instanceof ExcavatorTool));

}
