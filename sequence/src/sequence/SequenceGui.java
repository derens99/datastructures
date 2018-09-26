/**
 *Deren Singh
 *9/27/2016
 *This class is the gui of the program. It controls how the program will work. It has a database variable and two ArrayListWrapper variables to 
 *store numbers and sequences. 
 */
package sequence;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

import BreezySwing.DoubleField;
import BreezySwing.GBFrame;
import wrapper.ArrayListWrapper;

public class SequenceGui extends GBFrame {

	private JLabel inputLabel, outputLabel;// Label for the gui
	private DoubleField inputField;// Input the numberes

	private JList list;// List of numbers
	private DefaultListModel model;// List model
	private JButton input, change, delete, reset, exit, output;// Buttons for
																// the gui
	private JTextArea outputArea;// Output area to place sequences

	private Database database;// Database to solve sequences

	// Constructor to initialize variables and create window
	public SequenceGui() {
		inputLabel = addLabel("Input Number", 1, 1, 1, 1);
		outputLabel = addLabel("Output", 3, 1, 1, 1);
		inputField = addDoubleField(0.0, 1, 2, 1, 1);
		list = addList(2, 1, 2, 1);
		model = (DefaultListModel) list.getModel();
		input = addButton("Input", 1, 3, 1, 1);
		change = addButton("Change", 2, 3, 1, 1);
		delete = addButton("Delete", 3, 3, 1, 1);
		reset = addButton("Reset", 6, 3, 1, 1);
		exit = addButton("Exit", 7, 3, 1, 1);
		outputArea = addTextArea("", 5, 1, 2, 3);
		output = addButton("Output", 5, 3, 1, 1);
		inputField.selectAll();

		database = new Database();
	}

	/**
	 * Method to handle all button events
	 * 
	 * @button - the butting being clicked
	 */
	public void buttonClicked(JButton button) {
		if (button == input) {
			if(inputField.isValidNumber()==false){
				messageBox("Input was not a number!");
			}else{
				database.getNumbers().add(inputField.getNumber(), list.getSelectedIndex()+1);
			}
			inputField.requestFocus();
			inputField.setNumber(0.0);
			inputField.selectAll();
		} else if (button == change) {
			database.getNumbers().change(list.getSelectedIndex(), inputField.getNumber());
		} else if (button == delete) {
			database.getNumbers().delete(list.getSelectedIndex());
		} else if (button == output) {
			try {
				outputArea.setText(database.getLongestNonDecreasingSequences());
			} catch (IllegalArgumentException e) {
				messageBox(e.getMessage());
			}
		} else if (button == reset) {
			model.clear();
			database = new Database();
		} else {
			System.exit(0);
		}
		refreshList();
		database.getSequences().reinstantiate();
	}

	// Main method
	public static void main(String[] args) {
		SequenceGui gui = new SequenceGui();
		gui.setSize(600, 400);
		gui.setVisible(true);
	}

	public void refreshList() {
		ListIterator iterator = database.getNumbers().getArrayList().listIterator();
		model.clear();
		while (iterator.hasNext()) {
			model.addElement(iterator.next());
		}
		list.setSelectedIndex(model.getSize()-1);
	}
	


}
