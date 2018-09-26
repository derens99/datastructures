/** Deren Singh - Ms. Stowe
 * This gui comes up at the beginning. It allows the user to choose a class scheduler program 
 * or heart transplant program. They can also choose to use a random priority queue or sorted priority queue.
 */
package gui;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import BreezySwing.GBDialog;
import priorityqueue.PriorityQueueADT;
import priorityqueue.RandomPriorityQueue;
import priorityqueue.SortedPriorityQueue;

public class StartGui extends GBDialog{

	private JButton heartTransplant, classScheduler;//Buttons
	private JRadioButton random, sorted;//Radio buttons to select random or sorted
	private ButtonGroup group;//Group the radio buttons
	
	private PriorityQueueADT priorityQueue;//Which queue to use
	
	/** Special constructor
	 * @param frame - parent frame
	 */
	public StartGui(JFrame frame) {
		super(frame);
		heartTransplant = addButton("Heart Transplant", 1, 1, 1, 1);
		classScheduler = addButton("Class Scheduler", 1, 2, 1, 1);
		random = addRadioButton("Random Linked List", 2, 1, 1, 1);
		sorted = addRadioButton("Sorted Linked", 2, 2, 1, 1);
		group = new ButtonGroup();
		group.add(random);
		group.add(sorted);
		
		random.setSelected(true);
	}
	
	/* Button clicked method
	 * @button - which button being selected
	 */
	public void buttonClicked(JButton button) {
		if(random.isSelected()){
			priorityQueue = new RandomPriorityQueue<>();
		}else{
			priorityQueue = new SortedPriorityQueue<>();
		}
		if(button == heartTransplant){
			openHeartTransplantMenu(priorityQueue);
		}else if(button == classScheduler){
			openSchedulerMenu(priorityQueue);
		}
		
		
	}
	
	//Main method
	public static void main(String[] args) {
		StartGui gui = new StartGui(null);
		gui.setSize(350, 200);
		gui.setVisible(true);
	}
	
	/** Open the heart transplant gui
	 * @param p - the queue being selected
	 */
	private void openHeartTransplantMenu(PriorityQueueADT p){
		HeartTransplantGui gui = new HeartTransplantGui(p);
		gui.setSize(800, 600);
		gui.setVisible(true);
		this.dispose();
	}
	
	/** Open the event scheduler gui
	 * @param p - the queue being selected
	 */
	private void openSchedulerMenu(PriorityQueueADT p){
		ClassSchedulerGui gui = new ClassSchedulerGui(p);
		gui.setSize(800, 600);
		gui.setVisible(true);
		this.dispose();
	}

}
