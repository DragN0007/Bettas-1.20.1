package com.dragn.bettas.fish.saltwater.clownfish;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ClownfishRender extends GeoEntityRenderer<ClownfishEntity> {
    public ClownfishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ClownfishModel());
    }
}
