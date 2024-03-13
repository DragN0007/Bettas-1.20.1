package com.dragn.bettas.fish.freshwater.goldfish;

import com.dragn.bettas.BettasMain;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class GoldfishModel extends GeoModel<GoldfishEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/goldfish.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/clownfish.animation.json");

    @Override
    public ResourceLocation getModelResource(GoldfishEntity GoldfishEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(GoldfishEntity GoldfishEntity) {
        return Variant.patternFromOrdinal(GoldfishEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(GoldfishEntity GoldfishEntity) {
        return animationResource;
    }
}
