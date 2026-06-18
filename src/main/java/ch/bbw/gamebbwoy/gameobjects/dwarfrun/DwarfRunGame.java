package ch.bbw.gamebbwoy.gameobjects.dwarfrun;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.gameobjects.dwarfrun.screens.GameScreen;
import ch.bbw.gamebbwoy.gameobjects.dwarfrun.screens.PlayScreen;
import ch.bbw.gamebbwoy.gameobjects.dwarfrun.screens.TitleScreen;

public class DwarfRunGame implements PixelDrawing, ButtonListener {

    private GameScreen currentScreen;

    private TitleScreen titleScreen;
    private PlayScreen playScreen;

    public DwarfRunGame() {
        titleScreen = new TitleScreen();
        playScreen = new PlayScreen();

        currentScreen = titleScreen;
    }

    @Override
    public void initialize(PixelDisplay graphic) {
    }

    @Override
    public void tick(PixelDisplay graphic) {
        graphic.clear();

        currentScreen.update();
        currentScreen.draw(graphic);
    }

    @Override
    public void onButtonPress(GameButton button) {
        currentScreen.onButtonPress(button);

        if (currentScreen == titleScreen && button == GameButton.SPACE) {
            currentScreen = playScreen;
        }
    }

    @Override
    public void onButtonRelease(GameButton button) {
        currentScreen.onButtonRelease(button);
    }
}