package ch.bbw.gamebbwoy.gameobjects.dwarfrun.gameobjects;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.gameobjects.dwarfrun.sprites.SpriteDrawer;

public class Dwarf implements PixelDrawing, ButtonListener {

    private final int[][] pixels;
    private double x;
    private double y;
    private double xOffset;
    private double yOffset;

    private double xVelocity;
    private final double MAX_POS_VELOCITY = 1.0;
    private final double MAX_NEG_VELOCITY = -1.0;
    private double xAcceleration;

    public Dwarf() {
        this.pixels = dwarf;
    }

    // Aufgabe: Mit pixelpad.ch ein Sprite zeichnen und darstellen.
    // Das ist ein Array: Wir lesen via `xxx[zeile][spalte]` aus.
    // Der Wert 4 ist ein leeres Pixel.
    int[][] dwarf = {
            {4, 4, 4, 2, 2, 2, 3, 4, 4, 4, 4, 4},
            {4, 4, 2, 2, 2, 3, 1, 1, 4, 4, 4, 4},
            {4, 2, 2, 2, 3, 1, 3, 1, 1, 4, 4, 4},
            {4, 2, 4, 3, 1, 1, 1, 1, 1, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 1, 1, 2, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 1, 1, 2, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 1, 1, 2, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 2, 1, 1, 1, 2, 4, 4, 4, 4},
            {4, 4, 2, 2, 4, 4, 4, 2, 2, 4, 4, 4},
            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
    };

    //Stehen
    int[][] standingDwarf = {
            {4, 4, 4, 2, 2, 2, 3, 4, 4, 4, 4, 4},
            {4, 4, 2, 2, 2, 3, 1, 1, 4, 4, 4, 4},
            {4, 2, 2, 2, 3, 1, 3, 1, 1, 4, 4, 4},
            {4, 2, 4, 3, 1, 1, 1, 1, 1, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 1, 1, 2, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 1, 1, 2, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 1, 1, 2, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 2, 1, 1, 1, 2, 4, 4, 4, 4},
            {4, 4, 2, 2, 4, 4, 4, 2, 2, 4, 4, 4},
            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
    };

    // Laufen 1
    int[][] runningDwarf1 = {
            {4, 4, 4, 2, 2, 2, 3, 4, 4, 4, 4, 4},
            {4, 2, 2, 2, 2, 3, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 2, 3, 1, 3, 1, 1, 4, 4, 4},
            {4, 4, 4, 3, 1, 1, 1, 1, 1, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 2, 4, 4},
            {4, 2, 2, 1, 1, 1, 1, 1, 1, 2, 4, 4},
            {4, 2, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 2, 1, 4, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 4, 4, 4, 4, 2, 2, 4, 4, 4},
            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
    };

    //Laufen 2
    int[][] runningDwarf2 = {
            {4, 4, 4, 2, 2, 2, 3, 4, 4, 4, 4, 4},
            {4, 4, 2, 2, 2, 3, 1, 1, 4, 4, 4, 4},
            {4, 2, 2, 2, 3, 1, 3, 1, 1, 4, 4, 4},
            {4, 4, 4, 3, 1, 1, 1, 1, 1, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 1, 1, 2, 4, 4, 4},
            {4, 4, 4, 2, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 1, 4, 4, 4, 4, 4},
            {4, 4, 4, 2, 4, 4, 2, 2, 4, 4, 4, 4},
            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
    };

    // Laufen 3
    int[][] runningDwarf3 = {
            {4, 4, 4, 2, 2, 2, 3, 4, 4, 4, 4, 4},
            {4, 4, 2, 2, 2, 3, 1, 1, 4, 4, 4, 4},
            {4, 2, 2, 2, 3, 1, 3, 1, 1, 4, 4, 4},
            {4, 2, 4, 3, 1, 1, 1, 1, 1, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 2, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 2, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 2, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 2, 1, 1, 1, 4, 4, 4, 4, 4},
            {4, 4, 4, 2, 2, 4, 2, 2, 4, 4, 4, 4},
            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
    };

    // Laufen 4
    int[][] runningDwarf4 = {
            {4, 4, 4, 2, 2, 2, 3, 4, 4, 4, 4, 4},
            {4, 4, 2, 2, 2, 3, 1, 1, 4, 4, 4, 4},
            {4, 2, 2, 2, 3, 1, 3, 1, 1, 4, 4, 4},
            {4, 4, 4, 3, 1, 1, 1, 1, 1, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 2, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 2, 2, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 1, 1, 2, 1, 4, 4, 4, 4, 4},
            {4, 4, 4, 2, 4, 2, 2, 4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
    };

    // Laufen 5
    int[][] runningDwarf5 = {
            {4, 4, 4, 2, 2, 2, 3, 4, 4, 4, 4, 4},
            {4, 2, 2, 2, 2, 3, 1, 1, 4, 4, 4, 4},
            {4, 2, 2, 2, 3, 1, 3, 1, 1, 4, 4, 4},
            {4, 4, 4, 3, 1, 1, 1, 1, 1, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 2, 1, 2, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 1, 2, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4},
            {4, 4, 2, 1, 1, 1, 2, 4, 4, 4, 4, 4},
            {4, 4, 2, 4, 4, 4, 2, 2, 4, 4, 4, 4},
            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
    };

    int frame = 0;
    int timer = 0;
    int[][][] dwarfFrames = {
            runningDwarf1,
            runningDwarf2,
            runningDwarf3,
            runningDwarf4,
            runningDwarf5,
            runningDwarf4,
            runningDwarf3,
            runningDwarf2
    };

    @Override
    public void initialize(PixelDisplay graphic) {
        // initialize x and y by the offset of the starting position --> put the dwarf at the bottom mid of the screen
        xOffset = (double) graphic.getPixelWidth() / 2;
        yOffset = (double) graphic.getPixelHeight() * 4 / 5;
        x = xOffset;
        y = yOffset;
    }

    @Override
    public void tick(PixelDisplay graphic) {
        if (xVelocity >= MAX_POS_VELOCITY && xAcceleration > 0) {
            xVelocity = MAX_POS_VELOCITY;
        } else if(xVelocity <= MAX_NEG_VELOCITY && xAcceleration < 0) {
            xVelocity = MAX_NEG_VELOCITY;
        } else {
            xVelocity += xAcceleration;
        }

        var nextX = x + xVelocity;
        if (nextX < 0) { // out of bound on the left
            xVelocity = 0;
            nextX = 0;
        } else if (graphic.getPixelWidth() < (int) (pixels[0].length + nextX)) { // out of bounds right
            xVelocity = 0;
            nextX = graphic.getPixelWidth() - pixels[0].length;
        }
        x = nextX;

        timer++;

        if (timer % 10 == 0) {
            frame++;
            graphic.clear(); // this clears the pixels from the last dwarfFrame
            if (frame >= dwarfFrames.length) {
                frame = 0;
            }
        }

        int[][] currentDwarf = dwarfFrames[frame];

        SpriteDrawer.drawSprite(graphic, currentDwarf, (int) x, (int) y);
    }

    @Override
    public void onButtonPress(ButtonListener.GameButton button) {
        System.out.println("down: " + button);
        move(button, true);
    }

    @Override
    public void onButtonRelease(ButtonListener.GameButton button) {
        System.out.println("up: " + button);
        move(button, false);
    }

    public void move(ButtonListener.GameButton button, boolean isDown) {
        switch (button) {
            case LEFT -> xAcceleration = isDown ? -0.10 : 0;
            case RIGHT -> xAcceleration = isDown ? 0.10 : 0;
            default -> {
            } // ignore the rest
        }
    }
}
