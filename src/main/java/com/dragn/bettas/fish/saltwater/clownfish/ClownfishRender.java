package com.dragn.bettas.fish.saltwater.clownfish;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ClownfishRender extends GeoEntityRenderer<ClownfishEntity> {
    public ClownfishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ClownfishModel());
    }
}
