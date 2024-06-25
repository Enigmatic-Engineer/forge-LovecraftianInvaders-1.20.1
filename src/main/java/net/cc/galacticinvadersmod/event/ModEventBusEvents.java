package net.cc.galacticinvadersmod.event;

import net.cc.galacticinvadersmod.GalacticInvadersMod;
import net.cc.galacticinvadersmod.entity.ModEntities;
import net.cc.galacticinvadersmod.entity.client.EyeScoutModel;
import net.cc.galacticinvadersmod.entity.client.SmallRiftModel;
import net.cc.galacticinvadersmod.entity.custom.EyeScoutEntity;
import net.cc.galacticinvadersmod.entity.custom.SmallRiftEntity;
import net.cc.galacticinvadersmod.entity.layers.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GalacticInvadersMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SMALL_RIFT_LAYER, SmallRiftModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.EYE_SCOUT_LAYER, EyeScoutModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SMALL_RIFT.get(), SmallRiftEntity.createAttributes().build());
        event.put(ModEntities.EYE_SCOUT.get(), EyeScoutEntity.createAttributes().build());
    }
}
