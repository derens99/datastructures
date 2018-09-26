/** Deren Singh - Ms. Stowe
 * This program allows a user to enter a book with its isbn and a library card with its cardnumber.
 * It uses hashmaps to store these values and the program can iterate through each map
 * and gather data from each one.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JTextArea;

import BreezySwing.GBFrame;
import file.FileManager;
import hashmaplibrary.Library;

public class LibraryGui extends GBFrame {

	private JButton addBook, issueCard, checkoutBook, returnBook;// Input gui
																	// buttons
	private JButton listTitles, listISBN, listPeople, listCardNumbers, listTakenBooks;// Output
																						// buttons
	private JButton saveExit, reset;// sav or reset buttons
	private JTextArea outputArea;// Output text area
	private Library library;// Library object

	// Default constructor
	public LibraryGui() {
		addBook = addButton("Add Book", 1, 1, 1, 1);
		issueCard = addButton("Issue Card", 2, 1, 1, 1);
		checkoutBook = addButton("Checkout Book", 3, 1, 1, 1);
		returnBook = addButton("Return Book", 4, 1, 1, 1);
		listTitles = addButton("List Titles", 1, 2, 1, 1);
		listISBN = addButton("List ISBN", 2, 2, 1, 1);
		listPeople = addButton("List People", 3, 2, 1, 1);
		listCardNumbers = addButton("List Card Numbers", 4, 2, 1, 1);
		listTakenBooks = addButton("List Taken Books", 1, 3, 1, 1);
		reset = addButton("Reset", 2, 3, 1, 1);
		saveExit = addButton("Save & Exit", 3, 3, 1, 1);
		outputArea = addTextArea("", 5, 1, 3, 2);

		if (FileManager.fileExists() == false) {
			library = new Library();
			FileManager.write(null);
		} else {
			library = (Library) FileManager.getFile();
		}

	}

	/**
	 * Handle all button events
	 * 
	 * @param -
	 *            button being pressed
	 */
	public void buttonClicked(JButton button) {
		try {
			if (button == addBook) {
				openBookGui();
			} else if (button == issueCard) {
				openLibraryCardGui();
			} else if (button == checkoutBook) {
				openCheckoutGui();
			} else if (button == returnBook) {
				openReturnGui();
			} else if (button == listTitles) {
				outputArea.setText(library.listAlphabetically());
			} else if (button == listISBN) {
				outputArea.setText(library.listISBNs());
			} else if (button == listPeople) {
				outputArea.setText(library.listNames());
			} else if (button == listCardNumbers) {
				outputArea.setText(library.listNumbers());
			} else if (button == listTakenBooks) {
				outputArea.setText(library.listLoanedBooks());
			} else if (button == reset) {
				FileManager.clearFile();
				library = new Library();
				outputArea.setText("");
			} else if (button == saveExit) {
				FileManager.write(library);
				System.exit(0);
			}
		} catch (Exception e) {
			messageBox(e.getMessage());
		}

	}

	// Main method
	public static void main(String[] args) {
		LibraryGui gui = new LibraryGui();
		gui.setSize(800, 600);
		gui.setVisible(true);
	}

	// Open a book gui
	private void openBookGui() {
		BookGui gui = new BookGui(null, library);
		gui.setSize(400, 300);
		gui.setVisible(true);
	}

	// Open library card gui
	private void openLibraryCardGui() {
		LibraryCardGui gui = new LibraryCardGui(null, library);
		gui.setSize(400, 300);
		gui.setVisible(true);
	}

	// Open checkout gui
	private void openCheckoutGui() {
		CheckOutGui gui = new CheckOutGui(null, library);
		gui.setSize(400, 300);
		gui.setVisible(true);
	}

	// Open book return gui
	private void openReturnGui() {
		ReturnGui gui = new ReturnGui(null, library);
		gui.setSize(400, 300);
		gui.setVisible(true);
	}

}
