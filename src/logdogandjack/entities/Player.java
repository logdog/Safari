package logdogandjack.entities;

import java.util.ArrayList;

import logdogandjack.Game;
import logdogandjack.graphics.Sprite;
import logdogandjack.input.Keyboard;
import logdogandjack.level.Level;

public class Player extends Mob {
	
	protected ArrayList<Item> inventory;
	
	public Player() {
		super(Game.WIDTH / 2, Game.HEIGHT / 2, Sprite.yellow);
		sprite = Sprite.player;
		speed = 8;
	}

	public void reset() {
		xPos = Game.WIDTH / 2;
		yPos = Game.HEIGHT / 2;

		health = 100;
		Level.PLAYING.setStat(health);
	}

	public void takeDamage(int damage) {
		health -= damage;
		Level.PLAYING.setStat(health);
	}

	public void move(int deltaX, int deltaY) {
		xPos += deltaX;
		yPos += deltaY;

		if (deltaX > 0)
			setDir(Direction.RIGHT);
		if (deltaX < 0)
			setDir(Direction.LEFT);
	}

	public void update() {
		if (Keyboard.left) {
			if (Keyboard.shift)
				move(speed, 0);
			move(-speed, 0);
		}
		if (Keyboard.right) {
			if (Keyboard.shift)
				move(-speed, 0);
			move(speed, 0);

		}
		if (Keyboard.up) {
			if (Keyboard.shift)
				move(0, speed);
			move(0, -speed);

		}
		if (Keyboard.down) {
			if (Keyboard.shift)
				move(0, -speed);
			move(0, speed);
		}
			
		xRel = xPos - Level.cameraX;
		yRel = yPos - Level.cameraY;

		if (xRel < -63 || xRel >= Game.WIDTH || yRel < 0 || yRel >= Game.HEIGHT) {
			health = 0;
		}
	}

}
