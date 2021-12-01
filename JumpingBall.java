import java.awt.Color;


public class JumpingBall extends Ball{

	//create 2 constructors using the super class(ball) constructors
	//defaults constructor which used the same default as ball
	JumpingBall() {
		super();
	}
	
	//4 parameter constructor (x,y,diameter,color)
	
	//override the move method to remove the ball from its current location
	//relocate it at another random location on the screen
	//take in the same two parameters of bottom and right edge of screen
	public JumpingBall(double x, double y, double diameter, Color color) {
		super(x,y,diameter,color);
	}
	
	/**
		 * Moves to a random location within the boundaries of the rightEdge
		 * and bottomEdge
		 * @param rightEdge the rightEdge of the movement area
		 * @param bottomEdge the bottomEdge of the movement area
		 */
		public void move(int rightEdge, int bottomEdge) {
				setX((int)(Math.random()*200));
				setY((int)(Math.random()*200));
		}

	
	//distanceFrom method which calculates the distance between the center of the two objects
	//(x,y) positions of both objects - take the parameters (x,y) of the other ball
	
	public double findDistanceFrom(double x, double y) {
		return Math.sqrt((this.getX()-x)*(this.getX()-x)+(this.getY()-y)*(this.getY()-y));
			
	}
		
	//intersectsWith method checks to see if the Ball and the JumpringBall touch each other
	//parameter - other ball (ball object)
	//if distanceFrom <= combined radius
	//return value boolean (true/false)
	
	public boolean intersectsWith(Ball otherBall) {
		if(findDistanceFrom(otherBall.getX(), otherBall.getY()) <= (otherBall.getRadius() + this.getRadius())) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
}
