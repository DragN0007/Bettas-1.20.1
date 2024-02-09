package com.dragn.bettas.fish.saltwater.glaucus;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GlaucusRender extends GeoEntityRenderer<GlaucusEntity> {
    public GlaucusRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GlaucusModel());
    }
}
