package ch.bbw.gamebbwoy.games.bricks;

import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;

import java.util.List;

public class Ball implements PixelDrawing {
    private final List<Integer> pixels;
    private final int width;
    private final int height;
    private double x;
    private double y;

    public Ball(List<Integer> pixels, int width, int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
        if (width * height != pixels.size()) {
            throw new IllegalArgumentException("pixel size does not match provided width/height");
        }
    }
    public static Ball create() {
        return new Ball(List.of(
                //width and height are mirrored diagonally.
                3, 3, 3,
                3, 0, 3,
                3, 3, 3), 3, 3);
    }
    @Override
    public void tick(PixelDisplay graphic) {
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                var color = pixels.get(h + w * height);
                graphic.setPixel(w + (int) x, h + (int) y, PixelColor.fromValue(color));
            }
        }
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
}
