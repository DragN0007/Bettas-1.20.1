package com.dragn.bettas.fish.saltwater.peacockshrimp;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PeacockShrimpModel extends GeoModel<PeacockShrimpEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/peacockshrimp.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/ghostshrimp.animation.json");

    @Override
    public ResourceLocation getModelResource(PeacockShrimpEntity peacockShrimpEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(PeacockShrimpEntity peacockShrimpEntity) {
        return Texture.patternFromOrdinal(peacockShrimpEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(PeacockShrimpEntity peacockShrimpEntity) {
        return animationResource;
    }
}
