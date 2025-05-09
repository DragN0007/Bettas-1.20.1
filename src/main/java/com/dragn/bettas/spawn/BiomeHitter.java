package com.dragn.bettas.spawn;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.util.BettaTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class BiomeHitter {

    public static final ResourceKey<BiomeModifier> BETTA = registerKey("betta");
    public static final ResourceKey<BiomeModifier> SNAIL = registerKey("snail");
    public static final ResourceKey<BiomeModifier> KOI = registerKey("koi");
    public static final ResourceKey<BiomeModifier> TETRA = registerKey("tetra");
    public static final ResourceKey<BiomeModifier> CHERRY_BARB = registerKey("cherry_barb");
    public static final ResourceKey<BiomeModifier> GOLDFISH = registerKey("goldfish");
    public static final ResourceKey<BiomeModifier> GUPPY = registerKey("guppy");
    public static final ResourceKey<BiomeModifier> SILVER_SHARK = registerKey("silver_shark");
    public static final ResourceKey<BiomeModifier> GHOST_SHRIMP = registerKey("ghost_shrimp");
    public static final ResourceKey<BiomeModifier> SNAKEHEAD = registerKey("snakehead");
    public static final ResourceKey<BiomeModifier> GLOWFISH = registerKey("glowfish");
    public static final ResourceKey<BiomeModifier> CRYSTAL_SHRIMP = registerKey("crystal_shrimp");
    public static final ResourceKey<BiomeModifier> PLECO = registerKey("pleco");
    public static final ResourceKey<BiomeModifier> SALAMANDER = registerKey("salamander");
    public static final ResourceKey<BiomeModifier> ANGELFISH = registerKey("angelfish");
    public static final ResourceKey<BiomeModifier> CLOWNFISH = registerKey("clownfish");
    public static final ResourceKey<BiomeModifier> FILEFISH = registerKey("filefish");
    public static final ResourceKey<BiomeModifier> GLAUCUS = registerKey("glaucus");
    public static final ResourceKey<BiomeModifier> ISOPOD = registerKey("isopod");
    public static final ResourceKey<BiomeModifier> CRAB = registerKey("crab");
    public static final ResourceKey<BiomeModifier> JELLY = registerKey("jelly");
    public static final ResourceKey<BiomeModifier> PEACOCK_SHRIMP = registerKey("peacock_shrimp");
    public static final ResourceKey<BiomeModifier> SEASLUG = registerKey("seaslug");
    public static final ResourceKey<BiomeModifier> SEASTAR = registerKey("seastar");
    public static final ResourceKey<BiomeModifier> SEAHORSE = registerKey("seahorse");
    public static final ResourceKey<BiomeModifier> SEADRAGON = registerKey("seadragon");
    public static final ResourceKey<BiomeModifier> COLD_CRAB = registerKey("cold_crab");
    public static final ResourceKey<BiomeModifier> COLD_JELLY = registerKey("cold_jelly");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(BETTA, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.BETTA_ENTITY.get(),
                        4,
                        1,
                        1
                ))));

        context.register(SNAIL, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.FRESHWATER_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.SNAIL_ENTITY.get(),
                        4,
                        1,
                        3
                ))));

        context.register(KOI, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_RIVER),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(),
                        3,
                        1,
                        8
                ))));

        context.register(TETRA, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.FRESHWATER_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.TETRA_ENTITY.get(),
                        3,
                        1,
                        5
                ))));

        context.register(CHERRY_BARB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.FRESHWATER_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.CHERRYBARB_ENTITY.get(),
                        3,
                        1,
                        5
                ))));

        context.register(GOLDFISH, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.FRESHWATER_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.GOLDFISH_ENTITY.get(),
                        3,
                        1,
                        1
                ))));

        context.register(GUPPY, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.FRESHWATER_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.GUPPY_ENTITY.get(),
                        4,
                        1,
                        5
                ))));

        context.register(SILVER_SHARK, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_RIVER),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.SILVERSHARK_ENTITY.get(),
                        3,
                        1,
                        2
                ))));

        context.register(GHOST_SHRIMP, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.FRESHWATER_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.GHOSTSHRIMP_ENTITY.get(),
                        4,
                        1,
                        3
                ))));

        context.register(CRYSTAL_SHRIMP, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.FRESHWATER_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.CRYSTALSHRIMP_ENTITY.get(),
                        4,
                        1,
                        3
                ))));

        context.register(SNAKEHEAD, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_RIVER),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.SNAKEHEAD_ENTITY.get(),
                        3,
                        1,
                        2
                ))));

        context.register(PLECO, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.FRESHWATER_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.PLECO_ENTITY.get(),
                        3,
                        1,
                        2
                ))));

        context.register(SALAMANDER, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_RIVER),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.SALAMANDER_ENTITY.get(),
                        2,
                        1,
                        2
                ))));


        context.register(ISOPOD, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.ISOPOD_ENTITY.get(),
                        4,
                        1,
                        1
                ))));

        context.register(CRAB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.CRAB_ENTITY.get(),
                        4,
                        1,
                        1
                ))));

        context.register(JELLY, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.JELLY_ENTITY.get(),
                        2,
                        5,
                        10
                ))));

        context.register(GLAUCUS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.GLAUCUS_ENTITY.get(),
                        2,
                        1,
                        1
                ))));

        context.register(SEASLUG, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.SEASLUG_ENTITY.get(),
                        3,
                        1,
                        2
                ))));

        context.register(FILEFISH, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.FILEFISH_ENTITY.get(),
                        3,
                        1,
                        1
                ))));

        context.register(ANGELFISH, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.ANGELFISH_ENTITY.get(),
                        3,
                        1,
                        4
                ))));

        context.register(SEAHORSE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.SEAHORSE_ENTITY.get(),
                        3,
                        1,
                        2
                ))));

        context.register(CLOWNFISH, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.CLOWNFISH_ENTITY.get(),
                        4,
                        1,
                        4
                ))));

        context.register(SEASTAR, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.SEASTAR_ENTITY.get(),
                        3,
                        1,
                        3
                ))));

        context.register(SEADRAGON, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.SEADRAGON_ENTITY.get(),
                        3,
                        1,
                        1
                ))));

        context.register(PEACOCK_SHRIMP, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.LUKE_WARM_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.PEACOCKSHRIMP_ENTITY.get(),
                        1,
                        1,
                        1
                ))));

        context.register(COLD_JELLY, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.COLD_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.JELLY_ENTITY.get(),
                        2,
                        5,
                        10
                ))));

        context.register(COLD_CRAB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BettaTags.Biomes.COLD_OCEAN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(BettasMain.CRAB_ENTITY.get(),
                        3,
                        1,
                        2
                ))));

    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(BettasMain.MODID, name));
    }
}