package me.siasur.unrelatedadditions.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelItem extends Item {

    public static int DEFAULT_COAL_BURN_TIME = 1600;
    public static int TINY_COAL_DIVISOR = 8;

    private int _burnTime = -1;

    public FuelItem(Properties properties, int burnTime) {
        super(properties);
        _burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return _burnTime > 0 ? _burnTime :  super.getBurnTime(itemStack, recipeType);
    }
}
