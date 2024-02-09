package com.dragn.bettas.fish.freshwater.tetra;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TetraModel extends GeoModel<TetraEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/tetra.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/tetra.animation.json");

    @Override
    public ResourceLocation getModelResource(TetraEntity koiEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(TetraEntity koiEntity) {
        return Gender.patternFromOrdinal(koiEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(TetraEntity koiEntity) {
        return animationResource;
    }
}
