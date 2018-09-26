package hash;

import linkedlist.LinkedList;

public class LinkedListHash implements HashADT{
	
	private LinkedList<Integer>[] table;//array of values for table
	private final int SIZE = 12;//array size
	private int count;
	
	//Default constructor
	public LinkedListHash(){
		table = new LinkedList[SIZE];
		count = 0;
	}
	
	/* Add an element to the table array
	 * @param number - the number being added
	 */
	public void add(Integer element) {
		Integer index = getIndex(element);
		if(table[index] == null){
			table[index] = new LinkedList();
		}
		table[index].addLast(element);
		count++;
	}
	
	/* Search fora specific element in table array
	 * @param i - the number being searched for
	 */
	public String search(Integer i) {
		Integer index = getIndex(i);
		return table[index].searchItem(i);
	}

	/** Print all keys and values in table
	 * @return - string of values and keys of table
	 */
	public String printAll() {
		String str = "";
		for(int i = 0; i < SIZE; i++){
			if(table[i] == null){
				str += i + " --- Empty" + "\n"; 
			}else{
				str += i + " --- " + table[i].toString() + "\n";
			}
			
		}
		return str;
	}
	
	/** Get the index of a certain element
	 * @param n - number being checked for index
	 * @return - the numbers index
	 */
	private int getIndex(int i){
		return i % SIZE;
	}

}
