/**
 * Deren Singh
 * 9/15/2016
 * This class is for a commissioned employee. It stores their salary and the number of sales they had.
 * It checks if a commissioned employee is also valid or not.
 */
package employee;

import java.io.Serializable;

public class CommissionedEmployee extends Employee implements Serializable{
	
	private double salary;//Commissioned employees salary
	private int sales;//Commissioned employees sales
	
	/** Commissioned employee constructor to set instance variables
	 * @param n - employee name
	 * @param c - employee id
	 * @param sal - employee salary
	 */
	public CommissionedEmployee(String n, String c, double sal, int sale) {
		super(n, c);
		salary = sal;
		sales = sale;
		salary = salary + (salary * (0.05*sales));
	}
	
	/** Error check the employees salary
	 * @param s - the employees salary
	 */
	public static void validCommissionedEmployee(double s){
		if(s <= 0){
			throw new IllegalArgumentException("Employee salary is invalid!");
		}
	}
	
	/** The commissioned employee header
	 * @return - commissioned header
	 */
	public static String getHeader(){
		return Employee.getHeader() + "\t\tSalary\t\tSales\n";
	}
	
	//Tostring
	public String toString(){
		return super.toString() +"$" +format.format(salary) +"\t\t"+sales+ "\n";
	}
	
	//Getter method
	public double getSalary(){
		return salary;
	}
	
}
