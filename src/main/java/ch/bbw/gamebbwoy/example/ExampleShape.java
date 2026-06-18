package ch.bbw.gamebbwoy.example;

import java.util.List;

public class ExampleShape {

    private final List<Integer> pixels;
    private final int width;
    private final int height;

    public ExampleShape(List<Integer> pixels, int width, int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
    }

    public static ExampleShape ball() {
        // Note only valid PixelColor values are used here
        return new ExampleShape(List.of(0, 3, 3, 3, 0,
                3, 1, 1, 1, 3,
                3, 1, 1, 1, 3,
                3, 1, 1, 1, 3,
                0, 3, 3, 3, 0), 5, 5);
    }

    public static ExampleShape square() {
        // Note only valid PixelColor values are used here
        return new ExampleShape(List.of(3, 3, 3, 3, 3, 3,
                3, 1, 1, 1, 1, 3,
                3, 1, 1, 1, 1, 3,
                3, 1, 1, 1, 1, 3,
                3, 1, 1, 1, 1, 3,
                3, 3, 3, 3, 3, 3), 6, 6);
    }

    public static ExampleShape rectangle() {
        // Note only valid PixelColor values are used here
        return new ExampleShape(List.of(3, 3, 3, 3, 3, 3,
                3, 1, 1, 1, 1, 3,
                3, 1, 1, 1, 1, 3,
                3, 3, 3, 3, 3, 3), 4, 6);
    }

    public List<Integer> getPixels() {
        return this.pixels;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
