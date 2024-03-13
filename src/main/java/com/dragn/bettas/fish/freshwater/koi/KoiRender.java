package com.dragn.bettas.fish.freshwater.koi;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class KoiRender extends GeoEntityRenderer<KoiEntity> {
    public KoiRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KoiModel());
    }
}
