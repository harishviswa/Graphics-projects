import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")

public class KeyboardInput extends JPanel{
	//width and height variables
	private static final int WIDTH = 200;
	private static final int HEIGHT = 200;
	private static  int collisions = 0;
	
	private BufferedImage image;
	private Timer timer;
	private Graphics g;
	
	private Ball otherBall;
	//private Ball otherotherBall;
	private JumpingBall jumper = new JumpingBall();
	private int hitCount = 0;
	
	private boolean upPressed, downPressed, leftPressed, rightPressed;
	
	
	public KeyboardInput() {
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
	//	otherotherBall = new Ball(x, y, size, color);
	//	otherotherBall.draw(g);
		for(int i = 0; i < 5; i++) {
		Color color2 = new Color(red, green, blue);
		
		jumper = new JumpingBall(100, 100, size, color2);
		jumper.draw(g);
		}
		//setting random x and y speeds of the balls
		otherBall.setRandomSpeed(10);
		otherBall.setRandomSpeed(5);
		//otherotherBall.setRandomSpeed(10);
	//	otherotherBall.setRandomSpeed(5);
		
		// Timer object
				upPressed = false;
				downPressed = false;
				leftPressed = false;
				rightPressed = false;
			
				timer = new Timer(5, new TimerListener());
				timer.start();
				addKeyListener(new Keyboard());
				setFocusable(true);
	}
	
	public void updateKeyInput(){
		if(upPressed == true) {
			jumper.setY(jumper.getY() - 5);
		}
		if(downPressed == true) {
			jumper.setY(jumper.getY() + 5);
		}
		if(leftPressed == true) {
			jumper.setX(jumper.getX() - 5);
		}
		if(rightPressed == true) {
			jumper.setX(jumper.getX() + 5);
		}
	}
	
	private class Keyboard implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				upPressed = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				downPressed = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				leftPressed = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rightPressed = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				timer.stop();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				upPressed = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				downPressed = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				leftPressed = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rightPressed = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				timer.stop();
			}
			
		}
		
	}
	
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			updateKeyInput();
			
			
			otherBall.move(WIDTH, HEIGHT);
			otherBall.draw(g);
			//otherotherBall.move(WIDTH, HEIGHT);
		//	otherotherBall.draw(g);
			for(int i = 0; i < 5; i++) {
				jumper.draw(g);
			if(jumper.intersectsWith(otherBall)) {
				jumper.move(WIDTH, HEIGHT);
				hitCount++;
			}
			}
			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.BOLD, 10));
			g.drawString("# of Hits for Jumper: ", 10, 20);
			g.drawString(String.valueOf(hitCount), 120, 20);
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
			frame.setContentPane(new KeyboardInput());
			frame.setVisible(true);
	}
	
	
	
}
