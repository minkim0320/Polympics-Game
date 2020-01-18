/** Main.java
 * Description : This creates a JFrame to display the game
 * 	sets the dimensions of the window, default close operation, etc..
 * 	@author Min Kim
 * 	@version 1.0 (Created Jan 17)
 **/

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		// overall frame
		JFrame frame = new JFrame ("Polympics!");
		Game game = new Game();
		
		frame.setSize(new Dimension(1000,700));
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(game);

	}

}
