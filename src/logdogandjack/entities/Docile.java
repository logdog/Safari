package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public abstract class Docile extends Animal
{
    public Docile(Sprite sprite)
    {
        super(sprite);
    }
    
    public String getDeathSound()
    {
    	return "thump";
    }
}