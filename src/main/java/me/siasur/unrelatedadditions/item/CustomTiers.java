package me.siasur.unrelatedadditions.item;

import me.siasur.unrelatedadditions.utils.ModTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public final class CustomTiers {

    public static final ForgeTier BRONZE = new ForgeTier(2, 375, 7, 2, 10, ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModTags.Items.INGOTS_BRONZE));

}
