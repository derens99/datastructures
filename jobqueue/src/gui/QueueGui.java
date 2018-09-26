/** Deren Singh. Ms. Stowe
 * This class is the gui. It holds all button events and controls the entire
 * programs flow.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;
import queue.QueueADT;

public class QueueGui extends GBFrame{
	
	private JLabel nameLabel, descLabel;//Labels
	private JTextField nameField, descField;//Name and description fields
	private JButton add, display, remove, toggle;//Buttons
	private JTextArea outputArea;//Output area to print information
	
	private QueueADT<Job> queue;//Queue being used
	
	//Constructor to set up window and instance variable
	public QueueGui(QueueADT<Job> q){
		nameLabel = addLabel("Name", 1, 1, 1, 1);
		descLabel = addLabel("Description", 2, 1, 1, 1);
		nameField = addTextField("", 1, 2, 1, 1);
		descField = addTextField("", 2, 2, 1, 1);
		add = addButton("Add", 1, 3, 1, 1);
		display = addButton("Display", 2, 3, 1, 1);
		remove = addButton("Remove", 1, 4, 1, 1);
		toggle = addButton("Toggle", 2, 4, 1, 1);
		outputArea = addTextArea("", 3, 1, 4, 1);
		queue = q;
	}
	
	/** Handle all button events
	 * @param button - which button is being clicked
	 */
	public void buttonClicked(JButton button) {
		if(button == add){
			try{
				Job.validJob(nameField.getText(), descField.getText());
				queue.enqueue(new Job(nameField.getText(), descField.getText()));
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}
			
		}else if(button == display){
			try{
				outputArea.setText(queue.toString());
			}catch(IllegalStateException e){
				messageBox(e.getMessage());
			}
		}else if(button == remove){
			try{
				outputArea.setText(queue.dequeue().toString());
				
			}catch(IllegalStateException e){
				messageBox(e.getMessage());
			}
		}else if(button == toggle){
			this.setVisible(false);
			StartGui gui = new StartGui(null);
			gui.setSize(300, 150);
			gui.setVisible(true);
			
		}
	}
	
	
}
