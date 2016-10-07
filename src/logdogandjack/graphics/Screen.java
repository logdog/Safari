package logdogandjack.graphics;

import java.util.Random;

import logdogandjack.Game;

public class Screen {
	private int width, height;

	public int[] pixels;

	Random rand = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;

		pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void fillRect(int x, int y, int w, int h, int col) {
		for (int yy = 0; yy < h; yy++) {
			int yp = yy + y;
			if (yp < 0 || yp >= height)
				continue;
			for (int xx = 0; xx < w; xx++) {
				int xp = xx + x;
				if (xp < 0 || xp >= width)
					continue;

				if (col != 0xff00ff)
					pixels[xp + yp * width] = col;
			}
		}
	}

	public void drawRect(int x, int y, int w, int h, int col) {
		for (int yy = 0; yy < h; yy++) {
			int yp = yy + y;
			if (yp < 0 || yp >= height)
				continue;
			for (int xx = 0; xx < w; xx++) {
				int xp = xx + x;
				if (xp < 0 || xp >= width)
					continue;

				if (xx == 0 || yy == 0 || xx == w - 1 || yy == h - 1)
					pixels[xp + yp * width] = col;
			}
		}
	}

	public void renderSprite(int x, int y, Sprite sprite) {
		for (int yy = 0; yy < sprite.SIZE; yy++) {
			int yp = yy + y;
			if (yp < 0 || yp >= height)
				continue;
			for (int xx = 0; xx < sprite.SIZE; xx++) {
				int xp = xx + x;
				if (xp < 0 || xp >= width)
					continue;

				int col = sprite.pixels[xx + yy * sprite.SIZE];

				if (col == 0xffff00ff || col == 0xffaa00aa);
				else
					pixels[xp + yp * width] = col;
			}
		}
	}
	
	public void renderReverseSprite(int x, int y, Sprite sprite) {
		for (int yy = 0; yy < sprite.SIZE; yy++) {
			int yp = yy + y;
			if (yp < 0 || yp >= height)
				continue;
			for (int xx = 0; xx < sprite.SIZE; xx++) {
				int xc = sprite.SIZE - 1 - xx;
				int xp = xx + x;
				if (xp < 0 || xp >= width)
					continue;

				int col = sprite.pixels[xc + yy * sprite.SIZE];

				if (col == 0xffff00ff || col == 0xffaa00aa);
				else
					pixels[xp + yp * width] = col;
			}
		}
	}
	
	

	public void renderBackground(int x) {
		renderSprite(0,-60, Sprite.sun /*change to the sun setting later*/);
		x %= Sprite.background.SIZE;
		while (x < Game.WIDTH) {
			renderSprite(x, 0, Sprite.background);
			x += Sprite.background.SIZE;
		}
	}

