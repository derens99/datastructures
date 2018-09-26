/*
 * Deren Singh
 * 9/20/15
 * This class stores the data of an employee and finds the employees total sales. It also can output
 * information about the employee
 */

package company;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import BreezySwing.Format;

public class Employee {
	private String name;//The name of the employee
	private double[] quarter;//An array of all quarter sales the employees have
	
	//Constructor to set instance variables to an initial amount
	public Employee(String nm, double q1, double q2, double q3, double q4){
		quarter = new double[4];
		name = nm;
		quarter[0] = q1;
		quarter[1] = q2;
		quarter[2] = q3;
		quarter[3] = q4;
	}
	
	/*
	 * Method to return the total sales an employee has
	 * @return The total sales the employee has in total of all quarters
	 */
	public double getTotalSales(){
		return (quarter[0]+quarter[1]+quarter[2]+quarter[3]);
	}
	
	/*
	 * Creates the header for the table of information
	 * @return a string made for the header of the employees data
	 */
	private String outputHeader(){
		String s = "";
		s += "Name: " + name + "\n";
		s += Format.justify('l', "Quarter 1", 15);
		s += Format.justify('l', "Quarter 2", 15);
		s += Format.justify('l', "Quarter 3", 15);
		s += Format.justify('l', "Quarter 4", 15);
		s += Format.justify('l', "Total Sales", 15);
		return s;
	} 
	
	/*
	 * Puts all the employee information into a table
	 * @return A string containing all the information in table form of an employee
	 */
	private String outputInfo(){
		DecimalFormat format = new DecimalFormat("0.00");
		format.setRoundingMode(RoundingMode.HALF_EVEN);
		String s = "";
		s += Format.justify('l', "$"+format.format(quarter[0]), 15);
		s += Format.justify('l', "$"+format.format(quarter[1]), 15);
		s += Format.justify('l', "$"+format.format(quarter[2]), 15);
		s += Format.justify('l', "$"+format.format(quarter[3]), 15);
		s += Format.justify('l', "$"+format.format(getTotalSales()), 15);
		return s;
	}
	
	/*
	 * Gets the name of the employee
	 * @return employee's name
	 */
	public String getName(){
		return name;
	}
	
	/*
	 * toString method to print out information about class
	 * @return an organized table of the employees data with name and all 4 quarters
	 */
	public String toString(){
		String str;
		str = Format.justify('l',outputHeader(), 100);
		str+="\n";
		str += Format.justify('l', outputInfo(), 85);
		return str;
	}
	
	public boolean validEmployee(){
		return quarter[0] >= 0 &&
			   quarter[1] >= 0 &&
			   quarter[2] >= 0 &&
			   quarter[3] >= 0 &&
			   !name.equals("");
	}
	
}
