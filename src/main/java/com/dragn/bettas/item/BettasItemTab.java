package com.dragn.bettas.item;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.decor.Decor;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BettasItemTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BettasMain.MODID);

    public static final RegistryObject<CreativeModeTab> BETTAS_TAB = CREATIVE_MODE_TABS.register("betta_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BettasMain.BETTA_BUCKET.get())).title(Component.translatable("itemGroup.betta_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(BettasMain.BETTA_SPAWN_EGG.get());
                        output.accept(BettasMain.SNAIL_SPAWN_EGG.get());
                        output.accept(BettasMain.KOI_SPAWN_EGG.get());
                        output.accept(BettasMain.TETRA_SPAWN_EGG.get());
                        output.accept(BettasMain.CHERRYBARB_SPAWN_EGG.get());
                        output.accept(BettasMain.GOLDFISH_SPAWN_EGG.get());
                        output.accept(BettasMain.GUPPY_SPAWN_EGG.get());
                        output.accept(BettasMain.SILVERSHARK_SPAWN_EGG.get());
                        output.accept(BettasMain.GHOSTSHRIMP_SPAWN_EGG.get());
                        output.accept(BettasMain.ISOPOD_SPAWN_EGG.get());
                        output.accept(BettasMain.SNAKEHEAD_SPAWN_EGG.get());
                        output.accept(BettasMain.GLOWFISH_SPAWN_EGG.get());
                        output.accept(BettasMain.SEAHORSE_SPAWN_EGG.get());
                        output.accept(BettasMain.CLOWNFISH_SPAWN_EGG.get());
                        output.accept(BettasMain.SEASTAR_ITEM.get());
                        output.accept(BettasMain.ANGELFISH_SPAWN_EGG.get());
                        output.accept(BettasMain.FILEFISH_SPAWN_EGG.get());
                        output.accept(BettasMain.SEASLUG_SPAWN_EGG.get());
                        output.accept(BettasMain.GLAUCUS_SPAWN_EGG.get());
                        output.accept(BettasMain.JELLY_SPAWN_EGG.get());
                        output.accept(BettasMain.CRAB_SPAWN_EGG.get());

                        output.accept(BettasMain.BETTA_SPAWN_EGG.get());
                        output.accept(BettasMain.SNAIL_BUCKET.get());
                        output.accept(BettasMain.KOI_BUCKET.get());
                        output.accept(BettasMain.TETRA_BUCKET.get());
                        output.accept(BettasMain.CHERRYBARB_BUCKET.get());
                        output.accept(BettasMain.GOLDFISH_BUCKET.get());
                        output.accept(BettasMain.GUPPY_BUCKET.get());
                        output.accept(BettasMain.SILVERSHARK_BUCKET.get());
                        output.accept(BettasMain.GHOSTSHRIMP_BUCKET.get());
                        output.accept(BettasMain.ISOPOD_BUCKET.get());
                        output.accept(BettasMain.SNAKEHEAD_BUCKET.get());
                        output.accept(BettasMain.GLOWFISH_BUCKET.get());
                        output.accept(BettasMain.SEAHORSE_BUCKET.get());
                        output.accept(BettasMain.CLOWNFISH_BUCKET.get());
                        output.accept(BettasMain.ANGELFISH_BUCKET.get());
                        output.accept(BettasMain.FILEFISH_BUCKET.get());
                        output.accept(BettasMain.SEASLUG_BUCKET.get());
                        output.accept(BettasMain.GLAUCUS_BUCKET.get());
                        output.accept(BettasMain.JELLY_BUCKET.get());
                        output.accept(BettasMain.CRAB_BUCKET.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> TANK_TAB = CREATIVE_MODE_TABS.register("tank_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BettasMain.BETTA_BUCKET.get())).title(Component.translatable("itemGroup.tank_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(BettasMain.TANK.get());
                        output.accept(BettasMain.ALGAE_SCRAPER.get());
                        output.accept(BettasMain.ALLROUND.get());
                        output.accept(Decor.);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
