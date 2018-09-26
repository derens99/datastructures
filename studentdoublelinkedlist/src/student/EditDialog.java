package student;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.DoubleField;
import BreezySwing.GBDialog;
import BreezySwing.IntegerField;
import doublelinkedlist.DoubleListNode;

public class EditDialog extends GBDialog{

	private JLabel firstName, lastName, yogLabel, gpaLabel;//Labels to indicate area to enter information
	private JTextField firstField, lastField;//First and last fields
	private IntegerField yogField;//Year of graduation field
	private DoubleField gpaField;//Gpa field
	
	private JButton add, close;//Buttons to add/change or close dialog
	
	private DoubleListNode<Student> editNode;//Temporary node to edit a current node
	private boolean edit;
	
	/** Constructor for dialog box
	 * @param arg0 - gbframe parent window
	 * @param s - student being edited
	 */
	public EditDialog(JFrame arg0, DoubleListNode<Student> s, boolean edit) {
		super(arg0);
		this.edit = edit;
		firstName = addLabel("First Name", 1, 1, 1, 1);
		lastName = addLabel("Last Name", 2, 1, 1, 1);
		yogLabel = addLabel("Year of Graduation", 3, 1, 1, 1);
		gpaLabel = addLabel("GPA", 4, 1, 1, 1);
		
		//add = addButton("Add", 5, 1, 1, 1);
		add = (!edit) ? addButton("Add", 5, 1, 1, 1) : addButton("Edit", 5, 1, 1, 1);
		close = addButton("Cancel", 5, 2, 1, 1);
		editNode = s;
		if(editNode == null){
			firstField = addTextField("", 1, 2, 1, 1);
			lastField = addTextField("", 2, 2, 1, 1);
			yogField = addIntegerField(0, 3, 2, 1, 1);
			gpaField = addDoubleField(0.0, 4, 2, 1, 1);
		}else{
			firstField = addTextField(s.getValue().getFirstName(), 1, 2, 1, 1);
			lastField = addTextField(s.getValue().getLastName(), 2, 2, 1, 1);
			yogField = addIntegerField(s.getValue().getYearOfGraduation(), 3, 2, 1, 1);
			gpaField = addDoubleField(s.getValue().getGPA(), 4, 2, 1, 1);
		}
		
		
		
	}
	
	/** Handle all button events on dialog box
	 * @param button - the buttn being pressed
	 */
	public void buttonClicked(JButton button) {
		if(button == add){
			if(edit == false){
				try{
					Student.validStudent(firstField.getText(), lastField.getText(), yogField.getNumber(),gpaField.getNumber());
					editNode.setValue(new Student(firstField.getText(), lastField.getText(), yogField.getNumber(),gpaField.getNumber()));
					StudentGui.students.addElement(new Student(firstField.getText(), lastField.getText(), yogField.getNumber(),gpaField.getNumber()));
					dispose();
				}catch(IllegalArgumentException e){
					messageBox(e.getMessage());
				}
			}else{
				Student.validStudent(firstField.getText(), lastField.getText(), yogField.getNumber(),gpaField.getNumber());
				editNode.setValue(new Student(firstField.getText(), lastField.getText(), yogField.getNumber(),gpaField.getNumber()));
				StudentGui.students.deleteCurrent();
				StudentGui.students.addElement(editNode.getValue());
				dispose();
			}
		}else if(button == close){
			dispose();
		}
	}
	

}
