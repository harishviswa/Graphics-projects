//Harish Viswa
//Lab 00:HelloGraphics
//01.12.21
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class HelloGraphics extends JPanel {
	
		public void paintComponent(Graphics g) {
			//draws circle
			g.setColor(Color.red);
			g.drawOval(200, 400, 50, 50);
			//draws the magenta square
			g.setColor(Color.magenta);
			g.drawRect(500, 200, 50, 50);
			//draws vertical line
			g.setColor(Color.green);
			g.drawLine(300, 100, 300, 3000);
			//draws horizontal line
			g.setColor(Color.green);
			g.drawLine(100, 300, 3000, 300);
			//string of text
			g.setColor(Color.BLUE);
			g.setFont(new Font("TimesNewRoman", Font.ITALIC, 26));
			g.drawString("Harish knows how to code!", 400, 400);
			//draws three horizontal circles
			g.setColor(Color.red);
			int x = 75;
			for (int i = 0; i < 3; i++) {
				g.drawOval(x, 200, 50, 50);
				x = x + 75;
			}
		}
	
	
	//Driver method
		public static void main(String[] args) {
			
			
			JFrame frame = new JFrame("HelloGraphics"); //parameter is the title displayed at the top of the frame
			frame.setSize(1000, 800); //sets width, height of the frame
			frame.setLocation(0, 0); //sets upper left corner location
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(new HelloGraphics()); //parameter must match the class name
			frame.setVisible(true);
			

		}

	}


