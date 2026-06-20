package ch.bbw.gamebbwoy.gameobjects.dwarfrun.ui;

import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.gameobjects.dwarfrun.gameobjects.Dwarf;
import ch.bbw.gamebbwoy.gameobjects.dwarfrun.sprites.PixelText;

public class ScoreOverlay {

    public void draw(PixelDisplay graphic, Dwarf dwarf) {
        int score = dwarf.getScore();

        PixelText.drawText(graphic, "SCORE 120", 80, 2);
        drawNumber(graphic, score, 120, 2);
    }

    private void drawNumber(PixelDisplay graphic, int number, int x, int y) {
        String text = String.valueOf(number);

        for (int i = 0; i < text.length(); i++) {
            String digit = text.substring(i, i+1);
            PixelText.drawText(graphic, digit, x+i*4, y);
        }
    }
}