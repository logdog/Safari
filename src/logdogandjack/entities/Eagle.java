package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Eagle extends Flying{

	public Eagle()
	{
		super(Sprite.eagle);
	}
	
	public String speak()
	{
		return "'MURICA!";
	}
	
	 public String toString() {
	    return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender ;
	 }
	
}
