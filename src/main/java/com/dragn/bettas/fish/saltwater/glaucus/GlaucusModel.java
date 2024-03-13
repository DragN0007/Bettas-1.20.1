package com.dragn.bettas.fish.saltwater.glaucus;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public class GlaucusModel extends GeoModel<GlaucusEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/glaucus.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/glaucus.animation.json");

    @Override
    public ResourceLocation getModelResource(GlaucusEntity GlaucusEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(GlaucusEntity GlaucusEntity) {
        return Variant.patternFromOrdinal(GlaucusEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(GlaucusEntity GlaucusEntity) {
        return animationResource;
    }
}
