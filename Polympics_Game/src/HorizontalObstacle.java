/** HorizontalObstacle.java
 * Description : This class is for an obstacle object that only moves horizontally
 * 	This is for the game "Dropper" which creates instances of this class for a horizontal moving obstacleS
 * 	@author Min Kim
 * 	@version 1.0 (Created Jan 17)
 **/

import java.awt.Graphics;
import java.util.Random;

public class HorizontalObstacle extends Obstacles {
	
	//declares variables needed for this class
	private Random rand = new Random ();
	private int obsPosY,obsPosX,obsWidth;
	private double obsSpeed;
	private Images image = new Images ("rocket");
	
	//constructor
	public HorizontalObstacle(int x, int y, int width, double speed) {
		super (x,y,width,speed);
	
		//initializes the private variables of this class, based on the parameters of the constructor
		this.obsPosX= x;
		this.obsPosY = y;
		this.obsWidth = width;
		this.obsSpeed = speed;
	}
	
	
	/**display
	 * 	To draw images to be shown on the window, when game is run
	 * @param g
	 */
	public void display (Graphics g) {
		image.drawImage(g, obsPosX, obsPosY, obsWidth, obsWidth);
	}
	
	/**move
	 * 	To move the obstacle position, by adding to its x coordinate
	 */
	public void move() {
		this.obsPosX+= this.obsSpeed;
	}
	
	/** getX
	 * returns the x coordinate of this object
	 */
	public int getX() {
		return this.obsPosX;
	}
	
	/** getY
	 * returns the y coordinate of this object
	 */
	public int getY() {
		return this.obsPosY;
	}
	
	/** getWidth
	 * returns the width of this object
	 */
	public int getWidth(){
		return this.obsWidth;
	}
	
	/** obstacleReset
	 * 	resets the obstacle coordinates to starting values, if needed
	 */
	public void obstacleReset() {
			this.obsPosY= rand.nextInt(650) + 1;
			this.obsPosX= 0;
			this.obsSpeed +=0.1;
	}
	
	/**resetSpeed
	 * resets the value of speed for this object, based on its parameter
	 * @param speed
	 * 		the starting value for speed
	 */
	public void resetSpeed(double speed) {
		this.obsSpeed = speed;
	}
}
