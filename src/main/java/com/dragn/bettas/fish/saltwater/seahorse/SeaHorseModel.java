package com.dragn.bettas.fish.saltwater.seahorse;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SeaHorseModel extends GeoModel<SeaHorseEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/seahorse.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/seahorse.animation.json");

    @Override
    public ResourceLocation getModelResource(SeaHorseEntity SeaHorseEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(SeaHorseEntity SeaHorseEntity) {
        return Variant.patternFromOrdinal(SeaHorseEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(SeaHorseEntity SeaHorseEntity) {
        return animationResource;
    }
}
