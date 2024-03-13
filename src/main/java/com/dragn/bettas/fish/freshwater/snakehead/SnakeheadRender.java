package com.dragn.bettas.fish.freshwater.snakehead;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SnakeheadRender extends GeoEntityRenderer<SnakeheadEntity> {
    public SnakeheadRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SnakeheadModel());
    }
}
