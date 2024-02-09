package com.dragn.bettas.betta;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BettaModel extends GeoModel<BettaEntity> {

    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/betta.animations.json");

    @Override
    public ResourceLocation getModelResource(BettaEntity bettaEntity) {
        return Model.modelFromOrdinal(bettaEntity.getModel()).resourceLocation;
    }

    @Override
    public ResourceLocation getTextureResource(BettaEntity bettaEntity) {
        return bettaEntity.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(BettaEntity bettaEntity) {
        return animationResource;
    }
}
