import java.awt.Color;
import java.awt.Graphics;

public class GravityBall extends Ball{
	//define fields yAcceleration (due to gravity) constant 9.8
	private double yAcceleration;
	
	//define GravityBall constructor with 4 parameters (x, y, diameter, color)
	//call the super constructor that has those parameters
	public GravityBall(double x, double y, double diameter, Color color) {
		super(x,y,diameter,color);
	}
	
	//getters and setters (yAcceleration)

	public void setyAcceleration(double yAcceleration) {
		this.yAcceleration = yAcceleration;
	}
	public double getyAcceleration() {
		return yAcceleration;
	}
	//Methods
	//Launch method will look like move for the boundary conditions
	//launch method parameters will need (rightEdge and bottomEdge)
	//replace the move part of the move method with x and y calculations
	// x = x + xSpeed*deltaTime
	// y = y + ySpeed*deltaTime
	// ySpeed = ySpeed + acceleration*deltaTime

	public void launch(int rightEdge, int bottomEdge, double deltaTime) {
		setXSpeed(getXSpeed());
		setYSpeed(getYSpeed() - yAcceleration*deltaTime);
		
		setX(getX()+getXSpeed()*deltaTime);
		setY(getY()+getYSpeed()*deltaTime);
		
//		if(getX() + getRadius() > rightEdge) {
//			setXSpeed(getXSpeed() * -1);
//		}
		if(getY() + getRadius() > bottomEdge) {
			setYSpeed(getYSpeed() * -1);
		}
		if(getY() - getRadius() < 0) {
			setYSpeed(getYSpeed() * -1);
		}
	}
	
	//2nd method
	//setInitialVelocity - parameters: initial velocity and angle
	//use sin and cos from the math class to calculate xSpeed and ySpeed components
	public void setInitialVelocity(int speed, int angle) {
		setXSpeed(speed * Math.cos(Math.toRadians(angle)));
		setYSpeed(-1*speed * Math.sin(Math.toRadians(angle)));
	}
	
}




