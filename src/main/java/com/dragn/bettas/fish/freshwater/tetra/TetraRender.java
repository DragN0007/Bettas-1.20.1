package com.dragn.bettas.fish.freshwater.tetra;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class TetraRender extends GeoEntityRenderer<TetraEntity> {
    public TetraRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TetraModel());
    }
}
