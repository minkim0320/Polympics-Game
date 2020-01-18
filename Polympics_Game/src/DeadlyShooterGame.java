/** DeadlyShooterGame.java
 * Description : This class is for the main components of the game deadly shooter
 * 	It calls on objects and displays the background, player, and the obstacles of this game
 *	It also checks for collisions, score increase to keep track of the game and changes the state of the game accordingly
 * 	@author Min Kim
 * 	@version 1.0 (Created Jan 17)
 **/

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;

public class DeadlyShooterGame extends JPanel implements  MouseListener{

	private static final long serialVersionUID = 1L;

	//creates objects including the obstacles and random generators
	private FlyingObjects objects = new FlyingObjects();
	private Random rand = new Random ();

	//declares and initializes the width and the obstacle choice
	private int objWidth = 50;
	private int choice = 3;
	private Images image = new Images("backgroundTwo");
	private Images imageTwo = new Images ("goomba");
	private Images aim = new Images ("aim");
	private int mx, my;

	//constructor
	public DeadlyShooterGame() {
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		//adds mouse listener of this class
		this.addMouseListener(this);
	}

	/** display
	 * 	This method is for the displaying of the deadly shooter game
	 * @param g
	 */
	public void display (Graphics g) {
		if (Game.State == Game.STATE.SHOOTER) {
			//draws background
			image.drawImage(g, 0, 0, 1000,700);

			//draws obstacle based on its x and y coordinates
			imageTwo.drawImage(g,objects.getX(),objects.getY(),objWidth,objWidth);

			//draws the aim display of the "gun"
			aim.drawImage(g, mx - 10, my-10, 20, 20);

			//displays the user score
			g.setFont(new Font ("SanSerif", Font.BOLD, 40));
			g.drawString("Score : " + Menu.score, 10, 50);

		}
	}


	/**	perform
	 * 	This method simply moves the obstacles's coordinates based on which obstacle it is
	 * 	It also checks if the game is over by calling the checkGameOver method
	 */
	public void perform() {
		//only runs if the state is in the right game
		if (Game.State == Game.STATE.SHOOTER) {
			//choice 1 means that the obstacle moves horizontally
			if (choice == 1) {
				//moves obstacle horizontally
				objects.moveHorizontal();

				//choice 2 means that the obstacle moves vertically
			} else if (choice == 2) {
				//moves obstacle vertically
				objects.moveVertical();
			} else {
				//moves obstacle in a parabola
				objects.moveParabola();
			}
		}
		checkGameOver();
	}

	/**	checkGameOver
	 * 	checks to see if the game is over by checking the x and y coordinates of the object
	 * 	if x and y coordinates go beyond the screen, then the game is over
	 */
	public void checkGameOver() {
		//if the x coordinate goes beyond the right wall, the game is over
		if(objects.getX() >1000) {
			//changes game state to gameover, calling the game over screen
			Game.State = Game.STATE.GAMEOVER;

			//resets the coordinates and speed for next game
			objects.parabolaReset();
			objects.resetSpeed();
		}

		//if the y coordinate goes beyond the right wall, the game is over
		if (objects.getY() > 700) {
			//changes game state to gameover, calling the game over screen
			Game.State = Game.STATE.GAMEOVER;

			//resets the coordinates and speed for next game
			objects.parabolaReset();
			objects.resetSpeed();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}


	@Override
	public void mouseEntered(MouseEvent e) {


	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	/**	mousePressed
	 * 	Constantly receives whether or not mouse is pressed
	 * 	When mouse is pressed, it runs the code inside the method
	 */
	public void mousePressed(MouseEvent e) {
		//this mouse pressed only runs if the game state is shooter
		if (Game.State == Game.STATE.SHOOTER) {
			//stores the x and y coordinates of the mouse into variables
			mx = e.getX();
			my = e.getY();

			//if the mouse coordinates are hitting the object, increase score, and reset coordinates of different types of obstacles
			if (mx > objects.getX() && mx < objects.getX() + objWidth && my > objects.getY() && my < objects.getY() + objWidth) {
				Menu.score++;
				choice = rand.nextInt(3)+1;

				//if choice has a value of 1, the next object is one that moves horizontally
				if (choice == 1) {
					//resets the starting coordinates of the horizontal object
					objects.horizontalReset();

					//if choice has a value of 2, the next object is one that moves vertically
				} else if (choice == 2) {
					//resets the starting coordinates of the horizontal object
					objects.verticalReset();
				} else {
					//if else, the next object will move in a parabolic path
					//resets the starting coordinates of the parabola moving object
					objects.parabolaReset();
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
