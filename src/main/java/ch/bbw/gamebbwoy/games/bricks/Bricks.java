package ch.bbw.gamebbwoy.games.bricks;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.games.bricks.movement.BatterMovement;
import ch.bbw.gamebbwoy.internal.GameBbwoy;

public class Bricks implements PixelDrawing, ButtonListener {

	private final Batter batter = Batter.create();
	private WallOfBricks wall = new WallOfBricks();
	private Ball ball = Ball.create();
	private final BatterMovement batterMovement = new BatterMovement(batter);

	public static void main(String[] args) throws Throwable {
		GameBbwoy.playGame(new Bricks());
	}

	@Override
	public void initialize(PixelDisplay graphic) {
		// put the rectangle in the middle and at the bottom of the screen
		batter.setX((double) graphic.getPixelWidth()/2 - batter.getWidth()/2);
		batter.setY((double) graphic.getPixelHeight() * 10/11);
		// initialize the bricks wall

		// initialize the ball in the middle of the screen above the batter
		ball.setX((double) graphic.getPixelWidth()/2 - ball.getWidth()/2);
		ball.setY((double) graphic.getPixelHeight() * 10/11 - ball.getHeight());
	}

	@Override
	public void tick(PixelDisplay graphic) {
		graphic.clear();

		batterMovement.tick(graphic);
		wall.tick(graphic);
		ball.tick(graphic);
	}

	@Override
	public void onButtonPress(ButtonListener.GameButton button) {
		System.out.println("down: " + button);
		batterMovement.onButton(button, true);
	}

	@Override
	public void onButtonRelease(ButtonListener.GameButton button) {
		System.out.println("up: " + button);
		batterMovement.onButton(button, false);
	}
}

