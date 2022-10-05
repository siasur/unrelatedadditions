package me.siasur.unrelatedadditions.block.entity;

import me.siasur.unrelatedadditions.UnrelatedAdditions;
import me.siasur.unrelatedadditions.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UnrelatedAdditions.MODID);

    public static final RegistryObject<BlockEntityType<XPDrainBlockEntity>> XP_DRAIN = BLOCK_ENTITIES.register("xp_drain",
            () -> BlockEntityType.Builder.of(XPDrainBlockEntity::new, ModBlocks.XP_DRAIN.get()).build(null));
    public static final RegistryObject<BlockEntityType<XPShowerBlockEntity>> XP_SHOWER = BLOCK_ENTITIES.register("xp_shower",
            () -> BlockEntityType.Builder.of(XPShowerBlockEntity::new, ModBlocks.XP_SHOWER.get()).build(null));

    public static final RegistryObject<BlockEntityType<DryingRackBlockEntity>> DRYING_RACK = BLOCK_ENTITIES.register("drying_rack",
            () -> BlockEntityType.Builder.of(DryingRackBlockEntity::new, ModBlocks.DRYING_RACK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
