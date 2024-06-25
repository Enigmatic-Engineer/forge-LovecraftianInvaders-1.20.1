package net.cc.galacticinvadersmod.entity.client;

import net.cc.galacticinvadersmod.GalacticInvadersMod;
import net.cc.galacticinvadersmod.entity.custom.SmallRiftEntity;
import net.cc.galacticinvadersmod.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SmallRiftRenderer extends MobRenderer<SmallRiftEntity, SmallRiftModel<SmallRiftEntity>> {

    private static final ResourceLocation SMALL_RIFT_LOCATION = new ResourceLocation(GalacticInvadersMod.MOD_ID, "textures/entity/small_rift.png");

    public SmallRiftRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SmallRiftModel<>(pContext.bakeLayer(ModModelLayers.SMALL_RIFT_LAYER)), 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(SmallRiftEntity smallRiftEntity) {
        return SMALL_RIFT_LOCATION;
    }
}
