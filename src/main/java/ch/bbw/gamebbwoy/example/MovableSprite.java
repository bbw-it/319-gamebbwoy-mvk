package ch.bbw.gamebbwoy.example;

import ch.bbw.gamebbwoy.api.ButtonListener.GameButton;
import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;

import java.util.List;

public class MovableSprite implements PixelDrawing {

	private final PixelSprite sprite;
	double xVelocity;
	double yVelocity;
	double xAcceleration;
	double yAcceleration;

	public MovableSprite(ExampleShape exampleShape) {
		this.sprite = new PixelSprite(exampleShape);
	}

	public MovableSprite(List<Integer> pixels, int width, int height) {
		this.sprite = new PixelSprite(pixels, width, height);
	}

	public void onButton(GameButton button, boolean isDown) {
		switch (button) {
			case UP -> yAcceleration = isDown ? -0.05 : 0;
			case DOWN -> yAcceleration = isDown ? 0.05 : 0;
			case LEFT -> xAcceleration = isDown ? -0.05 : 0;
			case RIGHT -> xAcceleration = isDown ? 0.05 : 0;
			default -> {
			} // ignore the rest
		}
	}

	@Override
	public void tick(PixelDisplay graphic) {
		xVelocity += xAcceleration;
		yVelocity += yAcceleration;

		var nextX = sprite.getX() + xVelocity;
		if (nextX < 0) { // out of bound on the left
			xVelocity = -xVelocity;
			nextX = -nextX;
		} else if (graphic.getPixelWidth() < (int) (sprite.getWidth() + nextX)) { // out of bounds right
			xVelocity = -xVelocity;
			var overlap = nextX + sprite.getWidth() - graphic.getPixelWidth();
			nextX -= 2 * overlap;
		}
		sprite.setX(nextX);

		var nextY = sprite.getY() + yVelocity;
		if (nextY < 0) { // out of bound on top
			yVelocity = -yVelocity;
			nextY = -nextY;
		} else if (graphic.getPixelHeight() < (int) (sprite.getHeight() + nextY)) { // out of bounds bottom
			yVelocity = -yVelocity;
			var overlap = nextY + sprite.getHeight() - graphic.getPixelHeight();
			nextY -= 2 * overlap;
		}
		sprite.setY(nextY);

		sprite.tick(graphic);
	}

	public int getWidth() {
		return sprite.getWidth();
	}

	public int getHeight() {
		return sprite.getHeight();
	}

	public double getX() {
		return sprite.getX();
	}

	public double getY() {
		return sprite.getY();
	}

	public void setX(double x) {
		sprite.setX(x);
	}

	public void setY(double y) {
		sprite.setY(y);
	}

	public class PixelSprite implements PixelDrawing {

		private final List<Integer> pixels;
		private final int width;
		private final int height;
		/**
		 * x,y are represented as {@code double} to move it around the screen fluently. When drawing it, they are always
		 * reduced (rounded down) to an {@code int}.
		 */
		private double x;
		private double y;

		public PixelSprite(ExampleShape shape) {
			this.pixels = shape.getPixels();
			this.width = shape.getWidth();
			this.height = shape.getHeight();
		}

		/**
		 * A Pixel-Image represented as a one-dimensional array. {@code width * height} must be the same as
		 * {@code pixels.size()}.
		 *
		 * @param pixels One-dimensional array holding all pixel values. Pixel at position (h,w) can be obtained via
		 *               pixels.get(h + w * height).
		 * @param width  (Breite) in pixels
		 * @param height (Höhe) in pixels
		 */
		public PixelSprite(List<Integer> pixels, int width, int height) {
			this.pixels = pixels;
			this.width = width;
			this.height = height;
			if (width * height != pixels.size()) {
				throw new IllegalArgumentException("pixel size does not match provided width/height");
			}
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
}
