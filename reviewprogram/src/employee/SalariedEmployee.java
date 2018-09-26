/**
 * Deren Singh
 * 9/15/2016
 * This employee is also the child class of an employee. It stores the salary of an employee
 * and can check if a salaried employee is valid or not.
 */
package employee;

import java.io.Serializable;

public class SalariedEmployee extends Employee implements Serializable{
	
	private double salary;//Employee salary
	
	/** Salary employee constructor to initialize variables
	 * @param n - employee name
	 * @param c = employee 6 digit code
	 * @param sal - employee salary
	 */
	public SalariedEmployee(String n, String c, double sal) {
		super(n, c);
		salary = sal;
	}
	
	public static String getHeader(){
		return Employee.getHeader() + "\t\tSalary\n";
	}
	
	public String toString(){
		String output = "";
		output = super.toString() + "$"+format.format(salary) + "\n";
		return output;
	}
	
	/** Error check the employees salary
	 * @param s - the employees salary
	 */
	public static void validSalariedEmployee(double s){
		if(s <= 0){
			throw new IllegalArgumentException("Employee salary is invalid!");
		}
	}
	
	//Getter method
	public double getSalary(){
		return salary;
	}
	
}
