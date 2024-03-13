package com.dragn.bettas.fish.saltwater.crab;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public class CrabModel extends GeoModel<CrabEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/crab.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/crab.animation.json");

    @Override
    public ResourceLocation getModelResource(CrabEntity CrabEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(CrabEntity CrabEntity) {
        return Texture.patternFromOrdinal(CrabEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(CrabEntity CrabEntity) {
        return animationResource;
    }
}
