/**
 * Deren Singh
 * 10/12/2016
 * This class is the gui. It handles all button events, creates a window, and has the main method
 * to start the program, especially the gui.
 */
package student;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.DoubleField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
import linkedlist.LinkedList;

public class StudentGui extends GBFrame {

	private JLabel firstLabel, lastLabel, yogLabel, gpaLabel, outputLabel;//Gui labels
	private JTextField firstField, lastField;//String fields to enter name and yog
	private IntegerField yogField;
	private DoubleField gpaField;//Gpa field
	private JTextArea outputArea;//Place to output everything
	private JButton addFirst, addLast, getFirst, getLast, removeFirst, removeLast, printAll, deleteAll;//Buttons to control program flow
	private LinkedList<Student> students;//Linked list of Student objects
	
	//Constructor to create window and initalize variables
	public StudentGui() {
		firstLabel = addLabel("First Name", 1, 1, 1, 1);
		lastLabel = addLabel("Last Name", 2, 1, 1, 1);
		yogLabel = addLabel("Year of Graduation", 3, 1, 1, 1);
		gpaLabel = addLabel("GPA", 4, 1, 1, 1);
		firstField = addTextField("", 1, 2, 1, 1);
		lastField = addTextField("", 2, 2, 1, 1);
		yogField = addIntegerField(0, 3, 2, 1, 1);
		gpaField = addDoubleField(0.0, 4, 2, 1, 1);

		outputArea = addTextArea("", 6, 1, 2, 3);
		outputLabel = addLabel("Output", 5, 1, 1, 1);
		addFirst = addButton("Add First", 1, 3, 1, 1);
		addLast = addButton("Add Last", 2, 3, 1, 1);
		getFirst = addButton("Get First", 3, 3, 1, 1);
		getLast = addButton("Get Last", 4, 3, 1, 1);
		removeFirst = addButton("Remove First", 5, 3, 1, 1);
		removeLast = addButton("Remove Last", 6, 3, 1, 1);
		printAll = addButton("Print All", 7, 3, 1, 1);
		deleteAll = addButton("Delete All", 8, 3, 1, 1);
		students = new LinkedList<>();
	}
	
	/** Button clicked method to handle all button events
	 * button - the button getting clicked
	 */
	public void buttonClicked(JButton button) {
		if (button == addFirst) {
			try {
				Student.validStudent(firstField.getText(), lastField.getText(), yogField.getNumber(),
						gpaField.getNumber());
				students.addFirst(new Student(firstField.getText(), lastField.getText(), yogField.getNumber(),
						gpaField.getNumber()));
			} catch (IllegalArgumentException e) {
				messageBox(e.getMessage());
			}

		} else if (button == addLast) {
			try {
				Student.validStudent(firstField.getText(), lastField.getText(), yogField.getNumber(),
						gpaField.getNumber());
				students.addLast(new Student(firstField.getText(), lastField.getText(), yogField.getNumber(),
						gpaField.getNumber()));
			} catch (IllegalArgumentException e) {
				messageBox(e.getMessage());
			}
		} else if (button == getFirst) {
			try {
				outputArea.setText(students.getFirst().toString());
			} catch (IllegalStateException e) {
				messageBox(e.getMessage());
			}

		} else if (button == getLast) {
			try {
				outputArea.setText(students.getLast().toString());
			} catch (IllegalStateException e) {
				messageBox(e.getMessage());
			}

		} else if (button == removeFirst) {
			try {
				students.removeFirst();
			} catch (IllegalArgumentException e) {
				messageBox(e.getMessage());
			}

		} else if (button == removeLast) {
			try {
				students.removeLast();
			} catch (IllegalArgumentException e) {
				messageBox(e.getMessage());
			}

		} else if (button == printAll) {
			try {
				outputArea.setText(students.printAll());
			} catch (IllegalStateException e) {
				outputArea.setText("No students!");
			}

		} else if (button == deleteAll) {
			students.deleteAll();
			outputArea.setText("");
		}
	}
	
	//main method
	public static void main(String[] josh) {
		StudentGui gui = new StudentGui();
		gui.setSize(800, 600);
		gui.setVisible(true);
		gui.setTitle("Student Linked List Program");
	}

}
