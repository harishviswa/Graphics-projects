import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class BouncingBall extends JPanel {
	
	//width and height variables
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	private BufferedImage image;
	private Timer timer;
	private Graphics g;
	//array of 15 balls
	private Ball balls[] = new Ball[15];
	
	public BouncingBall() {
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();

		for(int i = 0; i < 15; i++) {
			
			//randomly generated values
			int x = (int)(Math.random()*400);
			int y = (int)(Math.random()*400);
			int size = (int)(Math.random()*50);
			int red = (int)(Math.random()*255);
			int green = (int)(Math.random()*255);
			int blue = (int)(Math.random()*255);
			Color color = new Color(red, green, blue);
			
			//creation and painting of the balls
			balls[i] = new Ball(x, y, size, color);
			balls[i].draw(g);
			
			//setting random x and y speeds of the balls
			balls[i].setRandomSpeed(10);
			balls[i].setRandomSpeed(5);
		}
		// Timer object
		timer = new Timer(5, new TimerListener());
		timer.start();
	}
	
	//timer (draws background and balls)
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
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
			JFrame frame = new JFrame("Bounce Ball Bounce");
			frame.setSize(500,500);
			frame.setLocation(200,100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(new BouncingBall());
			frame.setVisible(true);
	}

}