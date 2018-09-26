/**
 * Deren Singh
 * 9/14/2016
 * This class is the parent class of all employees on the database. It holds their name 
 * and id and can also check whether an employee entered is valid or not.
 */
package employee;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Employee implements Serializable{
	
	private String name; //Employee name
	private String id; //6 digit code
	protected final DecimalFormat format = new DecimalFormat("0.00");//Format doubles to have 2 decimals
	
	/** Employee constructor to set instance variables
	 * @param n - employee name
	 * @param i - employee id
	 */
	public Employee(String n, String i){
		name = n;
		id = i;
	}
	
	/** Method to check if employee name or id is valid
	 * @param n - employee name getting checked
	 * @param i - employee id getting checked
	 */
	public static void validEmployee(String n, String i){
		if(n.equals("") || i.length() != 6){
			throw new IllegalArgumentException("Employee does not have name or ID \nis invalid!");
		}
	}
	
	
	/** Get the employee header
	 * @return - the header
	 */
	public static String getHeader(){
		return "Name\t\tID";
	}
	
	//Tostring method
	public String toString(){
		String output;
		output = name + "\t\t" + id + "\t\t";
		return output;
	}
	
	//Getter methods
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
