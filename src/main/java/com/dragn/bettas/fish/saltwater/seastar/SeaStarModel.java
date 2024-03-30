package com.dragn.bettas.fish.saltwater.seastar;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SeaStarModel extends GeoModel<SeaStarEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/seastar.geo.json");

    @Override
    public ResourceLocation getModelResource(SeaStarEntity SeaStarEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(SeaStarEntity SeaStarEntity) {
        return Texture.patternFromOrdinal(SeaStarEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(SeaStarEntity SeaStarEntity) {
        return null;
    }
}
