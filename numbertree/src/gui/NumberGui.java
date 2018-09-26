/** Deren Singh - Ms. Stowe
 * This class is the gui which creates a window and handles buttons. It uses
 * a binary search tree to add elements and search for elements.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
import binarytree.Tree;

public class NumberGui extends GBFrame{
	
	private JLabel numberLabel;//Labels
	private IntegerField numberField;//Number field
	private JButton add, search, searchRecursion, reset;//Buttons
	private JTextArea outputArea;//Output Area
	private Tree<Integer> tree;//Binary tree
	
	//Constructor to make window
	public NumberGui(){
		numberLabel = addLabel("Number", 1, 1, 1, 1);
		numberField = addIntegerField(0, 1, 2, 1, 1);
		add = addButton("Add", 2, 1, 1, 1);
		search = addButton("Search", 2, 2, 1, 1);
		searchRecursion = addButton("Search Recursion", 2, 3, 1, 1);
		reset = addButton("Reset", 3, 3, 1, 1);
		tree = new Tree<>();
		outputArea = addTextArea("", 3, 1, 2, 1);
		
		numberField.requestFocus();
		numberField.selectAll();
	}
	
	/** Method to handle buttons
	 * @button - button being pressed
	 */
	public void buttonClicked(JButton button) {
		if(button == add){
			if(tree.contains(numberField.getNumber())){
				messageBox("Number is already in tree.");
			}else{
				tree.add(numberField.getNumber());
				numberField.requestFocus();
				numberField.selectAll();
			}
		}else if(button == search){
			outputArea.setText(tree.printSearchPath(numberField.getNumber(), tree.getRoot()) + "\nContains: "+tree.contains(numberField.getNumber()));
		}else if(button == searchRecursion){
			outputArea.setText(tree.printSearchPath(numberField.getNumber(), tree.getRoot()) + "\nContains: "+tree.contains(numberField.getNumber(), tree.getRoot()));
		}else{
			outputArea.setText("");
			numberField.setNumber(0);
			tree = new Tree<>();
		}
	}
	
	//Main method
	public static void main(String[] args) {
		NumberGui gui = new NumberGui();
		gui.setSize(600, 400);
		gui.setVisible(true);
	}
	
}
