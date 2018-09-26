/**
 * Deren Singh. Ms. Stowe. The gui class creates a window and handles all button events. 
 * It also can convert a number from base 10 to base 2, or binary.
 */
package stack;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

public class StackGui extends GBFrame{
	
	private JLabel enterLabel, sizeLabel;//Labels
	private IntegerField enterField;//Decimal number getting converted
	private JTextField arraySize;//Size of the array
	private JButton listConvert, arrayConvert;//Button to choose how to stack the binary conversion
	private JTextArea area;//Output area
	
	//Constructor to create window
	public StackGui(){
		enterLabel = addLabel("Enter Number", 1, 1, 1, 1);
		sizeLabel = addLabel("Array Size", 2, 1, 1, 1);
		enterField = addIntegerField(0, 1, 2, 1, 1);
		arraySize = addTextField("", 2, 2, 1, 1);
		
		listConvert = addButton("LinkedList Convert", 1, 3, 1, 1);
		arrayConvert = addButton("Array Convert", 2, 3, 1, 1);
		area = addTextArea("", 3, 1, 1, 1);
	}
	
	/** Handle all button events
	 * @param button - the button being pressed
	 */
	public void buttonClicked(JButton button) {
		if(button == listConvert){
			try{
				ArrayStack.validArraySize(Integer.parseInt(arraySize.getText()));
				ArrayStack.validBinaryNumber(enterField.getNumber());
				convert(enterField.getNumber(), "", false);
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}
		}else if(button == arrayConvert){
			try{
				ArrayStack.validBinaryNumber(enterField.getNumber());
				convert(enterField.getNumber(), arraySize.getText(), true);
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}
		}
	}
	
	//Main method
	public static void main(String[] joshthehalls) {
		StackGui gui = new StackGui();
		gui.setSize(600, 400);
		gui.setVisible(true);
	}
	
	/** Convert a decimal number to binary
	 * @param x - the number getting converted
	 * @param size - size of static array
	 * @param b - boolean of whether to use the linkedlist stack or static array stack
	 */
	public void convert(int x, String size, boolean b){
		StackADT<Integer> stack;
		if(b){
			if(size.equals("")){
				stack = new ArrayStack<Integer>();
			}else{
				stack = new ArrayStack<Integer>(Integer.parseInt(size));
			}
		}else{
			stack = new LinkedListStack<>();
		}
		String answer = "";
		Integer q=1, r=0;
		while(q != 0){
			q = x / 2;
			r = x % 2;
			x = x / 2;
			stack.push(r);
			x = q;
		}
		while(stack.size() != 0){
			answer += stack.pop().toString();
		}
		area.setText(answer);
	}
	
	
}
