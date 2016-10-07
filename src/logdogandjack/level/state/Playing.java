package logdogandjack.level.state;

import logdogandjack.UI.*;
import logdogandjack.level.Level;


public class Playing extends State{
	
	public TextBox tb;
	public StatusBar sb;
	
	public Playing() {
		super();
		uim = new UIManager();
		Panel uip = new Panel(0, 0, 150, 16, uim);
		tb = new TextBox(75, 2, "Score ", uip);
		sb = new StatusBar(0, 30, 150, 16, "Health", 0xff0000, uip);
		sb.setCurrent(Level.player.health);
		sb.setMax(Level.player.health);
	}
	
	public void setText(String str) {
		tb.changeMessage(str);
	}
	
	public void setStat(int x) {
		sb.setCurrent(x);
	}
	
}
