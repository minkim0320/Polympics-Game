/** MovingObstacle.java
 * Description : This class is for an obstacle object that only bounces on the walls and distracts the player from getting scores
 * 	This is for the game "Dropper" which creates instances of this class for a random moving obstacle
 * 	@author Min Kim
 * 	@version 1.0 (Created Jan 17)
 **/

import java.awt.Graphics;

public class MovingObstacle extends Obstacles {

	//declares variables needed for this class
	private int obsPosX, obsPosY,obsWidth;
	private double speed ;
	private double yVelocity = -2;
	private double xVelocity = -2;
	private Images image = new Images ("bomb");


	//constructor
	public MovingObstacle(int x, int y, int width, double speed) {
		super (x,y,width,speed);
		this.obsPosX = x;
		this.obsPosY = y;
		this.obsWidth = width;
		this.speed = speed;
	}

	/** display
	 * To draw images to be shown on the window, when game is run for this obstacle
	 * @param g
	 */
	public void display(Graphics g)
	{
		image.drawImage(g, obsPosX, obsPosY, obsWidth, obsWidth);
	}

	/**move
	 * 	To move the obstacle, and to bounce the obstacle every time it hits a wall, instead of going through
	 * 	This is done by using separate variables of xVelocity and yVelocity
	 */
	public void move() {
		//always add to its x and y coordinates to keep the object moving
		this.obsPosX += xVelocity;
		this.obsPosY += yVelocity;

		//if it hits the wall where x = 0, speed is positive so that the object can move away from the left wall
		if (obsPosX <0) {
			this.xVelocity = speed;
		} else if (obsPosX > 950) {
			//if it hits the wall where x = 950 (right side), speed is negative so that the object can move the opposite direction now
			this.xVelocity = -speed;
		}
		//if it hits the wall where y = 0, speed is positive so that the object can move away from the top wall
		if (obsPosY < 0) {
			yVelocity = speed;
		} else if (obsPosY > 650) {
			//if it hits the wall where y is greater than 650, the bottom wall y coordinate, the speed is negative so that the object can move the opposite direction
			yVelocity = -speed;
		}
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
		this.obsPosY= 200;
		this.obsPosX= 200;
		this.speed +=0.1;
	}
}
