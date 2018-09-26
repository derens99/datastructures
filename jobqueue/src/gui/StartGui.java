/** Deren Singh. Ms. Stowe
 * This class starts out asking the user if they want to make a queue
 * with a linked list or a static array.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BreezySwing.GBDialog;
import queue.ArrayQueue;
import queue.LinkedListQueue;
import queue.QueueADT;

public class StartGui extends GBDialog{
	
	private JLabel sizeLabel;//Size label
	private JTextField sizeField;//Size field
	private JButton listQueue, arrayQueue;//Buttons
	
	private QueueADT<Job> queue;//Which queue will be used
	
	//Constructor
	public StartGui(JFrame arg0) {
		super(arg0);
		sizeLabel = addLabel("Size", 1, 1, 1, 1);
		sizeField = addTextField("", 1, 2, 1, 1);
		listQueue = addButton("LinkedList Queue", 2, 1, 1, 1);
		arrayQueue = addButton("Array Queue", 2, 2, 1, 1);
	}
	
	/** Handle all button events
	 * @param button - which button is being clicked
	 */
	public void buttonClicked(JButton button) {
		if(button == listQueue){
			queue = new LinkedListQueue<>();
			initiateGui();
		}else if(button == arrayQueue){
			if(sizeField.getText().equals("")){
				queue = new ArrayQueue<>();
				initiateGui();
			}else{
				try{
					ArrayQueue.validSize(Parser.parseInt(sizeField.getText()));
					queue = new ArrayQueue<>(Parser.parseInt(sizeField.getText()));
					initiateGui();
				}catch(IllegalArgumentException e){
					messageBox(e.getMessage());
				}
			}
		}
	}
	
	//Main method
	public static void main(String[] args) {
		StartGui gui = new StartGui(null);
		gui.setSize(300, 150);
		gui.setVisible(true);
	}
	
	//Initiate the gui
	public void initiateGui(){
		QueueGui gui = new QueueGui(queue);
		gui.setSize(600, 400);
		gui.setVisible(true);
		this.dispose();
	}

}
