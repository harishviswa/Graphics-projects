import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.lang.Math;

public class RocketGarden extends JPanel{
	public static final int width = 400;
	public static final int height = 500;
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		Rocket SpaceX = new Rocket(300,770,width,height);
		SpaceX.draw(g);
		
		Rocket Elon = new Rocket(100,770,width/2,height/2);
		Elon.draw(g);
		
		Rocket Jeff = new Rocket(800,770,width/5,height/5);
		Jeff.draw(g);
	}








public static void main(String[] args) {
	JFrame frame = new JFrame("Rocket Garden");
	frame.setSize(1000,800);
	frame.setLocation(0, 0);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setContentPane(new RocketGarden());
	frame.setVisible(true);
}
}
