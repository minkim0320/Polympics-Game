/**	KeyInput.java
 * 	Class to keep track and record the key inputs of the user
 * 	@author Min Kim
 *  @version 1.0 (Updated Jan 17, 2019)
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private static boolean [] keys = new boolean [256];
	
	//key event when key is pressed
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	//boolean for when key is released
	public void keyReleased (KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	//returns the key in which when key is down
	public static boolean isKeyDown(int keyCode) {
		return keys [keyCode];
	}
}