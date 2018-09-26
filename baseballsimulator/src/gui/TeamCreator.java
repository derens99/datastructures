/**
 * Deren Singh. Ms. Stowe. This class is the team creator class. The user 
 * enters names and chooses either of two buttons to choose which team
 * the player is added to.
 */
package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.Game;
import game.Player;

public class TeamCreator extends BasicGameState {

	public static Game game;//Game object 

	private Image background;//background image
	private TextField nameField;//name text field

	private UnicodeFont font, font2;//fonts

	private Shape homeAdd;//button to add to home team
	private Shape awayAdd;//button to add to away team
	private Shape playBall;//button to start game

	private int x, y;//mouse x and y variables
	private long time;
	
	private boolean error, error2;//boolean to check for error
	
	public TeamCreator(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sgb) throws SlickException {
		game = new Game("Baseball Simulator");
		background = new Image("res/teamcreator.png");
		font = getNewFont(font, "Arial", 30);
		font2 = getNewFont(font2, "Arial", 40);
		nameField = new TextField(gc, font, 500, 200, 200, 50);
		homeAdd = new Rectangle(430, 205, 200, 40);
		awayAdd = new Rectangle(430, 255, 200, 40);
		playBall = new Rectangle(1050, Game.GAME_HEIGHT-50, 200, 40);
		error = false;
		error2 = false;
		
		game.addPlayerToAwayTeam(new Player("a"));
		game.addPlayerToAwayTeam(new Player("b"));
		game.addPlayerToAwayTeam(new Player("c"));
		game.addPlayerToAwayTeam(new Player("d"));
		game.addPlayerToAwayTeam(new Player("e"));
		game.addPlayerToAwayTeam(new Player("f"));
		game.addPlayerToAwayTeam(new Player("g"));
		game.addPlayerToAwayTeam(new Player("h"));
		game.addPlayerToAwayTeam(new Player("i"));
		
		game.addPlayerToHomeTeam(new Player("A"));
		game.addPlayerToHomeTeam(new Player("B"));
		game.addPlayerToHomeTeam(new Player("C"));
		game.addPlayerToHomeTeam(new Player("D"));
		game.addPlayerToHomeTeam(new Player("E"));
		game.addPlayerToHomeTeam(new Player("F"));
		game.addPlayerToHomeTeam(new Player("G"));
		game.addPlayerToHomeTeam(new Player("H"));
		game.addPlayerToHomeTeam(new Player("I"));
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.setFont(font2);
		g.setColor(Color.white);
		g.drawString("Name", 100, 200);

		g.drawString("Home: " + game.getHomeTeam().getPlayingRoster().getSize(), 1000, 200);
		g.drawString("Away: " + game.getAwayTeam().getPlayingRoster().getSize(), 1000, 250);
		if(game.getHomeTeam().getPlayingRoster().getSize() != 9){
			g.draw(homeAdd);
			g.fill(homeAdd);
			g.setColor(Color.black);
			g.setFont(font);
			g.drawString("Add", 500, 205);
		}
		
		if(game.getAwayTeam().getPlayingRoster().getSize() != 9){
			g.setColor(Color.white);
			g.draw(awayAdd);
			g.fill(awayAdd);
			g.setColor(Color.black);
			g.setFont(font);
			g.drawString("Add", 500, 255);
		}
		
		g.setColor(Color.white);
		nameField.render(gc, g);
		
		if(game.getAwayTeam().getPlayingRoster().getSize() == 9 && game.getHomeTeam().getPlayingRoster().getSize() == 9){
			g.setColor(Color.white);
			g.fill(playBall);
			g.setColor(Color.black);
			g.drawString("Play Ball!", 1090, 670);
		}
		
		if (homeAdd.intersects(new Rectangle(x, y, 1, 1)) && game.getHomeTeam().getPlayingRoster().getSize() != 9) {
			g.setColor(Color.lightGray);
			g.fill(homeAdd);
			g.setColor(Color.black);
			g.drawString("Add", 500, 205);
		}
		if (awayAdd.intersects(new Rectangle(x, y, 1, 1)) && game.getAwayTeam().getPlayingRoster().getSize() != 9) {
			g.setColor(Color.lightGray);
			g.fill(awayAdd);
			g.setColor(Color.black);
			g.drawString("Add", 500, 255);
		}
		if(playBall.intersects(new Rectangle(x, y, 1, 1)) && game.getAwayTeam().getPlayingRoster().getSize() == 9 
				&& game.getHomeTeam().getPlayingRoster().getSize() == 9){
			g.setColor(Color.lightGray);
			g.fill(playBall);
			g.setColor(Color.black);
			g.drawString("Play Ball!", 1090, 670);
		}
	}

	//Check for button events 
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		font.loadGlyphs();
		font2.loadGlyphs();
		x = Mouse.getX();
		y = Game.GAME_HEIGHT - Mouse.getY();
		
		time += delta;
		
		if (Mouse.isButtonDown(0)) {
			if (game.getHomeTeam().getPlayingRoster().getSize() < 9) {
				if (homeAdd.intersects(new Rectangle(x, y, 1, 1))) {
					try{
						Player.validPlayer(nameField.getText());
						game.addPlayerToHomeTeam(new Player(nameField.getText()));
						nameField.setText("");
						nameField.setFocus(true);
					}catch(IllegalArgumentException e){
						ErrorWindow w = new ErrorWindow("Invalid name!");
					}
					
				}
				
			}
		}

		if (Mouse.isButtonDown(0)) {
			if (game.getAwayTeam().getPlayingRoster().getSize() < 9) {
				if (awayAdd.intersects(new Rectangle(x, y, 1, 1))) {
					try{
						Player.validPlayer(nameField.getText());
						game.addPlayerToAwayTeam(new Player(nameField.getText()));
						nameField.setText("");
						nameField.setFocus(true);
					}catch(IllegalArgumentException e){
						ErrorWindow w = new ErrorWindow("Invalid name!");
					}
				}
				try {
					Thread.sleep(75);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(Mouse.isButtonDown(0)){
			if(playBall.intersects(new Rectangle(x, y, 1, 1))){
				if(game.getAwayTeam().getPlayingRoster().getSize() == 9 || game.getHomeTeam().getPlayingRoster().getSize() == 9){
					sbg.enterState(Game.PLAY);
				}else{
					ErrorWindow w = new ErrorWindow("Not enough players per team!!");
				}
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public int getID() {
		return 2;
	}

	public void enter(GameContainer gc, StateBasedGame game) throws SlickException {
		nameField = new TextField(gc, font, 220, 205, 200, 40);
	}
	
	public static UnicodeFont getNewFont(UnicodeFont f, String fontName, int fontSize) {
		f = new UnicodeFont(new Font(fontName, Font.PLAIN, fontSize));
		f.addGlyphs("@");
		f.getEffects().add(new ColorEffect(java.awt.Color.white));
		return (f);
	}
	
	public void messageBox(String m){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createWindow(m);
			}
		});
	}
	
	private void createWindow(String m){
		JFrame frame = new JFrame("Error box!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel(m);
		JButton button = new JButton("Close");
		frame.getContentPane().add(label);
		frame.getContentPane().add(button);
		frame.setSize(300,  250);
		//frame.pack();
		frame.setVisible(true);
	}
	
}
