package com.dragn.bettas.fish.freshwater.silvershark;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SilverSharkRender extends GeoEntityRenderer<SilverSharkEntity> {
    public SilverSharkRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SilverSharkModel());
    }
}
