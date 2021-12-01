import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class Rocket {

	private double x;
	private double y;
	private double width;
	private double height;
	private double ySpeed; //determine the distance moved each update

	/**
	 * Creates a rocket, with the given coordinates being the coordinates of its
	 * bottom left corner (with given width and height).
	 * @param x: x-coordinate of bottom-left of rocket
	 * @param y: y-coordinate of bottom-left of rocket
	 * @param width: width of rocket
	 * @param height: height of rocket
	 */
	public Rocket(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		ySpeed = 0;
	}

	/**
	 * Draws a rocket
	 * @param g the Graphics object
	 */
	public void draw(Graphics g) {
		
		//convert fields to ints
		int x = (int)this.x;
		int y = (int)this.y;
		int width = (int)this.width;
		int height = (int)this.height;
		

		//height and width variables
		int h1 = (height/3);
		int h2 = h1*2;
		int w1 = width/3;
		int w2 = w1*2;
		int w3 = width/2;

		//left wing
		int[] xPoints = {x, x+w1, x+w1};
		int[] yPoints = {y, y, y-h1};
		g.setColor(new Color(64,64,64));
		g.fillPolygon(xPoints, yPoints, 3);
		g.setColor(Color.black);
		g.drawPolygon(xPoints, yPoints, 3);

		//body
		g.setColor(Color.black);
		g.fillRect(x+w1, y-h2, w1, h2);
		g.setColor(Color.BLACK);
		g.drawRect(x+w1, y-h2, w1, h2);

		//right wing
		int[] xPoints2 = {x+width, x+w2, x+w2};
		int[] yPoints2 = {y, y, y-h1};
		g.setColor(new Color(64,64,64));
		g.fillPolygon(xPoints2, yPoints2, 3);
		g.setColor(Color.BLACK);
		g.drawPolygon(xPoints2, yPoints2, 3);

		//nose cone
		int[] xPoints3 = {x+w1, x+w2, x+w3};
		int[] yPoints3 = {y-h2, y-h2, y-height};
		g.setColor(Color.WHITE);
		g.fillPolygon(xPoints3, yPoints3, 3);
		g.setColor(Color.BLACK);
		g.drawPolygon(xPoints3, yPoints3, 3);

		//cool red window
		g.setColor(Color.red);
		g.fillOval(x+w1+5, y-h2+15, w1-10, h1/2);
		g.setColor(Color.black);
		g.drawOval(x+w1+5, y-h2+15, w1-10, h1/2);

		//String printing
		//spacing variable for adjustable spacing based on width & height
		int spacing = height/13;
		int w4 = w3-5;
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, width/5));
		g.drawString("I", x+w4, y-h1+spacing);
		g.drawString("T", x+w4, y-h1+2*spacing);
		g.drawString("C", x+w4, y-h1+3*spacing);
		g.drawString("S", x+w4, y-h1+4*spacing);
	}
	
	public int getX() {
		return (int)x;
	}
	
	public double getY() {
		return (int)y;
	}
	
	public int getYSpeed() {
		return (int)ySpeed;
	}
	
	public void setYSpeed(double d) {
		ySpeed = (int)d;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void move(int edge) {
		y = y - ySpeed;
		
		if(y-height  <= 0) {
			ySpeed = 0;
		}
	}
	
}