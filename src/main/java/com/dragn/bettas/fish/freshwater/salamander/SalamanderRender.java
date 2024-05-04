package com.dragn.bettas.fish.freshwater.salamander;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SalamanderRender extends GeoEntityRenderer<SalamanderEntity> {
    public SalamanderRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SalamanderModel());
    }
}
