package com.dragn.bettas.fish.freshwater.goldfish;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GoldfishRender extends GeoEntityRenderer<GoldfishEntity> {
    public GoldfishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GoldfishModel());
    }
}
