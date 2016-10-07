package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Tiger extends Hostile
{
    public Tiger()
    {
        super(Sprite.tiger);
        damage = 3;
    }
    
    public Tiger(int x, int y)
    {
        super(x, y, Sprite.tiger);
        damage = 3;
    }
    
    public String speak()
    {
    	return "ROAR";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
    }
}