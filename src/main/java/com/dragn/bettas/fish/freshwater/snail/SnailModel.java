package com.dragn.bettas.fish.freshwater.snail;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SnailModel extends GeoModel<SnailEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/snailsizefix.geo.json");

    @Override
    public ResourceLocation getModelResource(SnailEntity snailEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(SnailEntity snailEntity) {
        return Texture.patternFromOrdinal(snailEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(SnailEntity snailEntity) {
        return null;
    }
}
