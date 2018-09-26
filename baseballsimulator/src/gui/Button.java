/**
 * Deren Singh. Ms. Stowe. This class holds all the data needed for a 
 * button. It can check if its pressed or hovered over.
 */
package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import game.Game;

public class Button {
	
	private Image image;//original image
	private Image imageSelect;//selected image
	private int x;//x coordinate
	private int y;//y coordinate
	private int width;//button width
	private int height;//button height

	private Rectangle rect;//Rectangle for button
	
	//COnstructor to initialize button
	public Button(Image i, Image iS, int x, int y, int w, int h) {
		image = i;
		imageSelect = iS;
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		rect = new Rectangle(this.x, this.y, width, height);
	}
	
	//Check if mouse is on button
	public boolean isMouseOnButton() {
		int mouseX = Mouse.getX();
		int mouseY =  Game.GAME_HEIGHT - Mouse.getY();

		if (rect.contains(mouseX, mouseY))
			return true;
		else
			return false;
	}

	//Check if user clicked button
	public boolean isClicked() {
		if (isMouseOnButton()) {
			if (Mouse.isButtonDown(0)) {
				return true;
			}
		}
		return false;
	}
	
	//draw button
	public void drawButton(Graphics g) {
		if (isMouseOnButton()) {
			g.drawImage(imageSelect, x, y);
		} else {
			g.drawImage(image, x, y);
		}
	}
}
