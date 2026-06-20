package ch.bbw.gamebbwoy.games.dwarfrun.screens;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;

public interface GameScreen {

    void update();

    void draw(PixelDisplay graphic);

    void onButtonPress(ButtonListener.GameButton button);

    void onButtonRelease(ButtonListener.GameButton button);
}