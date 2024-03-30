package com.dragn.bettas.fish.freshwater.snakehead;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SnakeheadRender extends GeoEntityRenderer<SnakeheadEntity> {
    public SnakeheadRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SnakeheadModel());
    }
}
