/**
 * Deren Singh
 * 9/27/2016
 * This class holds all the data for a sequence. It has an arraylsit for type Double and
 * size to track how big the arraylist is.
 */
package sequence;

import java.util.ArrayList;
import java.util.ListIterator;

public class Sequence {
	
	private ArrayList<Double> sequence;//The non decreasing sequence
	private int size;//The sequence size
	
	//Constructor to initialize instance variables
	public Sequence(){
		sequence = new ArrayList<>();
		size = 0;
	}
	
	
	/** Add a number to the sequence
	 * @param d - the number getting added
	 */
	public void addNumber(Double d){
		ListIterator<Double> i = sequence.listIterator();
		//System.out.println(d);
		i.add(d);
		size++;
	}
	
	/** Get the size of the sequence
	 * @return - the sequences size
	 */
	public int getSize(){
		return size;
	}
	
	//toString method to @return the sequence
	public String toString(){
		String str = "";
		ListIterator i = sequence.listIterator(size);
		while(i.hasPrevious()){
			str+=i.previous() + ", ";
		}
		return str;
	}
	
	
}
