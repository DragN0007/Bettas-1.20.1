package com.dragn.bettas.fish.saltwater.seastar;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SeaStarRender extends GeoEntityRenderer<SeaStarEntity> {

    public SeaStarRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SeaStarModel());
    }
}
