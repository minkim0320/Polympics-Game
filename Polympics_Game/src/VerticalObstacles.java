/** VerticalObstacle.java
 * Description : This class is for an obstacle object that only moves vertically
 * 	This is for the game "Dropper" which creates instances of this class for a vertically moving obstacleS
 * 	@author Min Kim
 * 	@version 1.0 (Created Jan 17)
 **/

import java.awt.Graphics;
import java.util.Random;

public class VerticalObstacles extends Obstacles{
	private Random rand = new Random ();
	private int obsPosY,obsPosX,obsWidth;
	private double obsSpeed;
	
	//creates an image from the files
	private Images image = new Images ("bomb");
	
	//constructor
	public VerticalObstacles(int x, int y, int width, double speed) {
		super (x,y,width,speed);
		this.obsPosX = x;
		this.obsPosY = y;
		this.obsWidth = width;
		this.obsSpeed = speed;
	}

	/** display
	 * To draw images to be shown on the window, when game is run for this obstacle
	 * @param g for graphical display
	 */
	public void display(Graphics g) {
		image.drawImage(g, obsPosX, obsPosY , obsWidth, obsWidth);
		
	}
	
	/**move
	 * 	To move the obstacle vertically
	 * 	This is done by using the speed variable
	 */
	public void move () {
		this.obsPosY += this.obsSpeed;
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
	 * 	resets the obstacle coordinates and its speed to starting values, if needed
	 */
	public void obstacleReset() {
			this.obsPosX = rand.nextInt(950) + 1;
			this.obsPosY = 0;
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
