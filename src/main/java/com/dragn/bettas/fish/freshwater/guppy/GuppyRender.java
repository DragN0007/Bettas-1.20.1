package com.dragn.bettas.fish.freshwater.guppy;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GuppyRender extends GeoEntityRenderer<GuppyEntity> {
    public GuppyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GuppyModel());
    }
}
