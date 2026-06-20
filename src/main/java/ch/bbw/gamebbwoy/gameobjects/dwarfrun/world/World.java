package ch.bbw.gamebbwoy.gameobjects.dwarfrun.world;

import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.gameobjects.dwarfrun.sprites.SpriteDrawer;
import ch.bbw.gamebbwoy.gameobjects.dwarfrun.sprites.TileSprites;

public class World {

    private static final int TILE_SIZE = 4;

    private static final int EMPTY = 0;
    private static final int GROUND = 1;
    private static final int STONE = 2;

    private int[][] map = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public void draw(PixelDisplay graphic) {
        for (int tileY = 0; tileY < map.length; tileY++) {
            for (int tileX = 0; tileX < map[tileY].length; tileX++) {
                int tile = map[tileY][tileX];

                int pixelX = tileX * TILE_SIZE;
                int pixelY = tileY * TILE_SIZE;

                if (tile == GROUND) {
                    SpriteDrawer.drawSprite(graphic, TileSprites.GROUND, pixelX, pixelY);
                }

                if (tile == STONE) {
                    SpriteDrawer.drawSprite(graphic, TileSprites.STONE, pixelX, pixelY);
                }
            }
        }
    }

    public boolean isSolidPixel(int pixelX, int pixelY) {
        if (pixelX < 0 || pixelY < 0) {
            return false;
        }

        int tileX = pixelX / TILE_SIZE;
        int tileY = pixelY / TILE_SIZE;

        if (tileY < 0 || tileY >= map.length) {
            return false;
        }

        if (tileX < 0 || tileX >= map[tileY].length) {
            return false;
        }

        return map[tileY][tileX] == GROUND || map[tileY][tileX] == STONE;
    }
}