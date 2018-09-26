package setprogram;

import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;

public class SetGui extends GBFrame{
	
	private JLabel string1Label, string2Label;
	private JTextField inputField1, inputField2;
	private JButton frequency, common, union, uniqueLetters, remove, reset, enter;
	private JTextArea outputArea;
	
	private SetADT<Character> set1;
	private SetADT<Character> set2;
	
	private boolean type;
	
	public SetGui(boolean b) {
		string1Label = addLabel("Input 1", 1, 1, 1, 1);
		string2Label = addLabel("Input 2", 2, 1, 1, 1);
		
		inputField1 = addTextField("", 1, 2, 1, 1);
		inputField2 = addTextField("", 2, 2, 1, 1);
		
		frequency = addButton("Frequency", 5, 3, 1, 1);
		common = addButton("Common", 1, 3, 1, 1);
		uniqueLetters = addButton("Unique", 2, 3, 1, 1);
		remove = addButton("Remove", 3, 3, 1, 1);
		union = addButton("Union", 4, 3, 1, 1);
		reset = addButton("Reset", 6, 3, 1, 1);
				
		outputArea = addTextArea("", 3, 1, 2, 4);
		
		if(b == true){
			set1 = new ArraySet<>();
			set2 = new ArraySet<>();
		}else{
			set1 = new LinkedListSet<>();
			set2 = new LinkedListSet<>();
		}
		type = b;
		
	}
	
	public void buttonClicked(JButton button) {
		try{
			convertStringToSet(inputField1.getText(), set1);
			convertStringToSet(inputField2.getText(), set2);
			if(button == frequency){
				outputArea.setText(SetString.getFrequency(set1, inputField1.getText()));
			}else if(button == common){
				outputArea.setText(SetString.commonLetters(set1, set2));
			}else if(button == union){
				outputArea.setText(SetString.allLetters(set1, set2));
			}else if(button == uniqueLetters){
				outputArea.setText(SetString.uniqueLetters(set1, set2));
			}else if(button == remove){
				outputArea.setText(SetString.removeLetters(set1, set2));
			}else if(button == reset){
				/*resetSets();
				inputField1.setText("");
				inputField2.setText("");
				outputArea.setText("");
				System.out.println(set1.isEmpty());*/
				//StartGui.main(this);
				dispose();
				StartGui.createStartWindow();
			}
		}catch(Exception e){
			messageBox(e.getMessage());
		}
		System.out.println(set1.toString());
		System.out.println(set2.toString());
	}
	
	public void convertStringToSet(String s, SetADT<Character> set){
		for(char c: s.toCharArray()){
			set.add(c);
		}
	}
	
	private void resetSets(){
		if(type == true){
			set1 = new ArraySet<>();
			set2 = new ArraySet<>();
		}else{
			set1 = new LinkedListSet<>();
			set2 = new ArraySet<>();
		}
	}
	
}
