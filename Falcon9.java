import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Font;

@SuppressWarnings("serial")
public class Falcon9 extends Rocket {

	private double yAcceleration;
	private double fuelMass;
	private double velocity;
	private double deltaMass;
	private double thrust;
	private double deltaTime;
	private double netForce;
	private double fuelConsumption;
	private double burnTime;
	private double mass;
	private double forceGravity;
	private double x;
	private double altitude;
	private double AccelerationGravity;
	private double height;
	private double screenheight;
	private double screenwidth;
	private double y;
	private double width;
	private double time;
	
	//private static final double width2 = 47;
	//private static final double height2 = 3.7;
//	private static final int HEIGHT = 100000;
	//private static final int WIDTH = 300;
	private static final double gravity = 9.8;
	
	public Falcon9(double x, double altitude, double width, double height) {
		super((int)x,(int)altitude,(int)width,(int)height);	
		this.yAcceleration = yAcceleration;
		this.width = width;
		this.height = height;
		this.screenheight = screenheight;
		this.screenwidth = screenwidth;
		this.mass = 541300;
		this.fuelMass = 398900;
		this.thrust = 6806000;
		this.burnTime= 162;
		this.time = 0;
		this.velocity = velocity + (yAcceleration*deltaTime);
		this.deltaTime = deltaTime;
		this.deltaMass = (fuelMass/burnTime)*deltaTime;
		this.netForce = 0;
		this.altitude = altitude;
		this.AccelerationGravity = 9.8;
		this.fuelConsumption = fuelMass/burnTime;
		
		
		
	}
	/**
	 * gets yAcceleration of rocket
	 * @return returns yAcceleration
	 */
	public double getAcceleration() {
		return yAcceleration;
	}
	/**
	 * sets yAcceleration of rocket
	 * @param yAcceleration is the yAcceleration of the rocket
	 */
	public void setAcceleration(double yAcceleration) {
		this.yAcceleration = yAcceleration;
	}
	/**
	 * gets the current fuel mass of object
	 * @return returns fuel mass
	 */
	public double getfuelMass() {
		return fuelMass;
	}
	/**
	 * changes fuelMass variable to whatever put in parameter
	 * @param fuelMass
	 */
	public void setfuelMass(double fuelMass) {
		this.fuelMass = fuelMass;
	}
	/**
	 * gets time elapsed
	 * @return returns current time after start in seconds
	 */
	public double getTime() {
		return time;
	}
	/**
	 * sets a new time
	 * @param time
	 */
	public void setTime(double time) {
		this.time = time;
	}
	/**
	 * gets the current thrust force
	 * @return returns thrust force
	 */
	public double getThrust() {
		return thrust;
	}
	/**
	 * 
	 * @param thrust sets a new thrust force
	 */
	public void setThrust(double thrust) {
		this.thrust = thrust;
	}
	/**
	 * gets the new mass of the object (mass - deltamass)
	 * @return returns new mass
	 */
	public double getMass() {
		return mass;
	}
	/**
	 * 
	 * @param mass sets a new mass value
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}
	/**
	 * gets the new net force
	 * @return sets new net force
	 */
	public double getnetForce() {
		return netForce;
	}
	/**
	 * 
	 * @param netForce sets a new Net Force
	 */
	public void setnetForce(double netForce) {
		this.netForce = netForce;
	}
	/**
	 * 
	 * @param deltaTime sets a new deltaMass
	 */
	public void setdeltaMass(double deltaTime) {
		this.deltaMass = (fuelMass/burnTime)*deltaTime;
	}
		
	/**
	 * gets deltaMass of object
	 * @return returns new deltaMass
	 */
	public double getdeltaMass() {
		return deltaMass;
	}
	/**
	 * gets deltaTime of object
	 * @return returns new deltaTime
	 */
	public double getdeltaTime() {
		return deltaTime;
	}
	/**
	 * 
	 * @param deltaTime sets a new deltaTime
	 */
	public void setdeltaTime(double deltaTime) {
		this.deltaTime = deltaTime;
	}
	/**
	 * gets burnTime
	 * @return returns the new burnTime value(again useless)
	 */
	public double getburnTime() {
		return burnTime;
	}
	/**
	 * sets a new burn time
	 * @param burnTime
	 */
	public void setburnTime(double burnTime) {
		this.burnTime = burnTime;
	}
	/**
	 * gets yAcceleration due to gravity
	 * @return returns yAcceleration due to gravity
	 */
	public double getAccelerationGravity() {
		return AccelerationGravity;
	}
	/**
	 * 
	 * @param AccelerationGravity sets a new yAcceleration due to gravity
	 */
	public void setAccelerationGravity(double AccelerationGravity) {
		this.AccelerationGravity = AccelerationGravity;
	}
	
//	public double getY() {
//		return y;
//	}
//	
//	public void setY(double y) {
//		this.y = y;
//	}
	public double getScreenHeight() {
		return screenheight;
	}
	
	public void setScreenHeight(double screenheight) {
		this.screenheight = screenheight;
	}
	public double getScreenWidth() {
		return screenwidth;
	}
	
	public void setScreenWidth(double screenwidth) {
		this.screenwidth = screenwidth;
	}
	/**
	 * 
	 * @returns Altitude
	 */
	public double getAltitude() {
		return altitude;
	}
	/**
	 * 
	 * @param set new Altitude
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	/**
	 * 
	 * @returns velocity
	 */
	public double getVelocity() {
		return velocity;
	}
	/**
	 * 
	 * @param set new velocity
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	/**
	 * 
	 * @returns fuelconsumption
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	/**
	 * 
	 * @param set new fuelconsumption
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelMass/burnTime;
	}
	public void draw(Graphics g) {
		super.draw(g);
	}
	public void move(int height) {
		
			setMass(getMass()-getFuelConsumption()*getdeltaTime());
			setnetForce(getThrust() - (getMass()*getAccelerationGravity()));
			setAcceleration(getnetForce()/getMass());
			setVelocity(getVelocity() + (getAcceleration()*getdeltaTime()));
			setAltitude(getAltitude() + getVelocity()*getdeltaTime());
			setY(height * (1 - (getAltitude()/105000)));
			setTime(getTime() + getdeltaTime());
			System.out.println(getY());
}
	
}