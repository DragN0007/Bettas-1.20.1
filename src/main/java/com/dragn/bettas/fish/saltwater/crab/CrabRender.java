package com.dragn.bettas.fish.saltwater.crab;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CrabRender extends GeoEntityRenderer<CrabEntity> {

    public CrabRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrabModel());
    }
}
