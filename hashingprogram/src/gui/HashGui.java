/** Deren Singh - ms. Stowe
 * This program has the user enter numbers and choose what kind of hash they want.
 * It will then output the keys and values of the hash table and allow
 * the user to search for a specific value in the table. 
 */
package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
import hash.HashADT;

public class HashGui extends GBFrame {

	private JLabel numberLabel;//Number label
	private IntegerField numberField;//Number input field
	private JTextArea outputArea;//Outputting area
	private JButton add, search, print, reset;//Buttons

	private HashADT hash;//Hash type

	//Default constructor
	public HashGui(HashADT a) {
		numberLabel = addLabel("Number", 1, 1, 1, 1);
		numberField = addIntegerField(0, 1, 2, 1, 1);

		outputArea = addTextArea("", 2, 1, 2, 1);
		add = addButton("Add", 1, 3, 1, 1);
		search = addButton("Search", 2, 3, 1, 1);
		print = addButton("Print", 3, 3, 1, 1);
		reset = addButton("Reset", 3, 1, 1, 1);

		hash = a;
		selectField();
		
		hash.add(5);
		hash.add(77);
		hash.add(22);
		hash.add(30);
		hash.add(16);
		hash.add(32);
		hash.add(60);
		hash.add(10);
		hash.add(18);
	}

	/** Handle all button events
	 * @param button - the button being clicked
	 */
	public void buttonClicked(JButton button) {
		try {
			if (button == add) {
				hash.add(numberField.getNumber());
			} else if (button == search) {
				outputArea.setText(hash.search(numberField.getNumber()));
			} else if (button == print) {
				outputArea.setText(hash.printAll());
			} else {
				dispose();
				StartGui.createStartWindow();
			}
		} catch (IllegalArgumentException e) {
			messageBox(e.getMessage());
		} catch (IllegalStateException e) {
			messageBox(e.getMessage());
		}
		selectField();
	}
	
	//Select the fields
	private void selectField() {
		numberField.requestFocus();
		numberField.selectAll();
	}

}
