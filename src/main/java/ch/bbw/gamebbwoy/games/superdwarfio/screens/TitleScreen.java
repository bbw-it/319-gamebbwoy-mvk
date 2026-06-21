package ch.bbw.gamebbwoy.games.superdwarfio.screens;

import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.games.superdwarfio.sprites.LetterNumberAndSymbolSprites;

public class TitleScreen {
    private boolean selectedMenuItem = false;
    private int menuItemPosition = 0;
    private boolean updated = false;
    private final String TITLE = "DWARFIO";

    private MenuItems[] menuItems = MenuItems.values();

    public void drawTitleScreen(PixelDisplay graphic) {
        drawTitle(graphic, TITLE);
        drawMenuItems(graphic);
    }

    private void drawTitle(PixelDisplay graphic, String title) {
        String upper_title = title.toUpperCase();
        // x position of the title should be in the middle of the screen --> / 2
        // to correct the position we subtract the title length times the width of a pixel character
        int xOffset = graphic.getPixelWidth() / 2 - (title.length() * 3);
        // This y position is only an estimate, so it appears somewhere around the middle position.
        int yOffset = graphic.getPixelHeight() * 1 / 4;

        LetterNumberAndSymbolSprites.drawText(graphic, upper_title, xOffset, yOffset);
    }

    private void drawMenuItems(PixelDisplay graphic) {
        for (int i = 0; i < menuItems.length; i++) {
            // This x offset is just an estimate, of what could look good.
            int xOffset = graphic.getPixelWidth() / 2;
            // The first menu item should appear 8 pixels below the title.
            // Every other menu item should appear 8 pixels below the one before.
            int yOffset = graphic.getPixelHeight() * 1 / 4 + 8 + (i * 8);

            if (i == menuItemPosition) {
                // -10 pixels for the xOffset so the > symbol appears slightly to the left of the menu item
                LetterNumberAndSymbolSprites.drawText(graphic, ">", xOffset - 10, yOffset);
            }

            LetterNumberAndSymbolSprites.drawText(graphic, String.valueOf(menuItems[i]), xOffset, yOffset);
        }
    }

    public void moveSelectionUp() {
        menuItemPosition--;
        if (menuItemPosition < 0) {
            menuItemPosition = menuItems.length - 1;
        }
        updated = true;
    }

    public void moveSelectionDown() {
        menuItemPosition++;
        if (menuItemPosition >= menuItems.length) {
            menuItemPosition = 0;
        }
        updated = true;
    }

    public int getMenuItemPosition() {
        return menuItemPosition;
    }

    public boolean isSelectedMenuItem() {
        return selectedMenuItem;
    }

    public void setSelectedMenuItem(boolean selectedMenuItem) {
        this.selectedMenuItem = selectedMenuItem;
    }

    public void update(PixelDisplay graphic) {
        if (updated) {
            updated = false;
            graphic.clear();
            drawTitleScreen(graphic);
        }
    }
}
