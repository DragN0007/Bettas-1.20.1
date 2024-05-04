package com.dragn.bettas.fish.saltwater.seadragon;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SeadragonModel extends GeoModel<SeadragonEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/seadragon.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/seahorse.animation.json");

    @Override
    public ResourceLocation getModelResource(SeadragonEntity seadragonEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(SeadragonEntity seadragonEntity) {
        return Variant.patternFromOrdinal(seadragonEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(SeadragonEntity seadragonEntity) {
        return animationResource;
    }
}
