package ch.bbw.gamebbwoy.games.superdwarfio.gameobjects;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.games.superdwarfio.sprites.DwarfioSprites;

public class Dwarfio implements PixelDrawing, ButtonListener {

    int x = 0;
    int y = 0;

    int frame = 0;
    int timer = 0;

    int[][][] dwarfFrames = {
            DwarfioSprites.runningDwarf1,
            DwarfioSprites.runningDwarf2,
            DwarfioSprites.runningDwarf3,
            DwarfioSprites.runningDwarf4,
            DwarfioSprites.runningDwarf5,
            DwarfioSprites.runningDwarf4,
            DwarfioSprites.runningDwarf3,
            DwarfioSprites.runningDwarf2
    };

    @Override
    public void initialize(PixelDisplay graphic) {
        x = graphic.getPixelWidth() * 1 / 4;
        y = graphic.getPixelHeight() * 4 / 5;
    }

    @Override
    public void tick(PixelDisplay graphic) {

        timer++;

        if (timer % 10 == 0) {
            frame++;
            graphic.clear();
            if (frame >= dwarfFrames.length) {
                frame = 0;
            }
        }

        int[][] currentDwarf = dwarfFrames[frame];

        drawSprite(graphic, currentDwarf, x, y);

    }

    private void drawSprite(PixelDisplay graphic, int[][] sprite, int xOffset, int yOffset) {
        for (int y = 0; y < sprite.length; y++) {
            for (int x = 0; x < sprite[y].length; x++) {
                var colorNumber = sprite[y][x];
                if (colorNumber == 4) {
                    continue;
                }
                var color = PixelColor.fromValue(colorNumber);
                graphic.setPixel(x + xOffset, y + yOffset, color);
            }
        }
    }

    @Override
    public void onButtonPress(GameButton button) {

    }

    @Override
    public void onButtonRelease(GameButton button) {

    }
}
