package old;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public enum BasePattern {
    CLASSIC(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/classic.png")),
    FADE(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/fade.png")),
    GALAXY_KOI(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/galaxykoi.png")),
    KOI(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/koi.png")),
    SAMURAI(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/samurai.png")),
    WHITE_PASTEL(new ResourceLocation(BettasMain.MODID, "textures/entity/betta/whitepastel.png"));

    public final ResourceLocation resourceLocation;

    BasePattern(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static BasePattern patternFromOrdinal(int pattern) {
        return BasePattern.values()[pattern % BasePattern.values().length];
    }
}