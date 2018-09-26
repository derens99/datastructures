/*
 * Deren Singh
 * 9/20/15
 * This class stores an array of employees and outputs information based on comparing
 * employees to each other
 */

package company;

public class Database {
	
	private Employee[] company;//The array of employees
	private int count;//The number of employees entered into the array
	
	//Database constructor to set everything 
	public Database(){
		company = new Employee[20];
		count = 0;
	}
	
	/*
	 * This method enters an employee into the array
	 * @param Employee - The employee object put into the array
	 */
	public void enterEmployee(Employee e){
		company[count] = e;
		count++;
	}
	
	/*
	 * Makes a string of the employees with the highest sales and their name
	 * @return The string of the employee and their name 
	 */
	public String getHighestEmployees(){
		double high = company[0].getTotalSales();
		String str = "";
		for(int i = 0; i < count; i++){
			if(company[i].getTotalSales() > high){
				high = company[i].getTotalSales();
				str="";
				str="Name: "+company[i].getName()+" Total sales: $"+company[i].getTotalSales();
			}else if(company[i].getTotalSales() == high){
				str+="\nName: "+company[i].getName()+" Total sales: $"+company[i].getTotalSales();
			}
		}
		return str;
	}
	
	/*
	 * Finds the employee and writes their information onto a string
	 * @return the employee with the lowest sales and their name
	 */
	public String getLowestEmployees(){
		double low = company[0].getTotalSales();
		String str = "";
		for(int i = 0; i < count; i++){
			if(company[i].getTotalSales() < low){
				low = company[i].getTotalSales();
				str="";
				str="Name: "+company[i].getName()+" Total sales: $"+company[i].getTotalSales();
			}else if(company[i].getTotalSales() == low){
				str+="\nName: "+company[i].getName()+" Total sales: $"+company[i].getTotalSales();
			}
		}
		return str;
	}
	
	/*Outputs all the employees information
	 * @return A string filled with all the employees information
	 */
	public String getAllEmployees(){
		String str = "";
		for(int i = 0; i < count; i++){
			str+="\n"+company[i].toString();
			str+="\n";
		}
		return str;
	}
	
	/*
	 * Gets the employee the user searches for
	 * @param The name of the employee the user is searching for
	 * @return The employee that matches the entered name
	 */
	public Employee getSearchedEmployee(String name){
		for(int i = 0; i < count; i++){
			if(company[i].getName().equals(name)){
				return company[i];
			}
		}
		return null;
	}
	
	/*
	 * Gets the employee count
	 * @return the amount of employees entered
	 */
	public int getCount(){
		return count; 
	}
	
}
