import java.awt.Color;
import java.awt.Graphics;

public class Mountain {

	//Fields (properties of mountains)
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	/**
	 * Creates a mountain with its base centered at (x, y) with 
	 * the given width and height
	 * @param x the x-coordinate of the center of the base of the mountain
	 * @param y the y-coordinate of the center of the base of the mountain
	 * @param width the width of the mountain
	 * @param height the height of the mountain
	 */
	public Mountain(int ax, int ay, int aWidth, int aHeight, Color aColor) {
		x = ax;
		y = ay;
		width = aWidth;
		height = aHeight;
		color = aColor;
	}
	
	/**
	 * Draws a triangular mountain
	 * @param g the Graphics object
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		int[] xPoints = {x - width/2, x, x + width/2};
		int[] yPoints = {y, y - height, y};
		g.fillPolygon(xPoints, yPoints, xPoints.length);

	}

}