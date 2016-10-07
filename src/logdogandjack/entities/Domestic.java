package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public abstract class Domestic extends Docile
{
	public boolean tamed;
	public Item favoriteFood;
	public String name = "";
	
    public Domestic(Sprite sprite)
    {
        super(sprite);
    }
    
    public boolean tame(Item item)
    {
    	if(item == favoriteFood)
    		tamed = true;
    	return tamed;
    }  
    
    public void setName(String name) 
    {
    	this.name = name;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public String getDeathSound()
    {
    	return "wimper wimper";
    }
}