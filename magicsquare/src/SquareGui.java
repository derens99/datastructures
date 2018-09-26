/*
 * Deren Singh
 * 10/7/15
 * This class creates the GUI of the program. It handles all button events and it also 
 * enters the square size along with the square numbers within it
 */

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;


public class SquareGui extends GBFrame{
	
	private JLabel sizeLabel, enterLabel;//The labels to show what each fields enters
	private IntegerField sizeField, numberField;//sizeField - enters the size, numberField - enters the number into the array
	private JButton enterSize, enterNumber, reset;//Buttons to handle events
	private JTextArea outputArea;//The output area where all outputs go
	private Square square;//Square objects
	
	//Constructor to add components to window
	public SquareGui(){
		sizeLabel = addLabel("Enter Size", 2, 1, 1, 1);
		sizeField = addIntegerField(0, 2, 2, 1, 1);
		enterSize = addButton("Enter Size", 1, 4, 1, 1);
		enterLabel = addLabel("Enter Number", 3, 1, 1, 1);
		numberField = addIntegerField(0, 3, 2, 1, 1);
		enterNumber = addButton("Enter", 2, 4, 1, 1);
		outputArea = addTextArea("", 4, 1, 3, 1);
		reset = addButton("Reset", 4, 4, 1, 1);
		fieldState(false);
	}
	
	/* 
	 * This method handles all button events and actions
	 * button - the button the user presses
	 */
	public void buttonClicked(JButton button){
		if(button == enterSize){
			if(validSquareSize()==false || validFields()==false){

				messageBox("Invalid square size!");
			}else{
				square = new Square(sizeField.getNumber());
				fieldState(true);
				numberField.requestFocus();
				numberField.selectAll();
			}

		}else if(button == enterNumber){
			if(square.canEnter()){
				numberField.requestFocus();
				numberField.selectAll();
				square.enterNumber(numberField.getNumber());
			}else{
				square.enterNumber(numberField.getNumber());
				numberField.setEnabled(false);
				if(square.isMagicSquare()){
					outputArea.setText("The square is a \nMAGIC SQUARE!\nConstant - "+square.toString());
				}else{
					outputArea.setText("The square is not a magic square!");
				}
			}
		}else{
			sizeField.setNumber(0);
			numberField.setNumber(0);
			outputArea.setText("");
			fieldState(false);
			square = new Square(0);
		}
	}
	
	//Main method that creates the window
	public static void main(String[] args) {
		SquareGui gui = new SquareGui();
		gui.setSize(400, 300);
		gui.setVisible(true);
		gui.setTitle("Magic Square! - Deren");
	}
	
	/**
	 * @return a boolean if the square is a valid square size between 2 - 8
	 */
	private boolean validSquareSize(){
		return sizeField.getNumber() >= 2 && sizeField.getNumber() <= 8;
	}
	
	/**
	 * @param b - turns certain fields on and off with a boolean parameter
	 */
	private void fieldState(boolean b){
		enterNumber.setEnabled(b);
		numberField.setEnabled(b);
		reset.setEnabled(b);
		outputArea.setEditable(false);
	}
	
	/**
	 * @return a boolean of the fields for when they are not an integer
	 */
	private boolean validFields(){
		return sizeField.isValidNumber()||
				numberField.isValidNumber();
	}
	
}


