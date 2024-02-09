package com.dragn.bettas.fish.freshwater.snakehead;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SnakeheadModel extends GeoModel<SnakeheadEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/snakehead.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/silvershark.animation.json");

    @Override
    public ResourceLocation getModelResource(SnakeheadEntity SilverSharkEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(SnakeheadEntity SnakeheadEntity) {
        return Variant.patternFromOrdinal(SnakeheadEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(SnakeheadEntity SilverSharkEntity) {
        return animationResource;
    }
}
