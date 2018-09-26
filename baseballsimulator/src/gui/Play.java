/**
 * Deren Singh. Ms. Stowe. This class is the play class. The user has one of two
 * options. They can click the hit button to to simulate an at bat or 
 * sub button to substitute a player in for the batter.
 */
package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.Game;
import game.Player;

public class Play extends BasicGameState{
	
	private Image background;//background image
	
	private Shape hit, sub;//hit or sub buttons
	
	private UnicodeFont font, font2;//fonts
	
	private int x, y;//mouse x and y
	
	public static Game game;//game variables
	
	private TextField subField;//substitution field
	
	private boolean subError;//check if there was an error subbing someone in
	
	public Play(int state) {
		
	}
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		background = new Image("res/diamond.jpg");
		font = TeamCreator.getNewFont(font, "Arial", 30);
		font2 = TeamCreator.getNewFont(font2, "Arial", 30);
		hit = new Rectangle(1000, Game.GAME_HEIGHT-100, 200, 40);
		sub = new Rectangle(1000, Game.GAME_HEIGHT-50, 200, 40);
		game = TeamCreator.game;
		subError = false;
		
		
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	
		g.setColor(Color.blue);
		g.setBackground(Color.green);
		g.drawImage(background, 0, 0);
		renderHitButton(g);
		renderSubButton(g);
		renderScoreboard(g);
		renderBases(g);
		displayRecentAction(g);
		g.setColor(Color.white);
		g.setFont(font2);
		subField.render(gc, g);
		g.setFont(font);
		g.setColor(Color.red);
		if(subError == true){
			
		}
		
	}
	
	//handle button events
	public void update(GameContainer arg0, StateBasedGame sbg, int arg2) throws SlickException {
		font.loadGlyphs();
		font2.loadGlyphs();
		
		x = Mouse.getX();
		y = Game.GAME_HEIGHT - Mouse.getY();
		
		if(Mouse.isButtonDown(0)){
			if(hit.intersects(new Rectangle(x, y, 1, 1))){
				game.hit();
				try {
					Thread.sleep(125);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		if(Mouse.isButtonDown(0)){
			if(sub.intersects(new Rectangle(x, y, 1, 1))){
				if(game.getTeamAtBat().getSubstitutionsRoster().contains(new Player(subField.getText()))){
					final ErrorWindow e = new ErrorWindow("Player cannot be subbed back into game!");
					subError = true;
				}else{
					game.getTeamAtBat().substituteHitter(new Player(subField.getText()));
				}
			}
			try {
				Thread.sleep(125);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(game.isGameOver()){
			sbg.enterState(5);
		}
		
	}
	
	public void enter(GameContainer gc, StateBasedGame game) throws SlickException {
		subField = new TextField(gc, font2, 780, Game.GAME_HEIGHT-50, 200, 40);
	}
	
	public int getID() {
		return 3;
	}
	
	public void renderHitButton(Graphics g){
		int x = Mouse.getX();
		int y = 720-Mouse.getY();
		g.setColor(Color.white);
		g.draw(hit);
		g.fill(hit);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Hit", 1075, Game.GAME_HEIGHT-98);
		if(hit.intersects(new Rectangle(x, y, 1, 1))){
			g.setColor(Color.lightGray);
			g.fill(hit);
			g.setColor(Color.black);
			g.drawString("Hit", 1075, Game.GAME_HEIGHT-98);
		}
	}
	
	public void displayRecentAction(Graphics g){
		g.drawString(game.previousAction, 100, 100);
	}
	
	public void renderSubButton(Graphics g){
		g.setColor(Color.white);
		g.draw(sub);
		g.fill(sub);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Sub", 1070, Game.GAME_HEIGHT-50);
		if(sub.intersects(new Rectangle(x, y, 1, 1))){
			g.setColor(Color.lightGray);
			g.fill(sub);
			g.setColor(Color.black);
			g.drawString("Sub", 1070, Game.GAME_HEIGHT-50);
		}
	}
	
	public void renderScoreboard(Graphics g){
		g.setColor(new Color(150, 150, 150, 0.9f));
		g.fillRect(0, 0, 400, 140);
		g.setColor(Color.blue);
		g.drawString("Home: " + game.getHomeTeam().getScore(), 2, 2);
		g.drawString("Away: " + game.getAwayTeam().getScore(), 2, 32);
		g.drawString("Inning: " + game.getCurrentInning(), 2, 56);
		g.drawString("Outs: " + game.getCurrentOuts(), 180, 2);
	}
	
	//Render bases
	public void renderBases(Graphics g){
		game.getField().renderFirstBase(g);
		game.getField().renderSecondBase(g);
		game.getField().renderThirdBase(g);
		game.getField().renderHitter(g, game.getTeamAtBat().getPlayerAtBat());
	}

}
