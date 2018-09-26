/**
 * Deren Singh
 * 9/15/2016
 * This class is the child class of an employee. It also has an hourly wage and hours worked per week. 
 * It can calculate the weekly wage of a part time employee and also check the validity of a part time
 * employee.
 */
package employee;

import java.io.Serializable;

public class PartTimeEmployee extends Employee implements Serializable {

	private double hourlyWage;// Employees hourly wage
	private int hoursWorked;// Hours employee works per week

	/**
	 * Part Time Employee constructor
	 * 
	 * @param n
	 *            - employee name
	 * @param i
	 *            - employee id
	 * @param w
	 *            - employees hourly wage
	 * @param h
	 *            - hours worked per week
	 */
	public PartTimeEmployee(String n, String i, double w, int h) {
		super(n, i);
		hourlyWage = w;
		hoursWorked = h;
	}
	
	/** Get the weekly wage
	 * @return - the weekly wage for a part time employee
	 */
	public double getWeeklyWage(){
		return hourlyWage * hoursWorked;
	}

	/**
	 * Validate a part time employees data
	 * 
	 * @param wage
	 *            - part time employees wage
	 * @param hours
	 *            - part time employees hours
	 */
	public static void validPartTimeEmployee(double wage, int hours) {
		if (wage <= 0 || hours <= 0 || hours > 25) {
			throw new IllegalArgumentException(
					"Part time employee's wage is incorrect " + "or \n hours worked is negative or greater \nthan25");
		}
	}
	
	/** Part Time employee header
	 * @return - the part time employee header string
	 */
	public static String getHeader(){
		return Employee.getHeader() + "\t\tHourly Wage\t\tHours Worked\t\tWeekly Wage\n";
	}
	
	//Tostring method
	public String toString(){
		return super.toString() + "$" + format.format(hourlyWage) + "\t\t" + hoursWorked + "\t\t" + getWeeklyWage() +"\n";
	}

	// Getter methods
	public double getHourlyWage() {
		return hourlyWage;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

}
