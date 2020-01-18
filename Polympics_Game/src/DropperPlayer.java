/** Main.java
 * Description : This class creates an object for the player of the game, and methods to move and set player coordinates
 * 	this class also allows for key inputs to occur, moving the player with appropriate keys
 * 	@author Min Kim
 * 	@version 1.0 (Created Jan 17)
 **/

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class DropperPlayer {

	//declares the x, y, and maximum coordinates of the player
	private int playerX ,playerY, playerWidth;
	private int maxPlayerY = 600;

	//declares and initializes the speed and falling speed of the player
	private double speed = 3;
	private double fallingSpeed = 0.1;

	//declares boolean for jumping
	private boolean canJump;

	//sets the gravity of the player
	private double gravity = 0.1;

	//boolean to check which way the player object is moving
	private boolean lookLeft,lookRight,lookStraight;

	//declares images for the character faces
	Images image = new Images("character");
	Images imageTwo = new Images("characterLeft");
	Images imageThree = new Images("characterRight");

	//constructor for the player class
	public DropperPlayer(int x, int y, int width) {
		this.playerX = x;
		this.playerY = y;
		this.playerWidth = width;

	}

	public void display (Graphics g) {

		//displays the character faces based on which direction it is looking at
		if (lookStraight) 
			image.drawImage(g, this.playerX, this.playerY, this.playerWidth, this.playerWidth);

		//if moving left, display character face that looks left
		else if (lookLeft)
			imageTwo.drawImage(g, this.playerX, this.playerY, this.playerWidth, this.playerWidth);

		//if moving right, display character face that looks right
		else if (lookRight)
			imageThree.drawImage(g, this.playerX, this.playerY, this.playerWidth, this.playerWidth);

	}

	/** getPlayerX
	 *  returns the x coordinate of this object
	 * @return playerX
	 */
	public int getPlayerX() {
		return playerX;
	}

	/** getPlayerY
	 *  returns the y coordinate of this object
	 * @return playerY
	 */
	public int getPlayerY() {
		return playerY;
	}

	/** getWidth
	 *  returns the width of this object
	 * @return pointWidth
	 */
	public int getPlayerWidth() {
		return playerWidth;
	}

	/** moveRight
	 * 	moves the character right
	 */
	public void moveRight() {
		//adds the value of speed to player x coordinate
		playerX +=speed;
	}

	/** moveLeft
	 * 	moves the character left
	 */
	public void moveLeft() {
		//subtracts the value of speed to player x coordinate
		playerX -= speed;
	}

	/** playerMove
	 * 	The character moves, jumps, falls according to key input of the user
	 * 	The character fill also changes to a different picture for each key event
	 */
	public void playerMove() {
		//sets automatic direction to look straight
		lookLeft = false;
		lookRight = false;
		lookStraight = true;

		//calls method to make user fall after jumps, and sets height limit when jumping
		fall();
		jumpLimit();

		//if key right is pressed, move only if player is within the boundaries of the window
		if (KeyInput.isKeyDown(KeyEvent.VK_RIGHT)) {
			if (playerX >= 940) {
				playerX = 940;
			} else {
				moveRight();
			}
			//changes boolean values according to which way player moves
			lookLeft = false;
			lookRight = true;
			lookStraight = false;
		} 
		if (KeyInput.isKeyDown(KeyEvent.VK_LEFT)) {
			//if key left is pressed, move only if player is within the boundaries of the window
			if (playerX <= 10) {
				playerX = 10;
			} else {
				moveLeft();
			}

			//changes boolean values according to which way player moves
			lookLeft = true;
			lookRight = false;
			lookStraight = false;
		}

		//if key up if pressed, jump the player
		if (KeyInput.isKeyDown(KeyEvent.VK_UP)) {
			jump(7.5);
		}
	}

	/** fall
	 * 	This method allows the user to be falling at all times
	 * it acts as the functioning of gravity on a character in the window 
	 */
	public void fall () {
		
		//makes player fall at all time
		playerY += fallingSpeed;
		fallingSpeed += gravity;
		
		//stops the player y cooordinate movement when it reaches the maximum limit
		if (playerY >= maxPlayerY) {
			playerY = maxPlayerY;
		}
	}


	/**jumpLimit
	 * 	Sets a limit on how much the player y coordinate move in order to jump
	 * 	changes the canJump boolean accordingly
	 */
	public void jumpLimit() {
		//sets limit on when the player can jump
		if (playerY < 600) {
			canJump = false;

		} else  {
			
			//can jump is true, and will jump
			canJump = true;
		}
	}

	/**jump
	 * 	A method in which if the boolean canJump is true, the method call jump occurs, allowing the user to jump their character
	 * @param jumpHeight
	 */
	public void jump (double jumpHeight) {

		// if the user is able to jump, jump by "falling" upwards
		if (canJump) {
			//falling speed is negative to fall backwards, up the screen, like jumping
			fallingSpeed  = - jumpHeight;
			fall();
		}

	}
}
