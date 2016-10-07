package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Kangaroo extends Hostile
{
    public Kangaroo()
    {
        super(Sprite.kangaroo);
        damage = 2;
    }
    
    public Kangaroo(int x, int y)
    {
        super(x, y, Sprite.kangaroo);
        damage = 2;
    }
    
    public String speak()
    {
    	return "BOING, MATE!";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
    }
}