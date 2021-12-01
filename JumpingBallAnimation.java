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

public class JumpingBallAnimation extends JPanel{
	//width and height variables
	private static final int WIDTH = 200;
	private static final int HEIGHT = 200;
	private static  int collisions = 0;
	
	private BufferedImage image;
	private Timer timer;
	private Graphics g;
	
	private Ball otherBall;
	private Ball otherotherBall;
	private JumpingBall jumpers[] = new JumpingBall[5];
	private int hitCount[] = new int[5];
	
	public JumpingBallAnimation() {
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		
		//randomly generated values
		int x = (int)(Math.random()*200);
		int y = (int)(Math.random()*200);
		int size = (int)(Math.random()*50);
		int red = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		Color color = new Color(red, green, blue);
		
		//creation and painting of the balls
		otherBall = new Ball(x, y, size, color);
		otherBall.draw(g);
		otherotherBall = new Ball(x, y, size, color);
		otherotherBall.draw(g);
		for(int i = 0; i < 5; i++) {
		Color color2 = new Color(red, green, blue);
		
		jumpers[i] = new JumpingBall(100, 100, size, color2);
		jumpers[i].draw(g);
		}
		//setting random x and y speeds of the balls
		otherBall.setRandomSpeed(10);
		otherBall.setRandomSpeed(5);
		otherotherBall.setRandomSpeed(10);
		otherotherBall.setRandomSpeed(5);
		
		// Timer object
				timer = new Timer(5, new TimerListener());
				timer.start();
	}
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			otherBall.move(WIDTH, HEIGHT);
			otherBall.draw(g);
			otherotherBall.move(WIDTH, HEIGHT);
			otherotherBall.draw(g);
			for(int i = 0; i < 5; i++) {
				jumpers[i].draw(g);
			if(jumpers[i].intersectsWith(otherBall) || jumpers[i].intersectsWith(otherotherBall)) {
				jumpers[i].move(WIDTH, HEIGHT);
				hitCount[i]++;
			}
			}
			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.BOLD, 10));
			g.drawString("# of Hits for Jumper 1: ", 10, 20);
			g.drawString("# of Hits for Jumper 2: ", 10, 40);
			g.drawString("# of Hits for Jumper 3: ", 10, 60);
			g.drawString("# of Hits for Jumper 4: ", 10, 80);
			g.drawString("# of Hits for Jumper 5: ", 10, 100);
			g.drawString(String.valueOf(hitCount[0]), 120, 20);
			g.drawString(String.valueOf(hitCount[1]), 120, 40);
			g.drawString(String.valueOf(hitCount[2]), 120, 60);
			g.drawString(String.valueOf(hitCount[3]), 120, 80);
			g.drawString(String.valueOf(hitCount[4]), 120, 100);
			repaint();
			
		}
	}
	//paintComponent (drawing the image)
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
	
	//Driver
	public static void main(String[] args) {
			JFrame frame = new JFrame("Jump Ball Jump");
			frame.setSize(200,200);
			frame.setLocation(200,100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(new JumpingBallAnimation());
			frame.setVisible(true);
	}
	
	
	
}
