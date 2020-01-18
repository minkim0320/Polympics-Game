/** Main.java
 * Description : This is the main class that is for the running of the game
 * 	implements action listener to re draw the program after 3 milliseconds for the movement of objects
 * 	declares an enumeration for the state of the game, in order to flip between screens and display different game modes
 * 	This class also includes the code for the game dropper, which is the main game that I created
 * 	@author Min Kim
 * 	@version 1.0 (Updated Jan 17 2019)
 **/

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener{


	private static final long serialVersionUID = 1L;

	//object time for the timer of this class
	private Timer time;
	//sets speed of the timer for actionperformed
	private int speed = 4;

	//creates different states for the whole program, dividing each components of a game
	public static enum STATE{
		MENU,
		DROPPER,
		SHOOTER,
		INSTRUCTIONS,
		GAMEOVER
	};

	//sets default state to menu, so that menu screen appears first
	public static STATE State = STATE.MENU;

	//rectangle hitboxes for players, and obstacles
	Rectangle player, obstacleVertical,obstacleHoriz,obstacleMoving,point;
	
	//the objects for the screen of each component of the game
	Menu menu = new Menu();
	DeadlyShooterGame shooter = new DeadlyShooterGame();
	GameOver screen = new GameOver();
	Instructions rules = new Instructions();
	DropperGame dropper = new DropperGame();

	//constructor
	public Game() {
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		//key listener
		addKeyListener(new KeyInput());
		//adds all mouse listeners for each state
		this.addMouseListener(new Menu());
		this.addMouseListener(shooter);
		this.addMouseListener(new GameOver());
		this.addMouseListener (new Instructions());
		time = new Timer (speed, this);
	}

	/** paintComponent
	 * 	used to display the different screens using graphics
	 * 	called in the actionPerformed method to constantly repaint the screens
	 */
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		if (State == STATE.DROPPER) {
			dropper.display(g);
			//displays each state when it occurs
		} else if (State == STATE.MENU) {
			//if state is menu, it displays the menu screen
			menu.render(g);
		} else if (State == STATE.GAMEOVER) {
			//if state is gameover, it displays the game over screen
			screen.gameOverDisplay(g);
		} else if (Game.State == Game.STATE.INSTRUCTIONS) {
			//if state is instructions, it displays the instructions screen
			rules.display(g);
		} else {
			//displays the shooter game screen if no states match
			shooter.display(g);
		}
		time.start();
	}

	/** actionPerformed
	 * 	method to constantly update the display, and logics of the game
	 * 	it operates the code inside, and repaints, based on the speed of the timer
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (State == STATE.DROPPER) {
			//starts timer
			time.start();
			dropper.perform();
		
		} else if (State == STATE.SHOOTER) {
			shooter.perform();
		}
		repaint();
	}



	



}
