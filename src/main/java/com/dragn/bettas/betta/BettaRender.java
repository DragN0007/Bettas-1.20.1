package com.dragn.bettas.betta;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BettaRender extends GeoEntityRenderer<BettaEntity> {
    public BettaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BettaModel());
    }
}
