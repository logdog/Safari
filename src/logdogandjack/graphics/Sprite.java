package logdogandjack.graphics;

public class Sprite {
	public final int SIZE;
	public int[] pixels;
	public int x, y;
	private SpriteSheet sheet; 
	
	//sprites below
	public static Sprite yellow = new Sprite(64, 0xffff00);
	public static Sprite black = new Sprite(64,  0);
	
	public static Sprite background = new Sprite(512, 0, 0, SpriteSheet.background);
	public static Sprite menuBackground = new Sprite(800, 0, 0, SpriteSheet.menuBG);
	public static Sprite sun = new Sprite(800, 0, 0, SpriteSheet.sun);
	
	public static Sprite alligator = new Sprite(64, 0, 0, SpriteSheet.mobs);
	public static Sprite crocodile = new Sprite(64, 0, 1, SpriteSheet.mobs);
	public static Sprite dog = new Sprite(64, 0, 2, SpriteSheet.mobs);
	public static Sprite eagle = new Sprite(64, 0, 3, SpriteSheet.mobs);
	public static Sprite elephant = new Sprite(64, 0, 4, SpriteSheet.mobs);
	public static Sprite giraffe = new Sprite(64, 0, 5, SpriteSheet.mobs);
	public static Sprite gorilla = new Sprite(64, 0, 6, SpriteSheet.mobs);
	public static Sprite hippo = new Sprite(64, 0, 7, SpriteSheet.mobs);
	
	public static Sprite kangaroo = new Sprite(64, 1, 0, SpriteSheet.mobs);
	public static Sprite lion = new Sprite(64, 1, 1, SpriteSheet.mobs);
	public static Sprite monkey = new Sprite(64, 1, 2, SpriteSheet.mobs);
	public static Sprite frog = new Sprite(64, 1, 3, SpriteSheet.mobs);
	public static Sprite pig = new Sprite(64, 1, 4, SpriteSheet.mobs);
	public static Sprite pigeon = new Sprite(64, 1, 5, SpriteSheet.mobs);
	public static Sprite rhino = new Sprite(64, 1, 6, SpriteSheet.mobs);
	public static Sprite seagull = new Sprite(64, 1, 7, SpriteSheet.mobs);
	
	public static Sprite snake = new Sprite(64, 2, 0, SpriteSheet.mobs);
	public static Sprite tiger = new Sprite(64, 2, 1, SpriteSheet.mobs);
	public static Sprite vulture = new Sprite(64, 2, 2, SpriteSheet.mobs);
	public static Sprite zebra = new Sprite(64, 2, 3, SpriteSheet.mobs);
	public static Sprite player = new Sprite(64, 2, 4, SpriteSheet.mobs);
	
	
	//letters
	public static Sprite A = new Sprite(12, 0, 0, SpriteSheet.letters);
	public static Sprite B = new Sprite(12, 1, 0, SpriteSheet.letters);
	public static Sprite C = new Sprite(12, 2, 0, SpriteSheet.letters);
	public static Sprite D = new Sprite(12, 3, 0, SpriteSheet.letters);
	public static Sprite E = new Sprite(12, 4, 0, SpriteSheet.letters);
	public static Sprite F = new Sprite(12, 5, 0, SpriteSheet.letters);
	public static Sprite G = new Sprite(12, 6, 0, SpriteSheet.letters);
	public static Sprite H = new Sprite(12, 7, 0, SpriteSheet.letters);
	public static Sprite I = new Sprite(12, 8, 0, SpriteSheet.letters);
	public static Sprite J = new Sprite(12, 9, 0, SpriteSheet.letters);
	public static Sprite K = new Sprite(12, 10, 0, SpriteSheet.letters);
	public static Sprite L = new Sprite(12, 11, 0, SpriteSheet.letters);
	public static Sprite M = new Sprite(12, 12, 0, SpriteSheet.letters);
	public static Sprite N = new Sprite(12, 13, 0, SpriteSheet.letters);
	public static Sprite O = new Sprite(12, 14, 0, SpriteSheet.letters);
	public static Sprite P = new Sprite(12, 15, 0, SpriteSheet.letters);
	public static Sprite Q = new Sprite(12, 16, 0, SpriteSheet.letters);
	public static Sprite R = new Sprite(12, 17, 0, SpriteSheet.letters);
	public static Sprite S = new Sprite(12, 18, 0, SpriteSheet.letters);
	public static Sprite T = new Sprite(12, 19, 0, SpriteSheet.letters);
	
	public static Sprite U = new Sprite(12, 0, 1, SpriteSheet.letters);
	public static Sprite V = new Sprite(12, 1, 1, SpriteSheet.letters);
	public static Sprite W = new Sprite(12, 2, 1, SpriteSheet.letters);
	public static Sprite X = new Sprite(12, 3, 1, SpriteSheet.letters);
	public static Sprite Y = new Sprite(12, 4, 1, SpriteSheet.letters);
	public static Sprite Z = new Sprite(12, 5, 1, SpriteSheet.letters);
	public static Sprite exclamation = new Sprite(12, 6, 1, SpriteSheet.letters);
	public static Sprite question = new Sprite(12, 7, 1, SpriteSheet.letters);
	public static Sprite period = new Sprite(12, 8, 1, SpriteSheet.letters);
	
	public static Sprite zero = new Sprite(12, 0, 2, SpriteSheet.letters);
	public static Sprite one = new Sprite(12, 1, 2, SpriteSheet.letters);
	public static Sprite two = new Sprite(12, 2, 2, SpriteSheet.letters);
	public static Sprite three = new Sprite(12, 3, 2, SpriteSheet.letters);
	public static Sprite four = new Sprite(12, 4, 2, SpriteSheet.letters);
	public static Sprite five = new Sprite(12, 5, 2, SpriteSheet.letters);
	public static Sprite six = new Sprite(12, 6, 2, SpriteSheet.letters);
	public static Sprite seven = new Sprite(12, 7, 2, SpriteSheet.letters);
	public static Sprite eight = new Sprite(12, 8, 2, SpriteSheet.letters);
	public static Sprite nine = new Sprite(12, 9, 2, SpriteSheet.letters);

	//sprites above
	
	public Sprite(int size, int color){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	private void load(){
		for(int y = 0; y < SIZE; y ++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
	
	private void setColor(int color){
		for(int i = 0; i < SIZE * SIZE; i++){
			pixels[i] = color;
		}
	}
}
