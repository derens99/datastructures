/**
 * Deren Singh
 * 9/15/2016
 * This class is a child class of the employee class. It has an hourly wage along with the hours worked per week. 
 * It can calculate the weekly salary of an employee and check an hourly employees validity.
 */
package employee;

import java.io.Serializable;

public class HourlyEmployee extends Employee implements Serializable {

	private double hourlyWage;// Employees hourly wage
	private int hoursWorked;// Hours employee works per week

	/**
	 * Hourly Employee constructor
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
	public HourlyEmployee(String n, String i, double w, int h) {
		super(n, i);
		hourlyWage = w;
		hoursWorked = h;
	}

	/**
	 * Validate an hourly employees data
	 * 
	 * @param wage
	 *            - hourly employees wage
	 * @param hours
	 *            - hourly employees hours
	 */
	public static void validHourlyEmployee(double wage, int hours) {
		if (wage <= 0 || hours <= 0) {
			throw new IllegalArgumentException("Hourly Employee wage or hours is negative!");
		}
	}

	/** Get the hourly employee header
	 * @return - the hourly employee header
	 */
	public static String getHeader() {
		return Employee.getHeader() + "\t\tHourly Wage\t\tHours Worked\t\tWeekly Salary\n";
	}
	
	//Tostring method
	public String toString() {
		String output = "";
		output = super.toString() + "$" + format.format(hourlyWage) + "\t\t\t" + hoursWorked + "\t\t\t" + "$"
				+ format.format(getWeeklySalary()) + "\n";
		return output;
	}

	// Getter methods
	public double getHourlyWage() {
		return hourlyWage;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	/** Get the weekly salary for the hourly employee
	 * @return - the weekly salary
	 */
	public double getWeeklySalary() {
		if (hoursWorked > 40) {
			return (40 * hourlyWage) + ((hoursWorked - 40) * (1.5 * hourlyWage));
		} else {
			return hourlyWage * hoursWorked;
		}
	}

}
