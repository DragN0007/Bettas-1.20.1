package com.dragn.bettas.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class BettasCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> ALGAE_GROWTH_RATE;
    public static final ForgeConfigSpec.BooleanValue BETTA_RARE_COLORS;
    public static final ForgeConfigSpec.BooleanValue BETTAS_FIGHT;
    public static final ForgeConfigSpec.BooleanValue GENDERS_AFFECT_BREEDING;


    static {
        BUILDER.push("Configs for Bettas & Aquatics!");

        ALGAE_GROWTH_RATE = BUILDER.comment("How long should algae stages take to grow? Default is 3 days.")
                .define("Algae Growth Rate", 3);

        BETTA_RARE_COLORS = BUILDER.comment("Should Bettas have different chances of getting certain colors?")
                .define("Some Betta Colors Are Rare", true);

        BETTAS_FIGHT = BUILDER.comment("Should male bettas fight other male bettas?")
                .define("Bettas Fight Eachother", true);

        GENDERS_AFFECT_BREEDING = BUILDER.comment("Should the gender of a betta affect if it can breed or not?")
                .define("Genders Affect Breeding", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
