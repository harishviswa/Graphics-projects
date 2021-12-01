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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput2 extends JPanel {
	
	//creation of private variables
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 1250;
	private static final Color LIGHT_BLUE = new Color(108, 210, 247);
	
	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	
	// declare stuff
	private Ball ball;
	private Bumper blueBumper;
	private Bumper redBumper;
	private boolean upPressed, downPressed, leftPressed, rightPressed;
	
	public KeyboardInput2() {
		
		//drawing background
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		
		g.setColor(LIGHT_BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// instantiate ball
		ball = new Ball(200, 100, 200, Color.BLACK);
		ball.setRandomSpeed(6);
		
		//instantiate blue bumper
		blueBumper = new Bumper();
		blueBumper.setLocation(100, 1000);
		blueBumper.setWidth(150);
		blueBumper.setHeight(400);
		
		//instantiate red bumper
		redBumper = new Bumper(1000, 500, 200, 300, Color.RED);
		
		//boolean statements for keys
		upPressed = false;
		downPressed = false;
		leftPressed = false;
		rightPressed = false;
	
		//timer
		timer = new Timer(5, new TimerListener());
		timer.start();
		//KeyListener
		addKeyListener(new Keyboard());
		setFocusable(true);
	}
	//movements for key inputs
	public void updateKeyInput(){
		if(upPressed == true) {
			redBumper.setY(redBumper.getY() - 5);
		}
		if(downPressed == true) {
			redBumper.setY(redBumper.getY() + 5);
		}
		if(leftPressed == true) {
			redBumper.setX(redBumper.getX() - 5);
		}
		if(rightPressed == true) {
			redBumper.setX(redBumper.getX() + 5);
		}
	}
	
	private class Keyboard implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		//setting boolean statements to true so that lines 70-84 run
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

		//setting boolean values to false so that lines 70-84 stop running
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

		@Override
		public void actionPerformed(ActionEvent e) {

			// draw background / clear screen
			g.setColor(LIGHT_BLUE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			//key inputs
			updateKeyInput();
			
			// move stuff / update locations
			ball.move(WIDTH, HEIGHT);
			BumperCollision.collide(blueBumper, ball);
			BumperCollision.collide(redBumper, ball);
			
			// draw ball and bumpers
			ball.draw(g);
			blueBumper.draw(g);
			redBumper.draw(g);
				
			repaint();
		}
		
	}
	
	
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Bumper!!!");
		frame.setSize(1200, 900);
		frame.setLocation(200, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new KeyboardInput2());
		frame.setVisible(true);
	}
}