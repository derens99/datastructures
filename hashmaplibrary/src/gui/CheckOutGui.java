package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBDialog;
import BreezySwing.IntegerField;
import hashmaplibrary.Library;

public class CheckOutGui extends GBDialog {

	private Library library;// Library object
	private JLabel isbnLabel, cardLabel;// Labels
	private JTextField isbnField;// Input text fields
	private IntegerField cardField;// Card number field
	private JButton checkOut, cancel;// Buttons

	/**
	 * Constructor to initialize variables
	 * 
	 * @param arg0
	 *            - parent jframe
	 * @param l
	 *            - library object
	 */
	public CheckOutGui(JFrame arg0, Library l) {
		super(arg0);
		library = l;
		isbnLabel = addLabel("ISBN", 1, 1, 1, 1);
		isbnField = addTextField("", 1, 2, 1, 1);
		cardLabel = addLabel("Card Number", 2, 1, 1, 1);
		cardField = addIntegerField(0, 2, 2, 1, 1);
		checkOut = addButton("Check Out", 4, 1, 1, 1);
		cancel = addButton("Cancel or Exit", 4, 2, 1, 1);
	}

	/**
	 * Handle all button events
	 * 
	 * @param -
	 *            button being pressed
	 */
	public void buttonClicked(JButton button) {
		try {
			if (button == checkOut) {
				library.checkOutBook(isbnField.getText(), cardField.getNumber());
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
		cardField.setText("");
		isbnField.requestFocus();
	}

}
