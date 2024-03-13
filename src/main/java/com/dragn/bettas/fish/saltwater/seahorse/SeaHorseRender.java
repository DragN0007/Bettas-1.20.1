package com.dragn.bettas.fish.saltwater.seahorse;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SeaHorseRender extends GeoEntityRenderer<SeaHorseEntity> {
    public SeaHorseRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SeaHorseModel());
    }
}
