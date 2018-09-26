/** Deren Singh - Ms. Stowe
 * This is the gui. It handles all button events for the window it creates. It makes a 
 * heap tree object that can hold data and be sorted by using a heap sort.
 */
package heap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

public class NumberGui extends GBFrame{
	
	private JLabel numberLabel;//label
	private IntegerField numberField;//Number input field
	private JButton add, print, reset;//Buttons
	private JTextArea outputArea;//Output area
	
	private HeapTree<Integer> heapTree;//Heap tree
	
	//Default constructor to initialize/instantiate variables
	public NumberGui(){
		numberLabel = addLabel("Number", 1, 1, 1, 1);
		numberField = addIntegerField(0, 1, 2, 1, 1);
		add = addButton("Add", 1, 3, 1, 1);
		print = addButton("Print", 2, 3, 1, 1);
		reset = addButton("Reset", 3, 3, 1, 1);
		outputArea = addTextArea("", 2, 1, 1, 1);
		
		heapTree = new HeapTree<>();
		selectFields();
	}
	
	/** Button clicked method to handle all button events
	 * @param button - the button being clicked
	 */
	public void buttonClicked(JButton button) {
		if(button == add){
			heapTree.add(new Integer(numberField.getNumber()));
			selectFields();
		}else if(button == print){
			outputArea.setText(heapTree.toString());
		}else if(button == reset){
			heapTree = new HeapTree<>();
			outputArea.setText("");
			numberField.setNumber(0);
			selectFields();
		}
	}
	
	//Highlight the nubmer field for easier use
	private void selectFields(){
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
