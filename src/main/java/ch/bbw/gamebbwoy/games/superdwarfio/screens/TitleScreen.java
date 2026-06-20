package ch.bbw.gamebbwoy.games.superdwarfio.screens;

import ch.bbw.gamebbwoy.api.PixelDisplay;

public class TitleScreen {

    private int selectedMenuItem = 0;

    private String[] menuItems = {
            "START",
            "HIGHSCORE",
            "CHARACTER"
    };

    public void draw(PixelDisplay graphic) {
        PixelText.drawText(graphic, "DWARF RUN", 30, 10);

        for (int i = 0; i < menuItems.length; i++) {
            int y = 30 + i * 8;

            if (i == selectedMenuItem) {
                PixelText.drawText(graphic, ">", 20, y);
            }

            PixelText.drawText(graphic, menuItems[i], 30, y);
        }
    }

    public void moveSelectionUp() {
        selectedMenuItem--;

        if (selectedMenuItem < 0) {
            selectedMenuItem = menuItems.length - 1;
        }
    }

    public void moveSelectionDown() {
        selectedMenuItem++;

        if (selectedMenuItem >= menuItems.length) {
            selectedMenuItem = 0;
        }
    }

    public int getSelectedMenuItem() {
        return selectedMenuItem;
    }
}
