/** Obstacless
 *  Description : A parent class for all obstacle object classes in the game
 *  abstract class as it has abstract methods to be used by the child obstacle classes
 * @author Min Kim
 * @version 1.0 (Updated Jan 17, 2019)
 */
public abstract class Obstacles {
	
	private int x,y,width;
	private double speed;
	//parent constructor
	public Obstacles (int x,int y,int width,double speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.speed = speed;
	}
	
	//abstract classes created to be overridden by its child classes later on
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getWidth(){
		return this.width;
	}
	public double getSpeed() {
		return this.speed;
	}
	
	public void move() {
		
	}
	public void obstacleReset() {
	}
}
	

