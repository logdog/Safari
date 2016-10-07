package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Crocodile extends Hostile
{
    public Crocodile()
    {
        super(Sprite.crocodile);
        damage = 5;
        speed = 3;
        diet = Diet.CARNIVOROUS;
    }
    
    public Crocodile(int x, int y)
    {
        super(x, y, Sprite.crocodile);
        damage = 5;
        speed = 3;
        diet = Diet.CARNIVOROUS;
    }
    
    public String speak()
    {
    	return "SNAP";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;
    }
}