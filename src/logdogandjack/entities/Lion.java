package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Lion extends Hostile
{
    public Lion()
    {
        super(Sprite.lion);
        damage = 4;
    }
    
    public Lion(int x, int y)
    {
        super(x, y, Sprite.lion);
        damage = 4;
    }
    
    public String speak()
    {
    	return "ROAR";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
    }
}