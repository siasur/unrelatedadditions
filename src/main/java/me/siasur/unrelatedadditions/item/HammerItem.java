package me.siasur.unrelatedadditions.item;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class HammerItem extends DiggerItem {

    private static float _DAMAGE = 1f;
    private static float _ATTACKSPEED = -2.8f;

    public HammerItem(Tier toolTier, Properties properties) {
        super(_DAMAGE, _ATTACKSPEED, toolTier, BlockTags.create(new ResourceLocation(UnrelatedAdditions.MODID, "mineable/hammer")), properties);
    }
}
