package ch.bbw.gamebbwoy.gameobjects.dwarfrun.world;

import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;

public class World {

    private static final int TILE_SIZE = 4;

    private static final int EMPTY = 0;
    private static final int GROUND = 1;

    private int[][] map = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public void draw(PixelDisplay graphic) {
        for (int tileY = 0; tileY < map.length; tileY++) {
            for (int tileX = 0; tileX < map[tileY].length; tileX++) {
                if (map[tileY][tileX] == GROUND) {
                    drawGroundTile(graphic, tileX * TILE_SIZE, tileY * TILE_SIZE);
                }
            }
        }
    }

    private void drawGroundTile(PixelDisplay graphic, int xOffset, int yOffset) {
        for (int y = 0; y < TILE_SIZE; y++) {
            for (int x = 0; x < TILE_SIZE; x++) {
                graphic.setPixel(xOffset + x, yOffset + y, PixelColor.BLACK);
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

        return map[tileY][tileX] == GROUND;
    }
}
