package gui;

import java.util.ArrayList;

import stack.ArrayStack;
import stack.StackADT;
import utils.Parser;

public class Equation {

	private double calculate(int x, int y, Character o){
		if(o == '+'){
			return y+x;
		}
		if(o == '-'){
			return y-x;
		}
		if(o == '*'){
			return y * x;
		}
		if(o == '/'){
			return y / x;
		}
		if(o == '^'){
			return Math.pow(x, y);
		}
		if(o == '%'){
			return y % x;
		}
		throw new IllegalArgumentException("Operator not found!");
	}
	
	public static  ArrayList<String> tokenize(String infix){
		boolean pOperator = false;
		infix = infix.trim();
		ArrayList<String> tokens = new ArrayList<String>();
		int indexStart = 0;
		int index = 0;
		pOperator = true;
		while(index<infix.length()){
			Character currentChar = infix.charAt(index);
			if(isOperator(currentChar.toString().charAt(0))){ //If Operator
				if(indexStart!=index){
					tokens.add(infix.substring(indexStart, index));
				}
				if(currentChar == '-'&&pOperator){
					indexStart = index;	
					pOperator = false;
				}else{
					tokens.add(infix.substring(index,index+1));	 
					indexStart = index+1;
					pOperator = true;
				}
			}else if(isDelim(currentChar)){//If parenthesis
				if(indexStart!=index){
					tokens.add(infix.substring(indexStart, index));
				}
				tokens.add(infix.substring(index,index+1));	 
				indexStart = index+1;
			}else if(currentChar == ' '){ //If space
				if(indexStart!=index){
					tokens.add(infix.substring(indexStart, index));
				}
				indexStart = index+1;
			}else{
				pOperator = false;
			}
			
			index++;
		}
		if(indexStart!=index){
			tokens.add(infix.substring(indexStart,index));
		}
		return tokens;
	}	
	
	private static String getResult(ArrayList<String> postfix,StackADT<String> stack){
		String result = "";
		
		while(postfix.size()>0){
			String current = postfix.get(0);
			postfix.remove(0);
			if(isNumber(current)){
				stack.push(current);
			}else if(isOperator(current)){
				
				int x = Parser.parseInt(stack.pop());
				int y = Parser.parseInt(stack.pop());
				
				stack.push(calculate(y,x,current)+"");
			}
		}
		if(stack.isEmpty())
			throw new IllegalArgumentException("Invalid Number");
		result = stack.pop();
		
		return result;
	}
	
	public static String getCalculation(String infix,StackADT<String> stack){
		ArrayList<String> tExpression = tokenize(infix);
		checkInput(tExpression);
		ArrayList<String> postfix = getPostfix(tExpression,stack);
		System.out.println();
		return getResult(postfix,stack);
	}
	
	public static String printPostfix(String infix,StackADT<String> stack){
		ArrayList<String> tExpression = tokenize(infix);
		ArrayList<String> postfix = getPostfix(tExpression,stack);
		String str = "";
		for(String s: postfix){
			str += s + " ";
		}
		return str;
	}
	
	private static void checkInput(ArrayList<String> check){
		for(int i = 0; i < check.size();i++){
			if(i < check.size()-1){
				if(check.get(i).equals(")")&& check.get(i+1).equals("("))
					check.add(i+1, "*");
					
				else if(check.get(i).equals(")")&& isNumber(check.get(i+1)))
					throw new IllegalArgumentException("Invalid Input");
				else if(check.get(i+1).equals("(")&& isNumber(check.get(i)))
					throw new IllegalArgumentException("Invalid Input");
			
			}
		}
		
	}
	
	private static boolean isNumber(String current) {
		for(char c : current.toCharArray()){
			if(Character.isDigit(c))
				return true;
		}
		return false;
	
		
	}
	
	private static boolean isOperator(String current) {
		String[] operators = {"+","-","*","/","%","^"};
		for(String c: operators){
			if(current.equals(c))
				return true;
		}	
		return false;
	}
	
	private static  int calculate(int y, int x, String current) { 
		switch(current){
		
		case "+": return y+x;
		case "-": return y-x;
		case "*": return y*x;
		case "/": if(x==0)
					throw new IllegalArgumentException("Cannot divide by 0");
				  return y/x;
		case "^": return (int) Math.pow(y, x);
		case "%": return y%x;
	
		}
		throw new IllegalArgumentException("Unknown operator");
	}
	
	public static ArrayList<String> getPostfix(ArrayList<String> infix,StackADT<String> stack){
		ArrayList<String> postfix = new ArrayList<String>();
		stack.push("(");
		infix.add(")");
		
		while(!stack.isEmpty()){
				String current = infix.get(0);
				infix.remove(0);
				if(isNumber(current)){
					postfix.add(current);
				}else if(current.equals("(")){
					stack.push(current.toString());
				}else if(isOperator(current)){
					
					while(isOperator(stack.peek())&&checkPrecedence(current.charAt(0),stack.peek().charAt(0))){
						postfix.add(stack.pop());
					}
					stack.push(current.toString());
				}else if(current.equals(")")){
					
					while(isOperator(stack.peek())){
						postfix.add(stack.pop());
					}
					stack.pop();
				}	
		}
		return postfix;
	}
	
	public static boolean isStringNumber(String s){
		String num = s;
		if(num.startsWith("-")){
			num = num.substring(1);
		}
		for(int i = 0; i < num.length(); i++){
			if(!Character.isDigit(num.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	
	public String printTokens(ArrayList<String> tokens) {
		String str = "";
		for (String t : tokens) {
			str += t.toString() + "\n";
		}
		return str;

	}
	
	public static boolean isStringNumber1(String s) {
		s= s.trim();
		if (s.charAt(0) == '-') {
			for (int i = 1; i < s.length(); i++) {
				if (!Character.isDigit(s.charAt(i))) {
					return false;
				}
			}
		}else if(s.charAt(s.length()-1)=='.'){
			return true;
		}else {
			for (int i = 0; i < s.length(); i++) {
				if (Character.isDigit(s.charAt(i))==false) {
					if( s.charAt(i)!='.'){
						if(s.charAt(i)!=' '){
							return false;
						}
						return false;
					}
					
				}
			}
		}

		return true;
	}

	public static boolean isOperator(Character c) {
		final char[] OPERATORS = { '+', '-', '*', '/', '%', '^'};
		
		for (char l : OPERATORS) {
			if (l == c) {
				return true;
			}
		}
		return false;
	}
	

	public boolean isParenthesis(Character c) {
		return c == '(' || c == ')';
	}

	private static boolean isDelim(Character currentChar) {
		char[] delims = new char[] { ' ', ')', '(' };
		for (char c : delims) {
			if (currentChar == c)
				return true;
		}
		return false;
	}

	public static int getPrecedence(char c){
		if(c == '+' || c == '-'){
			return 0;
		}
		if(c == '*' || c == '/' || c == '%'){
			return 1;
		}
		if(c == '^'){
			return 2;
		}
		throw new IllegalStateException("Not an operator");
	}
	
	private static boolean checkPrecedence(char base, char check){
		return (getPrecedence(check) >= getPrecedence(base));
	}
	
	public static String printTokens(String infix){
		ArrayList<String> tokens = tokenize(infix);
		String str = "";
		for(int i = 0; i < tokens.size(); i++){
			str += tokens.get(i);
		}
		return str;
	}
	
}
