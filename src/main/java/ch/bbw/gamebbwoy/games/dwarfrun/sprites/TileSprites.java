package ch.bbw.gamebbwoy.games.dwarfrun.sprites;

public class TileSprites {

    private TileSprites() {
    }

    public static final int[][] GROUND = {
            {3, 3, 3, 3},
            {2, 1, 2, 1},
            {1, 2, 1, 2},
            {3, 3, 3, 3}
    };

    public static final int[][] STONE = {
            {3, 3, 3, 3},
            {3, 2, 2, 3},
            {3, 2, 2, 3},
            {3, 3, 3, 3}
    };

    public static final int[][] EMPTY = {
            {4, 4, 4, 4},
            {4, 4, 4, 4},
            {4, 4, 4, 4},
            {4, 4, 4, 4}
    };
}