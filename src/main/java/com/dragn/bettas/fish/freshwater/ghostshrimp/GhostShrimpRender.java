package com.dragn.bettas.fish.freshwater.ghostshrimp;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GhostShrimpRender extends GeoEntityRenderer<GhostShrimpEntity> {

    public GhostShrimpRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GhostShrimpModel());
    }
}
