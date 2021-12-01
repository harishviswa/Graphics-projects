import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsExample extends JPanel{

	public void paintComponent(Graphics g) {
		
		g.setColor(Color.white.brighter());
		g.fillRect(0,0,500,500);
		
		g.setColor(Color.black);
		
		g.drawLine(100, 50, 100, 300);
		
		g.drawLine(100, 50, 400, 50);
		
		g.setColor(new Color(225, 150, 0));
		
		g.drawRect(100, 200, 300, 100);
		g.fillOval(100, 200, 300, 100);
		
		g.setColor(Color.blue);
		g.drawString("Graphics Example", 50, 50);
		
		
		
		
	}
	
	//Driver method
	public static void main(String[] args) {
		
		
		JFrame frame = new JFrame("Graphics Example"); //parameter is the title displayed at the top of the frame
		frame.setSize(500, 500); //sets width, height of the frame
		frame.setLocation(50, 50); //sets upper left corner location
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new GraphicsExample()); //parameter must match the class name
		frame.setVisible(true);
		

	}

}
