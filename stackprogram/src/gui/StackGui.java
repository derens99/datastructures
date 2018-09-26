package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BreezySwing.GBFrame;
import stack.ArrayStack;
import stack.LinkedListStack;
import stack.StackADT;
import utils.Parser;

public class StackGui extends GBFrame {

	private JLabel equationLabel, outputLabel, size;
	private JTextField equationField, sizeField;
	private JButton listCalc, arrayCalc, clear;
	private JTextArea outputArea;

	private StackADT<String> stack;

	public StackGui() {
		equationLabel = addLabel("Enter Equation", 1, 1, 1, 1);
		equationField = addTextField("", 2, 1, 1, 1);
		outputArea = addTextArea("", 4, 1, 2, 1);
		listCalc = addButton("LinkedList Calculate", 1, 3, 1, 1);
		arrayCalc = addButton("Array Calculate", 1, 4, 1, 1);
		outputLabel = addLabel("Output", 3, 1, 1, 1);
		clear = addButton("Clear", 2, 3, 1, 1);
		size = addLabel("Size", 4, 3, 1, 1);
		sizeField = addTextField("", 4, 4, 1, 1);
	}

	public void buttonClicked(JButton button) {
		try {
			if (button == listCalc) {
				stack = new LinkedListStack<String>();
				outputArea.setText(Equation.getCalculation((equationField.getText()), stack)+"\n"+Equation.printPostfix(equationField.getText(), stack));
			} else if (button == arrayCalc) {
				if (sizeField.getText().equals("")) {
					stack = new ArrayStack<String>();
					outputArea.setText(Equation.getCalculation((equationField.getText()), stack)+"\n"+Equation.printPostfix(equationField.getText(), stack));
				} else {
					try {
						ArrayStack.validSize(Parser.parseInt(sizeField.getText()));
						stack = new ArrayStack<>(100);
						outputArea.setText(Equation.getCalculation((equationField.getText()), stack)+"\n"+Equation.printPostfix(equationField.getText(), stack));
					} catch (IllegalArgumentException e) {
						messageBox(e.getMessage());
					}
				}
				
			}else if(button == clear){
				equationField.setText("");
				outputArea.setText("");
			}
		}catch(Exception e){
			if(e.getMessage().equalsIgnoreCase("stack is empty")){
				messageBox("Error!");
			}else{
				messageBox(e.getMessage());
			}
		}
	}

	public static void main(String[] josh) {
		StackGui gui = new StackGui();
		gui.setSize(800, 600);
		gui.setVisible(true);
	}

}
