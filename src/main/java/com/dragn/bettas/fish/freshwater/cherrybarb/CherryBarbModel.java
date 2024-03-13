package com.dragn.bettas.fish.freshwater.cherrybarb;

import com.dragn.bettas.BettasMain;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class CherryBarbModel extends GeoModel<CherryBarbEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/cherrybarb.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/cherrybarb.animation.json");

    public static final ResourceLocation babyAnimationResource = new ResourceLocation(BettasMain.MODID, "animations/betta.animations.json");
    public static final ResourceLocation BABY_MODEL = new ResourceLocation (BettasMain.MODID, "geo/small_fry.geo.json");

    @Override
    public ResourceLocation getModelResource(CherryBarbEntity object) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(CherryBarbEntity object) {
        return Gender.patternFromOrdinal(object.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(CherryBarbEntity animatable) {
        return animationResource;
    }
}
