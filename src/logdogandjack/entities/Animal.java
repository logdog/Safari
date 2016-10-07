package logdogandjack.entities;

import logdogandjack.Game;
import logdogandjack.graphics.Sprite;
import logdogandjack.level.Level;

public abstract class Animal extends Mob
{
    public Diet diet = Diet.OMNIVOROUS;
    public Gender gender = Gender.MALE;
    
    public Animal(Sprite sprite)
    {
       super((int)(Math.random() * Game.WIDTH), (int)(Math.random() * Game.HEIGHT), sprite);
       speed = 4;
    }
    
    public Animal(int x, int y, Sprite sprite){
    	super(x + Level.cameraX, y + Level.cameraY, sprite);
    	speed = 4;
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
    }
    public void die()
    {
    	System.out.println(getDeathSound());
        health = 0;
        speed = 0;
    }
    
    public String speak() {
    	//override in subclasses
    	return "[animal sounds]";
    }
    
    public String getDeathSound()
    {
    	return "ahhhh";
    }
    
    public boolean isDead() {
    	return health <= 0;
    }
    
    public Diet getDiet()
    {
    	return diet;
    }
    
    public String toString() {
    	return "";
    }
    
    public void setGender(Gender gender) {
    	this.gender = gender;
    }
   
}