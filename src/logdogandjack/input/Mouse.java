package logdogandjack.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import logdogandjack.Game;

public class Mouse implements MouseMotionListener, MouseListener, MouseWheelListener{
	public static boolean leftPressed, rightPressed, scrollPressed;
	public static int xPos, yPos;
	
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		
	}

	
	public void mouseDragged(MouseEvent e) {
		
		
	}

	
	public void mouseMoved(MouseEvent e) {
		xPos = e.getX() / Game.SCALE;
		yPos = e.getY() / Game.SCALE;
	}

	
	public void mouseClicked(MouseEvent e) {
		
	}

	
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1) {
			leftPressed = true;
			/*
			int ex = e.getX() / Game.SCALE;
			int ey = e.getY() / Game.SCALE;
			int px = Level.player.getX();
			int py = Level.player.getY();
			double theta = 0.0;
			
			if(ex > px && ey > py) {
				theta = 4.71 + Math.atan( (double)(ex - px) / (ey - py) );
				Level.player.setDir(Direction.RIGHT);
			}
			else if(ex > px && ey < py) {
				theta = Math.atan( (double)(py - ey) / (ex - px) );
				Level.player.setDir(Direction.RIGHT);
			}
			else if(ex < px && ey > py) {
				theta = 3.14 - Math.atan( (double)(py - ey) / (px - ex) );
				Level.player.setDir(Direction.LEFT);
			}
			else if(ex < px && ey < py) {
				theta = 3.14 - Math.atan( (double)(py - ey) / (px - ex) );
				Level.player.setDir(Direction.LEFT);
			}
			
			else if(ex == px && ey > py)
				theta = 4.71;
			else if(ex == px && ey < py)
				theta = 3.14 / 2;
			else if(ey == py && px > ex) {
				theta = 3.14;
				Level.player.setDir(Direction.LEFT);
			}
			else
				Level.player.setDir(Direction.RIGHT);
				
			if(Level.player.getDir() == Direction.RIGHT)
				new Projectile(px + 66, py + 32, theta);
			else
				new Projectile(px - 2, py + 32, theta);
				*/
		}
		if(e.getButton() == 2)
			scrollPressed = true;
		if(e.getButton() == 3)
			rightPressed = true;
	}

	
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == 1)
			leftPressed = false;
		if(e.getButton() == 2)
			scrollPressed = false;
		if(e.getButton() == 3)
			rightPressed = false;
	}

	
	public void mouseEntered(MouseEvent e) {
		
		
	}

	
	public void mouseExited(MouseEvent e) {
		
		//System.exit(1);
	}
}
