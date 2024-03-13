package com.dragn.bettas.fish.saltwater.filefish;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class FilefishRender extends GeoEntityRenderer<FilefishEntity> {
    public FilefishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FilefishModel());
    }
}
