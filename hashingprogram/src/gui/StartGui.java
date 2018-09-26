package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

import BreezySwing.GBDialog;
import hash.*;

public class StartGui extends GBDialog{

	private JButton linear, quadratic, rehash, bucket, list;//Buttons for which type of hash
	
	//Default Constructor
	public StartGui(JFrame arg0) {
		super(arg0);
		linear = addButton("Linear", 1, 1, 1, 1);
		quadratic = addButton("Quadratic", 1, 2, 1, 1);
		rehash = addButton("Rehash", 1, 3, 1, 1);
		bucket = addButton("Bucket", 1, 4, 1, 1);
		list = addButton("List", 1, 5, 1, 1);
	}
	
	/** Handle all button events
	 * @param button - the button being clicked
	 */
	public void buttonClicked(JButton button) {
		if(button == linear){
			createMainGui(new LinearHash());
		}else if(button == quadratic){
			createMainGui(new QuadraticHash());
		}else if(button == rehash){
			createMainGui(new ReHash());
		}else if(button == bucket){
			createMainGui(new BucketHash());
		}else if(button == list){
			createMainGui(new LinkedListHash());
		}
		dispose();
	}
	
	//Main method
	public static void main(String[] args) {
		createStartWindow();
	}
	
	//Create this menu
	public static void createStartWindow(){
		StartGui gui = new StartGui(null);
		gui.setSize(600, 400);
		gui.setVisible(true);
	}
	
	//Create
	public void createMainGui(HashADT hash){
		HashGui gui = new HashGui(hash);
		gui.setSize(800, 600);
		gui.setVisible(true);
	}
	
}
