package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Elephant extends Hostile
{
    public Elephant()
    {
        super(Sprite.elephant);
        damage = 6;
        speed = 3;
        diet = Diet.HERBIVORE;
    }
    
    public Elephant(int x, int y)
    {
        super(x, y, Sprite.elephant);
        damage = 6;
        speed = 3;
        diet = Diet.HERBIVORE;
    }
    
    public String speak()
    {
    	return "*trumpet sounds*";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender ; //+ "\tThis animal's favorite food is a " + favoriteFood;
    }
}