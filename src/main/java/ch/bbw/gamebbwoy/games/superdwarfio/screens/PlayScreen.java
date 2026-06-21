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

    public void update(PixelDisplay graphic) {
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

    public void onButtonPress(ButtonListener.GameButton button) {

    }
}
