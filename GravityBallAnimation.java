import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GravityBallAnimation extends JPanel {
	
	//declare constant variables for width and height of the panel
	private static final int WIDTH = 2000;
	private static final int HEIGHT = 1040;
	private static final double deltaTime = 0.04;
	
	// Declare objects to be used
	private BufferedImage image;
	private Timer timer;
	private Graphics g;
	private GravityBall ball;
	
	public GravityBallAnimation() {
		//making BufferedImage
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		
		//Initial image - background, objects
		ball = new GravityBall(300, 200, 50, Color.blue);
		ball.setInitialVelocity(10, 45);
		ball.setyAcceleration(-9.8);
		ball.draw(g);
		
		timer = new Timer((int)	deltaTime*1000, new TimerListener());
		timer.start();
	}
	
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//image updates
			g.setColor(Color.white);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.blue);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("X: ", 100, 100);
			g.drawString("X Speed: ", 100, 150);
			g.drawString("Y: ", 100, 200);
			g.drawString("Y Speed: ", 100, 250);
			g.drawString(String.valueOf(ball.getX()), 150, 100);
			g.drawString(String.valueOf(ball.getY()), 150, 200);
			g.drawString(String.valueOf(ball.getXSpeed()), 300, 150);
			g.drawString(String.valueOf(ball.getYSpeed()), 300, 250);
			//object re-draws
			ball.launch(WIDTH, HEIGHT, deltaTime);
			ball.draw(g);
			
			repaint();
		}
	}
	
	//paintComponent (draws the image)
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
	
	//Driver
	public static void main(String[] args) {
		JFrame frame = new JFrame("Gravity Ball");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(-10,0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new GravityBallAnimation());
		frame.setVisible(true);
	}

}
