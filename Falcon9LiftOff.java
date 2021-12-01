import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Falcon9LiftOff extends JPanel{
	private static final int width = 400;
	private static final int height = 500;
	private static final int screenwidth = 1000;
	private static final int screenheight = 800;
	private static final double deltaTime = 0.5;
	private BufferedImage image;
	private Graphics g;
	private Falcon9 falcon9;
	private Timer timer;
	
	
	public Falcon9LiftOff() {
		//set up the buffered image and the graphics object
		image = new BufferedImage(1000, 800, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		
		
		g.setColor(Color.white);
		falcon9 = new Falcon9(450,0,width/5,height/5);
		falcon9.setdeltaTime(deltaTime);
		falcon9.draw(g);
		
		//set up and start the TimerListener
		timer = new Timer((int)	deltaTime*1000, new TimerListener());
		timer.start();
		
	}
	
	private class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//move object and repaint
			if(falcon9.getTime() <= 162) {
				
			
			
		
			g.setColor(Color.blue);
			g.fillRect(0, 0, screenwidth, screenheight);
			//text displays
			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Time: ", 50, 100);
			g.drawString("Speed: ", 50, 150);
			g.drawString("Altitude: ", 50, 200);
			g.drawString(String.valueOf(falcon9.getTime()), 130, 100);
			g.drawString(String.valueOf(falcon9.getVelocity()), 150, 150);
			g.drawString(String.valueOf(falcon9.getAltitude()), 180, 200);
			
			falcon9.move(800);
			falcon9.draw(g);
			
			System.out.println(falcon9.getTime() + "," + falcon9.getMass() + "," + falcon9.getnetForce() + "," + falcon9.getAcceleration() + "," + falcon9.getVelocity() + "," + falcon9.getAltitude());
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
		frame.setContentPane(new Falcon9LiftOff());
		frame.setVisible(true);
		

	}
}