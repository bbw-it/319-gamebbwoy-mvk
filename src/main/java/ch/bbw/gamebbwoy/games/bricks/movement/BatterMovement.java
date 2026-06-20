package ch.bbw.gamebbwoy.games.bricks.movement;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.games.bricks.Batter;

public class BatterMovement implements PixelDrawing {
    //TODO probably a better solution for this class.
    // Instead of BatterMovement there could be a generic class for
    // the movement of the main game object and the commands for the keys pressed.
    // That would make the movement class useable for every game with sometimes the same keys.

    private final Batter batter;
    double xVelocity;
    double xAcceleration;

    public BatterMovement(Batter batter) {
        this.batter = batter;
    }

    public void onButton(ButtonListener.GameButton button, boolean isDown) {
        switch (button) {
            case LEFT -> xAcceleration = isDown ? -0.10 : 0;
            case RIGHT -> xAcceleration = isDown ? 0.10 : 0;
            default -> {
            } // ignore the rest
        }
    }

    @Override
    public void tick(PixelDisplay graphic) {
        xVelocity += xAcceleration;

        var nextX = batter.getX() + xVelocity;
        if (nextX < 0) { // out of bound on the left
            xVelocity = 0;
            nextX = 0;
        } else if (graphic.getPixelWidth() < (int) (batter.getWidth() + nextX)) { // out of bounds right
            xVelocity = 0;
            nextX = graphic.getPixelWidth() - batter.getWidth();
        }
        batter.setX(nextX);

        batter.tick(graphic);
    }
}
