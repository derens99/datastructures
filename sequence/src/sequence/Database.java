/**
 * Deren Singh
 * 9/27/2016
 * This class stores the information of numbers and sequences passed in. It will then calculate 
 * sequences based off the arraylist of numbers passed in. Then, it will find the longest non decreasing
 sequence.
 */
package sequence;

import java.util.ArrayList;
import java.util.ListIterator;

import wrapper.ArrayListWrapper;

public class Database {
	
	private ArrayListWrapper<Double> numbers;//ArrayList to store numbers
	private ArrayListWrapper<Sequence> sequences;//ArrayList to store sequences
	
	//Constructor to initialize instance variables
	public Database(){
		numbers = new ArrayListWrapper<>();
		sequences = new ArrayListWrapper<>();
	}
	
	/** Get the numbers arraylistwraper
	 * @return - numbers arraylist
	 */
	public ArrayListWrapper<Double> getNumbers(){
		return numbers;
	}
	
	/** Get the sequences arraylist
	 * @return - the sequences
	 */
	public ArrayListWrapper<Sequence> getSequences(){
		return sequences;
	}
	
	//Calculate the sequences
	private void calculateSequences(){
		ArrayList<Double> nums = numbers.getArrayList();
		ListIterator<Double> iterator = nums.listIterator();
		//while(iterator.hasPrevious()){
			//iterator.previous();
		//}
		if(iterator.hasNext()==false){
			throw new IllegalArgumentException("No sequences entered!");
		}
		double prev = iterator.next();
		
		Sequence temp = new Sequence();
		temp.addNumber(prev);
		sequences.add(temp, sequences.getSize());
		for(int i = 1; i < numbers.getSize(); i++){
			double next = iterator.next();
			if(next < prev){
				prev = next;
				temp = new Sequence();
				temp.addNumber(next);
				sequences.add(temp, sequences.getSize());
			}else{
				temp.addNumber(next);
				prev = next;
			}
		}
	}
	
	/** Find the longest non decreasing sequence(s)
	 * @return - longest non decreasing sequences in string frorm
	 */
	public String getLongestNonDecreasingSequences(){
		calculateSequences();
		String str = "";
		int max = 0;
		ArrayList<Sequence> nums = sequences.getArrayList();
		ListIterator<Sequence> iterator = nums.listIterator();
		while(iterator.hasNext()){
			Sequence s = iterator.next();
			if(s.getSize() > max){
				max = s.getSize();
				str = s.toString();
			}else if(s.getSize()==max){
				str+="\n"+s.toString();
			}
		}
		
		return str;
	}
	
}
