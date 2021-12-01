import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CloudAnimation extends JPanel{
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private BufferedImage image;
	private Graphics g;
	private Cloud cloud;
	private Timer timer;
	
	
	public CloudAnimation() {
		//set up the buffered image and the graphics object
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		
		cloud = new Cloud(100,100,75,Color.white);
		cloud.setXSpeed(5);
		
		//set up and start the TimerListener
		timer = new Timer(5, new TimerListener());
		timer.start();
		
	}
	
	private class TimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//move object and repaint
			
			g.setColor(Color.blue);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			cloud.move(WIDTH);
			cloud.draw(g);
			
			repaint();
		}
		
	}
	
	
	//Paint Component for a buffered image
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Cloud Animation");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(50,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new CloudAnimation());
		frame.setVisible(true);
		
		
	}
}
