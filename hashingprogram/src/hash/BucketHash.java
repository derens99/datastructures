package hash;

public class BucketHash implements HashADT{
	
	private Integer[] table;
	private int count;
	private final int BUCKETSIZE = 3;
	private final int SIZE = 12 * BUCKETSIZE;
	private final int SIZE2 = 12;
	
	public BucketHash(){
		table = new Integer[SIZE];
		count = 0;
	}
	
	public void add(Integer element) {
		int index = getIndex(element)*BUCKETSIZE;
		if(table[index] == null){
			table[index] = element;
			count++;
			return;
		}
		int temp = 1;
		index += temp++;
		while(temp < BUCKETSIZE){
			if(table[index] == null){
				table[index] = element;
				count++;
				return;
			}
			index = temp++;
		}
		throw new IllegalArgumentException("Error for too many iterations.");
	}

	public String search(Integer i) {
		int c = 1;
		int index = getIndex(i)*BUCKETSIZE;
		if(table[index] == i){
			return "Item found in " + c + "steps.";
		}
		int temp = 1;
		index += temp++;
		while(temp < BUCKETSIZE){
			c++;
			if(table[index] == i){
				return "Item found in " + c + "steps.";
			}
			index += temp++;
		}
		throw new IllegalArgumentException("Error for too many iterations.");
	}

	public String printAll() {
		String str = "";
		int c = 0;
		for (int i = 0; i < SIZE; i++) {
			if(i % 3 == 0){
				str += "Bucket: " + c + "\n";
				c++;
			}
			if (table[i] == null) {
				str += i + " --- Empty" + "\n";
			} else {
				str += i + " --- " + table[i] + "\n";
			}

		}
		return str;
	}
	
	private int getIndex(int i) {
		return i % SIZE2;
	}

}
