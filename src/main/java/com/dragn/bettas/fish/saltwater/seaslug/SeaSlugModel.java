package com.dragn.bettas.fish.saltwater.seaslug;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SeaSlugModel extends GeoModel<SeaSlugEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/seaslug.geo.json");

    @Override
    public ResourceLocation getModelResource(SeaSlugEntity SeaSlugEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(SeaSlugEntity SeaSlugEntity) {
        return Texture.patternFromOrdinal(SeaSlugEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(SeaSlugEntity SeaSlugEntity) {
        return null;
    }
}
