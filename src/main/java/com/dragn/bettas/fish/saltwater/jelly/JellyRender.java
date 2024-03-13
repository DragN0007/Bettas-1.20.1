package com.dragn.bettas.fish.saltwater.jelly;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class JellyRender extends GeoEntityRenderer<JellyEntity> {
    public JellyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new JellyModel());
    }
}
