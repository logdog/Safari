package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Gorilla extends Hostile
{
    public Gorilla()
    {
        super(Sprite.gorilla);
        damage = 4;
        diet = Diet.HERBIVORE;
        speed = 4;
    }
    
    public Gorilla(int x, int y)
    {
        super(x, y, Sprite.hippo);
        damage = 4;
        speed = 4;
        diet = Diet.HERBIVORE;
    }
    
    public String speak()
    {
    	return "*menancing chest pound*";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
    }
}