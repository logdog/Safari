package logdogandjack.level.state;

import logdogandjack.Game;
import logdogandjack.UI.*;

public class Menu extends State{
	
	public Button button;
	public Panel uip;
	
	public Menu() {
		super();
		uim = new UIManager();
		uip = new Panel(Game.WIDTH / 2 - 100, Game.HEIGHT / 2 - 30, 200, 80, uim);
		button = new Button(0, 0, 200, 80, "PLAY", "playbutton", uip);
	}
}
