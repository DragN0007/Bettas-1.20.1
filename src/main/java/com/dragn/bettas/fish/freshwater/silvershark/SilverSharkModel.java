package com.dragn.bettas.fish.freshwater.silvershark;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SilverSharkModel extends GeoModel<SilverSharkEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/silvershark.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/silvershark.animation.json");

    @Override
    public ResourceLocation getModelResource(SilverSharkEntity SilverSharkEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(SilverSharkEntity SilverSharkEntity) {
        return Variant.patternFromOrdinal(SilverSharkEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(SilverSharkEntity SilverSharkEntity) {
        return animationResource;
    }
}
