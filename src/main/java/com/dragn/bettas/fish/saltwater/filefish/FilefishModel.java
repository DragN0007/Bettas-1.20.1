package com.dragn.bettas.fish.saltwater.filefish;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FilefishModel extends GeoModel<FilefishEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/filefish.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/filefish.animation.json");

    @Override
    public ResourceLocation getModelResource(FilefishEntity FilefishEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(FilefishEntity FilefishEntity) {
        return Variant.patternFromOrdinal(FilefishEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(FilefishEntity FilefishEntity) {
        return animationResource;
    }
}
