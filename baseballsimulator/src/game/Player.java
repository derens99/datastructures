/**
 * Deren Singh. Ms. Stowe. This class is the player class. It keeps track of their name and stats.
 * It can also calculate their average.
 */
package game;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Player implements Comparable<Player>{
	
	private String name;//Player name
	private int walks, singles, doubles, triples, homeruns, outs, atBats;//Player stats
	
	/** Player constructor to set name and initialize variables
	 * @param n - player name
	 */
	public Player(String n){
		name = n;
		walks = singles = doubles = triples = homeruns = outs = atBats = 0;
	}
	
	//Get name
	public String getName(){
		return name;
	}
	
	//To string method
	public String toString(){
		return name + " : " + getStats() + "\n";
	}
	
	/** Get the players stats
	 * @return - player stats
	 */
	public String getStats(){
		DecimalFormat format = new DecimalFormat("0.000");
		format.setRoundingMode(RoundingMode.HALF_UP);
		String str = "";
		if(walks != 0){
			str += "Walks: " + walks + ", ";
		}if(singles != 0){
			str += "Singles: " + singles + ", ";
		}if(doubles != 0){
			str += "Doubles: " + doubles + ", ";
		}if(triples != 0){
			str += "Triples: " + triples + ", ";
		}if(homeruns != 0){
			str += "Homeruns: " + homeruns + ", ";
		}if(outs != 0){
			str += "Outs: " + outs + ", ";
		}
		
		return str + " | " + calculateHits() + "/" + atBats + " Average: " + format.format(calculateAverage());
	}
	
	
	/** Get the total amount of hits the player had
	 * @return - total player hits
	 */
	private int calculateHits(){
		return singles + doubles + triples + homeruns;
	}
	
	/** Get the player's average
	 * @return - player average
	 */
	private double calculateAverage(){
		if(atBats == 0){
			return 0;
		}else{
			return  ((double)calculateHits()) / ((double)atBats);
		}
		
	}
	
	/** Add to the players stats
	 * @param c - type of stat to account for
	 */
	public void addStat(char c){
		atBats++;
		switch(c){
		case 'w':
			walks++;
			break;
		case 's':
			singles++;
			break;
		case 'd':
			doubles++;
			break;
		case 't':
			triples++;
			break;
		case 'h':
			homeruns++;
			break;
		case 'o':
			outs++;
			break;
		}
	}

	//CompareTo method
	public int compareTo(Player p) {
		if(name.compareTo(p.getName()) == 0){
			return 0;
		}
		return -1;
	}
	
	
	/** Check if a player has a valid name
	 * @param first - player name
	 */
	public static void validPlayer(String first){
		if(first.equals("")){
			throw new IllegalArgumentException("Name is invalid!");
		}
		
	}
	
}