	public void renderText(String message, int x, int y) {

		String str = message.toUpperCase();
		x -= (int) ((double) message.length() / 2 * 10);
		
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case 'A':
				renderSprite(x + i * 10, y, Sprite.A);
				break;
			case 'B':
				renderSprite(x + i * 10, y, Sprite.B);
				break;
			case 'C':
				renderSprite(x + i * 10, y, Sprite.C);
				break;
			case 'D':
				renderSprite(x + i * 10, y, Sprite.D);
				break;
			case 'E':
				renderSprite(x + i * 10, y, Sprite.E);
				break;
			case 'F':
				renderSprite(x + i * 10, y, Sprite.F);
				break;
			case 'G':
				renderSprite(x + i * 10, y, Sprite.G);
				break;
			case 'H':
				renderSprite(x + i * 10, y, Sprite.H);
				break;
			case 'I':
				renderSprite(x + i * 10, y, Sprite.I);
				break;
			case 'J':
				renderSprite(x + i * 10, y, Sprite.J);
				break;
			case 'K':
				renderSprite(x + i * 10, y, Sprite.K);
				break;
			case 'L':
				renderSprite(x + i * 10, y, Sprite.L);
				break;
			case 'M':
				renderSprite(x + i * 10, y, Sprite.M);
				break;
			case 'N':
				renderSprite(x + i * 10, y, Sprite.N);
				break;
			case 'O':
				renderSprite(x + i * 10, y, Sprite.O);
				break;
			case 'P':
				renderSprite(x + i * 10, y, Sprite.P);
				break;
			case 'Q':
				renderSprite(x + i * 10, y, Sprite.Q);
				break;
			case 'R':
				renderSprite(x + i * 10, y, Sprite.R);
				break;
			case 'S':
				renderSprite(x + i * 10, y, Sprite.S);
				break;
			case 'T':
				renderSprite(x + i * 10, y, Sprite.T);
				break;
			case 'U':
				renderSprite(x + i * 10, y, Sprite.U);
				break;
			case 'V':
				renderSprite(x + i * 10, y, Sprite.V);
				break;
			case 'W':
				renderSprite(x + i * 10, y, Sprite.W);
				break;
			case 'X':
				renderSprite(x + i * 10, y, Sprite.X);
				break;
			case 'Y':
				renderSprite(x + i * 10, y, Sprite.Y);
				break;
			case 'Z':
				renderSprite(x + i * 10, y, Sprite.Z);
				break;
			case '0':
				renderSprite(x + i * 10, y, Sprite.zero);
				break;
			case '1':
				renderSprite(x + i * 10, y, Sprite.one);
				break;
			case '2':
				renderSprite(x + i * 10, y, Sprite.two);
				break;
			case '3':
				renderSprite(x + i * 10, y, Sprite.three);
				break;
			case '4':
				renderSprite(x + i * 10, y, Sprite.four);
				break;
			case '5':
				renderSprite(x + i * 10, y, Sprite.five);
				break;
			case '6':
				renderSprite(x + i * 10, y, Sprite.six);
				break;
			case '7':
				renderSprite(x + i * 10, y, Sprite.seven);
				break;
			case '8':
				renderSprite(x + i * 10, y, Sprite.eight);
				break;
			case '9':
				renderSprite(x + i * 10, y, Sprite.nine);
				break;

			default:
				break;
			}
		}

	}

	/*
	 * public void renderVerticalText(String message, int x, int y) {
	 * 
	 * String str = message.toUpperCase(); x -= 3; y -= str.length() * 3;
	 * 
	 * for (int i = 0; i < str.length(); i++) { switch (str.charAt(i)) { case
	 * 'A': renderSprite(x, y + i * 6, Sprite.A); break; case 'B':
	 * renderSprite(x , y + i * 6, Sprite.B); break; case 'C':
	 * renderSprite(x, y + i * 6, Sprite.C); break; case 'D':
	 * renderSprite(x, y + i * 6, Sprite.D); break; case 'E':
	 * renderSprite(x, y + i * 6, Sprite.E); break; case 'F':
	 * renderSprite(x , y + i * 6, Sprite.F); break; case 'G':
	 * renderSprite(x , y + i * 6, Sprite.G); break; case 'H':
	 * renderSprite(x , y + i * 6, Sprite.H); break; case 'I':
	 * renderSprite(x, y + i * 6, Sprite.I); break; case 'J':
	 * renderSprite(x, y + i * 6, Sprite.J); break; case 'K':
	 * renderSprite(x , y + i * 6, Sprite.K); break; case 'L':
	 * renderSprite(x , y + i * 6, Sprite.L); break; case 'M':
	 * renderSprite(x , y + i * 6, Sprite.M); break; case 'N':
	 * renderSprite(x , y + i * 6, Sprite.N); break; case 'O':
	 * renderSprite(x , y + i * 6, Sprite.O); break; case 'P':
	 * renderSprite(x , y + i * 6, Sprite.P); break; case 'Q':
	 * renderSprite(x , y + i * 6, Sprite.Q); break; case 'R':
	 * renderSprite(x, y + i * 6, Sprite.R); break; case 'S':
	 * renderSprite(x , y + i * 6, Sprite.S); break; case 'T':
	 * renderSprite(x , y + i * 6, Sprite.T); break; case 'U':
	 * renderSprite(x , y + i * 6, Sprite.U); break; case 'V':
	 * renderSprite(x , y + i * 6, Sprite.V); break; case 'W':
	 * renderSprite(x, y + i * 6, Sprite.W); break; case 'X':
	 * renderSprite(x , y+ i * 6, Sprite.X); break; case 'Y':
	 * renderSprite(x, y+ i * 6, Sprite.Y); break; case 'Z': renderSprite(x
	 * , y + i * 6, Sprite.Z); break; case '0': renderSprite(x , y+ i * 6,
	 * Sprite.One); break; case '2': renderSprite(x , y+ i * 6,
	 * Sprite.Two); break; case '3': renderSprite(x, y+ i * 6,
	 * Sprite.Three); break; case '4': renderSprite(x, y+ i * 6,
	 * Sprite.Four); break; case '5': renderSprite(x , y+ i * 6,
	 * Sprite.Five); break; case '6': renderSprite(x, y+ i * 6,
	 * Sprite.Six); break; case '7': renderSprite(x , y+ i * 6,
	 * Sprite.Seven); break; case '8': renderSprite(x , y+ i * 6,
	 * Sprite.Eight); break; case '9': renderSprite(x , y+ i * 6,
	 * Sprite.Nine); break;
	 * 
	 * default: break; } }
	 * 
	 * }
	 */
}
