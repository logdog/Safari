package logdogandjack.entities;

import logdogandjack.Game;
import logdogandjack.graphics.Sprite;
import logdogandjack.level.Level;

public abstract class Hostile extends Animal
{
	public int damage = 4;
	
    public Hostile(Sprite sprite)
    {
        super(sprite);
    }
    
    public Hostile(int x, int y,Sprite sprite)
    {
        super(x, y, sprite);
    }
    
    public String getDeathSound()
    {
    	return "AHH IM DYING. Now i am dead";
    }
    
    public boolean shouldAttack(Mob mob) {
    	return (xPos - mob.xPos < 16 && xPos - mob.xPos > -16 && yPos - mob.yPos < 16 && yPos -mob.yPos > -16);
    }
    
    public void attack(Mob mob) {
    	mob.takeDamage(damage);
    }
    
    public void update()
    {
    	xRel = xPos - Level.cameraX;
		yRel = yPos - Level.cameraY;

		if (xPos > Level.player.xPos)
			move(-speed, 0);
		if (xPos < Level.player.xPos)
			move(speed, 0);
		if (yPos < Level.player.yPos)
			move(0, speed);
		if (yPos > Level.player.yPos)
			move(0, -speed);

		if (xRel < 0 || xRel >= Game.WIDTH || yRel < 0 || yRel >= Game.HEIGHT) {
			entities.remove(this);
		}
		
		if(Math.abs(xPos - Level.player.xPos) < 32 && Math.abs(yPos - Level.player.yPos) < 32) {
			Level.player.takeDamage(damage);
			if(getDir() == Direction.RIGHT)
				Level.player.move(64, (int) (Math.random() * 32) - 16);
			else
				Level.player.move(-64, (int) (Math.random() * 32) - 16);
		}
    }
}