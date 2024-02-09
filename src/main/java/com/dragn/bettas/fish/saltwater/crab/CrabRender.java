package com.dragn.bettas.fish.saltwater.crab;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrabRender extends GeoEntityRenderer<CrabEntity> {

    public CrabRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrabModel());
    }
}
