package com.dragn.bettas.fish.freshwater.salamander;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SalamanderModel extends GeoModel<SalamanderEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/salamander.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/salamander.animation.json");

    @Override
    public ResourceLocation getModelResource(SalamanderEntity object) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(SalamanderEntity object) {
        return Variant.patternFromOrdinal(object.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(SalamanderEntity object) {
        return animationResource;
    }
}
