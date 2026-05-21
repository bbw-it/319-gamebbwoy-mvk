package ch.bbw.gamebbwoy.internal;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.ButtonListener.GameButton;
import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Generally don't look at this class.
 * It implements a SwingUI to draw simple pixels in four colours.
 */
public class GameBbwoy {

	public static final int FPS = 60;

	protected GameBbwoy() {
		// hidden, use playGame instead
	}

	public static void playGame(PixelDrawing logic) throws Throwable {
		try {
			playGameInternal(logic);
		} catch (ExecutionException e) {
			// A bit of hacking here, such that the exception is shown in IntelliJ in the most visible way.
			// Keeping the UI thread running a while longer helps to see the issue
			// and exit 0 is less verbose than exit 1 when run with Gradle (but still gets rid of the process).
			CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS).execute(() -> System.exit(0));
			throw e.getCause();
		}
	}

	private static Point centerOfScreen(Dimension windowSize) {
		// in case of multiple screens, take the one with the mouse on
		var screenBounds = MouseInfo.getPointerInfo().getDevice().getDefaultConfiguration().getBounds();
		var x = screenBounds.x + (screenBounds.width - windowSize.width) / 2;
		var y = screenBounds.y + (screenBounds.height - windowSize.height) / 2;
		return new Point(x, y);
	}

	protected static void playGameInternal(PixelDrawing logic) throws Exception {
		System.setProperty("sun.java2d.opengl", "true");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		var display = new SwingDisplay();
		logic.initialize(display);
		SwingUtilities.invokeLater(() -> {
			var mainWindow = new JFrame("GameBBWoy");
			mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			mainWindow.setContentPane(display);
			mainWindow.setLocation(centerOfScreen(display.getPreferredSize()));
			mainWindow.setResizable(false);
			mainWindow.setVisible(true);
			mainWindow.pack();
			if (logic instanceof ButtonListener buttonAware) {
				// instanceof is a bit edgy, but GameLogic remains easier to use this way
				mainWindow.addKeyListener(new SwingController(buttonAware));
			}
		});
		try(var executor = Executors.newSingleThreadScheduledExecutor()) {
			var future = executor.scheduleAtFixedRate(() -> {
				display.clear();
				logic.tick(display);
				display.refresh();
			}, 0, 1000 / FPS, TimeUnit.MILLISECONDS);
			future.get(); // blocks forever
		}
	}

	private static class SwingDisplay extends JPanel implements PixelDisplay {

		private static final int SCALE = 8;
		private static final int[] COLORS = new int[]{0xe6f8da, 0x99c886, 0x437969, 0x051f2a};
		private final int pixelWidth;
		private final int pixelHeight;
		private final transient BufferedImage img;
		private final int[] rgb;

		public SwingDisplay() {
			var gfxConfig = GraphicsEnvironment.getLocalGraphicsEnvironment()
					.getDefaultScreenDevice()
					.getDefaultConfiguration();
			this.pixelWidth = getPixelWidth();
			this.pixelHeight = getPixelHeight();
			rgb = new int[pixelWidth * pixelHeight];
			img = gfxConfig.createCompatibleImage(pixelWidth, pixelHeight);
			setPreferredSize(new Dimension(pixelWidth * SCALE, pixelHeight * SCALE));
			clear();
		}

		@Override
		public void setPixel(int x, int y, PixelColor color) {
			if (x < 0 || pixelWidth <= x || y < 0 || pixelHeight <= y) {
				throw new IllegalArgumentException("""
						You attempt to draw an invalid pixel at coordinate (x,y)=(%d.%d).
						Pixels must be between top-left (0,0) and bottom-right (%d,%d) including.
						""".formatted(x, y, pixelWidth, pixelHeight));
			}
			rgb[x + y * pixelWidth] = COLORS[color.ordinal()];
		}

		@Override
		public void clear() {
			Arrays.fill(rgb, COLORS[0]);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.drawImage(img, 0, 0, pixelWidth * SCALE, pixelHeight * SCALE, null);
			g2d.dispose();
		}

		public void refresh() {
			img.setRGB(0, 0, pixelWidth, pixelHeight, rgb, 0, pixelWidth);
			validate();
			repaint();
		}
	}

	private static class SwingController implements KeyListener {

		private final ButtonListener buttonController;

		public SwingController(ButtonListener buttonController) {
			this.buttonController = buttonController;
		}

		private static Optional<GameButton> keyEventToButton(KeyEvent e) {
			return Optional.ofNullable(switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT -> GameButton.LEFT;
				case KeyEvent.VK_RIGHT -> GameButton.RIGHT;
				case KeyEvent.VK_DOWN -> GameButton.DOWN;
				case KeyEvent.VK_UP -> GameButton.UP;
				case KeyEvent.VK_SPACE -> GameButton.SPACE;
				case KeyEvent.VK_CONTROL -> GameButton.CTRL;
				case KeyEvent.VK_W -> GameButton.W;
				case KeyEvent.VK_A -> GameButton.A;
				case KeyEvent.VK_S -> GameButton.S;
				case KeyEvent.VK_D -> GameButton.D;
				default -> null;
			});
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// ignore
		}

		@Override
		public void keyPressed(KeyEvent e) {
			keyEventToButton(e).ifPresent(buttonController::onButtonPress);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			keyEventToButton(e).ifPresent(buttonController::onButtonRelease);
		}
	}
}
