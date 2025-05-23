package old;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.util.BettasCommonConfig;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

import java.util.List;

public record BettaBiomeModifier(HolderSet<Biome> biomes) implements BiomeModifier {

    public static List<MobSpawnSettings.SpawnerData> OCEANS_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(BettasMain.ISOPOD_ENTITY.get(), BettasCommonConfig.ISOPOD_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.CRAB_ENTITY.get(), BettasCommonConfig.CRAB_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.JELLY_ENTITY.get(), BettasCommonConfig.JELLY_WEIGHT.get(), 5, 10),
            new MobSpawnSettings.SpawnerData(BettasMain.SEASLUG_ENTITY.get(), BettasCommonConfig.SEASLUG_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.SEASTAR_ENTITY.get(), BettasCommonConfig.SEASTAR_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.SEADRAGON_ENTITY.get(), BettasCommonConfig.SEADRAGON_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.PEACOCKSHRIMP_ENTITY.get(), BettasCommonConfig.PEACOCKSHRIMP_WEIGHT.get(), 1, 1)
    );

    public static List<MobSpawnSettings.SpawnerData> WARM_OCEANS_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(BettasMain.ISOPOD_ENTITY.get(), BettasCommonConfig.ISOPOD_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.CRAB_ENTITY.get(), BettasCommonConfig.CRAB_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.JELLY_ENTITY.get(), BettasCommonConfig.JELLY_WEIGHT.get(), 5, 10),
            new MobSpawnSettings.SpawnerData(BettasMain.GLAUCUS_ENTITY.get(), BettasCommonConfig.GLAUCUS_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.SEASLUG_ENTITY.get(), BettasCommonConfig.SEASLUG_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.FILEFISH_ENTITY.get(), BettasCommonConfig.FILEFISH_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.ANGELFISH_ENTITY.get(), BettasCommonConfig.ANGELFISH_WEIGHT.get(), 3, 5),
            new MobSpawnSettings.SpawnerData(BettasMain.SEAHORSE_ENTITY.get(), BettasCommonConfig.SEAHORSE_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.CLOWNFISH_ENTITY.get(), BettasCommonConfig.CLOWNFISH_WEIGHT.get(), 1, 4),
            new MobSpawnSettings.SpawnerData(BettasMain.SEASTAR_ENTITY.get(), BettasCommonConfig.SEASTAR_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.SEADRAGON_ENTITY.get(), BettasCommonConfig.SEADRAGON_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.PEACOCKSHRIMP_ENTITY.get(), BettasCommonConfig.PEACOCKSHRIMP_WEIGHT.get(), 1, 1)
    );

    public static List<MobSpawnSettings.SpawnerData> LUKEWARM_OCEANS_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(BettasMain.ISOPOD_ENTITY.get(), BettasCommonConfig.ISOPOD_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.CRAB_ENTITY.get(), BettasCommonConfig.CRAB_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.JELLY_ENTITY.get(), BettasCommonConfig.JELLY_WEIGHT.get(), 5, 10),
            new MobSpawnSettings.SpawnerData(BettasMain.GLAUCUS_ENTITY.get(), BettasCommonConfig.GLAUCUS_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.SEASLUG_ENTITY.get(), BettasCommonConfig.SEASLUG_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.FILEFISH_ENTITY.get(), BettasCommonConfig.FILEFISH_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.ANGELFISH_ENTITY.get(), BettasCommonConfig.ANGELFISH_WEIGHT.get(), 3, 5),
            new MobSpawnSettings.SpawnerData(BettasMain.SEAHORSE_ENTITY.get(), BettasCommonConfig.SEAHORSE_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.CLOWNFISH_ENTITY.get(), BettasCommonConfig.CLOWNFISH_WEIGHT.get(), 1, 4),
            new MobSpawnSettings.SpawnerData(BettasMain.SEASTAR_ENTITY.get(), BettasCommonConfig.SEASTAR_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.SEADRAGON_ENTITY.get(), BettasCommonConfig.SEADRAGON_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.PEACOCKSHRIMP_ENTITY.get(), BettasCommonConfig.PEACOCKSHRIMP_WEIGHT.get(), 1, 1)
    );

    public static List<MobSpawnSettings.SpawnerData> COLD_OCEAN_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(BettasMain.CRAB_ENTITY.get(), BettasCommonConfig.CRAB_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.JELLY_ENTITY.get(), BettasCommonConfig.JELLY_WEIGHT.get(), 5, 10)
    );

    public static List<MobSpawnSettings.SpawnerData> SWAMP_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(BettasMain.GHOSTSHRIMP_ENTITY.get(), BettasCommonConfig.GHOSTSHRIMP_WEIGHT.get(), 1, 3),
            new MobSpawnSettings.SpawnerData(BettasMain.ISOPOD_ENTITY.get(), BettasCommonConfig.ISOPOD_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.SNAKEHEAD_ENTITY.get(), BettasCommonConfig.SNAKEHEAD_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.SILVERSHARK_ENTITY.get(), BettasCommonConfig.SILVERSHARK_WEIGHT.get(), 1, 4),
            new MobSpawnSettings.SpawnerData(BettasMain.GUPPY_ENTITY.get(), BettasCommonConfig.GUPPY_WEIGHT.get(), 2, 4),
            new MobSpawnSettings.SpawnerData(BettasMain.GOLDFISH_ENTITY.get(), BettasCommonConfig.GOLDFISH_WEIGHT.get(), 1, 4),
            new MobSpawnSettings.SpawnerData(BettasMain.TETRA_ENTITY.get(), BettasCommonConfig.TETRA_WEIGHT.get(), 2, 6),
            new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(), BettasCommonConfig.KOI_WEIGHT.get(), 2, 6),
            new MobSpawnSettings.SpawnerData(BettasMain.BETTA_ENTITY.get(), BettasCommonConfig.BETTA_WEIGHT.get(), 3, 15),
            new MobSpawnSettings.SpawnerData(BettasMain.SNAIL_ENTITY.get(), BettasCommonConfig.SNAIL_WEIGHT.get(), 1, 5),
            new MobSpawnSettings.SpawnerData(BettasMain.CRYSTALSHRIMP_ENTITY.get(), BettasCommonConfig.CRYSTALSHRIMP_WEIGHT.get(), 1, 3),
            new MobSpawnSettings.SpawnerData(BettasMain.PLECO_ENTITY.get(), BettasCommonConfig.PLECO_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.SALAMANDER_ENTITY.get(), BettasCommonConfig.SALAMANDER_WEIGHT.get(), 1, 1)
    );

    public static List<MobSpawnSettings.SpawnerData> RIVER_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(BettasMain.GHOSTSHRIMP_ENTITY.get(), BettasCommonConfig.GHOSTSHRIMP_WEIGHT.get(), 1, 3),
            new MobSpawnSettings.SpawnerData(BettasMain.ISOPOD_ENTITY.get(), BettasCommonConfig.ISOPOD_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.SNAKEHEAD_ENTITY.get(), BettasCommonConfig.SNAKEHEAD_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.SILVERSHARK_ENTITY.get(), BettasCommonConfig.SILVERSHARK_WEIGHT.get(), 1, 4),
            new MobSpawnSettings.SpawnerData(BettasMain.GUPPY_ENTITY.get(), BettasCommonConfig.GUPPY_WEIGHT.get(), 2, 4),
            new MobSpawnSettings.SpawnerData(BettasMain.GOLDFISH_ENTITY.get(), BettasCommonConfig.GOLDFISH_WEIGHT.get(), 1, 4),
            new MobSpawnSettings.SpawnerData(BettasMain.CHERRYBARB_ENTITY.get(), BettasCommonConfig.CHERRYBARB_WEIGHT.get(), 2, 6),
            new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(), BettasCommonConfig.KOI_WEIGHT.get(), 2, 6),
            new MobSpawnSettings.SpawnerData(BettasMain.CRYSTALSHRIMP_ENTITY.get(), BettasCommonConfig.CRYSTALSHRIMP_WEIGHT.get(), 1, 3),
            new MobSpawnSettings.SpawnerData(BettasMain.PLECO_ENTITY.get(), BettasCommonConfig.PLECO_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.SALAMANDER_ENTITY.get(), BettasCommonConfig.SALAMANDER_WEIGHT.get(), 1, 1)
    );

    public static List<MobSpawnSettings.SpawnerData> PLAINS_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(BettasMain.CHERRYBARB_ENTITY.get(), BettasCommonConfig.CHERRYBARB_WEIGHT.get(), 1, 3),
            new MobSpawnSettings.SpawnerData(BettasMain.GOLDFISH_ENTITY.get(), BettasCommonConfig.GOLDFISH_WEIGHT.get(), 1, 4),
            new MobSpawnSettings.SpawnerData(BettasMain.TETRA_ENTITY.get(), BettasCommonConfig.TETRA_WEIGHT.get(), 2, 6),
            new MobSpawnSettings.SpawnerData(BettasMain.SNAIL_ENTITY.get(), BettasCommonConfig.SNAIL_WEIGHT.get(), 1, 5),
            new MobSpawnSettings.SpawnerData(BettasMain.SALAMANDER_ENTITY.get(), BettasCommonConfig.SALAMANDER_WEIGHT.get(), 1, 1)
    );

    public static List<MobSpawnSettings.SpawnerData> LUSH_CAVES_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(BettasMain.ISOPOD_ENTITY.get(), BettasCommonConfig.ISOPOD_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.GHOSTSHRIMP_ENTITY.get(), BettasCommonConfig.GOLDFISH_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.SNAIL_ENTITY.get(), BettasCommonConfig.SNAIL_WEIGHT.get(), 1, 5),
            new MobSpawnSettings.SpawnerData(BettasMain.SALAMANDER_ENTITY.get(), BettasCommonConfig.SALAMANDER_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.SNAKEHEAD_ENTITY.get(), BettasCommonConfig.SNAKEHEAD_WEIGHT.get(), 1, 1)
    );

    public static List<MobSpawnSettings.SpawnerData> JUNGLE_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(BettasMain.GOLDFISH_ENTITY.get(), BettasCommonConfig.GOLDFISH_WEIGHT.get(), 1, 4),
            new MobSpawnSettings.SpawnerData(BettasMain.SALAMANDER_ENTITY.get(), BettasCommonConfig.SALAMANDER_WEIGHT.get(), 1, 1),
            new MobSpawnSettings.SpawnerData(BettasMain.SNAIL_ENTITY.get(), BettasCommonConfig.SNAIL_WEIGHT.get(), 1, 5)
    );

    public static List<MobSpawnSettings.SpawnerData> BEACH_SPAWNS = List.of(
            new MobSpawnSettings.SpawnerData(BettasMain.GLAUCUS_ENTITY.get(), BettasCommonConfig.GLAUCUS_WEIGHT.get(), 1, 2),
            new MobSpawnSettings.SpawnerData(BettasMain.SEASTAR_ENTITY.get(), BettasCommonConfig.SEASTAR_WEIGHT.get(), 1, 2)
    );


    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if(phase == Phase.ADD && biomes.contains(biome)) {
            List<MobSpawnSettings.SpawnerData> spawner = builder.getMobSpawnSettings().getSpawner(MobCategory.WATER_AMBIENT);

            if(biome.is(Biomes.OCEAN) || biome.is(Biomes.DEEP_OCEAN)) {
                spawner.addAll(OCEANS_SPAWNS);

            } else if(biome.is(Biomes.WARM_OCEAN)) {
                spawner.addAll(WARM_OCEANS_SPAWNS);

            } else if(biome.is(Biomes.LUKEWARM_OCEAN) || biome.is(Biomes.DEEP_LUKEWARM_OCEAN)) {
                spawner.addAll(LUKEWARM_OCEANS_SPAWNS);

            } else if(biome.is(Biomes.COLD_OCEAN) || biome.is(Biomes.DEEP_COLD_OCEAN)) {
                spawner.addAll(COLD_OCEAN_SPAWNS);

            } else if(biome.is(Biomes.RIVER)) {
                spawner.addAll(RIVER_SPAWNS);

            } else if(biome.is(Biomes.SWAMP) || biome.is(Biomes.MANGROVE_SWAMP)) {
                spawner.addAll(SWAMP_SPAWNS);

            } else if(biome.is(Biomes.PLAINS) || biome.is(Biomes.SAVANNA)) {
                spawner.addAll(PLAINS_SPAWNS);

            } else if(biome.is(Biomes.LUSH_CAVES)) {
                spawner.addAll(LUSH_CAVES_SPAWNS);

            } else if(biome.is(Biomes.JUNGLE) || biome.is(Biomes.SPARSE_JUNGLE)) {
                spawner.addAll(JUNGLE_SPAWNS);

            } else if(biome.is(Biomes.BEACH)) {
                spawner.addAll(BEACH_SPAWNS);

            }
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return BettasMain.BETTA_CODEC.get();
    }
}
