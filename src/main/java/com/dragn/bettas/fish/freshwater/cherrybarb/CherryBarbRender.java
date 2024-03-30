package com.dragn.bettas.fish.freshwater.cherrybarb;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CherryBarbRender extends GeoEntityRenderer<CherryBarbEntity> {
    public CherryBarbRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CherryBarbModel());
    }
}
