import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class BouncingBallTester extends JPanel {

	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;

	private BufferedImage image;
	private Graphics g;
	public Timer timer;

	public BouncingBallTester() {

		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();

		// Test default constructor
		Ball defaultBall = new Ball();
		defaultBall.draw(g);
		printSpecs(defaultBall, "defaultBall");
		
		// Test setMethods
		defaultBall.setColor(Color.YELLOW);
		defaultBall.setX(100);
		defaultBall.setY(300);
		defaultBall.setRadius(75);
		defaultBall.setRandomSpeed(10);
		defaultBall.draw(g);
		
		System.out.println();
		printSpecs(defaultBall, "defaultBall");
		
		
		// Test other constructor
		Ball parameterBall = new Ball(400, 200, 125, Color.GREEN);
		parameterBall.draw(g);
		printSpecs(parameterBall, "parameterBall");
		
		// Test other set methods
		parameterBall.setColor(Color.CYAN);
		parameterBall.setDiameter(200);
		parameterBall.setLocation(400, 0);
		parameterBall.setXSpeed(3.24);
		parameterBall.setYSpeed(-3.9823);
		parameterBall.draw(g);
		
		System.out.println();
		printSpecs(parameterBall, "parameterBall");
		
		
		
		

	}

	
	public void printSpecs(Ball ball, String ballName) {
		System.out.println(ballName + "   Color: " + ball.getColor());
		System.out.println("X: " + ball.getX() + "   Y: " + ball.getY());
		System.out.println("Diameter: " + ball.getDiameter() + "   Radius: " + ball.getRadius());
		System.out.println("X-Speed: " + ball.getXSpeed() + "   Y-Speed: " + ball.getYSpeed());
		
	}

	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}



	public static void main(String[] args) {

		JFrame frame = new JFrame("Bouncing Ball Tester");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(200, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new BouncingBallTester());
		frame.setVisible(true);
	}

}