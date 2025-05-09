package com.dragn.bettas.util;

import com.dragn.bettas.BettasMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;

public class BettaTags {

    public static class Items {

        public static final TagKey<Item> BETTA_FOOD = tag("betta_food");

        private static TagKey<Item> forgeTag (String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
        private static TagKey<Item> tag (String name) {
            return ItemTags.create(new ResourceLocation(BettasMain.MODID, name));
        }
    }

    public static class Biomes {

        public static final TagKey<Biome> LUKE_WARM_OCEAN_SPAWNS = tag("luke_warm_ocean_spawns");
        public static final TagKey<Biome> WARM_OCEAN_SPAWNS = tag("warm_ocean_spawns");
        public static final TagKey<Biome> LUKEWARM_OCEAN_SPAWNS = tag("lukewarm_ocean_spawns");
        public static final TagKey<Biome> COLD_OCEAN_SPAWNS = tag("cold_ocean_spawns");
        public static final TagKey<Biome> FRESHWATER_SPAWNS = tag("freshwater_spawns");

        public static TagKey<Biome> tag (String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(BettasMain.MODID, name));
        }
    }

}
