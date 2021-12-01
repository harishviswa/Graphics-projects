import java.awt.*;
import java.util.*;
import javax.swing.*;


//create 100 snowflakes that will spawn in random locations
public class Snowflake {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	public Snowflake(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
public void draw(Graphics g) {
	g.drawOval(x, y, 5, 5);
	g.fillOval(x, y, 5, 5);
	g.drawOval(x, y+10, 5, 5);
	g.fillOval(x, y+10, 5, 5);
	g.drawOval(x+5, y+5, 5, 5);
	g.fillOval(x+5, y+5, 5, 5);
	g.drawOval(x-5, y+5, 5, 5);
	g.fillOval(x-5, y+5, 5, 5);
	    }
}




