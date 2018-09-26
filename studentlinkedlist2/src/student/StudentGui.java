/**
 * Deren Singh
 * 10/12/2016
 * This class is the gui. It handles all button events, creates a window, and has the main method
 * to start the program, especially the gui.
 */
package student;

import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.DoubleField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
import file.FileManager;
import linkedlist.LinkedList;

public class StudentGui extends GBFrame {

	private JLabel firstLabel, lastLabel, yogLabel, gpaLabel, outputLabel;//Gui labels
	private JTextField firstField, lastField;//String fields to enter name and yog
	private IntegerField yogField;
	private DoubleField gpaField;//Gpa field
	private JTextArea outputArea;//Place to output everything
	private JButton addSort, deleteAll, displayList, displayListWithIterator, saveAndExit, search, edit, delete;//Buttons to control program flow
	private LinkedList<Student> students;//Linked list of Student objects
	
	//Stuff for editing
	private JLabel firstLabel2, lastLabel2, yogLabel2, gpaLabel2, searchLabel;
	private JTextField firstField2, lastField2;
	private IntegerField yogField2;
	private DoubleField gpaField2;
	
	//Constructor to create window and initialize variables
	public StudentGui() {
		firstLabel = addLabel("First Name", 1, 1, 1, 1);
		lastLabel = addLabel("Last Name", 2, 1, 1, 1);
		yogLabel = addLabel("Year of Graduation", 3, 1, 1, 1);
		gpaLabel = addLabel("GPA", 4, 1, 1, 1);
		firstField = addTextField("", 1, 2, 1, 1);
		lastField = addTextField("", 2, 2, 1, 1);
		yogField = addIntegerField(0, 3, 2, 1, 1);
		gpaField = addDoubleField(0.0, 4, 2, 1, 1);

		outputArea = addTextArea("", 6, 1, 4, 3);
		outputLabel = addLabel("Output", 5, 1, 1, 1);
		
		addSort = addButton("Add Sort", 1, 3, 1, 1);
		displayList = addButton("Display List", 2, 3, 1, 1);
		displayListWithIterator = addButton("Display List With Iterator", 3, 3, 1, 1);
		deleteAll = addButton("Delete All", 4, 3, 1, 1);
		saveAndExit = addButton("Save & Exit", 5, 3, 1, 1);
		search = addButton("Search", 1, 4, 1, 1);
		edit = addButton("Edit", 2, 4, 1, 1);
		delete = addButton("Delete", 3, 4, 1, 1);
		
		searchLabel = addLabel("Search & Edit", 1, 5, 1, 1);
		firstLabel2 = addLabel("First Name", 1, 6, 1, 1);
		lastLabel2 = addLabel("Last Name", 2, 6, 1, 1);
		yogLabel2 = addLabel("Year of Graduation", 3, 6, 1, 1);
		gpaLabel2 = addLabel("GPA", 4, 6, 1, 1);
		
		firstField2 = addTextField("", 1, 7, 1, 1);
		lastField2 = addTextField("", 2, 7, 1, 1);
		yogField2 = addIntegerField(0, 3, 7, 1, 1);
		gpaField2 = addDoubleField(0.0, 4, 7, 1, 1);
		
		if(FileManager.fileExists()==false){
			students = new LinkedList<>();
			FileManager.write(null);
		}else{
			if(FileManager.getFile() == null){
				students = new LinkedList<>();
			}else{
				students = (LinkedList) FileManager.getFile();
			}
		}
	}
	
	/** Button clicked method to handle all button events
	 * button - the button getting clicked
	 */
	public void buttonClicked(JButton button) {
		if(button == addSort){
			try{
				Student.validStudent(firstField.getText(), lastField.getText(), yogField.getNumber(), gpaField.getNumber());
				students.addAlphabetically(new Student(firstField.getText(), lastField.getText(), yogField.getNumber(), gpaField.getNumber()));
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}
		}else if(button == displayList){
			try{
				outputArea.setText(students.printAll());
			}catch(IllegalStateException e){
				outputArea.setText("");
				messageBox(e.getMessage());
			}
		}else if(button == displayListWithIterator){
			try{
				displayListWithIterator();
			}catch(IllegalStateException e){
				outputArea.setText("");
				messageBox(e.getMessage());
			}
			
		}else if (button == deleteAll) {
			students.deleteAll();
			outputArea.setText("");
		}else if(button == saveAndExit){
			FileManager.write(students);
			System.exit(0);
		}else if(button == search){
			try{
				outputArea.setText(students.search(new Student(firstField.getText(), lastField.getText(), 0, 0)).toString());
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}
		}else if(button == edit){
			try{
				editStudent(new Student(firstField.getText(), lastField.getText(), yogField.getNumber(), gpaField.getNumber()), new Student(firstField2.getText(), lastField2.getText(), yogField2.getNumber(), gpaField2.getNumber()));
				outputArea.setText(students.printAll());
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}catch(IllegalStateException e){
				messageBox(e.getMessage());
			}
		}else if(button == delete){
			try{
				removeElement(new Student(firstField.getText(), lastField.getText(), 0, 0));
			}catch(IllegalArgumentException e){
				outputArea.setText("");
				 messageBox(e.getMessage());
			}
		}
	}
	
	//main method
	public static void main(String[] josh) {
		StudentGui gui = new StudentGui();
		gui.setSize(1200, 800);
		gui.setVisible(true);
		gui.setTitle("Student Linked List Program");
	}
	
	//Print the students using an iterator
	private void displayListWithIterator(){
		Iterator<Student> iterator = students.iterator();
		String str = "";
		while(iterator.hasNext()){
			str += iterator.next().toString() + "\n";
		}
		outputArea.setText(str);
	}
	
	//Remove a student
	//@param s - the student being removed
	private void removeElement(Student s){
		Iterator<Student> iterator = students.iterator();
			while(iterator.hasNext()){
				if(iterator.next().compareTo(s)==0){
					iterator.remove();
					return;
				}
		}
		throw new IllegalArgumentException("Element not found in linked list!");
	}
	
	private void editStudent(Student target, Student edit){
		removeElement(target);
		students.addAlphabetically(edit);
	}

}
