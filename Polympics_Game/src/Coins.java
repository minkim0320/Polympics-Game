/** Main.java
 * Description : This creates an object to display and move a coin in the dropper game
 * 	methods to set x and y coordinates, and return the coordinates
 * 	@author Min Kim
 * 	@version 1.0 (Created Jan 17)
 **/

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Coins {
	
	//declares and initializes variables for the coin
	public Random rand = new Random ();
	private int pointX = rand.nextInt(950) + 1 ;
	private int pointY = rand.nextInt(400)+260;
	private int pointWidth = 20;
	
	//displays the coin on screen
	public void display(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(pointX, pointY, pointWidth, pointWidth);
	}
	
	//resets the coordinates of the coin to random positions on the window
	public void starReset() {
		pointX = rand.nextInt(900) + 50 ;
		pointY = rand.nextInt(350)+300;
	}
	
	/** getX
	 *  returns the x coordinate of this object
	 * @return pointX
	 */
	public int getX() {
		return this.pointX;
	}

	/** getY
	 *  returns the y coordinate of this object
	 * @return pointY
	 */
	public int getY() {
		return this.pointY;
	}

	/** getWidth
	 *  returns the width of this object
	 * @return pointWidth
	 */
	public int getWidth() {
		return this.pointWidth;
	}
	
	
}
