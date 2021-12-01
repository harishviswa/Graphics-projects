import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class LiftOff extends JPanel{
	private static final int width = 400;
	private static final int height = 500;
	private static final int screenwidth = 1000;
	private static final int screenheight = 800;
	private BufferedImage image;
	private Graphics g;
	private Rocket rocket;
	private Timer timer;
	
	
	public LiftOff() {
		//set up the buffered image and the graphics object
		image = new BufferedImage(1000, 800, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		
		g.setColor(Color.white);
		rocket = new Rocket(300,770,width,height);
		rocket.setYSpeed(5);
		rocket.draw(g);
		
		//set up and start the TimerListener
		timer = new Timer(5, new TimerListener());
		timer.start();
		
	}
	
	private class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//move object and repaint
			
			g.setColor(Color.blue);
			g.fillRect(0, 0, screenwidth, screenheight);
			
			rocket.move(800);
			rocket.draw(g);
			
			System.out.println(rocket.getY());
			
			repaint();
		}
		
	}
	
	
	//Paint Component for a buffered image
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Lift Off");
		frame.setSize(screenwidth, screenheight);
		frame.setLocation(50,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new LiftOff());
		frame.setVisible(true);
		

	}
}
