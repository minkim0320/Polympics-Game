/** FlyingObjects.java
 * Description : This class creates obstacle object for the game deadly shooter.
 * 	obstacles move in a parabolic, horizontal, or vertical path based on a random pattern
 * 	this class also has methods that reset the coordinates of obstacles after it is used
 * 	@author Min Kim
 * 	@version 1.0 (Created Jan 17)
 **/

import java.util.Random;

public class FlyingObjects {

	
	//declares and initializes the starting quantities of the player's 
	private int objX = 0;
	private int objY = 550;
	//speed of the player
	private double yVel = 2;
	private double yVelPara = 1.5;
	private double xVel = 2;
	
	//creates an instance of a random object
	private Random rand = new Random ();
	
	//default constructor
	public FlyingObjects () {
		
	}
	
	/** moveParabola
	 * 	move the object of this class in a parabolic path, based on if statements of where the x coordinate of the object is
 	 */
	public void moveParabola() {
		//if x coordinate is in the first half of the window, move the y coordinate up the window
		if (objX <= 500) {
			objY -= yVelPara;
		} else if (objX > 500) {
			//if x coordinate is in the second half of the window, move the y coordinate down the window
			objY += yVelPara;
		} 
		//always move the x coordinate
		objX += xVel;
		

	}
	
	/** parabolaReset
	 * 	resets the coordinates, speed of the object that moves all around the window
	 */
	public void parabolaReset() {
		objX = 0;
		objY = 550;
		xVel +=0.2;
		yVel +=0.2;
	}

	/** moveHorizontal
	 * 	moves the obstacle horizontally only
	 */
	public void moveHorizontal() {
		//to move horizontally, add the speed to the x coordinate to increase it
		objX += xVel;
	}
	
	/** horizontalReset
	 * 	resets the coordinates, speed of the object that moves horizontally only
	 */
	public void horizontalReset() {
		//resets the object coordinates if moving horizontally
		objY = rand.nextInt(650);
		objX = 0;
		xVel +=0.2;
	}
	
	/**	moveVertical
	 * 	allows for the movement of obstacles vertically only
	 */
	public void moveVertical() {
		//to move vertically, add the spped to the y coordinate
		objY += yVel;
	}
	
	/** verticalReset
	 * 	resets the coordinates, speed of object that moves vertically only
	 */
	public void verticalReset() {
		//resets the object coordinates if moving vertically
		objX = rand.nextInt(950);
		objY = 0;
		yVel +=0.2;
	}
	
	/** getPlayerX
	 *  returns the x coordinate of this object
	 * @return playerX
	 */
	public int getX() {
		return objX;
	}
	
	/** getPlayerY
	 *  returns the y coordinate of this object
	 * @return playerY
	 */
	public int getY() {
		return objY;
	}
	
	//resets the speed to starting values, in case the game ends
	public void resetSpeed() {
		  yVel = 2;
		  yVelPara = 1.5;
		  xVel = 2;
	}
	
}
