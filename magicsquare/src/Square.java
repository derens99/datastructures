/*
 * Deren Singh
 * 10/7/15
 * This class stores all the numbers into a multidimensional array 
 * called a square. It then checks if the square is a magic square 
 */

public class Square {
	
	private int[][] square;//The square array
	private int rowCount;//The row we are in when entering numbers
	private int colCount;//The column we are in when entering numbers
	
	/**
	 *Constructor to make a square array
	 * @param sz - The size of the square the user enters
	 */
	public Square(int sz){
		square = new int[sz][sz];
		rowCount=0;
		colCount=0;
	}
	
	/**
	 * Method to enter number into array
	 * @param num
	 */
	public void enterNumber(int num){
		if(colCount==square.length){
			colCount = 0;
			rowCount++;
		}
		square[rowCount]  [colCount] = num;
		colCount++;
	}
	
	//toString method to output square
	public String toString(){
		return ""+square[0][0];
	}
	
	/**
	 * @param row - the row the use wants to find the total of
	 * @return the total of the row the user wants to find
	 */
	private int getRowSum(int row){
		int sum = 0;
		for(int i = row; i < square.length; i++){
			sum += square[row][i];
		}
		return sum;
	}
	
	/**
	 * @param column - the column the user wants to find the total of
	 * @return the total of the column entered
	 */
	private int getColumnSum(int column){
		int sum = 0;
		for(int i = 0; i < square.length; i++){
			sum+=square[i][column];
		}
		return sum;
	}
	
	
	/**
	 * @return the total of the diagonal line going from top to bottom
	 */
	private int getDiagonalTopSum(){
		int sum = 0;
		for(int row = 0; row < square.length; row++){
			sum+=square[row][row];
		}
		return sum;
	}
	
	/**
	 * @return the total of the diagonal line going from bottom to top
	 */
	private int getDiagonalBottomSum(){
		int sum = 0;
		for(int i = 0; i < square.length; i++){
			sum+=square[i][square.length-1-i];
		}
		return sum;
	}
	
	/**
	 * @return a boolean if the user can enter another number into the square array
	 */
	public boolean canEnter(){
		return !(colCount == square.length-1 && rowCount == square.length-1);
	}
	
	/**
	 * @return a boolean if the square is a magic square or not
	 */
	public boolean isMagicSquare(){
		boolean isSquare = false;
		for(int i = 0; i < square.length; i++){
			if(getRowSum(0)==getRowSum(i)&&getRowSum(0)==getColumnSum(i) && getRowSum(0)==getDiagonalTopSum() && getRowSum(0)==getDiagonalBottomSum()){
				isSquare = true;
			}
			
		}
		return isSquare;
	}

}


