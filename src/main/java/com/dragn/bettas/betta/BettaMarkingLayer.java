package com.dragn.bettas.betta;

import com.dragn.bettas.BettasMain;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class BettaMarkingLayer extends GeoRenderLayer<Betta> {
    public BettaMarkingLayer(GeoRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack poseStack, Betta animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {

        if (animatable.isBaby()) {
            return;
        }

        RenderType renderMarkingType = RenderType.entityCutout(((Betta)animatable).getOverlayLocation());
        poseStack.pushPose();
        poseStack.scale(1.0f, 1.0f, 1.0f);
        poseStack.translate(0.0d, 0.0d, 0.0d);
        poseStack.popPose();
        getRenderer().reRender(getDefaultBakedModel(animatable),
                poseStack,
                bufferSource,
                animatable,
                renderMarkingType,
                bufferSource.getBuffer(renderMarkingType), partialTick, packedLight, OverlayTexture.NO_OVERLAY,
                1, 1, 1, 1);
    }

    public enum Overlay {
        NONE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/none.png")),
        BLACK_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/black_tipped.png")),
        RED_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/red_tipped.png")),
        ORANGE_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/orange_tipped.png")),
        YELLOW_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/yellow_tipped.png")),
        GREEN_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/green_tipped.png")),
        TEAL_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/teal_tipped.png")),
        BLUE_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/blue_tipped.png")),
        PURPLE_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/purple_tipped.png")),
        PINK_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/pink_tipped.png")),
        WHITE_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/white_tipped.png")),
        GOLD_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/gold_tipped.png")),
        PEARL_TIPPED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/pearl_tipped.png")),
        BUTTERFLY(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/butterfly.png")),
        DRAGON(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/dragon.png")),
        FADE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/fade.png")),
        GALAXY_KOI(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/galaxy_koi.png")),
        GRIZZLED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/grizzled.png")),
        HELLBOY(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/hellboy.png")),
        KOI(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/koi.png")),
        MONSTER_MASK(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/monster_mask.png")),
        MUSTARD_GAS(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/mustard_gas.png")),
        SAMURAI(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/samurai.png")),
        REVERSE_BUTTERFLY(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/reverse_butterfly.png")),
        REVERSE_DRAGON(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/reverse_dragon.png")),
        REVERSE_FADE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/reverse_fade.png")),
        REVERSE_HELLBOY(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/reverse_hellboy.png")),
        REVERSE_KOI(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/marking/reverse_koi.png")),
        ;

        public final ResourceLocation resourceLocation;
        Overlay(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Overlay overlayFromOrdinal(int overlay) { return Overlay.values()[overlay % Overlay.values().length];
        }
    }

}
