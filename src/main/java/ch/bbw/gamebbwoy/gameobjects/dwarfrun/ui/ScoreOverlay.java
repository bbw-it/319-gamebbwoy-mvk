package ch.bbw.gamebbwoy.gameobjects.dwarfrun.ui;

import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.gameobjects.dwarfrun.sprites.DigitSprites;
import ch.bbw.gamebbwoy.gameobjects.dwarfrun.gameobjects.Dwarf;

public class ScoreOverlay {

    public void draw(PixelDisplay graphic, Dwarf dwarf) {
        int score = dwarf.getScore();

        drawNumber(graphic, score, 120, 2);
    }

    private void drawNumber(PixelDisplay graphic, int number, int x, int y) {
        String text = String.valueOf(number);

        for (int i = 0; i < text.length(); i++) {
            char digit = text.charAt(i);
            drawDigit(graphic, digit, x + i * 4, y);
        }
    }

    private void drawDigit(PixelDisplay graphic, char digit, int xOffset, int yOffset) {
        int[][] sprite = DigitSprites.getDigit(digit);

        for (int y = 0; y < sprite.length; y++) {
            for (int x = 0; x < sprite[y].length; x++) {
                if (sprite[y][x] == 1) {
                    graphic.setPixel(xOffset + x, yOffset + y, PixelColor.BLACK);
                }
            }
        }
    }
}