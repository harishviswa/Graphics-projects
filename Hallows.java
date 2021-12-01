//Harish Viswa
//ITCS
//02.04.2021
import java.awt.Color;
import java.awt.Graphics;

public class Hallows {

	//Fields (properties of the symbol)
	private int x;
	private int y;
	private int size;
	
	//Constructor creating the hallows with (x,y) representing the bottom left hand corner of the symbol
	//width and height represented by size
	public Hallows(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void draw(Graphics g) {
		//draw outer triangle
		int[] xPoints = {x, x + size/2, x + size};
		int[] yPoints = {y, y - size, y};
		g.drawPolygon(xPoints, yPoints, xPoints.length);
		//variables to draw line
		int xtop = x + size/2;
		int ytop = y;
		int xbot = x + size/2;
		int ybot = y-size;
		g.drawLine(xtop, ytop, xbot, ybot);
		//draws inner circle (to the closest possible I could get within the time limit)
		g.drawOval(x + size/2, y - size/2, size/2, size/2);
		

	}
}