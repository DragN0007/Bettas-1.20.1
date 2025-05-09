package com.dragn.bettas.betta;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public enum BettaBodyType {
    DOUBLETAIL(new ResourceLocation(BettasMain.MODID, "geo/betta/doubletail.geo.json")),
    DUMBO(new ResourceLocation(BettasMain.MODID, "geo/betta/dumbo.geo.json")),
    HALFMOON(new ResourceLocation(BettasMain.MODID, "geo/betta/halfmoon.geo.json")),
    PLAKAT(new ResourceLocation(BettasMain.MODID, "geo/betta/plakat.geo.json")),
    VEIL(new ResourceLocation(BettasMain.MODID, "geo/betta/veiltail.geo.json"));

    public final ResourceLocation resourceLocation;

    BettaBodyType(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static BettaBodyType modelFromOrdinal(int ordinal) {
        return BettaBodyType.values()[ordinal % BettaBodyType.values().length];
    }
}