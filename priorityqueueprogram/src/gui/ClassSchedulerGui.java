/** Deren Singh - Ms. Stowe
 * This is the gui that handles the event scheduler section.
 * It creates a window and handles all button events.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;
import items.Date;
import items.Event;
import priorityqueue.PriorityQueueADT;

public class ClassSchedulerGui extends GBFrame{
	
	private JLabel month, day, year, name;//Labels
	private IntegerField monthField, dayField, yearField;//Date fields
	private JTextField nameField;//Name field
	private JButton add, remove;//Buttons
	
	private JTextArea outputArea;//Output area for schedules
	private PriorityQueueADT<Event> queue;//Queue using interface
	
	/** Constructor to set queue
	 * @param q - queue being passed in
	 */
	public ClassSchedulerGui(PriorityQueueADT<Event> q){
		queue = q;
		name = addLabel("Name", 1, 1, 1, 1);
		month = addLabel("Month", 2, 1, 1, 1);
		day = addLabel("Day", 3, 1, 1, 1);
		year = addLabel("Year", 4, 1, 1, 1);
		nameField = addTextField("", 1, 2, 1, 1);
		monthField = addIntegerField(1, 2, 2, 1, 1);
		dayField = addIntegerField(1, 3, 2, 1, 1);
		yearField = addIntegerField(1, 4, 2, 1, 1);
		
		outputArea = addTextArea("", 5, 1, 2, 1);
		
		add = addButton("Add", 1, 3, 1, 1);
		remove = addButton("Remove", 2, 3, 1, 1);
		
		outputArea.setText("No events.");
	}
	
	/* Handle button events
	 * @button - button being clicked
	 */
	public void buttonClicked(JButton button) {
		if(button == add){
			try{
				Date.validDate( monthField.getNumber(), dayField.getNumber(), yearField.getNumber());
				Event.validName(nameField.getText());
				queue.add(new Event(nameField.getText(), monthField.getNumber(), dayField.getNumber(), yearField.getNumber()));
			}catch(Exception e){
				messageBox(e.getMessage());
			}
		}else if(button == remove){
			queue.removeMin();
		}
		setOutput();
	}
	
	//Set the output area
	private void setOutput(){
		if(queue.isEmpty()){
			outputArea.setText("No events.");
		}else{
			outputArea.setText(queue.peekMin().toString());
		}
	}

	
}
