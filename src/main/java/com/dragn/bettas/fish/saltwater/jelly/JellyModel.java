package com.dragn.bettas.fish.saltwater.jelly;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class JellyModel extends GeoModel<JellyEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/jelly.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/jelly.animation.json");

    @Override
    public ResourceLocation getModelResource(JellyEntity JellyEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(JellyEntity JellyEntity) {
        return Variant.patternFromOrdinal(JellyEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(JellyEntity JellyEntity) {
        return animationResource;
    }
}
