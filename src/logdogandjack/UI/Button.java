package logdogandjack.UI;

import logdogandjack.graphics.Screen;
import logdogandjack.input.Mouse;
import logdogandjack.level.Level;

/*
 * 
 * buttons are rectangles that do something when the mouse is clicked on them
 * that is it. they can update and render and also do stuff when clicked
 * this will probably be an boolean isClicked() method
 * 
 */

public class Button extends Component {

	public int col = 0xcccccc;
	public final String ID;
	private TextBox text = null;

	public Button(int x, int y, int w, int h, String id, Panel panel) {
		super(x, y, w, h, panel);
		ID = id;
	}

	public Button(int x, int y, int w, int h, String msg, String id, Panel panel) {
		super(x, y, w, h, panel);
		text = new TextBox(x + w / 2, y + h / 2, msg, panel);
		ID = id;
	}
	
	public void setBackground(int col){
		this.col = col;
	}

	public void update() {
		if(Mouse.xPos > xRel && Mouse.xPos < xRel + width && Mouse.yPos > yRel && Mouse.yPos < yRel + height && Mouse.leftPressed) {
			if(ID.equalsIgnoreCase("playbutton")) {
				Level.currentState = Level.PLAYING;
			}
		}
	}


	public void render(Screen screen) {
		screen.fillRect(xRel, yRel, width, height, col);
		screen.drawRect(xRel, yRel, width, height, 0);

		if (text != null)
			text.render(screen);
	}

}
