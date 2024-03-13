package com.dragn.bettas.fish.freshwater.snail;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SnailRender extends GeoEntityRenderer<SnailEntity> {

    public SnailRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SnailModel());
    }
}
