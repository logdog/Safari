package logdogandjack;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

import logdogandjack.graphics.Screen;
import logdogandjack.input.Keyboard;
import logdogandjack.input.Mouse;
import logdogandjack.level.Level;
import logdogandjack.entities.*;


public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	private boolean running = false;
	private Screen screen;
	private Keyboard key;
	private Mouse mouse;
	public static int highscore;
	private Level level;
	public static String title = "Safari";
	public static String highscores = "Leader: ", highscorer = "";
	public static final int WIDTH = 800, HEIGHT = 512, SCALE = 1;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	public int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);

		frame = new JFrame();
		screen = new Screen(WIDTH, HEIGHT);
		level = new Level();
		
		key = new Keyboard();
		mouse = new Mouse();
		
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse); 
		addMouseWheelListener(mouse);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0, updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps" + "  |  " + highscores);
				updates = 0;
				frames = 0;
			}
		}
	}
	
	public void update() {
		Keyboard.update();
		level.update();
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		
		//stuff
		screen.clear();
		level.render(screen);
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		
		//time spent here around 2:30
		/*
		System.out.println("Here are some hostile animals");
		
		Hippo hippo = new Hippo();
		MountainChicken mc = new MountainChicken();
		Alligator ally = new Alligator();
		
		ally.setGender(Gender.FEMALE);
		
		System.out.println(hippo);
		System.out.println(mc);
		System.out.println(ally);
		
		System.out.println("\nAlly the alligator doesn't feel so hot. She has a case of swampitus");
		
		ally.die();
		
		Vulture valechka = new Vulture();
		valechka.setGender(Gender.FEMALE);
		
		System.out.println("\nThe vulture is hungry...\nValechka the Vulture will eat ally the alligator!");
		
		valechka.eatAnimal(ally);
		
		System.out.println("\nMeanwhile, a seagull roams the surrounding skies. Lets call him Jerry");
		
		Seagull jerry = new Seagull();
		
		System.out.println("Valechka the vulture is scared of Jerry. He has a rare, lifethreatening blood disease. valechka flies away");
		
		valechka.fly();
		
		Player joe = new Player();
		
		System.out.println("\nWe have created a player on a safari. His name is Joe. Joe likes to kill animals");
		
		hippo.die();
		mc.die();
		jerry.die();
		
		System.out.println("The hippo is dead. The Mountain Chicken is dead. Jerry is dead. Jerry went poof beacuse he was a flying animal.\nValechka survived because she flew away.");
		
		System.out.println("\nThe player has a defined amount of health. He is damaged by hostile mobs. Each hostile mob can do a different amount of damage per hit.");
		
		System.out.println("Before Ally got swampitus, she did " + ally.damage + " damage to the player.");
		
		joe.health -= ally.damage;
		//cannot call the takeDamage(int damage) method because the Level class hasn't been instantiated yet
		
		System.out.println("Here, Joe took " + ally.damage + " damage! Initially Joe had 100 health. Now he has " + joe.health);
		
		System.out.println("Likewise, hostile animals have different amounts of speed.\nOur hippo can move at a rate of " + hippo.speed + " meters per second");
		System.out.println("The fast Mountain Chicken could move at a rate of " + mc.speed + " meters per second");
		
		System.out.println("\nEnough with Hostile and flying animals. Let's create a domestic dog");
		
		Dog sparky = new Dog();
		
		System.out.println("Dogs love food, so let's feed him!");
		
		sparky.tame(Item.BANANA);
		
		System.out.println("After giving sparky the banana, his tamed status is " + sparky.tamed);
		System.out.println("Sparky only likes bones. Let's give him a bone!");
		
		sparky.tame(Item.BONE);
		
		System.out.println("After giving sparky a bone, his tamed status is " + sparky.tamed);
		
		System.out.println("\nIt worked! Sparky is now a tamed dog");
		
		System.out.println("Monkeys and Cats can be tamed in a similar manner");
		
		System.out.println("Enough with these animals, let's go on a safari mission!");
		
		System.out.println("*smooth transition to jar file*");
		*/
		
		Game game = new Game();
		
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("res/saves/highscore.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		highscorer += scan.nextLine();
		highscores += highscorer;
		highscores += " (";
		highscore = scan.nextInt();
		highscores += highscore;
		highscores += ")";
		
		frame.setResizable(false);
		frame.setTitle(title);

		frame.add(game);
		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		game.start();
		
	}
}
