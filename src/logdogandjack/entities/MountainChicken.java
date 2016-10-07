package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class MountainChicken extends Hostile{
	
	public MountainChicken(int x, int y) {
		super(x, y, Sprite.frog);
		speed = 7;
		damage = 1;
		diet = Diet.CARNIVOROUS;
	}
	
	public MountainChicken() {
		super(Sprite.frog);
		speed = 7;
		damage = 1;
		diet = Diet.CARNIVOROUS;
	}
	
	public String speak()
	{
		return "Cook-a-doodle-ribbet";
	}
	
	 public String toString() {
	    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
	    }

}
