package com.dragn.bettas.fish.freshwater.guppy;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GuppyModel extends GeoModel<GuppyEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/guppy.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/cherrybarb.animation.json");

    @Override
    public ResourceLocation getModelResource(GuppyEntity GuppyEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(GuppyEntity GuppyEntity) {
        return Variant.patternFromOrdinal(GuppyEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(GuppyEntity GuppyEntity) {
        return animationResource;
    }
}
