package com.dragn.bettas.fish.saltwater.angelfish;

import com.dragn.bettas.BettasMain;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class AngelfishModel extends GeoModel<AngelfishEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/angelfish.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/angelfish.animation.json");

    @Override
    public ResourceLocation getModelResource(AngelfishEntity ClownfishEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(AngelfishEntity ClownfishEntity) {
        return Variant.patternFromOrdinal(ClownfishEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(AngelfishEntity SeaHorseEntity) {
        return animationResource;
    }
}
