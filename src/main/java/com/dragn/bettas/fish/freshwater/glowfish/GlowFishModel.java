package com.dragn.bettas.fish.freshwater.glowfish;

import com.dragn.bettas.BettasMain;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class GlowFishModel extends GeoModel<GlowFishEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/glowfish.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/tetra.animation.json");

    @Override
    public ResourceLocation getModelResource(GlowFishEntity glow) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(GlowFishEntity glow) {
        return Variant.patternFromOrdinal(glow.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(GlowFishEntity glow) {
        return animationResource;
    }
}
