package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public abstract class Flying extends Docile
{
    public Flying(Sprite sprite)
    {
        super(sprite);
    }
    
    public String getDeathSound()
    {
    	return "poof!";
    }
    
    public void fly ()
    {
    	System.out.println("I'm flying away! WEEE");
    }
}