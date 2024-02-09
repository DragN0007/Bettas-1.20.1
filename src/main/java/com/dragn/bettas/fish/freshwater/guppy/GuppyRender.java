package com.dragn.bettas.fish.freshwater.guppy;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GuppyRender extends GeoEntityRenderer<GuppyEntity> {
    public GuppyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GuppyModel());
    }
}
