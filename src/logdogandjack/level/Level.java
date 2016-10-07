package logdogandjack.level;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

import logdogandjack.Game;
import logdogandjack.entities.*;
import logdogandjack.graphics.*;
import logdogandjack.input.Keyboard;
import logdogandjack.level.state.*;

public class Level {

	public static Player player;
	public static int cameraX, cameraY, score = 1;
	public static State currentState;

	public static State PLAYING, MENU;

	public Level() {
		player = new Player();
		PLAYING = new Playing();
		MENU = new Menu();

		currentState = MENU;
		reset();
	}

	public void update() {
		currentState.update();

		if (currentState instanceof Playing) {
			Entity.updateAll();
			cameraX += 2;
			score++;

			if (score % 120 == 0 && score > 100) {
				for (int i = 0; i < Math.exp(score / 5000.0) + 1; i++)
					spawnRandomHostile();
			}

			currentState.setText("Score " + score);
		
			if (player.health <= 0) {
				currentState = MENU;
				postgameTasks();
			}

		} else if (currentState instanceof Menu) {

		}
	}

	public void render(Screen screen) {

		if (currentState instanceof Playing) {
			screen.renderBackground(-cameraX);
			Entity.renderAll(screen);
		} else if (currentState instanceof Menu) {
			screen.renderSprite(0, 0, Sprite.menuBackground);
		}

		currentState.render(screen);
	}

	private static void spawnRandomHostile() {
		int rand = (int) (Math.random() * 2);
		int x = 0;
		if (rand == 0)
			x = 1;
		else
			x = Game.WIDTH - 1;
		
		spawnRandomHostile(x, (int) (Math.random() * Game.HEIGHT));
	}

	private static void spawnRandomHostile(int x, int y) {
		int rand = (int) (Math.random() * 12);
		switch (rand) {
		case 0:
			new Alligator(x, y);
			break;
		case 1:
			new Crocodile(x, y);
			break;
		case 2:
			new Elephant(x, y);
			break;
		case 3:
			new Giraffe(x, y);
			break;
		case 4:
			new Gorilla(x, y);
			break;
		case 5:
			new Hippo(x, y);
			break;
		case 6:
			new Kangaroo(x, y);
			break;
		case 7:
			new Lion(x, y);
			break;
		case 8:
			new Rhino(x, y);
			break;
		case 9:
			new Snake(x, y);
			break;
		case 10:
			new Tiger(x, y);
			break;
		case 11:
			new Zebra(x, y);
			break;
		}
	}

	private static void postgameTasks() {
		if (score > Game.highscore) {
			Keyboard.turnOff();
			String newLeader = (String) JOptionPane.showInputDialog(Game.frame, "Enter your name here",
					"New Highscore! (" + score + ")", JOptionPane.PLAIN_MESSAGE, null, null, Game.highscorer);
			Game.highscore = score;
			PrintWriter output = null;
			try {
				output = new PrintWriter(new File("res/saves/highscore.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			output.println(newLeader);
			output.println(score);
			output.close();
			Game.highscores = "Leader: " + newLeader + " (" + score + ")";
		} else {
			Keyboard.turnOff();
			JOptionPane.showConfirmDialog(Game.frame, "You got " + score + " points!", "Game Over",
					JOptionPane.PLAIN_MESSAGE);
		}

		reset();
	}

	public static void reset() {
		player.reset();
		cameraX = 0;
		score = 1;
		int i = 0;
		while (i < Entity.entities.size()) {
			Entity.entities.remove(i);
		}
		Entity.entities.add(player);
	}
	
}
