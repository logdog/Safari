package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Hippo extends Hostile
{
    public Hippo()
    {
        super(Sprite.hippo);
        damage = 6;
        speed = 3;
        diet = Diet.HERBIVORE;
    }
    
    public Hippo(int x, int y)
    {
        super(x, y, Sprite.hippo);
        damage = 6;
        speed = 3;
        diet = Diet.HERBIVORE;
    }
    
    public String speak()
    {
    	return "huuuuuuuuuugh";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender ;//+ "\tThis animal's favorite food is a " + favoriteFood;
    }
}