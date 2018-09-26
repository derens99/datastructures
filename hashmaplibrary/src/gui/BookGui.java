package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBDialog;
import hashmaplibrary.Book;
import hashmaplibrary.Library;

public class BookGui extends GBDialog {

	private JLabel title, isbn, author;// Labels
	private JTextField titleField, isbnField, authorField;// Text Fields
	private JButton add, cancel;// Buttons

	private Library library;// Referenced library object

	/**
	 * Constructor to initialize variables
	 * 
	 * @param arg0
	 *            - parent jframe
	 * @param l
	 *            - library object
	 */
	public BookGui(JFrame arg0, Library l) {
		super(arg0);
		title = addLabel("Title", 1, 1, 1, 1);
		isbn = addLabel("ISBN", 2, 1, 1, 1);
		author = addLabel("Author", 3, 1, 1, 1);
		titleField = addTextField("", 1, 2, 1, 1);
		isbnField = addTextField("", 2, 2, 1, 1);
		authorField = addTextField("", 3, 2, 1, 1);
		add = addButton("Add", 5, 1, 1, 1);
		cancel = addButton("Cancel or Exit", 5, 2, 1, 1);
		library = l;
	}

	/**
	 * Handle all button events
	 * 
	 * @param -
	 *            button being pressed
	 */
	public void buttonClicked(JButton button) {
		try {
			if (button == add) {
				library.addBook(new Book(titleField.getText(), authorField.getText(), isbnField.getText()),
						isbnField.getText());
				clearFields();
			} else if (button == cancel) {
				dispose();
			}
		} catch (Exception e) {
			messageBox(e.getMessage());
		}

	}

	private void clearFields() {
		titleField.setText("");
		isbnField.setText("");
		authorField.setText("");
		titleField.requestFocus();
		titleField.selectAll();
	}

}
