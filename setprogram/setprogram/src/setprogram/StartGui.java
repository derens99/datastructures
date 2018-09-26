package setprogram;

import javax.swing.JButton;
import javax.swing.JFrame;

import BreezySwing.GBDialog;

public class StartGui extends GBDialog{
	
	private JButton arraySet, linkedListSet;
	
	public StartGui(JFrame arg0) {
		super(arg0);
		arraySet = addButton("Array Set", 1, 1, 1, 1);
		linkedListSet = addButton("LinkedList Set", 1, 2, 1, 1);
	}
	
	public void buttonClicked(JButton button) {
		if(button == arraySet){
			createWindow(true);
		}else{
			createWindow(false);
		}
	}
	
	public void createWindow(boolean b){
		SetGui gui = new SetGui(b);
		gui.setSize(800, 600);
		gui.setVisible(true); 
		dispose();
	}
	
	public static void main(String[] args) {
		createStartWindow();
	}
	
	public static void createStartWindow(){
		StartGui gui = new StartGui(null);
		gui.setSize(400, 300);
		gui.setVisible(true);
	}
	

}
