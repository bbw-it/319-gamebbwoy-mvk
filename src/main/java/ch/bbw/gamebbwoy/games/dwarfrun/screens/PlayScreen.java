package ch.bbw.gamebbwoy.games.dwarfrun.screens;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.games.dwarfrun.gameobjects.Dwarf;
import ch.bbw.gamebbwoy.games.dwarfrun.world.World;
import ch.bbw.gamebbwoy.games.dwarfrun.ui.ScoreOverlay;

public class PlayScreen implements GameScreen {

    private World world = new World();
    private Dwarf dwarf = new Dwarf();
    private ScoreOverlay scoreOverlay = new ScoreOverlay();

    @Override
    public void update() {
        dwarf.update(world);
    }

    @Override
    public void draw(PixelDisplay graphic) {
        world.draw(graphic);
        dwarf.draw(graphic);
        scoreOverlay.draw(graphic, dwarf);
    }

    @Override
    public void onButtonPress(ButtonListener.GameButton button) {
        dwarf.onButtonPress(button);
    }

    @Override
    public void onButtonRelease(ButtonListener.GameButton button) {
        dwarf.onButtonRelease(button);
    }
}
