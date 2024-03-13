package com.dragn.bettas.fish.freshwater.isopod;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class IsopodRender extends GeoEntityRenderer<IsopodEntity> {

    public IsopodRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IsopodModel());
    }
}
