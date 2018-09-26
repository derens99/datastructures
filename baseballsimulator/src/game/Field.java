/**
 * Deren Singh. Ms. Stowe. This class is the field class. It keeps track of runs and 
 * base occupancy. It also registers all events that happen within a baseball game
 */
package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.UnicodeFont;

import gui.TeamCreator;

public class Field {

	private Player[] bases;//Bases of whether peopel are on them or not
	
	private UnicodeFont font;//Font

	//Constructor to initialize instance variables
	public Field() {
		bases = new Player[4];
		font = TeamCreator.getNewFont(font, "Arial", 30);
	}

	//Clear the bases such as an ending inning
	public void clearBases() {
		for (int i = 0; i < 4; i++) {
			bases[i] = null;
		}
	}

	/** Register the walk event 
	 * @param player - the player getting walked
	 * @return - amount of runs scored
	 */
	public int registerWalk(Player player) {
		int runs = 0;
		if(isBaseOccupied(3)){
			if(isBaseOccupied(2) && isBaseOccupied(1)){
				runs += moveBases(3,1);
			}
		}
		if(isBaseOccupied(2)){
			if(isBaseOccupied(1)){
				runs += moveBases(2,1);
			}
		}
		if(isBaseOccupied(1)){
			runs += moveBases(1,1);
		}
		setBase(1, player);
		return runs;
	}

	/** Register a single hit event
	 * @param player - the player who hit a single
	 * @return - amount of runs scored off of single
	 */
	public int registerSingle(Player player) {
		int runs = 0;
		if(isBaseOccupied(3)){
			runs += moveBases(3, 1);
		}
		if(isBaseOccupied(2)){
			runs+=moveBases(2,1);
		}
		if(isBaseOccupied(1)){
			runs += moveBases(1,1);
		}
		setBase(1, player);
		return runs;
	}
	
	/** Register a double hit event
	 * @param player - the player who hit a double
	 * @return - amount of runs scored off of double
	 */
	public int registerDouble(Player player) {
		int runs = 0;
		if(isBaseOccupied(3)){
			runs += moveBases(3, 2);
		}
		if(isBaseOccupied(2)){
			runs += moveBases(2, 2);
		}
		if(isBaseOccupied(1)){
			runs += moveBases(1, 2);
		}
		setBase(2, player);
		return runs;
	}
	
	/** Register a triple hit event
	 * @param player - the player who hit a triple
	 * @return - amount of runs scored off of triple
	 */
	public int registerTriple(Player player) {
		int runs = 0;
		if(isBaseOccupied(3)){
			runs += moveBases(3, 3);
		}
		if(isBaseOccupied(2)){
			runs += moveBases(2, 3);
		}
		if(isBaseOccupied(1)){
			runs += moveBases(1, 3);
		}
		setBase(3, player);
		return runs;
	}
	
	/** Register a homerun event
	 * @param player - the player who hit a homerun
	 * @return - amount of runs scored off of homerun
	 */
	public int registerHomerun(Player player) {
		int runs = 0;
		if(isBaseOccupied(3)){
			runs += moveBases(3, 4);
		}
		if(isBaseOccupied(2)){
			runs += moveBases(2, 4);
		}
		if(isBaseOccupied(1)){
			runs += moveBases(1, 4);
		}
		runs++;
		return runs;
	}
	
	/** Register an out event
	 * @param player - player who got out
	 * @return - return 0 since no runs scored off an out in this simulation
	 */
	public int registerOut(Player player){
		return 0;
	}
	
	/** Calculate runs scored off of where a player started and ended
	 * @param start - starting base
	 * @param end - ending base
	 * @return - amount of runs
	 */
	private int moveBases(int start, int end){
		int runs = 0;
		if((start+end) > 3){
			bases[0] = bases[start];
			bases[start] = null;
			runs++;
		}else{
			bases[start+end] = bases[start];
			bases[start] = null;
		}
		return runs;
	}
	
	/** Check if a base is occupied
	 * @param b - the base
	 * @return - boolean of whether the base has a player on it
	 */
	private boolean isBaseOccupied(int b){
		return bases[b] != null;
	}
	
	/** Set a player to a base
	 * @param base - the base getting a player placed on
	 * @param player - player getting put on a base
	 */
	private void setBase(int base, Player player){
		bases[base] = player;
	}
	
	//Render methods for play class
	public void renderFirstBase(Graphics g){
		if(isBaseOccupied(1)){
			g.fillOval(970, 360, 50, 50);
			g.setColor(Color.blue);
			g.drawString(bases[1].getName(), 970, 310);
		}
	}
	
	public void renderSecondBase(Graphics g){
		if(isBaseOccupied(2)){
			g.setColor(Color.blue);
			g.fillOval(595, 130, 50, 50);
			g.drawString(bases[2].getName(), 580, 80);
		}
	}
	
	public void renderThirdBase(Graphics g){
		if(isBaseOccupied(3)){
			g.setColor(Color.blue);
			g.fillOval(220, 360, 50, 50);
			g.drawString(bases[3].getName(), 200, 310);
		}
	}
	
	public void renderHitter(Graphics g, Player p){
		g.fillOval(595, 602, 50, 50);
		g.drawString(p.getName(), 595, 660);
	}

}
