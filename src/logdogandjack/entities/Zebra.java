package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Zebra extends Hostile {
	public Zebra() {
		super(Sprite.zebra);
		damage = 3;
		speed = 5;
	}

	public Zebra(int x, int y) {
		super(x, y, Sprite.zebra);
		damage = 3;
		speed = 5;
	}

	public String speak() {
		return "whinny";
	}
	
	 public String toString() {
	    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
	    }
}