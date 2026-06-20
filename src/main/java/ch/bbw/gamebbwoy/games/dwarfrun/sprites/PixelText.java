package ch.bbw.gamebbwoy.games.dwarfrun.sprites;

import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;

public class PixelText {

    private static final int LETTER_WIDTH = 3;
    private static final int LETTER_HEIGHT = 5;
    private static final int LETTER_SPACING = 1;

    private PixelText() {
        // Hilfsklasse, soll nicht instanziiert werden
    }

    public static void drawText(PixelDisplay graphic, String text, int xOffset, int yOffset) {
        drawText(graphic, text, xOffset, yOffset, PixelColor.BLACK);
    }

    public static void drawText(PixelDisplay graphic, String text, int xOffset, int yOffset, PixelColor color) {
        String upperText = text.toUpperCase();

        for (int i = 0; i < upperText.length(); i++) {
            char character = upperText.charAt(i);

            int[][] sprite = getCharacterSprite(character);

            int characterX = xOffset + i * (LETTER_WIDTH + LETTER_SPACING);

            drawCharacter(graphic, sprite, characterX, yOffset, color);
        }
    }

    private static void drawCharacter(PixelDisplay graphic, int[][] sprite, int xOffset, int yOffset, PixelColor color) {
        for (int y = 0; y < sprite.length; y++) {
            for (int x = 0; x < sprite[y].length; x++) {
                if (sprite[y][x] == 1) {
                    graphic.setPixel(xOffset + x, yOffset + y, color);
                }
            }
        }
    }

    private static int[][] getCharacterSprite(char character) {
        return switch (character) {
            case 'A' -> A;
            case 'B' -> B;
            case 'C' -> C;
            case 'D' -> D;
            case 'E' -> E;
            case 'F' -> F;
            case 'G' -> G;
            case 'H' -> H;
            case 'I' -> I;
            case 'J' -> J;
            case 'K' -> K;
            case 'L' -> L;
            case 'M' -> M;
            case 'N' -> N;
            case 'O' -> O;
            case 'P' -> P;
            case 'Q' -> Q;
            case 'R' -> R;
            case 'S' -> S;
            case 'T' -> T;
            case 'U' -> U;
            case 'V' -> V;
            case 'W' -> W;
            case 'X' -> X;
            case 'Y' -> Y;
            case 'Z' -> Z;
            case '0' -> ZERO;
            case '1' -> ONE;
            case '2' -> TWO;
            case '3' -> THREE;
            case '4' -> FOUR;
            case '5' -> FIVE;
            case '6' -> SIX;
            case '7' -> SEVEN;
            case '8' -> EIGHT;
            case '9' -> NINE;
            case ' ' -> SPACE;
            default -> UNKNOWN;
        };
    }

    private static final int[][] A = {
            {0, 1, 0},
            {1, 0, 1},
            {1, 1, 1},
            {1, 0, 1},
            {1, 0, 1}
    };

    private static final int[][] B = {
            {1, 1, 0},
            {1, 0, 1},
            {1, 1, 0},
            {1, 0, 1},
            {1, 1, 0}
    };

    private static final int[][] C = {
            {0, 1, 1},
            {1, 0, 0},
            {1, 0, 0},
            {1, 0, 0},
            {0, 1, 1}
    };

