/**
 * This is the gui class. It creates a doubly linked list of students and can add, edit, delete and save to the list. 
 * It can also print the next and previous node.
 */
package student;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import BreezySwing.GBFrame;
import doublelinkedlist.DoubleLinkedList;
import doublelinkedlist.DoubleListNode;
import file.FileManager;

public class StudentGui extends GBFrame {

	public static DoubleLinkedList<Student> students;// List of students

	private JButton add, edit, delete, next, previous, saveAndExit, sort;//Window buttons
	private JTextArea outputArea;//Area to output current student information

	//Constructor to create window
	public StudentGui() {
		add = addButton("Add", 1, 1, 1, 1);
		edit = addButton("Edit", 1, 2, 1, 1);
		delete = addButton("Delete", 1, 3, 1, 1);
		saveAndExit = addButton("Save & Exit", 1, 4, 1, 1);
		outputArea = addTextArea("", 2, 1, 4, 1);
		next = addButton("Next", 3, 2, 1, 1);
		previous = addButton("Previous", 3, 1, 1, 1);
		sort = addButton("Toggle Sort", 3, 3, 1, 1);

		if (FileManager.fileExists() == false) {
			students = new DoubleLinkedList<>();
			FileManager.write(null);
			dialogSort();
			delete.setEnabled(false);
			edit.setEnabled(false);
			next.setEnabled(false);
			previous.setEnabled(false);
		} else {
			if (FileManager.getFile() == null) {
				students = new DoubleLinkedList<>();
				dialogSort();
				next.setEnabled(false);
				previous.setEnabled(false);
			} else {
				students = (DoubleLinkedList) FileManager.getFile();
				next.setEnabled(false);
				previous.setEnabled(false);
				if (students.isListEmpty() == false) {
					toggleButtons(true);
					dialogSort();
					students.rearrangeList();
					outputArea.setText(students.getCurrentListNode().getValue().toString());
					enableNextAndPrevious();
				}
			}
		}
		if(students.getCurrentListNode()==null){
			toggleButtons(false);
		}else{
			toggleButtons(true);
		}
	}
	
	/** Handle all button events on gbframe window
	 * @param button - button being pressed on window
	 */
	public void buttonClicked(JButton button) {
		if (button == add) {
			DoubleListNode<Student> dummy = new DoubleListNode<Student>(new Student("", "", 0, 0), null, null);
			EditDialog dialog = new EditDialog(this, dummy, false);
			dialog.setVisible(true);
			toggleButtons(true);
		} else if (button == edit) {
			DoubleListNode<Student> dummy = students.getCurrentListNode();
			EditDialog dialog = new EditDialog(this, dummy, true);
			dialog.setVisible(true);
			students.deleteCurrent();
			students.addElement(dummy.getValue());
		} else if (button == delete) {
			try{
				students.deleteCurrent();
			}catch(Exception e){
				messageBox(e.getMessage());
			}
		} else if (button == next) {
			students.getNext();
		} else if (button == previous) {
			students.getPrevious();
		} else if (button == saveAndExit) {
			FileManager.write(students);
			System.exit(0);
		} else if (button == sort) {
			Student.toggleSortByGpa();
			students.rearrangeList();
		}
		printCurrentStudent();
		if(students.getCurrentListNode()==null){
			toggleButtons(false);
		}else{
			toggleButtons(true);
		}
	}
	
	//Main method
	public static void main(String[] args) {
		StudentGui gui = new StudentGui();
		gui.setSize(1200, 800);
		gui.setVisible(true);
		gui.setTitle("Student Linked List Program");
	}
	
	//Display current student to output textbox
	private void printCurrentStudent() {
		if (students.isListEmpty()) {
			outputArea.setText("No students!");
			return;
		}
		outputArea.setText(students.getCurrentListNode().getValue().toString());
		enableNextAndPrevious();
	}
	
	//Determine when to enable and disable next/previous buttons
	private void enableNextAndPrevious() {
		next.setEnabled(students.canMoveNext());
		previous.setEnabled(students.canMovePrevious());
	}
	
	//Turn certain buttons on/off
	private void toggleButtons(boolean b) {
		delete.setEnabled(b);
		edit.setEnabled(b);
		sort.setEnabled(b);
	}
	
	//Special dialog box to sort by name or gpa
	private void dialogSort() {
		Object[] options = { "Name", "GPA" };
		int n = JOptionPane.showOptionDialog(null, "How do you want to sort Students?", "Sort option window",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == 0) {
			Student.sortByGPA = false;
		} else {
			Student.sortByGPA = true;
			students.rearrangeList();
		}
	}

}
