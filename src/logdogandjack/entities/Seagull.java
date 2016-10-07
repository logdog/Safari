package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Seagull extends Flying{
	
	public Seagull() 
	{
		super(Sprite.seagull);
	}
	
	public String speak()
    {
    	return "MINE! MINE! MINE!";
    }
	
	 public String toString() {
	    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
	    }

}
