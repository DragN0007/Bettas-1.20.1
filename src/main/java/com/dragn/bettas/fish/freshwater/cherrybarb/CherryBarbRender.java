package com.dragn.bettas.fish.freshwater.cherrybarb;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CherryBarbRender extends GeoEntityRenderer<CherryBarbEntity> {
    public CherryBarbRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CherryBarbModel());
    }
}
