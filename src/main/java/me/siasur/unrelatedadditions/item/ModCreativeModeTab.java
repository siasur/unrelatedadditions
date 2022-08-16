package me.siasur.unrelatedadditions.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TAB_UNRELATEDADDITIONS = new CreativeModeTab("unrelatedadditions") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.Tiny_Charcoal.get());
        }
    };
}
