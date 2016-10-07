package logdogandjack.UI;

import logdogandjack.graphics.Screen;

public class StatusBar extends Component{

	private int currentStat, maxStat, barColor;
	private TextBox text;
	
	public StatusBar(int xRel, int yRel, int width, int height, String title, int barCol, Panel panel) {
		super(xRel, yRel, width, height, panel);
		text = new TextBox(xRel + width / 2, yRel - 12, title, panel);
		barColor = barCol;
	}
	
	public void setCurrent(int c) {
		currentStat = c;
	}
	
	public void setMax(int m) {
		maxStat = m;
	}
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		screen.fillRect(xRel,  height, width, 16, 0xffffff);
		screen.fillRect(xRel,  height, (int) (width * ((double)currentStat / maxStat)), 16, barColor);
		text.render(screen);

	}

}
