package old;

import com.dragn.bettas.BettasMain;

public enum Palette {

    REDS(
            new int[]{0xf1524f, 0xff3f3f, 0xea7676},
            new int[]{0xc90000, 0xc73131, 0xb15959},
            new int[]{0x990000, 0x952424, 0x7c3f3f},
            new int[]{0x690000, 0x621717, 0x522a2a}
    ),

//    BLUES(
//            new int[]{0xff86a9f3, 0xffafc4f2, 0xff618fef, 0xff457ef4, 0xff2164f1},
//            new int[]{0xff7493d4, 0xff557ed3, 0xff3668d2, 0xff1d56d0, 0xff0043cf},
//            new int[]{0xff8594b7, 0xff657fba, 0xff4c6ebb, 0xff2855bb, 0xff033bbb},
//            new int[]{0xff717fa1, 0xff556c9f, 0xff365497, 0xff194096, 0xff002c8d}
//    ),
    ;

//    ORANGES(
//            new int[]{0xff008cff, 0xff005dff, 0xff003fbb, 0xff557dff, 0xff002785, 0xff005298, 0xff0047e6, 0xff0046bc, 0xff0085ff, 0xff001d82},
//            new int[]{0xff007ae3, 0xff005dd9, 0xff003d9b, 0xff556ce6, 0xff001d6f, 0xff003884, 0xff002c76, 0xff003db1, 0xff0067ce, 0xff001370}
//    ),
//
//    YELLOWS(
//            new int[]{0xff008cff, 0xff005dff, 0xff003fbb, 0xff557dff, 0xff002785, 0xff005298, 0xff0047e6, 0xff0046bc, 0xff0085ff, 0xff001d82},
//            new int[]{0xff007ae3, 0xff005dd9, 0xff003d9b, 0xff556ce6, 0xff001d6f, 0xff003884, 0xff002c76, 0xff003db1, 0xff0067ce, 0xff001370}
//    ),
//
//    GREENS(
//            new int[]{0xff6cb700, 0xffa0d200, 0xff5ab700, 0xff49b84f, 0xff67b38a, 0xff9dcc6f, 0xcc91ff54, 0xff82c354, 0xff71b400, 0xff7fb300},
//            new int[]{0xff589c00, 0xff89b700, 0xff49a500, 0xff3c9c38, 0xff55996f, 0xff88bc6f, 0xff82d254, 0xff71ad54, 0xff63a200, 0xff679500}
//    ),
//
//    BLUES(
//            new int[]{0xffdc0004, 0xddc81b04, 0xdda63504, 0xdd81351f, 0xff58351f, 0xff952215, 0xff7a3a15, 0xffca7615, 0xffaf6c15, 0xff946200},
//            new int[]{0xffc80004, 0xdda61b04, 0xdd813504, 0xdd62351f, 0xff3d2214, 0xff7a2215, 0xff532e15, 0xffaf6c15, 0xffaf8415, 0xff765b00}
//    ),
//
//    PURPLES(
//            new int[]{0xb2430045, 0x66430045, 0xd8430038, 0xe5430060},
//            new int[]{0xcc430045, 0x8c430045, 0xe5430038, 0xf2390054}
//    ),
//
//    PINKS(
//            new int[]{0xcc9128eb, 0xccb47cd6, 0xcc915eff, 0xcc7d27dc, 0xcc885bd0},
//            new int[]{0xcc5417bd, 0xcc915ec2, 0xcc7d5ec2, 0xcc6127b4, 0xcc724aac}
//    ),
//
//    GREYS(
//            new int[]{0xff363637, 0xffecedeb, 0xd3000000, 0xa5000000, 0xa000000},
//            new int[]{0xff202223, 0xffcfcfce, 0xe5000000, 0xc6000000, 0x23000000}
//    );

    private final int[] highlights;
    private final int[] colors;
    private final int[] light_shades;
    private final int[] heavy_shades;

    Palette(int[] highlights, int[] colors, int[] light_shades, int[] heavy_shades) {
        this.highlights = highlights;
        this.colors = colors;
        this.light_shades = light_shades;
        this.heavy_shades = heavy_shades;
    }

    public static Palette getRandomPalette() {
        return Palette.values()[BettasMain.RANDOM.nextInt(Palette.values().length)];
    }

    public int getRandomHighlight() {
        return highlights[BettasMain.RANDOM.nextInt(highlights.length)];
    }

    public int getRandomColor() {
        return colors[BettasMain.RANDOM.nextInt(colors.length)];
    }

    public int getRandomLightShade() {
        return light_shades[BettasMain.RANDOM.nextInt(light_shades.length)];
    }

    public int getRandomHeavyShade() {
        return heavy_shades[BettasMain.RANDOM.nextInt(heavy_shades.length)];
    }
}