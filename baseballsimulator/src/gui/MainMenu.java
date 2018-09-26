/**
 * Deren Singh. Ms. Stowe. This class is the main menu class. It starts the program
 * and the user can either choose to start or exit
 */
package gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.Game;

public class MainMenu extends BasicGameState{
	
	public MainMenu(int state){
		
	}
	
	private Image background;//background picture
	private Button play;//play button
	private Button exit;//exit button
	
	//Button width and height
	private final int BUTTON_WIDTH = 400;
	private final int BUTTON_HEIGHT = 100;
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		background = new Image("res/fenway.jpg");
		play = new Button(new Image("res/play.png"), new Image("res/playSelect.png"), Game.GAME_WIDTH/2-200, Game.GAME_HEIGHT/2-150, BUTTON_WIDTH, BUTTON_HEIGHT);
		exit = new Button(new Image("res/quit.png"), new Image("res/quitSelect.png"), Game.GAME_WIDTH/2-200, Game.GAME_HEIGHT/2, BUTTON_WIDTH, BUTTON_HEIGHT);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		play.drawButton(g);
		exit.drawButton(g);
	}

	//check for button events
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		if(play.isClicked()){
			sbg.enterState(Game.TEAMCREATOR);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(exit.isClicked()){
			System.exit(0);
		}
	}

	public int getID() {
		return 1;
	}

}
