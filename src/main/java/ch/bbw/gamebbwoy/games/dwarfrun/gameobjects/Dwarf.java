package ch.bbw.gamebbwoy.games.dwarfrun.gameobjects;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.games.dwarfrun.sprites.DwarfSprites;
import ch.bbw.gamebbwoy.games.dwarfrun.sprites.SpriteDrawer;
import ch.bbw.gamebbwoy.games.dwarfrun.world.World;

public class Dwarf implements ButtonListener {

//    private final int[][] pixels;
    private double x;
    private double y;

    private double velocityX = 0;
    private double velocityY = 0;

    private boolean leftPressed = false;
    private boolean rightPressed = false;

    private int timer = 0;
    private int animationFrame = 0;

    private int score = 0;

    private static final double ACCELERATION = 0.15;
    private static final double FRICTION = 0.85;
    private static final double MAX_SPEED = 1.5;

    private static final double GRAVITY = 0.2;
    private static final double MAX_FALL_SPEED = 3.0;

    public void update(World world) {
        timer++;

        updateHorizontalMovement();
        updateGravity(world);
        updateAnimation();

        score++;
    }

    private void updateHorizontalMovement() {
        if (leftPressed) {
            velocityX -= ACCELERATION;
        }

        if (rightPressed) {
            velocityX += ACCELERATION;
        }

        if (velocityX > MAX_SPEED) {
            velocityX = MAX_SPEED;
        }

        if (velocityX < -MAX_SPEED) {
            velocityX = -MAX_SPEED;
        }

        x += velocityX;

        if (!leftPressed && !rightPressed) {
            velocityX *= FRICTION;
        }
    }

    private void updateGravity(World world) {
        if (!isStandingOnGround(world)) {
            velocityY += GRAVITY;

            if (velocityY > MAX_FALL_SPEED) {
                velocityY = MAX_FALL_SPEED;
            }
        } else {
            velocityY = 0;
        }

        y += velocityY;

        while (isCollidingWithGround(world)) {
            y--;
            velocityY = 0;
        }
    }

    private boolean isStandingOnGround(World world) {
        int[][] sprite = getCurrentSprite();

        int leftFootX = (int) x + 2;
        int rightFootX = (int) x + sprite[0].length - 3;
        int footY = (int) y + sprite.length;

        return world.isSolidPixel(leftFootX, footY)
                || world.isSolidPixel(rightFootX, footY);
    }

    private boolean isCollidingWithGround(World world) {
        int[][] sprite = getCurrentSprite();

        int leftFootX = (int) x + 2;
        int rightFootX = (int) x + sprite[0].length - 3;
        int bottomY = (int) y + sprite.length - 1;

        return world.isSolidPixel(leftFootX, bottomY)
                || world.isSolidPixel(rightFootX, bottomY);
    }

    private void updateAnimation() {
        boolean isMoving = leftPressed || rightPressed;

        if (!isMoving) {
            animationFrame = 0;
            return;
        }

        if (timer % 8 == 0) {
            animationFrame++;

            if (animationFrame >= DwarfSprites.RUNNING_FRAMES.length) {
                animationFrame = 0;
            }
        }
    }

    public void draw(PixelDisplay graphic) {
        SpriteDrawer.drawSprite(graphic, getCurrentSprite(), (int) x, (int) y);
    }

    private int[][] getCurrentSprite() {
        boolean isMoving = leftPressed || rightPressed;

        if (!isMoving) {
            return DwarfSprites.STANDING_DWARF;
        }

        return DwarfSprites.RUNNING_FRAMES[animationFrame];
    }

    public void onButtonPress(GameButton button) {
        if (button == GameButton.LEFT) {
            leftPressed = true;
        }

        if (button == GameButton.RIGHT) {
            rightPressed = true;
        }
    }

    public void onButtonRelease(GameButton button) {
        if (button == GameButton.LEFT) {
            leftPressed = false;
        }

        if (button == GameButton.RIGHT) {
            rightPressed = false;
        }
    }

    public int getScore() {
        return score;
    }
}
