package com.dragn.bettas.fish.freshwater.snakehead;

import com.dragn.bettas.BettasMain;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class SnakeheadModel extends GeoModel<SnakeheadEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/snakehead.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/silvershark.animation.json");

    @Override
    public ResourceLocation getModelResource(SnakeheadEntity SilverSharkEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(SnakeheadEntity SnakeheadEntity) {
        return Variant.patternFromOrdinal(SnakeheadEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(SnakeheadEntity SilverSharkEntity) {
        return animationResource;
    }
}
