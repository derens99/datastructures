/**
 * Deren Singh. Ms. Stowe. This class is the game class. It starts the program and 
 * holds both teams and practically controls the entire program.
 */
package game;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import gui.*;

public class Game extends StateBasedGame {

	public static final int innings = 3;// Inning constant to determine how many
										// innings played
	private int currentInning;// Current inning in game

	public static final String NAME = "Baseball Simulator";// Game name
	// Game states
	public static final int MENU = 1;
	public static final int TEAMCREATOR = 2;
	public static final int PLAY = 3;
	public static final int ENDGAMESTATS = 5;

	// Game height and width
	public static final int GAME_WIDTH = 1280;
	public static final int GAME_HEIGHT = 720;

	// Home and away teams
	private Team home, away;

	private Team atBat;// Team at bat
	public String previousAction;// previous action a player did
	private int outs;// How many outs there are

	private boolean isOver;// Is the game over or not

	private Field field;// Field to keep track of bases, runs, and stats

	// Constructor to set name and initialize instance variables
	public Game(String name) {
		super(name);
		home = new Team();
		away = new Team();
		atBat = away;
		outs = 0;
		currentInning = 1;
		field = new Field();
		away.setName("Away");
		home.setName("Home");
		previousAction = "";
		isOver = false;
		this.addState(new MainMenu(MENU));
		this.addState(new TeamCreator(TEAMCREATOR));
		this.addState(new Play(PLAY));
		this.addState(new EndGameStats(ENDGAMESTATS));
	}

	/**
	 * Get the current inning
	 * 
	 * @return - current inning of the game
	 */
	public String getCurrentInning() {
		if (atBat == away) {
			return "Top " + currentInning;
		} else {
			return "Bot " + currentInning;
		}

	}

	// Initialize graphics and window
	public void initStatesList(GameContainer gc) throws SlickException {
		getState(MENU).init(gc, this);
		getState(TEAMCREATOR).init(gc, this);
		getState(PLAY).init(gc, this);
		getState(ENDGAMESTATS).init(gc, this);
		enterState(MENU);
		gc.setTargetFrameRate(60);
		gc.setShowFPS(false);
	}

	

	/**
	 * Set the previous action manually
	 * 
	 * @param s
	 *            - previous action
	 */
	public void setPreviousAction(String s) {
		previousAction = s;
	}

	/** Return what just happened by a specific player
	 * @return - the event a player called
	 */
	public String getRecentHit() {
		String name;
		if (atBat.getPreviousBatter() == null) {
			name = "";
		} else {
			name = atBat.getPreviousBatter().getName();
		}
		switch (previousAction) {
		case "walk":
			return name + " gets walked.";
		case "single":
			return name + " hits a single.";
		case "double":
			return name + " hits a double!";
		case "triple":
			return name + " hits a triple!";
		case "homerun":
			return name + " hits a homerun!";
		case "out":
			return name + " gets an out.";
		}
		return "";

	}

	//Main method
	public static void main(String[] args) throws SlickException {

		AppGameContainer container = new AppGameContainer(new Game("Baseball Simulator"));

		container.setDisplayMode(Game.GAME_WIDTH, Game.GAME_HEIGHT, false);
		container.setAlwaysRender(true);
		container.start();
	}

	/** Calcualate an event based on probability
	 * @param t - the team making an event
	 */
	public void calculateAction(Team t) {
		Random gen = new Random();
		int play = gen.nextInt(100) + 1;
		if (play <= 8) {
			registerWalk(t.getPlayerAtBat());
			atBat.advanceBattingOrder();
			return;
		} else if (play <= 28) {
			registerSingle(t.getPlayerAtBat());
			atBat.advanceBattingOrder();
			return;
		} else if (play <= 40) {
			registerDouble(t.getPlayerAtBat());
			atBat.advanceBattingOrder();
			return;
		} else if (play <= 43) {
			registerTriple(t.getPlayerAtBat());
			atBat.advanceBattingOrder();
			return;
		} else if (play <= 50) {
			registerHomerun(t.getPlayerAtBat());
			atBat.advanceBattingOrder();
			return;
		} else {
			registerOut(t.getPlayerAtBat());
		}
	}
	
	// Method to hit the ball
		public void hit() {
			Team prev = atBat;
			calculateAction(atBat);
		}
	
	/** Register a walk event to the game
	 * @param player - the player getting walked
	 */
	public void registerWalk(Player player) {
		atBat.addToScore(field.registerWalk(player));
		player.addStat('w');
		previousAction = atBat.getPlayerAtBat().getName() + " gets a walk!";
	}
	/** Register a single hit event to the game
	 * @param player - the player getting a single
	 */
	public void registerSingle(Player player) {
		atBat.addToScore(field.registerSingle(player));
		player.addStat('s');
		previousAction = atBat.getPlayerAtBat().getName() + " gets a single!";
	}
	/** Register a double hit event to the game
	 * @param player - the player getting a double
	 */
	public void registerDouble(Player player) {
		atBat.addToScore(field.registerDouble(player));
		player.addStat('d');
		previousAction = atBat.getPlayerAtBat().getName() + " gets a double!";
	}
	
	/** Register a triple hit event to the game
	 * @param player - the player getting a triple
	 */
	public void registerTriple(Player player) {
		atBat.addToScore(field.registerTriple(player));
		player.addStat('t');
		previousAction = atBat.getPlayerAtBat().getName() + " gets a triple!";
	}
	/** Register a homerun hit event to the game
	 * @param player - the player getting a homerun
	 */
	public void registerHomerun(Player player) {
		atBat.addToScore(field.registerHomerun(player));
		player.addStat('h');
		previousAction = atBat.getPlayerAtBat().getName() + " gets a homerun!";
	}
	/** Register an out event to the game
	 * @param player - the player getting out
	 */
	public void registerOut(Player player) {
		field.registerOut(player);
		previousAction = atBat.getPlayerAtBat().getName() + " gets an out.";
		player.addStat('o');
		if (outs == 2) {
			outs = 0;
			setPreviousAction(atBat.getPlayerAtBat().getName() + " gets out.");
			atBat.advanceBattingOrder();
			switchBattingTeam();
			return;
		} else {
			outs++;
			atBat.advanceBattingOrder();
		}

	}
	
	/** Get the outs
	 * @return - outs
	 */
	public int getCurrentOuts() {
		return outs;
	}

	//Switch the teams for batting
	private void switchBattingTeam() {
		if (atBat == home) {
			if (away.getScore() > home.getScore() && currentInning >= innings) {
				isOver = true;
				return;
			}

			atBat = away;
			currentInning++;
		} else {

			atBat = home;
		}
		field.clearBases();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Getter methods
	public Team getHomeTeam() {
		return home;
	}

	public Team getAwayTeam() {
		return away;
	}

	public Team getTeamAtBat() {
		return atBat;
	}
	
	public Field getField() {
		return field;
	}

	/** Add player to home team
	 * @param p - player getting added
	 */
	public void addPlayerToHomeTeam(Player p) {
		home.addPlayerToPlayingRoster(p);
	}

	/** Add player to away team
	 * @param p - the player getting added
	 */
	public void addPlayerToAwayTeam(Player p) {
		away.addPlayerToPlayingRoster(p);
	}

	/** Determine if game is over
	 * @return - boolean if game is over
	 */
	public boolean isGameOver() {
		if (currentInning >= innings && atBat == home) {
			if (home.getScore() > away.getScore()) {
				return true;
			}
		}
		return isOver;
	}

}
