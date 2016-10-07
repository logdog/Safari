package logdogandjack.entities;

import logdogandjack.Game;
import logdogandjack.graphics.Screen;

public class Projectile extends Entity{
	
	private double pxRel, pyRel;
	private boolean right;
	
	public Projectile(int x, int y, boolean right) {
		super(x, y);
		this.right = right;
		pxRel = x;
		pyRel = y;
	}
	
	public void update()
	{
		if(right)
			pxRel += 12;
		else
			pxRel -= 12;
		
		xRel = (int) pxRel;
		yRel = (int) pyRel;
		
		if(xRel < 0 || xRel >= Game.WIDTH || yRel < 0 || yRel >= Game.WIDTH)
			entities.remove(this);
			
		for(int i = 0; i < entities.size(); i++){
			if(entities.get(i) instanceof Animal) {
				if(xRel - entities.get(i).xRel >= 0 && xRel - entities.get(i).xRel < 64 && yRel - entities.get(i).yRel >= 0 && yRel - entities.get(i).yRel < 64) {
					entities.remove(i);
					entities.remove(this);
					break;
				}
			}
		}
	}
	
	public void render(Screen screen) 
	{
		screen.fillRect(xRel, yRel, 6, 6, 0);
	}
	
}
