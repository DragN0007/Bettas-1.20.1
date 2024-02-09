package com.dragn.bettas.fish.saltwater.seahorse;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SeaHorseRender extends GeoEntityRenderer<SeaHorseEntity> {
    public SeaHorseRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SeaHorseModel());
    }
}
