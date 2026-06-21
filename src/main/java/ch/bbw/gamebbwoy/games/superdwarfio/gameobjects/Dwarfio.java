package ch.bbw.gamebbwoy.games.superdwarfio.gameobjects;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.games.superdwarfio.sprites.DwarfioSprites;

public class Dwarfio implements PixelDrawing, ButtonListener {

    private int[][] dwarfioFrame;
    double x;
    double y;

    private double xOffset;
    private double yOffset;

    private double xVelocity;
    private static final double ACCELERATION = 0.05;
    // Only values between 0 and 1 make sense. Lower value means more friction.
    private static final double FRICTION = 0.80;
    private static final double MAX_SPEED = 2.5;

    private boolean leftPressed = false;
    private boolean rightPressed = false;

    int frame = 0;
    int timer = 0;

    @Override
    public void initialize(PixelDisplay graphic) {
        // initialize x and y by the offset of the starting position --> put the dwarf at the bottom left of the screen
        dwarfioFrame = DwarfioSprites.STANDING_DWARFIO;
        xOffset = graphic.getPixelWidth() * 1 / 4;
        yOffset = graphic.getPixelHeight() * 4 / 5;
        x = xOffset;
        y = yOffset;
    }

    private void updateHorizontalMovement(PixelDisplay graphic) {
        if (leftPressed) {
            xVelocity -= ACCELERATION;
        }
        if (rightPressed) {
            xVelocity += ACCELERATION;
        }

        if (xVelocity > MAX_SPEED) {
            xVelocity = MAX_SPEED;
        }
        if (xVelocity < -MAX_SPEED) {
            xVelocity = -MAX_SPEED;
        }

        x += xVelocity;
        if (x < 0) {
            x = 0;
        }
        if (x > graphic.getPixelWidth() - DwarfioSprites.DWARFIO[0].length) {
            x = graphic.getPixelWidth() - DwarfioSprites.DWARFIO[0].length;
        }

        if (!leftPressed && !rightPressed) {
            xVelocity *= FRICTION;
        }
    }

    private void updateAnimation() {
        boolean isMoving = leftPressed || rightPressed;
        if (!isMoving) {
            frame = 0;
            return;
        }

        if (timer % 8 == 0) {
            frame++;
            if (frame >= DwarfioSprites.RUNNING_FRAMES.length) {
                frame = 0;
            }
        }
    }

    @Override
    public void tick(PixelDisplay graphic) {
        timer++;
        updateHorizontalMovement(graphic);
        updateAnimation();
        drawSprite(graphic, getCurrentSprite(), (int) x, (int) y);
    }

    private int[][] getCurrentSprite() {
        boolean isMoving = leftPressed || rightPressed;
        if (!isMoving) {
            return DwarfioSprites.STANDING_DWARFIO;
        }
        return DwarfioSprites.RUNNING_FRAMES[frame];
    }

    private void drawSprite(PixelDisplay graphic, int[][] sprite, int xOffset, int yOffset) {
        for (int y = 0; y < sprite.length; y++) {
            for (int x = 0; x < sprite[y].length; x++) {
                var colorNumber = sprite[y][x];
                if (colorNumber == 4) {
                    continue;
                }
                var color = PixelColor.fromValue(colorNumber);
                graphic.setPixel(x + xOffset, y + yOffset, color);
            }
        }
    }

    @Override
    public void onButtonPress(GameButton button) {
        System.out.println("down: " + button);
        if (button == GameButton.LEFT) {
            leftPressed = true;
        }
        if (button == GameButton.RIGHT) {
            rightPressed = true;
        }
    }

    @Override
    public void onButtonRelease(GameButton button) {
        System.out.println("up: " + button);
        if (button == GameButton.LEFT) {
            leftPressed = false;
        }
        if (button == GameButton.RIGHT) {
            rightPressed = false;
        }
    }
}
