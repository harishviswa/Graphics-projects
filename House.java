import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class House extends JPanel {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;
	
	public void paintComponent(Graphics g) {
		
		drawBackground(g);
		drawHouse(g);
		
		Mountain[] mountains = new Mountain[5];
		for(int i = 0; i < mountains.length; i++) {
			int red = (int)(Math.random()*255+5);
			int green = (int)(Math.random()*255+5);
			int blue = (int)(Math.random()*255+5);
			Color color = new Color(red, green , blue);
			mountains[i] = new Mountain(i*175, 300, 200, 300, color);
			mountains[i].draw(g);
		}
		
		Cloud cloud = new Cloud(200,75, 100, Color.white);
		cloud.draw(g);
	}
	
	public static void drawBackground(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	public static void drawHouse(Graphics g) {
		g.setColor(Color.green.darker());
		g.fillRect(100, 200, 150, 150);
		
		int[] xpoints = {100, 175, 250};
		int[] ypoints = {200, 100, 200};
		g.fillPolygon(xpoints, ypoints, 3);
		
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("My House");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(50,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new House());
		frame.setVisible(true);
		
		
	}
}
