package ch.bbw.gamebbwoy.games.superdwarfio.screens;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.games.superdwarfio.gameobjects.Dwarfio;

public class PlayScreen {

    private boolean playing = false;
    private Dwarfio dwarfio = new Dwarfio();


    public void initialize(PixelDisplay graphic) {
        dwarfio.initialize(graphic);
        playing = true;
    }

    public void updateScreen(PixelDisplay graphic) {
        // clear graphic and redraw dwarfio with every tick.
        graphic.clear();
        dwarfio.tick(graphic);
    }


    public void drawPlayScreen(PixelDisplay graphic) {

    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void onButtonRelease(ButtonListener.GameButton button) {
        dwarfio.onButtonRelease(button);
    }

    public void onButtonPress(ButtonListener.GameButton button) {
        dwarfio.onButtonPress(button);
    }
}
