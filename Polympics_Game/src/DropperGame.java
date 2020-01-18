import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JPanel;

public class DropperGame extends JPanel {

	private static final long serialVersionUID = 1L;
	//declare and initialize variables
	private Random rand = new Random (); //random object to generate random numbers later in the program
	private int obsVerticalX = rand.nextInt(950) + 1; //the vertical obstacle starts at a random x coordinate
	private int obsVerticalY = 0; //the vertical obstacle starts from the top of the screen

	//sets the starting coordinate of the obstacles that move horizontally
	private int obsHorizontalX = 0;
	private int obsHorizontalY= rand.nextInt(500) + 1;

	//sets the starting coordinates of the obstacles that move vertical
	private int obsMovingX = 200;
	private int obsMovingY = 200;

	//declares and initializes the obstacle width and its starting speed
	private int obsWidth = 50;
	private double obsSpeed = 2.5;

	//declares and intializes the number of lives for the player
	private int lives = 3;

	//rectangle hitboxes for players, and obstacles
	Rectangle player, obstacleVertical,obstacleHoriz,obstacleMoving,point;

	//creates instances of objects needed for this game
	DropperPlayer user = new DropperPlayer(400,600,50);
	VerticalObstacles vertical = new VerticalObstacles(obsVerticalX,obsVerticalY, obsWidth, obsSpeed);
	HorizontalObstacle horizontal = new HorizontalObstacle(obsHorizontalX, obsHorizontalY, obsWidth,obsSpeed);
	MovingObstacle moving = new MovingObstacle(obsMovingX,obsMovingY,obsWidth,obsSpeed-1.5);
	Coins star = new Coins();

	//creating an image, calling a file from icons folder
	Images image = new Images("background");

	public void display(Graphics g) {
		//displays background map
		image.drawImage(g, 0, 0, 1000,700);

		//the character
		user.display(g);

		//obstacles
		vertical.display(g);
		horizontal.display(g);
		moving.display(g);
		star.display(g);

		//displays the score and lives
		g.setColor(Color.WHITE);
		g.setFont(new Font ("SanSerif", Font.BOLD, 40));
		g.drawString("Score : " + Menu.score, 10, 50);
		g.drawString("Lives : " + lives , 10, 100);
	}

	/**	perform
	 * 	constantly updates new coordinates of the rectangle that needs for the collision check
	 * 	calls methods gameOn and pointCount to run the game
	 */
	public void perform() {
		//updates positions of the player and obstacle hit boxes by creating new rectangles with new dimensions
		player = new Rectangle(user.getPlayerX(), user.getPlayerY(), user.getPlayerWidth(), user.getPlayerWidth());
		obstacleVertical = new Rectangle (vertical.getX(), vertical.getY(), vertical.getWidth(), vertical.getWidth());
		obstacleHoriz = new Rectangle (horizontal.getX(), horizontal.getY(), horizontal.getWidth(), horizontal.getWidth());
		obstacleMoving = new Rectangle (moving.getX(),moving.getY(),moving.getWidth(),moving.getWidth());
		point = new Rectangle (star.getX(), star.getY(), star.getWidth()/4, star.getWidth()/4);
		
		//calls methods which move obstacles, and calculating lives, to update the pictures and numbers as the program runs
		checkGameOn();
		gameOn();
		pointCount();
	}


	/** checkGameOn
	 * 	Constantly checks for the number of lives that the user has, and if it is at 0, it changes the game state to game over
	 * 	this then allows for the game over screen to display and resets lives to 3 for next time
	 */
	public void checkGameOn() {
		//checks to see if the game ended, because lives have all been used
		if(lives <= 0) {
			//changes the state of the game to game over
			Game.State = Game.STATE.GAMEOVER;

			//resets number of lives to 3 for next time the game runs
			lives = 3;

			//resets the speed of the obstacles for next time, as the obstacle speeds increase as the game goes on
			vertical.resetSpeed(obsSpeed);
			horizontal.resetSpeed(obsSpeed);
		}
	}
	
	
	/**	gameOn
	 * 	This method runs other methods that run the functions of the game
	 * 	This includes, user movement, obstacle movement, and checking for collision
	 */
	public void gameOn() {

		//moving player and obstacle
		user.playerMove();
		vertical.move();
		horizontal.move();
		moving.move();

		//checking for collision
		obstacleVerticalCollide();
		obstacleHorizontalCollide();
		obstacleMovingCollide();

	}
	
	/** obstacleVerticalCollide
	 * 	A void method to just check to see if players collide with obstacle and adjusts coordinates and score accordingly
	 */
	public void obstacleVerticalCollide() {
		
		//checks to see if player collided with obstacles, and if so, decrease the number of lives and reset the coordinates of the obstacles
		if (player.intersects(obstacleVertical)) {
			//decreases lives and resets coordinates
			lives --;
			vertical.obstacleReset();
		} else if (vertical.getY()>700){
			//if obstacles over exceed the boundaries of the window, reset the coordinates
			vertical.obstacleReset();
		}
	}

	/** obstacleMovingCollide
	 * 	A void method to just check to see if players collide with obstacle and adjusts coordinates and score accordingly
	 */
	public void obstacleMovingCollide() {
		//checks to see if player collided with obstacles, and if so, decrease the number of lives and reset the coordinates of the obstacles
		if (player.intersects(obstacleMoving)) {
			//decreases lives and resets coordinates
			lives --;
			moving.obstacleReset();
		} 
	}
	/** obstacleHorizontalCollide
	 * 	A void method to just check to see if players collide with obstacle and adjusts coordinates and score accordingly
	 */
	public void obstacleHorizontalCollide() {
		//checks to see if player collided with obstacles, and if so, decrease the number of lives and reset the coordinates of the obstacles
		if(player.intersects(obstacleHoriz)) {
			//decreases lives and resets coordinates
			lives --;
			horizontal.obstacleReset();
		} else if (horizontal.getX()>1000){
			//if obstacles over exceed the boundaries of the window, reset the coordinates
			horizontal.obstacleReset();
		}
	}
	
	/** pointCount
	 * 	method to count and increase score if a player meets the requirements
	 */
	public void pointCount() {
		
		//checks to see if player hitbox collides with the coin hitbox and increases score as it collides
		if (player.intersects(point)) {
			//increases score
			Menu.score ++;
			star.starReset();
		}
	}

}
