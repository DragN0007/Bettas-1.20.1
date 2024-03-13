package com.dragn.bettas.fish.saltwater.seastar;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SeaStarRender extends GeoEntityRenderer<SeaStarEntity> {

    public SeaStarRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SeaStarModel());
    }
}
