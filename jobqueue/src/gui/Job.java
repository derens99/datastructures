/** Deren Singh. Ms. Stowe
 * This class holds the information of a job. It has a name and 
 * a description. It can also validate a job as well.
 */
package gui;

public class Job {
	
	private String name, description;
	
	public Job(String n, String d){
		name = n;
		description = d;
	}
	
	public String toString(){
		return "Name: " + name + "\n" + "Description: " + description;
	}
	
	public static void validJob(String n, String d){
		if(n.equals("") || d.equals("")){
			throw new IllegalArgumentException("Name or description is invalid!");
		}
	}
	
}
