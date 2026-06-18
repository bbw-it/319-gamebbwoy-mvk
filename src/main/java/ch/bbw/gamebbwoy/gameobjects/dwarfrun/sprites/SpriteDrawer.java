package ch.bbw.gamebbwoy.gameobjects.dwarfrun.sprites;

import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;

public class SpriteDrawer {

    private SpriteDrawer() {
    }

    public static void drawSprite(PixelDisplay graphic, int[][] sprite, int xOffset, int yOffset) {
        for (int y = 0; y < sprite.length; y++) {
            for (int x = 0; x < sprite[y].length; x++) {
                int colorNumber = sprite[y][x];

                if (colorNumber == 4) {
                    continue;
                }

                PixelColor color = PixelColor.fromValue(colorNumber);
                graphic.setPixel(x + xOffset, y + yOffset, color);
            }
        }
    }
}
