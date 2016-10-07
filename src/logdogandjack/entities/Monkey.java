package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Monkey extends Domestic
{
    public Monkey()
    {
        super(Sprite.monkey);
       // favoriteFood = Item.BANANA;
    }
 
    
    public String speak()
    {
    	return "OOH OOH AAH AAH";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tFavorite Food: " + favoriteFood + "\tThis animal says " + speak() + "\t This animal is a " + gender;
    }
}