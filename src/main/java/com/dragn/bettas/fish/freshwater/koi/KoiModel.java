package com.dragn.bettas.fish.freshwater.koi;

import com.dragn.bettas.BettasMain;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class KoiModel extends GeoModel<KoiEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/koi.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/koi.animation.json");

    @Override
    public ResourceLocation getModelResource(KoiEntity koiEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(KoiEntity koiEntity) {
        return Variant.patternFromOrdinal(koiEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(KoiEntity koiEntity) {
        return animationResource;
    }
}
