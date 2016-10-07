package logdogandjack.level.state;

import logdogandjack.UI.UIManager;
import logdogandjack.graphics.Screen;

public class State {
	protected UIManager uim;
	
	public State() {
		
	}
	
	public void update() {
		uim.update();
	}
	
	public void setText(String str) {
		
	}
	
	public void setStat(int x) {
		
	}
	
	public void render(Screen screen) {
		uim.render(screen);
		//sSystem.out.println("render state");
	}
}
