import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResizableImage extends JPanel {
	private static final int WIDTH = 900;
	private static final int HEIGHT = 500;
	
	private BufferedImage bufferedImage;
	
	public ResizableImage() {
		
		bufferedImage = new BufferedImage (WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		
		g.setColor(Color.CYAN.darker());
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		ImageIcon image = new ImageIcon("chaseyoung.jpg");
		g.drawImage(image.getImage(), WIDTH/2-200, HEIGHT/2-150, WIDTH/2, HEIGHT/2, null);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString("Raise your hand if", 100, 50);
		g.drawString("Raise your hand if", 100, 400);
		g.drawString("Raise your hand if", 100, 450);
		
		g.setColor(Color.gray);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.drawArc(0, 200, 200, 200, 45, 145);
		
	}
	
	
	
	
	//use this version of paintComponent for a buffered image - do not edit!
	public void paintComponent(Graphics g) {
		g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
	}
	
	
	public static void main(String[] args) {
		JFrame  frame = new JFrame("Resizable Image");
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new ResizableImage());
		frame.setVisible(true);	
	}

}