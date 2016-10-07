package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Alligator extends Hostile {
	public Alligator() {
		super(Sprite.alligator);
		diet = Diet.CARNIVOROUS;
		damage = 6;
		speed = 3;
	}
	
	public Alligator(int x, int y)
    {
        super(x, y, Sprite.alligator);
        diet = Diet.CARNIVOROUS;
        damage = 6;
        speed = 3;
    }
	
	public String speak()
	{
		return "CHOMP";
	}
	
	 public String toString() {
		 return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a " + gender;
	 }
	
}