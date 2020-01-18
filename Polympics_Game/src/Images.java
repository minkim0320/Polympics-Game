/**	Images.java
 * 	Description: This is a class which images can be called and stored into an object
 * 	@author Min Kim
 *  @version 1.0 (Updated Jan 17,2019)
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	private BufferedImage image;
	
	public Images(String fileName) {
		try {
			//must track the source folder for the pictures
			image = ImageIO.read(new File("C:\\Users\\minki\\Documents\\eclipse-workspace\\Polympics_Game\\icons\\" + fileName + ".PNG"));
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	/** drawImage
	 * 	Method to display the image using coordinates
	 * @param g
	 * @param x	- x coordinate
	 * @param y	- y coordinate
	 * @param width - width of image
	 * @param height - width of height
	 */
	public void drawImage(Graphics g, int x, int y, int width, int height) {
		g.drawImage(image, x, y, width, height, null);
	}


}