package net.cc.galacticinvadersmod.entity.client;

import net.cc.galacticinvadersmod.GalacticInvadersMod;
import net.cc.galacticinvadersmod.entity.custom.EyeScoutEntity;
import net.cc.galacticinvadersmod.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EyeScoutRenderer extends MobRenderer<EyeScoutEntity, EyeScoutModel<EyeScoutEntity>> {
    private static final ResourceLocation EYE_SCOUT_LOCATION = new ResourceLocation(GalacticInvadersMod.MOD_ID, "textures/entity/eye_scout.png");

    public EyeScoutRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EyeScoutModel<>(pContext.bakeLayer(ModModelLayers.EYE_SCOUT_LAYER)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(EyeScoutEntity eyeScoutEntity) {
        return EYE_SCOUT_LOCATION;
    }
}
