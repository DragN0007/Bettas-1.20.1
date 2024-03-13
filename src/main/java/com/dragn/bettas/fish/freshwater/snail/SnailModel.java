package com.dragn.bettas.fish.freshwater.snail;

import com.dragn.bettas.BettasMain;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

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
