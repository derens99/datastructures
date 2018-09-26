package hash;

public class ReHash implements HashADT {

	private Integer[] table;//array of values for table
	private int count;//array count

	private final int SIZE = 12;//array size

	//Default constructor
	public ReHash() {
		table = new Integer[SIZE];
		count = 0;
	}

	/* Add an element to the table array
	 * @param number - the number being added
	 */
	public void add(Integer element) {
		if (count == SIZE) {
			throw new IllegalStateException("Hash table is full!");
		}
		if(table[getIndex(element)] == null){
			table[getIndex(element)] = element;
			count++;
		}else if(table[getRehash(element)] == null){
			table[getRehash(element)] = element;
			count++;
		}else{
			Integer key = getRehash(element);
			Integer[] check = new Integer[12];
			int number = key;
			int pow = 1;
			while(table[number] != null){
				number = key + (int) Math.pow(pow, 2);
				pow++;
				if(number >= table.length){
					number = getIndex(number);
				}
				for(int i = 0; i < check.length; i++){
					if(check[i] != null){
						if(check[i] == number)
							throw new IllegalStateException("Number can't be placed");
					}else{
						check[i] = number;
					}
				}
			}
			table[number] = element;
			count++;
		}
	}

	/* Search fora specific element in table array
	 * @param i - the number being searched for
	 */
	public String search(Integer i) {
		int searches = 1;
		if(table[getIndex(i)].equals(i)){
			searches++;
		}else if(table[getRehash(i)].equals(i)){
			searches++;
		}else{
			Integer key = getRehash(i);
			Integer[] check = new Integer[12];
			int number = key;
			int pow = 1;
			while(table[number] != i){
				number = key + (int) Math.pow(pow, 2);
				pow++;
				if(number >= table.length){
					number = getIndex(number);
				}
				for(int ii = 0; ii < check.length; ii++){
					if(check[ii] != null){
						if(check[ii] == number)
							throw new IllegalStateException("Number can't be found");
					}else{
						check[ii] = number;
					}
				}
				searches++;
			}
		}
		return i + "found in " + searches + " step/s.";
	}

	/** Print all keys and values in table
	 * @return - string of values and keys of table
	 */
	public String printAll() {
		String str = "";
		for (int i = 0; i < SIZE; i++) {
			if (table[i] == null) {
				str += i + " --- Empty" + "\n";
			} else {
				str += i + " --- " + table[i] + "\n";
			}

		}
		return str;
	}

	/** Get the index of a certain element
	 * @param n - number being checked for index
	 * @return - the numbers index
	 */
	private int getIndex(int i) {
		return i % SIZE;
	}
	
	
	/** Get the rehash index of a certain element
	 * @param i - number being checked for rehash index
	 * @return - rehash index
	 */
	private int getRehash(int i) {
		return (3 * i) % SIZE;
	}

	/** Get quadratic index of a certain element
	 * @param i - the number getting the quadratic index
	 * @param pow - power it's being raised to
	 * @return - wuadratic index
	 */
	private int getQuad(int i, int pow) {
		return (int) Math.pow(pow, 2) + (getRehash(i));
	}

}
