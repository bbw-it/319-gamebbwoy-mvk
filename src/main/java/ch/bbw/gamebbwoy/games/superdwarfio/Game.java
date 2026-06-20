package ch.bbw.gamebbwoy.games.superdwarfio;

import ch.bbw.gamebbwoy.games.superdwarfio.gameobjects.Dwarfio;
import ch.bbw.gamebbwoy.games.superdwarfio.screens.PlayScreen;
import ch.bbw.gamebbwoy.games.superdwarfio.screens.TitleScreen;
import ch.bbw.gamebbwoy.internal.GameBbwoy;

public class Game {

    private TitleScreen titleScreen = new TitleScreen();
    private PlayScreen playScreen = new PlayScreen();

    public static void main(String[] args) throws Throwable {
        GameBbwoy.playGame(new Dwarfio());
    }
}
