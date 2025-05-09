package com.dragn.bettas.betta;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BettaRender extends GeoEntityRenderer<Betta> {

    public BettaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BettaModel());
        this.addRenderLayer(new BettaMarkingLayer(this));
    }

    @Override
    public void preRender(PoseStack poseStack, Betta entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if(entity.isAggressive()) {
            model.getBone("flare").ifPresent(b -> b.setHidden(false));
        } else {
            model.getBone("flare").ifPresent(b -> b.setHidden(true));
        }

        if(entity.isFemale()) {
            model.getBone("tail").ifPresent(b -> b.setScaleX(1.0F));
            model.getBone("tail").ifPresent(b -> b.setScaleY(0.8F));
            model.getBone("tail").ifPresent(b -> b.setScaleZ(0.7F));
            model.getBone("dorsal_fin").ifPresent(b -> b.setScaleY(0.8F));
            model.getBone("bottom_fin").ifPresent(b -> b.setScaleY(0.8F));
            model.getBone("anal_fins").ifPresent(b -> b.setScaleY(0.8F));
            model.getBone("body_front").ifPresent(b -> b.setScaleY(0.8F));
            model.getBone("body_front").ifPresent(b -> b.setScaleX(0.8F));
        }

        if(entity.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
