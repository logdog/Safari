package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Giraffe extends Hostile
{
    public Giraffe()
    {
        super(Sprite.giraffe);
        damage = 3;
        speed = 4;
        diet = Diet.HERBIVORE;
    }
    
    public Giraffe(int x, int y)
    {
        super(x, y, Sprite.giraffe);
        damage = 3;
        speed = 4;
        diet = Diet.HERBIVORE;
    }
    
    public String speak()
    {
    	return "munch";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
    }
}