/**
 * Deren Singh. Ms. Stowe. THis class shows all the stats at the end of the game. 
 * It shows the final score and all stats from each player.
 */
package gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.Game;

public class EndGameStats extends BasicGameState{
	
	private Game game;//game object
	private UnicodeFont font;//font
	
	public EndGameStats(int state){
		
	}
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		game = Play.game;
		font = TeamCreator.getNewFont(font, "Arial", 20);
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.setColor(Color.black);
		g.setFont(font);
		g.drawString(getHomeTeamRoster(), 50, 50);
		
		g.drawString(getAwayTeamRoster(), 50, 380);
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		font.loadGlyphs();
	}

	public int getID() {
		return 5;
	}
	
	//Get the rosters
	private String getHomeTeamRoster(){
		return game.getHomeTeam().getEntireRoster();
	}
	
	private String getAwayTeamRoster(){
		return game.getAwayTeam().getEntireRoster();
	}
	

}
