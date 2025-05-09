package old;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.util.Arrays;


/* MOVED FROM BETTA ENTITY BECAUSE DYNAMIC TEXTURE CAN NOT BE ON SERVER DIST */
public class TextureGen {
    public static ResourceLocation generateTexture(BasePattern basePattern, int[] map) {
        try {
            return Minecraft.getInstance().textureManager.register(String.valueOf(Arrays.hashCode(map)), new DynamicTexture(NativeImage.read(
                    Minecraft.getInstance().getResourceManager().getResource(basePattern.resourceLocation).get().open()
            )) {
                @Override
                public void upload() {
                    this.bind();
                    for (int x = 0; x < getPixels().getWidth(); x++) {
                        for (int y = 0; y < getPixels().getHeight(); y++) {
                            switch (getPixels().getPixelRGBA(x, y)) {
                                //region 1
                                case 0xff000000 -> getPixels().setPixelRGBA(x, y, map[0]);
                                case 0xff050505 -> getPixels().setPixelRGBA(x, y, map[1]);
                                case 0xff0b0b0b -> getPixels().setPixelRGBA(x, y, map[2]);
                                case 0xff131313 -> getPixels().setPixelRGBA(x, y, map[3]);

                                //region 2
                                case 0xff5d5d5d -> getPixels().setPixelRGBA(x, y, map[4]);
                                case 0xff727272 -> getPixels().setPixelRGBA(x, y, map[5]);
                                case 0xff848484 -> getPixels().setPixelRGBA(x, y, map[6]);
                                case 0xff949494 -> getPixels().setPixelRGBA(x, y, map[7]);

                            }
                        }
                    }
                    getPixels().upload(0, 0, 0, false);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
