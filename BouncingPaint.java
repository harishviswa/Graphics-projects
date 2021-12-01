import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class BouncingPaint extends JPanel {
	
	//width and height variables
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	private BufferedImage image;
	private Timer timer;
	private Graphics g;
	//array of 15 balls
	private Ball balls[] = new Ball[15];
	
	public BouncingPaint() {
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();

		for(int i = 0; i < 15; i++) {
			
			//randomly generated values to be used in creating the 
			//balls later
			int x = (int)(Math.random()*400);
			int y = (int)(Math.random()*400);
			int size = (int)(Math.random()*50);
			int red = (int)(Math.random()*255);
			int green = (int)(Math.random()*255);
			int blue = (int)(Math.random()*255);
			Color color = new Color(red, green, blue);
			
			//creating and drawing the balls w/ generated
			//x, y, size, and color
			balls[i] = new Ball(x, y, size, color);
			balls[i].draw(g);
			
			//setting x and y speeds of the balls
			balls[i].setRandomSpeed(10);
		}
		// create a Timer object and call the listener defined in the private class below
		// The listener can be called anything you chose
		timer = new Timer(5, new TimerListener());
		timer.start();
	}
	
	//timer (draws background and balls)
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < 15; i++) {
				balls[i].move(WIDTH, HEIGHT);
				balls[i].draw(g);
			}
			repaint();
		}
	}
	
	//paintComponent (drawing the image)
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
	
	//Driver
	public static void main(String[] args) {
			JFrame frame = new JFrame("Bounce...bounce...");
			frame.setSize(500,500);
			frame.setLocation(200,100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(new BouncingBall());
			frame.setVisible(true);
	}

}