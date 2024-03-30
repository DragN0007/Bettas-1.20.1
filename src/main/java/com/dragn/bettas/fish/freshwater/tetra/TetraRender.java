package com.dragn.bettas.fish.freshwater.tetra;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TetraRender extends GeoEntityRenderer<TetraEntity> {
    public TetraRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TetraModel());
    }
}
