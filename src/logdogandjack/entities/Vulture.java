package logdogandjack.entities;

import logdogandjack.graphics.Sprite;

public class Vulture extends Flying {

	public Vulture() {
		super(Sprite.vulture);
	}

	public String speak() {
		return "*scream*";
	}

	public void eatAnimal(Animal other) {
		if (other.isDead()) {
			System.out.println("The vulture is eating the " + other.getClass().getSimpleName());
			System.out.println("The vulture is satisfied with its meal");
		}
		else
			System.out.println("The vulture only eats carrion");
	}

	public String toString() {
		return "Type: " + getClass().getSimpleName() + "\tThis animal says " + speak() + "\t This animal is a "
				+ gender;// + "\tThis animal's favorite food is a " +
							// favoriteFood;
	}

}
