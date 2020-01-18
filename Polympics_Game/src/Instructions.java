/** Instructions.java
 * 	Description : to display the instruction screen in the game
 * 	The instruction screen consists of rules displayed in a string, and the buttons to go back to menu and quit game
 * 	@author Min Kim
 *  @version 1.0 (Updated Jan 17, 2019)
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Instructions implements MouseListener {

	//rectangle instances for the buttons displayed in this instructions screen
	public Rectangle menu = new Rectangle(100,500,700,60);
	public Rectangle quit = new Rectangle(100,580,700,60);

	/** display
	 * 	The method used to display the instructions screen that has been designed
	 * @param g
	 */
	public void display(Graphics g) {

		//creates a 2d graphics object (for button display)
		Graphics2D g2d = (Graphics2D) g;

		//sets color, and fills background with a rectangle
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 1000, 700);

		//new color, font, sub-titles
		g.setColor(Color.black);
		g.setFont(new Font("SanSerif", Font.BOLD, 30));
		g.drawString("Dropper Rules : ", 100, 50);
		g.drawString("Deadly Shooter Rules : ", 100, 300);

		//displays the rules of dropper
		g.setFont(new Font("SanSerif", Font.BOLD, 15));
		g.drawString("The objective is to collect coins in order to increase the score.",100,100);
		g.drawString("There are obstacles that bounce off walls, goes across screen that you will need to dodge ",100,150);
		g.drawString("To dodge, simply move left, right, and jump using the arrow keys and collect as many coins as you can!!!", 100, 200);

		//displays the rules of deadly shooter
		g.drawString("The objective is to hit the monster flying across the screen.",100,350);
		g.drawString("The monster can come from anywhere in any direction, and you must shot it before it reaches the other end ",100,400);
		g.drawString("To shot, aim at the monster and left click the mouse!!! Good luck ", 100, 450);
		
		//creates labels and displays buttons for the menu and quitting game
		g.setFont(new Font("SanSerif", Font.BOLD, 30));
		g.drawString("Back to Main Menu", menu.x+50,  menu.y+50);
		g2d.draw(menu);

		g.drawString("Quit Game", quit.x+50,  quit.y+50);
		g2d.draw(quit);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	/**	mousePressed
	 * 	Constantly receives whether or not mouse is pressed
	 * 	When mouse is pressed, it runs the code inside the method
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		//this only runs if the game state is equal to instructions
		if (Game.State == Game.STATE.INSTRUCTIONS) {
			//sets the coordinates of the mouse into variables
			int mx = e.getX();
			int my = e.getY();
			
			//checks to see if the mouse pressed on a menu button
			if (mx >= 100 && mx <= 800) {
				if ( my >= 500 && my <= 560) {
					//changes state to menu, which then displays the menu screen
					Game.State = Game.STATE.MENU;
				}
			}

			//checks to see if the mouse pressed on a quit game button
			if (mx >= 100 && mx <= 800) {
				if ( my >= 580 && my <= 640) {
					//quits the game
					System.exit(0);
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
