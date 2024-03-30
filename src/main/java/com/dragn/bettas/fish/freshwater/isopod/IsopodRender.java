package com.dragn.bettas.fish.freshwater.isopod;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class IsopodRender extends GeoEntityRenderer<IsopodEntity> {

    public IsopodRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IsopodModel());
    }
}
