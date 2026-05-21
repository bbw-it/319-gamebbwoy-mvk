package ch.bbw.gamebbwoy.example;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.internal.GameBbwoy;

/**
 * Combines multiple effects into one.
 */
public class BallAndStarfield implements PixelDrawing, ButtonListener {

	private final PixelSprite ball = PixelSprite.ball();

	private final MovableSprite movingBall = new MovableSprite(ball);

	private final StarfieldAnimation starfieldAnimation = new StarfieldAnimation();

	public static void main(String[] args) throws Throwable {
		GameBbwoy.playGame(new BallAndStarfield());
	}

	@Override
	public void initialize(PixelDisplay graphic) {
		// put the ball in the middle of the screen
		ball.setX((double) graphic.getPixelWidth() / 2);
		ball.setY((double) graphic.getPixelHeight() / 2);
	}

	@Override
	public void tick(PixelDisplay graphic) {
		starfieldAnimation.tick(graphic); // background is drawn BEFORE the ball
		movingBall.tick(graphic);
	}

	@Override
	public void onButtonPress(GameButton button) {
		movingBall.onButton(button, true);
	}

	@Override
	public void onButtonRelease(GameButton button) {
		movingBall.onButton(button, false);
	}
}
