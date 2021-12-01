import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.lang.Math;

public class Wonderland extends JPanel {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;

	public void paintComponent(Graphics g) {
		drawBlueSky(g);
	    drawMainBuilding(g);
		drawLightGrayRoof(g);
		drawLeftSideBuilding(g);
		drawDarkGrayLeftRoof(g);
		drawRightSideBuilding(g);
		drawDarkGrayRightRoof(g);
		drawLeftSnowman(g);
		drawRightSnowman(g);
		drawClouds(g);
		drawFloor(g);
		drawMainDoorOutline(g);
		drawMainDoorLines(g);
		drawLeftDoorOutline(g);
		drawLeftDoorLines(g);
		drawRightDoorOutline(g);
		drawRightDoorLines(g);
		drawMainEdges(g);
		drawLeftEdges(g);
		drawRightEdges(g);
		drawTitle(g);
		drawFence(g);
		MoonMaker moon = new MoonMaker(850, 100, 100, 100, Color.LIGHT_GRAY);
		moon.draw(g);
		g.setColor(Color.WHITE);
		Snowflake[] array = new Snowflake[100];
		for(int i = 0; i < array.length; i++) {
			array[i] = new Snowflake((int)(Math.random()*1000),(int)(Math.random()*800),5,5,Color.WHITE);
			array[i].draw(g); 
		}
	}

	public static void drawRightEdges(Graphics g) {
		g.setColor(Color.lightGray);
		g.drawRect(570, 245, 210, 20);
		g.fillRect(570, 245, 210, 20);
	}
	public static void drawLeftEdges(Graphics g) {
		g.setColor(Color.lightGray);
		g.drawRect(170, 245, 210, 20);
		g.fillRect(170, 245, 210, 20);
	}
	public static void drawMainEdges(Graphics g) {
		g.setColor(Color.darkGray);
		g.drawRect(370, 295, 210, 20);
		g.fillRect(370, 295, 210, 20);
		}
		
	public static void drawRightDoorLines(Graphics g) {
		g.setColor(Color.darkGray);
		g.drawRect(670, 415, 15, 235);
		g.fillRect(670, 415, 15, 235);
		g.drawRect(615, 475, 125, 15);
		g.fillRect(615, 475, 125, 15);
	}
	public static void drawRightDoorOutline(Graphics g) {
		g.setColor(Color.lightGray);
		g.drawRect(615, 475, 125, 175);
		g.fillRect(615, 475, 125, 175);
		g.drawOval(615, 415, 125, 125);
		g.fillOval(615, 415, 125, 125);
	}
	public static void drawLeftDoorLines(Graphics g) {
		g.setColor(Color.darkGray);
		g.drawRect(265, 415, 15, 235);
		g.fillRect(265, 415, 15, 235);
		g.drawRect(210, 475, 125, 15);
		g.fillRect(210, 475, 125, 15);
	}
	public static void drawLeftDoorOutline(Graphics g) {
		g.setColor(Color.lightGray);
		g.drawRect(210, 475, 125, 175);
		g.fillRect(210, 475, 125, 175);
		g.drawOval(210, 415, 125, 125);
		g.fillOval(210, 415, 125, 125);
	}
	public static void drawMainDoorLines(Graphics g) {
		g.setColor(Color.lightGray);
		g.drawRect(470, 415, 15, 235);
		g.fillRect(470, 415, 15, 235);
		g.drawRect(415, 475, 125, 15);
		g.fillRect(415, 475, 125, 15);
	}
	public static void drawMainDoorOutline(Graphics g) {
		g.setColor(Color.darkGray);
		g.drawRect(415, 475, 125, 175);
		g.fillRect(415, 475, 125, 175);
		g.drawOval(415, 415, 125, 125);
		g.fillOval(415, 415, 125, 125);
	}
	public static void drawFloor(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(0, 650, 1000, 800);
		g.fillRect(0, 650, 1000, 800);
	}

	public static void drawClouds(Graphics g) {
		g.setColor(new Color (220,220,220));
		for(int i=75; i<900; i+=150) {
			g.drawOval(0+i, 10, 90, 50);
			g.fillOval(0+i, 10, 90, 50);
	}
		g.setColor(new Color (220,220,220));
		for(int i=25; i<875; i+=75) {
			g.drawOval(0+i, 30, 90, 50);
			g.fillOval(0+i, 30, 90, 50);
	}
		}
	public static void drawRightSnowman(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(805,500,150,150);
		g.fillOval(805, 500, 150, 150);
		g.drawOval(820, 375, 125, 125);
		g.fillOval(820, 375, 125, 125);
		g.drawOval(835, 275, 100, 100);
		g.fillOval(835, 275, 100, 100);
	}
	public static void drawLeftSnowman(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval(15, 500, 150, 150);
		g.fillOval(15, 500, 150, 150);
		g.drawOval(30, 375, 125, 125);
		g.fillOval(30, 375, 125, 125);
		g.drawOval(45, 275, 100, 100);
		g.fillOval(45, 275, 100, 100);
	}
	public static void drawDarkGrayRightRoof(Graphics g) {
		g.setColor(Color.darkGray);
		int xPoints[] = {575,675,775};
		int yPoints[] = {250,125,250};
		g.drawPolygon(xPoints,yPoints,3);
		g.fillPolygon(xPoints,yPoints,3);
	}
	public static void drawRightSideBuilding(Graphics g) {
		g.setColor(new Color (95,158,160));
		g.drawRect(575, 250, 200, 400);
		g.fillRect(575, 250, 200, 400);
	}
	public static void drawDarkGrayLeftRoof(Graphics g) {
		g.setColor(Color.darkGray);
		int xPoints[] = {175,275,375};
		int yPoints[] = {250,125,250};
		g.drawPolygon(xPoints,yPoints,3);
		g.fillPolygon(xPoints,yPoints,3);
	}
	public static void drawLeftSideBuilding(Graphics g) {
		g.setColor(new Color(95,158,160));
		g.drawRect(175, 250, 200, 400);
		g.fillRect(175, 250, 200, 400);
	}
	public static void drawLightGrayRoof(Graphics g) {
		g.setColor(Color.lightGray);
		int xPoints[] = {375,475,575};
		int yPoints[] = {300,175,300};
		g.drawPolygon(xPoints,yPoints,3);
		g.fillPolygon(xPoints,yPoints,3);
	}
	public static void drawMainBuilding(Graphics g) {
		g.setColor(new Color (65,105,225));
		g.drawRect(375, 300, 200, 350);
		g.fillRect(375, 300, 200, 350);
	}

	public static void drawBlueSky(Graphics g) {
		g.setColor(new Color(25,25,112));
		g.drawRect(1,1,1000,800);
		g.fillRect(1, 1, 1000, 800);
	}
	public static void drawTitle(Graphics g) {
		g.setColor(Color.blue);
		g.setFont(new Font("TimesNewRoman", Font.ITALIC, 26));
		g.drawString("Winter Wonderland", 60, 60);
	}
	public static void drawFence(Graphics g) {
		g.setColor(Color.black);
		// Vertical lines for fence
		for (int x = 0; x < WIDTH; x += 70) {
			g.drawLine(x, 650, x, 375);
		}
		// Horizontal lines for fence
		g.drawLine(0, 550, WIDTH, 550);
		g.drawLine(0, 500, WIDTH, 500);

	}


	public static void main(String[] args) {
		JFrame frame = new JFrame("Winter Wonderland");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Wonderland());
		frame.setVisible(true);
	}
		}


