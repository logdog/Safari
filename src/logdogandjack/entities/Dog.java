package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Dog extends Domestic
{
    public Dog()
    {
        super(Sprite.dog);
        favoriteFood = Item.BONE;
        speed = 5;
    }
    
    public String speak()
    {
    	return "BOW WOW";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender + "\tThis animal's favorite food is a " + favoriteFood;
    }
}