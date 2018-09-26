/**
 * Deren Singh. Ms. Stowe. This class is the team class. It keeps track of
 * the players in the game with a circular linked list and keeps track of the
 * subs in a linear linked list
 */
package game;

import linkedlist.CircularLinkedList;
import linkedlist.LinkedList;

public class Team {

	private CircularLinkedList<Player> playingRoster;//Players who are in the atBat roster
	private LinkedList<Player> subs;//Substitutions list

	private String name;//Team name
	private int score;//Team score
	private Player previous;//previous hitter

	//Constructor to initialize instance variables
	public Team() {
		playingRoster = new CircularLinkedList<>();
		subs = new LinkedList<>();
		name = "";
		score = 0;
		previous = null;
	}

	/** Get the roster
	 * @return - the roster
	 */
	public String getEntireRoster() {
		try {
			subs.getFirst();
			return name + " Team - Playing Roster" + "\n" + playingRoster.printAll() + "\n" + "Substitution Roster" + "\n"
					+ subs.printAll();
		} catch (Exception e) {
				return name +" Team - Playing Roster" + "\n" + playingRoster.printAll() + "\n" + "Substitution Roster"
						+ "\n" + "No substitutions!";
		}

	}
	
	/** Substitute a player
	 * @param p - player getting subbed
	 */
	public void substituteHitter(Player p){
		subs.addLast(playingRoster.getCurrent().getValue());
		playingRoster.getCurrent().setValue(p);
	}

	/** Add  player to playing roster
	 * @param p - player getting added
	 */
	public void addPlayerToPlayingRoster(Player p) {
		playingRoster.addLast(p);
	}

	/** Add Player to sub roster
	 * @param - player added to substitute roster
	 */
	public void addPlayerToSubstitutionsRoster(Player p) {
		subs.addLast(p);
	}
	
	//Getter and setter methods
	public LinkedList<Player> getSubstitutionsRoster(){
		return subs;
	}
	
	public CircularLinkedList<Player> getPlayingRoster() {
		return playingRoster;
	}

	public void setScore(int s) {
		score = s;
	}

	public int getScore() {
		return score;
	}

	public void addToScore(int s) {
		score += s;
	}

	public Player getPlayerAtBat() {
		return playingRoster.getCurrent().getValue();
	}

	public void advanceBattingOrder() {
		previous = playingRoster.getCurrent().getValue();
		playingRoster.getNext();
	}

	public Player getPreviousBatter() {
		return previous;
	}

	public void setName(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}
	
}
