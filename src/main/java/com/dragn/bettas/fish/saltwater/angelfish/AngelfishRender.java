package com.dragn.bettas.fish.saltwater.angelfish;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class AngelfishRender extends GeoEntityRenderer<AngelfishEntity> {
    public AngelfishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AngelfishModel());
    }
}
