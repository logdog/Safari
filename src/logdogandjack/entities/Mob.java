package logdogandjack.entities;

import logdogandjack.Game;
import logdogandjack.graphics.Screen;
import logdogandjack.graphics.Sprite;
import logdogandjack.level.Level;

public abstract class Mob extends Entity {

	public enum Direction {
		LEFT, RIGHT
	};

	protected Sprite sprite;
	protected Direction dir = Direction.RIGHT;
	public int health = 100;
	public int speed = 4;
	public boolean alive = true;

	public Mob(int x, int y, Sprite sprite) {
		super(x, y);
		this.sprite = sprite;
	}

	public void move(int x, int y) {
		while (x != 0 || y != 0) {
			if (y > 0) { // down

				if (yPos > Level.player.yPos)
					yPos++;
				else if (Level.player.yPos - yPos >= 32)
					yPos++;
				else if (Math.abs(xPos - Level.player.xPos) >= 32)
					yPos++;

				y--;
			}

			if (y < 0) { // up

				if (Level.player.yPos > yPos)
					yPos--;
				else if (yPos - Level.player.yPos >= 32)
					yPos--;
				else if (Math.abs(xPos - Level.player.xPos) >= 32)
					yPos--;

				y++;
			}

			if (x > 0) { // right
				setDir(Direction.RIGHT);

				if (xPos > Level.player.xPos)
					xPos++;
				else if (Level.player.xPos - xPos >= 32)
					xPos++;
				else if (Math.abs(Level.player.yPos - yPos) >= 32)
					xPos++;

				x--;
			}

			if (x < 0) { // left
				setDir(Direction.LEFT);

				if (xPos < Level.player.xPos)
					xPos--;
				else if (xPos - Level.player.xPos >= 32)
					xPos--;
				else if (Math.abs(yPos - Level.player.yPos) >= 32)
					xPos--;

				x++;
			}
		}
	}

	public void takeDamage(int damage) {
		health -= damage;
	}

	public void update() {
		xRel = xPos - Level.cameraX;
		yRel = yPos - Level.cameraY;

		if (alive) {
			if (xPos > Level.player.xPos)
				move(-speed, 0);
			if (xPos < Level.player.xPos)
				move(speed, 0);
			if (yPos < Level.player.yPos)
				move(0, speed);
			if (yPos > Level.player.yPos)
				move(0, -speed);
		}
		if (xRel < -63 || xRel >= Game.WIDTH || yRel < -63 || yRel >= Game.HEIGHT) {
			entities.remove(this);
		}
	}

	public void render(Screen screen) {
		if (getDir() == Direction.LEFT)
			screen.renderReverseSprite(xRel, yRel, sprite);
		else
			screen.renderSprite(xRel, yRel, sprite);
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
}
