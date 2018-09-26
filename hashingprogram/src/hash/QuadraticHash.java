package hash;

public class QuadraticHash implements HashADT {

	private Integer[] table;//array of values for table
	private int count;//array count

	private static final int SIZE = 12;//array size

	//Default constructor
	public QuadraticHash() {
		table = new Integer[SIZE];
		count = 0;
	}

	/* Add an element to the table array
	 * @param number - the number being added
	 */
	public void add(Integer element) {
		if(count == SIZE-1){
			throw new IllegalStateException("Hash table is full!");
		}
		int power = 1;
		int index = getIndex(element);
		int num = index;
		while(table[num] != null){
			num = index + (int)Math.pow(power, 2);
			power++;
			if(num >= table.length){
				num = getIndex(num);
			}
			if(power >= table.length){
				throw new IllegalStateException("Number cannot be placed!");
			}
		}
		table[num] = element;
		count++;
	}

	/* Search fora specific element in table array
	 * @param i - the number being searched for
	 */
	public String search1(Integer i) {
		int index = getIndex(i);
		int power = 0;
		int c = 1;
		while(power < 10){
			if(table[index] == i){
				return i + " found in: " + c + "steps."; 
			}
			c++;
			index = (int)Math.pow(power, 2) + getIndex(i);
		}
		throw new IllegalArgumentException("Number " + i + "not found after 10 steps.");
	}
	
	public String search(Integer i) {
		int searches = 1;
		int index = getIndex(i);
		int num = index;
		int power = 1;
		while(table[num] != i){
			num = index + (int)Math.pow(power, 2);
			power++;
			if(num >= table.length){
				num = getIndex(num);
			}
			if(power >= table.length){
				throw new IllegalArgumentException("Number " + i + " not found after 10 steps.");
			}
			searches++;
		}
		return "Number: " + i + " found in " + searches + " steps!";
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
	private Integer getIndex(Integer n){
		return n % SIZE;
	}

}
