package com.dragn.bettas.betta;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BettaRender extends GeoEntityRenderer<BettaEntity> {
    public BettaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BettaModel());
    }
}
