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
	private JButton add, preOrder, preOrderRec, inOrder, postOrder, levelOrder, printTree, reset;//Buttons
	private JTextArea outputArea;//Output Area
	private Tree<Integer> tree;//Binary tree
	
	//Constructor to make window
	public NumberGui(){
		numberLabel = addLabel("Number", 1, 1, 1, 1);
		numberField = addIntegerField(0, 1, 2, 1, 1);
		add = addButton("Add", 2, 1, 1, 1);
		preOrder = addButton("PreOrder", 2, 2, 1, 1);
		inOrder = addButton("InOrder", 2, 3, 1, 1);
		postOrder = addButton("PostOrder", 2, 4, 1, 1);
		levelOrder = addButton("Level Order", 2, 5, 1, 1);
		printTree = addButton("Print Tree", 2, 6, 1, 1);
		preOrderRec = addButton("PreOrder Recursion", 2, 7, 1, 1);
		reset = addButton("Reset", 3, 6, 1, 1);
		tree = new Tree<>();
		outputArea = addTextArea("", 3, 1, 5, 1);
		
		numberField.requestFocus();
		numberField.selectAll();
	}
	
	/** Method to handle buttons
	 * @button - button being pressed
	 */
	public void buttonClicked(JButton button) {
		if(button == add){
			if(tree.contains(numberField.getNumber())){
				messageBox("Number is already in tree!");
			}else{
				tree.add(numberField.getNumber());
			}
		}else if(button == preOrder){
			outputArea.setText(tree.preOrder(tree.getRoot()));
		}else if(button == inOrder){
			outputArea.setText(tree.inOrder(tree.getRoot()));
		}else if(button == postOrder){
			outputArea.setText(tree.postOrder(tree.getRoot()));
		}else if(button == levelOrder){
			outputArea.setText(tree.levelOrder(tree.getRoot()));
		}else if(button == printTree){
			outputArea.setText(tree.prettyPrintBinaryTree());
		}else if(button == preOrderRec){
			outputArea.setText(tree.preOrderRecursion(tree.getRoot()));
		}else{
			outputArea.setText("");
			numberField.setNumber(0);
			tree = new Tree<>();
		}
		numberField.requestFocus();
		numberField.selectAll();
	}
	
	//Main method
	public static void main(String[] args) {
		NumberGui gui = new NumberGui();
		gui.setSize(800, 600);
		gui.setVisible(true);
	}
	
}
