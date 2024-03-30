package com.dragn.bettas.fish.saltwater.jelly;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class JellyRender extends GeoEntityRenderer<JellyEntity> {
    public JellyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new JellyModel());
    }
}
