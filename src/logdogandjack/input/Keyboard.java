package logdogandjack.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import logdogandjack.entities.Projectile;
import logdogandjack.level.Level;
import logdogandjack.entities.Mob.Direction;

public class Keyboard implements KeyListener{
	public static boolean[] keys = new boolean[255];
	public static boolean up, down, left, right, shift;
	
	public static void update(){
		up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		shift = keys[KeyEvent.VK_SHIFT];
	}
	
	public static void turnOff() {
		keys[KeyEvent.VK_W] = false;
		keys[KeyEvent.VK_UP] = false;
		keys[KeyEvent.VK_S] = false;
		keys[KeyEvent.VK_DOWN] = false;
		keys[KeyEvent.VK_A] = false;
		keys[KeyEvent.VK_LEFT] = false;
		keys[KeyEvent.VK_D] = false;
		keys[KeyEvent.VK_RIGHT] = false;
		keys[KeyEvent.VK_SHIFT] = false;
		update();
	}
	
	public void keyTyped(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
			if(Level.player.getDir() == Direction.RIGHT)
				new Projectile(Level.player.xRel + 66, Level.player.yRel + 32, true);
			else
				new Projectile(Level.player.xRel - 2, Level.player.yRel + 32, false);
		}
	}

	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
			if(Level.player.getDir() == Direction.RIGHT)
				new Projectile(Level.player.xRel + 66, Level.player.yRel + 32, true);
			else
				new Projectile(Level.player.xRel - 2, Level.player.yRel + 32, false);
		}
	}

	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
}
