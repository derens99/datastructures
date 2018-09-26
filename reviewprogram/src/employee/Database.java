/**
 * Deren Singh
 * 9/15/2016
 * This class has an arraylsit that holds all employees entered. It also sorts and
 * prints the array in tables based on each employee.
 */
package employee;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Database implements Serializable{
	
	private ArrayList<Employee> employees;//Arraylist of employees
	private final DecimalFormat format = new DecimalFormat("0.00");//Format doubles to have 2 decimals
	
	// Constructor to initalize employees arraylist
	public Database(){
		employees = new ArrayList<>();
	}
	
	/** Add an employee to the employees arraylist
	 * @param e - employee passed into array
	 */
	public void addEmployee(Employee e){
		employees.add(e);
	}
	
	//Insertion sort employees array by name
	public void sortEmployees(){
		int s = 0;
		for(int i = 0; i < employees.size()-1; i++){
			s = i;
			for(int j = i+1; j < employees.size(); j++){
				if(employees.get(j).getName().compareTo(employees.get(s).getName()) < 0){
					s = j;
				}
			}
			Employee temp = employees.get(i);
			employees.set(i, employees.get(s));
			employees.set(s, temp);
		}
	}
	
	/** Print out all salaried employees in a sorted string
	 * @return - a string of all salaried employees in a table
	 */
	public String getSalariedEmployees(){
		String output = "Salaried Employees: \n" + SalariedEmployee.getHeader();
		double total = 0;
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i) instanceof SalariedEmployee){
				total += ((SalariedEmployee)employees.get(i)).getSalary();
				output += employees.get(i).toString();
			}
		}
		output += "Total: $" + format.format(total) + "\n";
		return output;
	}
	
	/** Print out all commissioned employees in a sorted string
	 * @return - a string of all commissioned employees in a table
	 */
	public String getCommissionedEmployees(){
		String output = "Commissioned Employees: \n" + CommissionedEmployee.getHeader();
		double total = 0;
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i) instanceof CommissionedEmployee){
				total += ((CommissionedEmployee)employees.get(i)).getSalary();
				output += employees.get(i).toString();
			}
		}
		output += "Total: $" + format.format(total) + "\n";
		return output;
	}
	
	/** Print out all hourly employees in a sorted string
	 * @return - a string of all hourly employees in a table
	 */
	public String getHourlyEmployees(){
		String output = "Hourly Employees: \n" + HourlyEmployee.getHeader();
		double total = 0;
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i) instanceof HourlyEmployee){
				total += ((HourlyEmployee)employees.get(i)).getWeeklySalary();
				output += employees.get(i).toString();
			}
		}
		output += "Total: $" + format.format(total) + "\n";
		return output;
	}
	
	/** Print out all part time employees in a sorted string
	 * @return - a string of all part time employees in a table
	 */
	public String getPartTimeEmployees(){
		String output = "Part Time Employees: \n" + PartTimeEmployee.getHeader();
		double total = 0;
		for(int i = 0; i < employees.size(); i++){
			if(employees.get(i) instanceof PartTimeEmployee){
				total += ((PartTimeEmployee)employees.get(i)).getWeeklyWage();
				output += employees.get(i).toString();
			}
		}
		output += "Total: $" + format.format(total) + "\n";
		return output;
	}
	
	/** Print all employees in one method
	 * @return - a string full of all employees information
	 */
	public String printAll(){
		sortEmployees();
		return getSalariedEmployees() + "\n" + getCommissionedEmployees() + "\n" + 
	getHourlyEmployees() + "\n" + getPartTimeEmployees();
	}
	
	/** Get the employees arraylist
	 * @return - the employees arraylist
	 */
	public ArrayList<Employee> getEmployees(){
		return employees;
	}
	
}
