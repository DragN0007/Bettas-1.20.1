package com.dragn.bettas.fish.freshwater.isopod;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IsopodModel extends GeoModel<IsopodEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/isopod.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/isopod.animation.json");

    @Override
    public ResourceLocation getModelResource(IsopodEntity IsopodEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(IsopodEntity IsopodEntity) {
        return Texture.patternFromOrdinal(IsopodEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(IsopodEntity IsopodEntity) {
        return animationResource;
    }
}
