package com.dragn.bettas.fish.saltwater.angelfish;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AngelfishRender extends GeoEntityRenderer<AngelfishEntity> {
    public AngelfishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AngelfishModel());
    }
}
