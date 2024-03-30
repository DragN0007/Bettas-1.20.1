package com.dragn.bettas.fish.freshwater.ghostshrimp;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.freshwater.cherrybarb.Gender;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GhostShrimpModel extends GeoModel<GhostShrimpEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/ghostshrimp.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/ghostshrimp.animation.json");

    @Override
    public ResourceLocation getModelResource(GhostShrimpEntity object) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(GhostShrimpEntity object) {
        return Gender.patternFromOrdinal(object.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(GhostShrimpEntity animatable) {
        return animationResource;
    }
}
