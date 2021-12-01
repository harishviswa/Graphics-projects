import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")

public class MouseExample extends JPanel{
	//width and height variables
	private static final int WIDTH = 200;
	private static final int HEIGHT = 200;
	private static  int collisions = 0;
	
	private BufferedImage image;
	private Timer timer;
	private Graphics g;
	
	//declaring ball
	private Ball otherBall;
	//private Ball otherotherBall;
	//declaring jumper
	private JumpingBall jumper = new JumpingBall();
	//collision counter variable
	private int hitCount = 0;
	
	public MouseExample() {
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		
		//randomly generated values for color, x,y, and size
		int x = (int)(Math.random()*200);
		int y = (int)(Math.random()*200);
		int size = (int)(Math.random()*50);
		int red = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		Color color = new Color(red, green, blue);
		
		//creation and painting of the balls
		otherBall = new Ball(x, y, size, Color.white);
		otherBall.draw(g);
		//otherotherBall = new Ball(x, y, size, color);
		//otherotherBall.draw(g);
		
		for(int i = 0; i < 5; i++) {
		Color color2 = new Color(red, green, blue);
		
		jumper = new JumpingBall(100, 100, size, color2);
		jumper.draw(g);
		}
		//setting random x and y speeds of the balls
		otherBall.setRandomSpeed(10);
		otherBall.setRandomSpeed(5);
	//	otherotherBall.setRandomSpeed(10);
	//	otherotherBall.setRandomSpeed(5);
		
		// Timer object
				timer = new Timer(5, new TimerListener());
				timer.start();
		//add mouselistener
		addMouseListener(new Mouse());
		
	}
	
	private class Mouse implements MouseListener{

		//mouse events for various instances
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.isMetaDown()) {
				jumper.setX(e.getX());
				jumper.setY(e.getY());
			}
			if(e.isShiftDown()) {
				otherBall.setRandomSpeed(Math.random()*10);
				otherBall.setRandomSpeed(Math.random()*5);
			}
			if(e.isAltDown()) {
				int red = (int)(Math.random()*255);
				int green = (int)(Math.random()*255);
				int blue = (int)(Math.random()*255);
				Color color = new Color(red, green, blue);
				jumper.setColor(color);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
			otherBall.setX(e.getX());
			otherBall.setY(e.getY());
			
			if(e.isControlDown()) {
				otherBall.setDiameter((int)(Math.random()*50));
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//creation of background
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			otherBall.move(WIDTH, HEIGHT);
			otherBall.draw(g);
		//	otherotherBall.move(WIDTH, HEIGHT);
		//	otherotherBall.draw(g);
			//collision counter and draw
			for(int i = 0; i < 5; i++) {
				jumper.draw(g);
			if(jumper.intersectsWith(otherBall)) {
				jumper.move(WIDTH, HEIGHT);
				hitCount++;
			}
			}
			//display of hits
			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.BOLD, 10));
			g.drawString("# of Hits for Jumper : ", 10, 20);
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
			frame.setSize(200 + 18,200 + 47);
			frame.setLocation(200,100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(new MouseExample());
			frame.setVisible(true);
	}
	
	
	
}
