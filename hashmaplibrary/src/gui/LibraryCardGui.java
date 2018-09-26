package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBDialog;
import BreezySwing.IntegerField;
import hashmaplibrary.Library;
import hashmaplibrary.LibraryCard;

public class LibraryCardGui extends GBDialog{
	
	private JLabel numberLabel, name;//Labels
	private IntegerField numberField;//number field
	private JTextField nameField;//name field
	private JButton add, cancel;//buttons
	private Library library;//library object
	
	/** Constructor to initialize variables
	 * @param arg0 - parent jframe
	 * @param l - library object
	 */
	public LibraryCardGui(JFrame arg0, Library l) {
		super(arg0);
		numberLabel = addLabel("Card Number", 1, 1, 1, 1);
		name = addLabel("Name", 2, 1, 1, 1);
		numberField  = addIntegerField(0, 1, 2, 1, 1);
		nameField = addTextField("", 2, 2, 1, 1);
		add = addButton("Add", 3, 1, 1, 1);
		cancel = addButton("Cancel or Exit", 3, 2, 1, 1);
		library = l;
	}
	
	/** Handle all button events
	 * @param - button being pressed
	 */
	public void buttonClicked(JButton button) {
		try{
			if(button == add){
				library.addLibraryCard(new LibraryCard(numberField.getNumber(), nameField.getText()), numberField.getNumber());
				clearFields();
			}else if(button == cancel){
				dispose();
			}
		}catch(Exception e){
			messageBox(e.getMessage());
		}

	}
	
	private void clearFields(){
		numberField.setNumber(0);
		nameField.setText("");
		numberField.requestFocus();
	}

}
