/**	Menu.java
 * 	Description : To create a graphical menu screen to be displayed 
 * 	the menu screen consists of the title of the game, the buttons to each game and instructions
 * 	it also allows for the closing of the program to be done
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Menu implements MouseListener {

	//creates new rectangle objects for the button locations
	public Rectangle playDropper = new Rectangle(200,200,700,60);
	public Rectangle playSkeetShooter = new Rectangle(200,300,700,60);
	public Rectangle instructions = new Rectangle(200,400,700,60);
	public Rectangle quit = new Rectangle(200,500,700,60);

	//each time the menu screen appears, it resets the score to 0 for all games
	public static int score = 0;
	public static int highScore = 0;
	
	/** render
	 * 	The method used to display the menu screen that has been designed
	 * @param g
	 */
	public void render (Graphics g) {
		
		//creates an object for 2 dimensional graphics (buttons)
		Graphics2D g2d = (Graphics2D) g;

		//sets the background colour and fills the background using a rectangleS
		g.setColor(Color.BLACK);
		
		//title of the game
		g.fillRect(0,0,1000, 700);
		g.setColor(Color.WHITE);
		Font fnt0 = new Font ("arial", Font.BOLD, 100);
		g.setFont(fnt0);
		g.drawString("POLYMPICS" , 250, 100);

		//displays the name and shape of the buttons
		Font fnt1 = new Font ("arial", Font.BOLD, 50);
		g.setFont(fnt1);
		//button to play dropper game
		g.drawString("PLAY DROPPER", playDropper.x,  playDropper.y+50);
		g2d.draw(playDropper);

		//button to play deadly shooter game
		g.drawString("PLAY DEADLY SHOOTER", playSkeetShooter.x,  playSkeetShooter.y+50);
		g2d.draw(playSkeetShooter);

		//button to go to instructions page
		g.drawString("Instructions", instructions.x,  instructions.y+50);
		g2d.draw(instructions);

		//button to close program
		g.drawString("Quit Game", quit.x,  quit.y+50);
		g2d.draw(quit);

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
	@Override
	public void mousePressed(MouseEvent e) {
		//only runs if the state of the game is menu
		if (Game.State == Game.STATE.MENU) {
			
			//stores the coordinates of the mouse into variables
			int mx = e.getX();
			int my = e.getY();

			//checks to see if mouse pressed on a buttton for the dropper game
			if (mx >= 200 && mx <= 900) {
				if ( my >= 200 && my <= 260) {
					//change the state to dropper, running the game
					Game.State = Game.STATE.DROPPER;
				}
			}

			//checks to see if mouse pressed on a buttton for the deadly shooter game
			if (mx >= 200 && mx <= 900) {
				if ( my >= 300 && my <= 360) {
					//change the state to shooter, running the deadly shooter game
					Game.State = Game.STATE.SHOOTER;
				}
			}
			
			//checks to see if mouse pressed on a buttton for the instructions page
			if (mx >= 200 && mx <= 900) {
				if ( my >= 400 && my <= 460) {
					//changes game state to instructions, which display the instructions screen
					Game.State = Game.STATE.INSTRUCTIONS;
				}
			}
			
			//checks to see if mouse pressed on a buttton to quit game
			if (mx >= 200 && mx <= 900) {
				if ( my >= 500 && my <= 560) {
					//closes the program
					highScore = 0;
					System.exit(0);
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}


}
