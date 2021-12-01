import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Meme extends JPanel {
	private static final int WIDTH = 900;
	private static final int HEIGHT = 500;
	
	private BufferedImage bufferedImage;
	
	public Meme() {
		
		bufferedImage = new BufferedImage (WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		
		ImageIcon image = new ImageIcon("chaseyoung.jpg");
		g.drawImage(image.getImage(), WIDTH/2-450, HEIGHT/2-250, WIDTH, HEIGHT, null);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact", Font.BOLD, 40));
		g.drawString("WHEN THERE'S A 1% CHANCE OF SNOW", 140, 50);
		g.drawString("AND WAYDE HASN'T CALLED YET", 185, 450);
		
	}
	
	
	
	

	public void paintComponent(Graphics g) {
		g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
	}
	
	
	public static void main(String[] args) {
		JFrame  frame = new JFrame("Meme");
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Meme());
		frame.setVisible(true);	
	}

}