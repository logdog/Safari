package logdogandjack.entities;

import java.util.ArrayList;
import java.util.List;

import logdogandjack.graphics.Screen;

public abstract class Entity {
	
	protected int xPos = -64, yPos = -64;
	public int xRel = -64;
	public int yRel = -64;
	public static List<Entity> entities = new ArrayList<Entity>();
	
	public Entity(int x, int y) {
		xPos = x;
		yPos = y;
		entities.add(this);
	}
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public static void updateAll() {
		for(int i = 0; i < entities.size(); i++)
			entities.get(i).update();
	}
	
	public static void renderAll(Screen screen) {
		for(int i = 0; i < entities.size(); i++)
			entities.get(i).render(screen);
	}
	
	public int getX()
	{
		return xRel;
	}
	
	public int getY()
	{
		return yRel;
	}

}
