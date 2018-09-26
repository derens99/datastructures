package hash;

public class LinearHash implements HashADT {

	private Integer[] table;//array of values for table
	private int count;//array count

	private static final int SIZE = 12;//array size
	
	//Default constructor
	public LinearHash() {
		table = new Integer[SIZE];
		count = 0;
	}
	
	
	/* Add an element to the table array
	 * @param number - the number being added
	 */
	public void add(Integer number) {
		if (count == table.length) {
			throw new IllegalArgumentException("Table is full!");
		}
		int index = number % SIZE;

		while (table[index] != null) {
			if(index == SIZE-1){
				index = 0;
			}
			index++;
		}
		table[index] = number;
	}

	/* Search fora specific element in table array
	 * @param i - the number being searched for
	 */
	public String search(Integer i) {
		int index = getIndex(i);
		int c = 1;
		while(table[index] != i){
			if(index == SIZE-1){
				index = 0;
			}
			index++;
			c++;
			if(c == SIZE){
				throw new IllegalArgumentException("Number not found!");
			}
		}
		return "Item: " + i + " found in: " + c + " searches.";
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
				str += i + " --- " + table[i] + "\n";
			}
			
		}
		return str;
	}

	/** Get the index of a certain element
	 * @param n - number being checked for index
	 * @return - the numbers index
	 */
	private int getIndex(int n){
		return n % SIZE;
	}

}
