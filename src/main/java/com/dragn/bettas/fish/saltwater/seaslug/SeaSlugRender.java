package com.dragn.bettas.fish.saltwater.seaslug;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SeaSlugRender extends GeoEntityRenderer<SeaSlugEntity> {

    public SeaSlugRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SeaSlugModel());
    }
}
