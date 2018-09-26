/** Deren Singh - Ms. Stowe
 * This is the gui that handles the heart transplant section.
 * It creates a window and handles all button events.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
import items.Patient;
import priorityqueue.PriorityQueueADT;
import queue.LinkedListQueue;

public class HeartTransplantGui extends GBFrame{
	
	private PriorityQueueADT<Patient> priorityQueue;//Queue
	private LinkedListQueue<Patient> deniedQueue;//Queue of people who denied
	
	private JLabel nameLabel, priorityLabel;//Labels
	private JTextField nameField;//Name field
	private IntegerField priorityField;//Heart priority
	
	private JTextArea outputArea;//Output area to print patient
	private JButton add, accept, deny;//Buttona
	
	/** Constructor to set queue
	 * @param q - queue being passed in
	 */
	public HeartTransplantGui(PriorityQueueADT<Patient> p){
		priorityQueue = p;
		deniedQueue = new LinkedListQueue<>();
		nameLabel = addLabel("Name", 1, 1, 1, 1);
		priorityLabel = addLabel("Priority", 2, 1, 1, 1);
		nameField = addTextField("", 1, 2, 1, 1);
		priorityField = addIntegerField(0, 2, 2, 1, 1);
		outputArea = addTextArea("", 3, 1, 2, 1);
		add = addButton("Add", 1, 3, 1, 1);
		accept = addButton("Accept", 2, 3, 1, 1);
		deny = addButton("Deny", 3, 3, 1, 1);
		outputArea.setText("No patients.");
	}
	
	/* Handle button events
	 * @button - button being clicked
	 */
	public void buttonClicked(JButton button) {
		if(button == add){
			try{
				Patient.validPatient(nameField.getText(), priorityField.getNumber());
				priorityQueue.add(new Patient(nameField.getText(), priorityField.getNumber()));
			}catch(IllegalArgumentException e){
				messageBox(e.getMessage());
			}
		}else if(button == accept){
			try{
				priorityQueue.removeMin();
				addDeniedPatients();
			}catch(Exception e){
				messageBox(e.getMessage());
			}
		}else if(button == deny){
			try{
				deniedQueue.enqueue(priorityQueue.removeMin());
			}catch(Exception e){
				messageBox(e.getMessage());
			}
		}
		setOutput();
	}
	
	//Set the output area
	private void setOutput(){
		if(priorityQueue.isEmpty()){
			outputArea.setText("No patients.");
		}else{
			outputArea.setText(priorityQueue.peekMin().toString());
		}
	}
	
	//Add denied patients back to queue once seomeone presses accept
	public void addDeniedPatients(){
		while(deniedQueue.isEmpty()==false){
			priorityQueue.add(deniedQueue.dequeue());
		}
	}
	
	
	
}
