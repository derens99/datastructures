package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBDialog;
import BreezySwing.IntegerField;
import hashmaplibrary.Library;

public class ReturnGui extends GBDialog {

	private Library library;// Referenced library object
	private JLabel isbnLabel, cardLabel;// Labels for indication
	private JTextField isbnField;// Text input field
	private IntegerField cardField;// Number field
	private JButton returnBook, cancel;// Buttons

	/**
	 * Constructor to initialize variables
	 * 
	 * @param arg0
	 *            - parent jframe
	 * @param l
	 *            - library object
	 */
	public ReturnGui(JFrame arg0, Library l) {
		super(arg0);
		library = l;
		isbnLabel = addLabel("ISBN", 1, 1, 1, 1);
		isbnField = addTextField("", 1, 2, 1, 1);
		cardLabel = addLabel("Card", 2, 1, 1, 1);
		cardField = addIntegerField(0, 2, 2, 1, 1);

		returnBook = addButton("Return Book", 3, 1, 1, 1);
		cancel = addButton("Cancel or Exit", 3, 2, 1, 1);
	}

	/**
	 * Handle all button events
	 * 
	 * @param -
	 *            button being pressed
	 */
	public void buttonClicked(JButton button) {

		try {
			if (button == returnBook) {
				library.returnBook(isbnField.getText(), cardField.getNumber());
				clearFields();
			} else if (button == cancel) {
				dispose();
			}
		} catch (Exception e) {
			messageBox(e.getMessage());
		}
		
		
	}

	private void clearFields() {
		isbnField.setText("");
		cardField.setNumber(0);
		isbnField.requestFocus();
	}

}
