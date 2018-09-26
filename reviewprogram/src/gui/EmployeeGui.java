/**
 * Deren Singh
 * 9/15/2016
 * This class controls the entire program using a graphical user interface (gui). It has a button clicked method
 * to handle all button events and also has a main method to start the entire program. It also manages the files using FileManager.
 */
package gui;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.DoubleField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
import employee.*;
import file.FileManager;

public class EmployeeGui extends GBFrame implements Serializable{

	private JLabel nameLabel, idLabel, salaryLabel,saleLabel ,hoursLabel; // Labels to
																// indicate
																// fields
	private JTextField nameField, idField;// Name and ID field
	private DoubleField salaryField;// Salary field
	private IntegerField hoursField, salesField;// Hours worked or some employees
	private JTextArea outputArea;
	private JButton inputSalaried, inputCommissioned, inputHourly, inputPartTime, reset, exit, output; // Buttons
																										// for
																										// the
																										// gui
	private FileManager fileManager;//Class to manage files

	private Database database;// Database full of employees
	

	// Constructor to create gui window
	public EmployeeGui() {
		nameLabel = addLabel("Name", 1, 1, 1, 1);
		idLabel = addLabel("ID", 2, 1, 1, 1);
		salaryLabel = addLabel("Salary/Hourly Wage", 3, 1, 1, 1);
		hoursLabel = addLabel("Hours", 4, 1, 1, 1);
		saleLabel = addLabel("Sales", 5, 1, 1, 1);
		
		nameField = addTextField("", 1, 2, 1, 1);
		idField = addTextField("", 2, 2, 1, 1);
		salaryField = addDoubleField(0.0, 3, 2, 1, 1);
		hoursField = addIntegerField(0, 4, 2, 1, 1);
		salesField = addIntegerField(0, 5, 2, 1, 1);
		
		inputSalaried = addButton("Input Salaried", 1, 3, 1, 1);
		inputCommissioned = addButton("Input Commissioned", 2, 3, 1, 1);
		inputHourly = addButton("Input Hourly", 3, 3, 1, 1);
		inputPartTime = addButton("Input Part-Time", 4, 3, 1, 1);

		reset = addButton("Clear File", 6, 1, 1, 1);
		exit = addButton("Save & Exit", 6, 2, 1, 1);
		output = addButton("Output", 6, 3, 1, 1);
		
		outputArea = addTextArea("", 7, 1, 3, 1);
		fileManager = new FileManager();
		
		
		if(fileManager.getFile1().exists() == false){
			database = new Database();
			FileManager.write(null);
		}else{
			database = (Database) FileManager.getFile();
		}
	}

	/** Handle all button events
	 * @param button - the button getting clicked
	 */
	public void buttonClicked(JButton button) {
		if (button == inputSalaried) {
			try {
				Employee.validEmployee(nameField.getText(), idField.getText());
				SalariedEmployee.validSalariedEmployee(salaryField.getNumber());
				database.addEmployee(
						new SalariedEmployee(nameField.getText(), idField.getText(), salaryField.getNumber()));
			} catch (IllegalArgumentException e) {
				messageBox(e.getMessage());
			}
		} else if (button == inputCommissioned) {
			try {
				Employee.validEmployee(nameField.getText(), idField.getText());
				CommissionedEmployee.validCommissionedEmployee(salaryField.getNumber());
				database.addEmployee(new CommissionedEmployee(nameField.getText(), idField.getText(), salaryField.getNumber(), salesField.getNumber()));
			} catch (IllegalArgumentException e) {
				messageBox(e.getMessage());
			}
		}else if(button == inputHourly){
			try{
				Employee.validEmployee(nameField.getText(), idField.getText());
				HourlyEmployee.validHourlyEmployee(salaryField.getNumber(), hoursField.getNumber());
				database.addEmployee(new HourlyEmployee(nameField.getText(), idField.getText(), salaryField.getNumber(), hoursField.getNumber()));
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}
		}else if(button == inputPartTime){
			Employee.validEmployee(nameField.getText(), idField.getText());
			HourlyEmployee.validHourlyEmployee(salaryField.getNumber(), hoursField.getNumber());
			database.addEmployee(new PartTimeEmployee(nameField.getText(), idField.getText(), salaryField.getNumber(), hoursField.getNumber()));
		}else if(button == output){
			outputArea.setText(database.printAll());
		}else if(button == exit){
			FileManager.write(database);
			System.exit(0);
		}else if(button == reset){
			FileManager.clearFile();
			FileManager.write(null);
			database = new Database();
		}
	}

	// Main method to start gui
	public static void main(String[] args) {
		EmployeeGui gui = new EmployeeGui();
		gui.setSize(700, 500);
		gui.setVisible(true);
	}

}
