package com.dragn.bettas.fish.saltwater.filefish;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FilefishRender extends GeoEntityRenderer<FilefishEntity> {
    public FilefishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FilefishModel());
    }
}
