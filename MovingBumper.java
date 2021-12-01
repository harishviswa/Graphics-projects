import java.awt.Color;
import java.awt.Graphics;

public class MovingBumper extends Bumper {
	
	private double ySpeed; //determine the distance moved each update
	
// default constructor
	public MovingBumper() {
		super();
		ySpeed = 0;
	}
//5 Parameter constructor
	public MovingBumper(int x, int y, int width, int height, Color color) {
		super(x,y,width, height, color);
		ySpeed = 0;
	}

	//y-Speed getter
	public int getYSpeed() {
		return (int)ySpeed;
	}
	//y-Speed setter
	public void setYSpeed(double ySpeed) {
		ySpeed = (int)ySpeed;
	}
//move method
	public void move(int y, int height) {
		y = (int) (y - ySpeed);
		
		if(y-height  <= 0) {
			ySpeed = 0;
		}
	}
	
	
	/**
	 * Returns true if any part of the Ball is inside the bumper
	 * @param ball the Ball
	 * @return true if any part of the Ball is inside the bumper, false otherwise
	 */
	public boolean inBumper(Ball ball) {
		for (int x = getX() - getWidth()/2; x <= getX() + getWidth()/2; x++) {
			for (int y = getY() - getHeight()/2; y <= getY() + getHeight()/2; y++) {
				if (getDistance(x, y, ball.getX(), ball.getY()) <= ball.getRadius()) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Calculates the distance between (x1, y1) and (x2, y2)
	 * @param x1 the x-coordinate of the first point
	 * @param y1 the y-coordinate of the first point
	 * @param x2 the x-coordinate of the second point
	 * @param y2 the y-coordinate of the second point
	 * @return the distance between (x1, y1) and (x2, y2)
	 */
	private double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	
	
}