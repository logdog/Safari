package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Rhino extends Hostile
{
    public Rhino()
    {
        super(Sprite.rhino);
        damage = 5;
    }
    
    public Rhino(int x, int y)
    {
        super(x, y, Sprite.rhino);
        damage = 5;
    }
    
    public String speak()
    {
    	return "Snort, snort";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
    }
}