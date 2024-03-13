package com.dragn.bettas.fish.saltwater.glaucus;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GlaucusRender extends GeoEntityRenderer<GlaucusEntity> {
    public GlaucusRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GlaucusModel());
    }
}
