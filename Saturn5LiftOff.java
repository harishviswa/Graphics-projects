import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Saturn5LiftOff extends JPanel{
	private static final int width = 400;
	private static final int height = 500;
	private static final int screenwidth = 1000;
	private static final int screenheight = 800;
	private static final double deltaTime = 0.5;
	private BufferedImage image;
	private Graphics g;
	private Saturn5 saturn5;
	private Timer timer;
	
	
	public Saturn5LiftOff() {
		//set up the buffered image and the graphics object
		image = new BufferedImage(1000, 800, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		
		
		g.setColor(Color.white);
		saturn5 = new Saturn5(450,0,width/5,height/5);
		saturn5.setdeltaTime(deltaTime);
		saturn5.draw(g);
		
		//set up and start the TimerListener
		timer = new Timer((int)	deltaTime*1000, new TimerListener());
		timer.start();
		
	}
	
	private class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//move object and repaint
			if(saturn5.getTime() <= 168) {
				
			
			
		
			g.setColor(Color.blue);
			g.fillRect(0, 0, screenwidth, screenheight);
			//text displays
			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Time: ", 50, 100);
			g.drawString("Speed: ", 50, 150);
			g.drawString("Altitude: ", 50, 200);
			g.drawString(String.valueOf(saturn5.getTime()), 130, 100);
			g.drawString(String.valueOf(saturn5.getVelocity()), 150, 150);
			g.drawString(String.valueOf(saturn5.getAltitude()), 180, 200);
			
			saturn5.move(800);
			saturn5.draw(g);
			
			System.out.println(saturn5.getTime() + "," + saturn5.getMass() + "," + saturn5.getnetForce() + "," + saturn5.getAcceleration() + "," + saturn5.getVelocity() + "," + saturn5.getAltitude());
			repaint();
		}
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
		frame.setContentPane(new Saturn5LiftOff());
		frame.setVisible(true);
		

	}
}