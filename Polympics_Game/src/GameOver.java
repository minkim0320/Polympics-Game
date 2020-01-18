/** GameOver.java
 * Description : This class creates a graphical design for the game over screen of the game
 * 	The components of this class is run if the game state is at gameover
 * 	It will display the score, a game over message, and a medal based on the score of the user
 * 	it has mouse action for buttons to be pressed to return to menu or to close the game
 * 	@author Min Kim
 * 	@version 1.0 (Created Jan 17)
 **/


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameOver implements MouseListener{

	//declares and initializes the coordinates of buttons
	private int buttonY = 400;
	private int buttonX = 400;
	private int buttonWidth = 200;
	
	//creates retangles for the buttons
	private Rectangle menu = new Rectangle(buttonX,buttonY,buttonWidth,60);
	private Rectangle quitGame = new Rectangle(buttonX,buttonY+100,buttonWidth,60);

	//stores images in Images object
	private Images gold = new Images ("gold");
	private Images silver = new Images ("silver");
	private Images bronze = new Images ("bronze");
	private Images participation = new Images ("nicetry");

	//y coordinate of the medal image positions
	private int medalY = 200;

	/**	gameOverDisplay
	 * 	To display the game over screen
	 * @param g
	 * 	graphics to set color, font, and display rectangles
	 */
	public void gameOverDisplay(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 700);

		g.setColor(Color.black);
		g.setFont(new Font("SanSerif", Font.BOLD, 15));
		
		if (Menu.score >= Menu.highScore) {
			Menu.highScore = Menu.score;
		}
		
		//based on the score of the user, it will display medals accordingly (gold, silver, bronze)
		if (Menu.score > 30) {
			//display gold medal
			gold.drawImage(g, 450, medalY, 100, 150);
		} else if (Menu.score > 20) {
			//display silver medal
			silver.drawImage(g, 450, medalY, 100, 150);
		} else if (Menu.score > 10) {
			//display bronze medal
			bronze.drawImage(g, 450, medalY, 100, 150);
		} else {
			//displays a participation ribbon
			participation.drawImage(g, 450, medalY, 100, 150);
			g.drawString("No medal for you..." , 400, medalY + 180);
		}
		
		
		//displays the message of game over
		g.setFont(new Font("SanSerif", Font.BOLD, 30));
		g.setColor(Color.black);
		g.drawString("GAME OVER", 400, 100);
		g.drawString("Your Score is " + Menu.score, 400, 150);
		g.drawString("HIGH SCORE : " + Menu.highScore , 400, 200);

		//draws button rectangles to go to main menu, and quit
		g.setColor(Color.black);
		Font fnt1 = new Font ("arial", Font.BOLD, 30); //declares new font
		g.setFont(fnt1);
		
		g.drawString("Main Menu", menu.x,  menu.y+50);
		g2d.draw(menu);
		g.drawString("Quit Game", quitGame.x,  quitGame.y+50);
		g2d.draw(quitGame);
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
		//only runs if the state of the game is in game over
		if (Game.State == Game.STATE.GAMEOVER) {
			//gets the x and y coordinates of the mouse, when mouse is pressed
			int mx = e.getX();
			int my = e.getY();

			//if the button coordinates are inside the menu button, change the game state to menu to display menu screen
			if (mx >= buttonX && mx <= buttonX + buttonWidth) {
				if ( my >= buttonY && my <= buttonY + 60) {
					Game.State = Game.STATE.MENU;
					Menu.score = 0;
				}
			}
			//if the button coordinates are inside the quit game button, close the program
			if (mx >= buttonX && mx <= buttonX + buttonWidth) {
				if ( my >= buttonY + 100 && my <= buttonY + 160) {
					System.exit(0);
				}
			}
		}	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
