import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



import java.util.ArrayList;
import java.util.List;

public class HailHydra extends JPanel{
	private static final int WIDTH = 200;
	private static final int HEIGHT = 200;
	//collisions counter
	private int collisions = 0;
	
	private BufferedImage image;
	private Timer timer;
	private Graphics g;
	
	private Ball ball;
	private List <JumpingBall> jumpers;
	
	
	public HailHydra() {
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
//creating BouncingBall and setting location
		ball = new Ball();
		ball.setColor(Color.green);
		ball.setDiameter(50);
		while(ball.getXSpeed() < 1) {
			ball.setRandomSpeed(5);
		}
		ball.setLocation(Math.random()*WIDTH, Math.random()*HEIGHT);
		//arraylist of JumpingBalls
		jumpers = new ArrayList<>();
		
		jumpers.add(new JumpingBall(75,75,75,Color.blue));
		jumpers.add(new JumpingBall(50, 100, 25, Color.YELLOW));
		JumpingBall jumper1 = new JumpingBall(5, 5, 100, new Color(128, 50, 255));
		JumpingBall jumper2 = new JumpingBall(100,100,50,Color.red);
		jumpers.add(jumper1);
		jumpers.add(jumper2);
		
		timer = new Timer(5, new TimerListener());
		timer.start();

	}
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//drawing background
			g.setColor(Color.gray);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			ball.move(WIDTH, HEIGHT);
			ball.draw(g);
		
			//JumpingBall move
			//deletion of balls
			//creation of new balls
			for(int i = 0; i < jumpers.size(); i++) {
				if(jumpers.get(i).intersectsWith(ball)) {
					jumpers.get(i).move(WIDTH, HEIGHT);
					jumpers.get(i).setDiameter(jumpers.get(i).getDiameter()/2);
					jumpers.add(new JumpingBall(Math.random()*WIDTH, Math.random()*HEIGHT,jumpers.get(i).getDiameter(),jumpers.get(i).getColor()));
					collisions++;
				
				
				if(jumpers.get(i).getRadius() < 20) {
					jumpers.remove(i);
				}
				}
				jumpers.get(i).draw(g);
			}
			
			//displaying Hit counter
			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.BOLD, 10));
			g.drawString("Hits: ", 10, 20);
			g.drawString(String.valueOf(collisions), 40, 20);
			repaint();
			
			
		}
		
		}
	//paintComponent (drawing the image)
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
	}
	
	//Driver
	public static void main(String[] args) {
			JFrame frame = new JFrame("Hail Hydra");
			frame.setSize(200,200);
			frame.setLocation(200,100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(new HailHydra());
			frame.setVisible(true);
	}
	
}
