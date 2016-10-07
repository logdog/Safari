package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Pig extends Domestic
{
    public Pig()
    {
        super(Sprite.pig);
    }
    
    public String speak()
    {
    	return "oink";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
    }
}