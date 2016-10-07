package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Snake extends Hostile
{
    public Snake()
    {
        super(Sprite.snake);
        damage = 2;
    }
    
    public Snake(int x, int y)
    {
        super(x, y, Sprite.snake);
        damage = 2;
    }
    
    public String speak()
    {
    	return "hisssssss";
    }
    
    public String toString() {
    	return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;// + "\tThis animal's favorite food is a " + favoriteFood;
    }
}