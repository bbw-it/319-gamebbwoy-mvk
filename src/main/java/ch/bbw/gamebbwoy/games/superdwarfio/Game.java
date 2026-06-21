package ch.bbw.gamebbwoy.games.superdwarfio;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.games.superdwarfio.screens.PlayScreen;
import ch.bbw.gamebbwoy.games.superdwarfio.screens.TitleScreen;
import ch.bbw.gamebbwoy.internal.GameBbwoy;

public class Game implements PixelDrawing, ButtonListener {

    private TitleScreen titleScreen = new TitleScreen();
    private PlayScreen playScreen = new PlayScreen();

    public static void main(String[] args) throws Throwable {
        GameBbwoy.playGame(new Game());
    }

    @Override
    public void initialize(PixelDisplay graphic) {
        titleScreen.drawTitleScreen(graphic);
    }

    @Override
    public void tick(PixelDisplay graphic) {
        if (!playScreen.isPlaying()) {
            // while title screen is shown
            if (!titleScreen.isSelectedMenuItem()) {
                titleScreen.update(graphic);
            } else if (titleScreen.isSelectedMenuItem() && titleScreen.getMenuItemPosition() == 0) {
                graphic.clear();
                playScreen.initialize(graphic);
            }
        } else {
            // while play screen is shown
            playScreen.update(graphic);
        }
    }

    @Override
    public void onButtonRelease(GameButton button) {
        if (!playScreen.isPlaying()) {
            // while title screen is shown
            // something like titleScreen.onButtonRelease(button); could be useful later

        } else {
            // while play screen is shown
            // something like playScreen.onButtonRelease(button); could be useful later
        }
    }

    @Override
    public void onButtonPress(GameButton button) {
        if (!playScreen.isPlaying()) {
            // while title screen is shown
            if (button == GameButton.UP) {
                titleScreen.moveSelectionUp();
            }

            if (button == GameButton.DOWN) {
                titleScreen.moveSelectionDown();
            }

            if (button == GameButton.SPACE) {
                // this if can be deleted after every screen is implemented. screen.setSelectedMenuItem(true) is enough.
                if (titleScreen.getMenuItemPosition() == 0) {
                    titleScreen.setSelectedMenuItem(true);
                }
            }
        } else {
            // while play screen is shown
            playScreen.onButtonPress(button);
        }
    }
}
