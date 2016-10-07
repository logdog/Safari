package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Pigeon extends Flying{
	
	public Pigeon() 
	{
		super(Sprite.pigeon);
	}
	
	public String speak()
    {
    	return "coo";
    }
	
	 public String toString() {
	    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
	    }

}
