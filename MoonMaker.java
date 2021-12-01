import java.awt.Color;
import java.awt.Graphics;

public class MoonMaker {
	private int x;
	private int y;
	private int x1;
	private int y1;
	private Color color;
	
	public MoonMaker(int x, int y, int x1, int y1, Color color) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.color = color;
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, x1, y1);
	}

}
