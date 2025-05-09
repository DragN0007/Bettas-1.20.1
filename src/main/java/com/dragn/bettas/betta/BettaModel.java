package com.dragn.bettas.betta;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BettaModel extends GeoModel<Betta> {

    public enum Variant {
        BLACK(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/black.png")),
        B_RED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/bright_red.png")),
        D_RED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/dark_red.png")),
        P_RED(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/pastel_red.png")),
        B_ORANGE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/bright_orange.png")),
        D_ORANGE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/dark_orange.png")),
        P_ORANGE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/pastel_orange.png")),
        B_YELLOW(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/bright_yellow.png")),
        D_YELLOW(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/dark_yellow.png")),
        P_YELLOW(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/pastel_yellow.png")),
        B_GREEN(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/bright_green.png")),
        D_GREEN(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/dark_green.png")),
        P_GREEN(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/pastel_green.png")),
        B_TEAL(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/bright_teal.png")),
        D_TEAL(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/dark_teal.png")),
        P_TEAL(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/pastel_teal.png")),
        B_BLUE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/bright_blue.png")),
        D_BLUE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/dark_blue.png")),
        P_BLUE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/pastel_blue.png")),
        B_PURPLE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/bright_purple.png")),
        D_PURPLE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/dark_purple.png")),
        P_PURPLE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/pastel_purple.png")),
        B_PINK(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/bright_pink.png")),
        D_PINK(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/dark_pink.png")),
        P_PINK(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/pastel_pink.png")),
        IRIDESCENT_GREEN(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/iridescent_green.png")),
        IRIDESCENT_BLUE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/iridescent_blue.png")),
        IRIDESCENT_MAGENTA(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/iridescent_magenta.png")),
        GOLD(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/gold.png")),
        PEARL(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/pearl.png")),
        WHITE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/white.png")),
        LIGHT_GREY(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/light_grey.png")),
        GREY(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/grey.png")),
        BROWN(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/brown.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }


    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/betta.animation.json");

    @Override
    public ResourceLocation getModelResource(Betta bettaEntity) {
        return BettaBodyType.modelFromOrdinal(bettaEntity.getBodyType()).resourceLocation;
    }

    @Override
    public ResourceLocation getTextureResource(Betta bettaEntity) {
        return bettaEntity.getVariantLocation();
    }

    @Override
    public ResourceLocation getAnimationResource(Betta bettaEntity) {
        return animationResource;
    }
}
