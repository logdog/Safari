package logdogandjack.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet background = new SpriteSheet("/textures/background2.png", 512);
	public static SpriteSheet letters = new SpriteSheet("/textures/Letters.png" , 240);
	public static SpriteSheet menuBG = new SpriteSheet("/textures/menuscreen.png", 800);
	public static SpriteSheet sun = new SpriteSheet("/textures/sun.png", 800);
	
	public static SpriteSheet mobs = new SpriteSheet("/textures/SafariMobs.png", 512);
	
	public SpriteSheet(String path, int size){
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		
		load();
	}
	
	private void load() {
		try{
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
