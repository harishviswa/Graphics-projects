import java.awt.*;

public class Cloud {
	
	private int x;
	private int y;
	private Color color;
	private int diameter;
	private int xSpeed; //determine the distance moved each update

	
	public Cloud(int x, int y, int diameter, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.diameter = diameter;
		xSpeed = 0;

	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		// middle row
		g.fillOval(x-(diameter+diameter/2)+1, y-diameter/2, diameter, diameter);
		g.fillOval(x-diameter/2, y-diameter/2, diameter, diameter);
		g.fillOval(x+diameter/2, y-diameter/2, diameter, diameter);
		
		// top row
		g.fillOval(x-diameter, y-diameter, diameter, diameter);
		g.fillOval(x-1, y-diameter, diameter, diameter);
		
		// bottom row
		g.fillOval(x-diameter, y+1, diameter, diameter);
		g.fillOval(x-1, y, diameter, diameter);
	}
	
	public int getX() {
		return x;
	}
	
	public void setXSpeed(int speed) {
		xSpeed = speed;
	}
	
	public void move(int edge) {
		x = x + xSpeed;
		
		if(x - (diameter*2) > edge) {
			x = 0-(diameter*2);
		}
	}
	
}


















