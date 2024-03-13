package com.dragn.bettas.fish.saltwater.seaslug;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SeaSlugRender extends GeoEntityRenderer<SeaSlugEntity> {

    public SeaSlugRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SeaSlugModel());
    }
}
