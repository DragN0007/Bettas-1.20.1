package com.dragn.bettas.fish.freshwater.ghostshrimp;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GhostShrimpRender extends GeoEntityRenderer<GhostShrimpEntity> {

    public GhostShrimpRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GhostShrimpModel());
    }
}
