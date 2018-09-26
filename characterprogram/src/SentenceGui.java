/**
 * @author Deren Singh
 * 1/14/2016
 * This class is the gui of the sentence program. It takes the sentence and creates an object wit it 
 * to count the total characters and words. It then prints how many times a word shows up as well.
 */

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import BreezySwing.GBFrame;

public class SentenceGui extends GBFrame{
	
	private JTextArea inputArea, outputArea;//Area for input and output
	private JLabel inputLabel, outputLabel;//Labels for input and output
	private JButton enterSentence, reset;//buttons to enter and reset sentence
	
	private Sentence sentence;//the sentence entered
	
	//Constructor to create window
	public SentenceGui(){
		inputLabel = addLabel("Input", 1, 1, 1, 1);
		outputLabel = addLabel("Output", 1, 3, 1, 1);
		inputArea= addTextArea("", 2, 1, 1, 1);
		enterSentence= addButton("Count", 1, 2, 1, 1);
		outputArea = addTextArea("", 2, 3, 1, 1);
		reset = addButton("Reset", 2, 2, 1, 1);
	}
	
	/** Method to handle button events 
	 * @param button - the button pressed
	 */
	public void buttonClicked(JButton button){
		if(button == enterSentence){
			try{
				Sentence.validSentence(inputArea.getText());
				sentence = new Sentence(inputArea.getText());
				outputArea.setText(sentence.toString());
			}catch(IllegalStateException e){
				messageBox(e.getMessage());
			}
			
		}else{
			inputArea.setText("");
			outputArea.setText("");
		}
	}
	
	//Main method
	public static void main(String[] args) {
		SentenceGui gui = new SentenceGui();
		gui.setSize(800, 650);
		gui.setVisible(true);
	}

}
