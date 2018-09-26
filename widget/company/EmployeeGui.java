/*
 * Deren Singh
 * 9/20/15
 * This class creates the GUI of the program and handles all button events. It also enters
 * employee data and lets the user decide how the program runs.
 */

package company;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.DoubleField;
import BreezySwing.GBFrame;

public class EmployeeGui extends GBFrame{
	
	private JLabel nameLabel, q1Label, q2Label, q3Label, q4Label, searchLabel;//All are labels to each input field
	private JTextField nameField, searchField;//nameField - user enters employee name, searchfield - user enters employee's name to find employee information 
	private DoubleField q1Field, q2Field, q3Field, q4Field;//All quarter fields where the user enters each employees sales
	private JButton enter, highest, lowest, outputAll, search, reset;
	/*
	 * enter - the button to enter info about each employee
	 * highest - button to output the highest employee sale
	 * lowest - button to output the lowest employee sale
	 * outputAll - button to output all employees and their information
	 * search - button to search for employee in the search field
	 * reset - resets all data within the program
	 */
	private JTextArea outputArea;//The textbox where all the outputs are placed
	
	private Database database = new Database();//Database object to hold all the employees
	
	//Creates the window and adds its components aka the gui class constructor
	public EmployeeGui(){
		nameLabel = addLabel("Name", 1, 1, 1, 1);
		q1Label = addLabel("Quarter 1", 1, 2, 1, 1);
		q2Label = addLabel("Quarter 2", 1, 3, 1, 1);
		q3Label = addLabel("Quarter 3", 1, 4, 1, 1);
		q4Label = addLabel("Quarter 4", 1, 5, 1, 1);
		nameField = addTextField("", 2, 1, 1, 1);
		q1Field = addDoubleField(0.00, 2, 2, 1, 1);
		q2Field = addDoubleField(0.00, 2, 3, 1, 1);
		q3Field = addDoubleField(0.00, 2, 4, 1, 1);
		q4Field = addDoubleField(0.00, 2, 5, 1, 1);
		enter = addButton("Enter", 1, 6, 1, 1);
		highest = addButton("Highest", 2, 6, 1, 1);
		lowest = addButton("Lowest", 3, 6, 1, 1);
		outputAll = addButton("Output all", 4, 6, 1, 1);
		reset = addButton("Reset", 5, 6, 1, 1);
		outputArea = this.addTextArea("", 4, 1, 5, 1);
		searchLabel = this.addLabel("Search: ", 3, 1, 1, 1);
		searchField = this.addTextField("", 3, 2, 1, 1);
		search = this.addButton("Search", 3, 3, 2, 1);
		setButtons(false);
	}
	
	/*Handles all button events
	 * @param button - the button the user presses
	 */
	public void buttonClicked(JButton button){
		if(button == enter){
			if(database.getCount()>19){
				messageBox("Error. You have too many employees!");
			}else if(validFields()==false){
				messageBox("Error. You cannot have letters for \nquarterly sales.");
			}else if(validEmployee(new Employee(nameField.getText(), q1Field.getNumber(), q2Field.getNumber(), q3Field.getNumber(), q4Field.getNumber()))==false){
				messageBox("Error. You cannot have negative \nquarterly sales or a blank\nname!");
			}else{
				outputArea.setText("Employee Added!");
				database.enterEmployee(new Employee(nameField.getText(), q1Field.getNumber(), q2Field.getNumber(), q3Field.getNumber(), q4Field.getNumber()));
				setButtons(true);
			}
			
		}else if(button == highest){
			outputArea.setText("Highest: \n" + database.getHighestEmployees());
		}else if(button == lowest){
			outputArea.setText("Lowest: \n" + database.getLowestEmployees());
		}else if(button == search){
			if(database.getSearchedEmployee(searchField.getText()) == null){
				messageBox("[ERROR] EMPLOYEE DOES NOT EXIST");
			}else{
				outputArea.setText(database.getSearchedEmployee(searchField.getText()).toString());
			}
		}else if(button == outputAll){
			outputArea.setText("All Employees: \n" + database.getAllEmployees()+"\n");
		}else if(button == reset){
			database = new Database();
			clearFields();
			setButtons(false);
		}
	}
	//Main method
	public static void main(String[] args) {
		EmployeeGui gui = new EmployeeGui();
		gui.setSize(850, 500);
		gui.setVisible(true);
		gui.setTitle("Employee - By: Deren");
		gui.setLocationRelativeTo(null);
	}
	
	/*
	 * Checks if the employee has valid quarter sales
	 * @param Employee - checks the employees sales to see if they are above 0
	 * @return if the sales are above 0 or not
	 */
	private boolean validEmployee(Employee emp){
		return emp.validEmployee();
	}
	
	/*
	 * Checks if the user put a letter for a sale amount
	 * @return The boolean if a field is a letter or not
	 */
	private boolean validFields(){
		return  q1Field.isValidNumber() &&
				q2Field.isValidNumber() &&
				q3Field.isValidNumber() &&
				q4Field.isValidNumber();
	}
	
	/*
	 * Method to set the buttons enabled or disabled
	 */
	public void setButtons(boolean b){
		if(b == true){
			highest.setEnabled(true);
			lowest.setEnabled(true);
			search.setEnabled(true);
			outputAll.setEnabled(true);
		}else{
			outputArea.setEditable(false);
			highest.setEnabled(false);
			lowest.setEnabled(false);
			search.setEnabled(false);
			outputAll.setEnabled(false);
		}
	}
	
	/*
	 * Method to clear all fields when necessary
	 */
	public void clearFields(){
		nameField.setText("");
		q1Field.setNumber(0.0);
		q2Field.setNumber(0.0);
		q3Field.setNumber(0.0);
		q4Field.setNumber(0.0);
		outputArea.setText("");
	}

}