    private static final int[][] D = {
            {1, 1, 0},
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1},
            {1, 1, 0}
    };

    private static final int[][] E = {
            {1, 1, 1},
            {1, 0, 0},
            {1, 1, 0},
            {1, 0, 0},
            {1, 1, 1}
    };

    private static final int[][] F = {
            {1, 1, 1},
            {1, 0, 0},
            {1, 1, 0},
            {1, 0, 0},
            {1, 0, 0}
    };

    private static final int[][] G = {
            {1, 1, 1},
            {1, 0, 0},
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
    };

    private static final int[][] H = {
            {1, 0, 1},
            {1, 0, 1},
            {1, 1, 1},
            {1, 0, 1},
            {1, 0, 1}
    };

    private static final int[][] I = {
            {1, 1, 1},
            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 0},
            {1, 1, 1}
    };

    private static final int[][] J = {
            {1, 1, 1},
            {0, 0, 1},
            {0, 0, 1},
            {1, 0, 1},
            {0, 1, 0}
    };

    private static final int[][] K = {
            {1, 0, 1},
            {1, 1, 0},
            {1, 0, 0},
            {1, 1, 0},
            {1, 0, 1}
    };

    private static final int[][] L = {
            {1, 0, 0},
            {1, 0, 0},
            {1, 0, 0},
            {1, 0, 0},
            {1, 1, 1}
    };

    private static final int[][] M = {
            {1, 0, 1},
            {1, 1, 1},
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1}
    };

    private static final int[][] N = {
            {0, 0, 0},
            {1, 0, 1},
            {1, 0, 1},
            {1, 1, 1},
            {1, 0, 1}
    };

    private static final int[][] O = {
            {0, 1, 0},
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1},
            {0, 1, 0}
    };

    private static final int[][] P = {
            {1, 1, 0},
            {1, 0, 1},
            {1, 1, 0},
            {1, 0, 0},
            {1, 0, 0}
    };

    private static final int[][] Q = {
            {0, 1, 0},
            {1, 0, 1},
            {1, 0, 1},
            {1, 1, 1},
            {0, 1, 1}
    };

    private static final int[][] R = {
            {1, 1, 0},
            {1, 0, 1},
            {1, 1, 0},
            {1, 0, 1},
            {1, 0, 1}
    };

    private static final int[][] S = {
            {0, 1, 1},
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 0}
    };

    private static final int[][] T = {
            {1, 1, 1},
            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
    };

    private static final int[][] U = {
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1},
            {1, 1, 1}
    };

    private static final int[][] V = {
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1},
            {0, 1, 0}
    };

    private static final int[][] W = {
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1},
            {1, 1, 1},
            {1, 0, 1}
    };

    private static final int[][] X = {
            {1, 0, 1},
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1},
            {1, 0, 1}
    };

    private static final int[][] Y = {
            {1, 0, 1},
            {1, 0, 1},
            {0, 1, 0},
            {0, 1, 0},
            {1, 1, 0}
    };

    private static final int[][] Z = {
            {1, 1, 1},
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0},
            {1, 1, 1}
    };

    private static final int[][] SPACE = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    private static final int[][] UNKNOWN = {
            {1, 1, 1},
            {0, 0, 1},
            {0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}
    };

    private static final int[][] ZERO = {
            {0, 1, 0},
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1},
            {0, 1, 0}
    };

    private static final int[][] ONE = {
            {0, 1, 0},
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 0},
            {1, 1, 1}
    };

    private static final int[][] TWO = {
            {0, 1, 0},
            {1, 0, 1},
            {0, 0, 1},
            {0, 1, 0},
            {1, 1, 1}
    };

    private static final int[][] THREE = {
            {1, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 1},
            {1, 1, 0}
    };

    private static final int[][] FOUR = {
            {1, 0, 1},
            {1, 0, 1},
            {1, 1, 1},
            {0, 0, 1},
            {0, 0, 1}
    };

    private static final int[][] FIVE = {
            {1, 1, 1},
            {1, 0, 0},
            {1, 1, 0},
            {0, 0, 1},
            {1, 1, 0}
    };

    private static final int[][] SIX = {
            {0, 1, 1},
            {1, 0, 0},
            {1, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
    };

    private static final int[][] SEVEN = {
            {1, 1, 1},
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0},
            {1, 0, 0}
    };

    private static final int[][] EIGHT = {
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
    };

    private static final int[][] NINE = {
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 1},
            {0, 0, 1},
            {1, 1, 0}
    };
}

