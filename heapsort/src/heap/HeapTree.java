/** Deren Singh - Ms. Stowe
 * This class is the heap tree class. It holds an array of elements that simulate
 * a binary heap tree. It's default size is set to ten and it can sort a tree using
 * the heap sort.
 */

package heap;

public class HeapTree<T extends Comparable<T>> {

	private T[] heap;// Array of T elements
	private int count;// Item count
	private int originalCount;// Original item count before adjustments

	private static final int SIZE = 10;// Default array size

	// Default constructor to initialize instance variables
	public HeapTree() {
		heap = (T[]) (new Comparable[SIZE]);
		count = 0;
		originalCount = 0;
	}

	/**
	 * Add an item to the tree
	 * 
	 * @param element
	 *            - element being added to tree
	 */
	public void add(T element) {
		if (count == heap.length) {
			expandArray();
		}
		heap[count] = element;
		count++;
		originalCount = count;
	}

	/**
	 * Switch two elements places in the heap tree
	 * 
	 * @param first
	 *            - first element location
	 * @param second
	 *            - second element location
	 */
	private void switchElements(int first, int second) {
		T temp = heap[first];
		heap[first] = heap[second];
		heap[second] = temp;
	}

	// Expand the heap array to double its size
	public void expandArray() {
		T[] array = (T[]) (new Integer[heap.length * 2]);
		for (int i = 0; i < heap.length; i++) {
			array[i] = heap[i];
		}
		heap = array;
	}

	/**
	 * Check if the heap tree is in order
	 * 
	 * @return - boolean if tree is in order
	 */
	private boolean isHeapInOrder() {
		for (int i = 1; i < originalCount; i++) {
			T temp = heap[i - 1];
			if (temp.compareTo(heap[i]) > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Get the maximum heap
	 * 
	 * @param i
	 *            - index i of the heap
	 */
	private void heapDown1(int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int largest;
		if (left <= count && heap[left].compareTo(heap[i]) > 0) {
			largest = left;
		} else {
			largest = i;
		}
		if (right <= count && heap[right].compareTo(heap[largest]) > 0) {
			largest = right;
		}
		if (largest != i) {
			switchElements(i, largest);
			heapDown(largest);
		}
	}
	
	public void heapDown(int index) {
		int childIndex = 0;
		if(hasLeftChild(index)){
			childIndex = getLeftChild(index);
			if(hasRightChild(index) && heap[getRightChild(index)].compareTo(heap[getLeftChild(index)]) > 0){
				childIndex = getRightChild(index);
			}
			if (heap[index].compareTo(heap[childIndex]) < 0) {
				switchElements(index, childIndex);
			}
		}
	}

	private void heapUp(int i) {
		int index = i;
		if (hasRightChild(getParent(index))) {
			if (heap[getRightChild(getParent(index))].compareTo(heap[getLeftChild(getParent(index))]) > 0) {
				index = getRightChild(getParent(index));
			} else {
				index = getLeftChild(getParent(index));
			}
		}
		if (heap[getParent(index)].compareTo(heap[index]) < 0) {
			switchElements(getParent(index), index);
		}
	}

	/**
	 * Get the index of the left child
	 * 
	 * @param i
	 *            - parent index
	 * @return - left child index
	 */
	private int getLeftChild(int i) {
		return 2 * i + 0;
	}

	/**
	 * Get the index of the right child
	 * 
	 * @param i
	 *            - parent index
	 * @return - right child index
	 */
	private int getRightChild(int i) {
		return 2 * i + 1;
	}

	/**
	 * Get the index of the parent
	 * 
	 * @param i
	 *            - the index of the child
	 * @return - index of the parent child
	 */
	private int getParent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Check if the left child exists
	 * 
	 * @param index
	 *            - index of parent
	 * @return - if the left child exists in array
	 */
	private boolean hasLeftChild(int index) {
		return getLeftChild(index) < count;
	}

	/**
	 * Check if the right child exists
	 * 
	 * @param index
	 *            - index of parent
	 * @return - if the right child exists in array
	 */
	private boolean hasRightChild(int index) {
		return getRightChild(index) < count;
	}

	/**
	 * Check if the parent exists
	 * 
	 * @param index
	 *            - index of child
	 * @return - if the parent exists in array
	 */
	private boolean hasParent(int index) {
		return getParent(index) >= 0;
	}

	/**
	 * Check if there is a heap
	 * 
	 * @return - if there is a heap
	 */
	private boolean isHeap() {
		for (int i = count - 1; i > 0; i--) {
			int index = i;
			while (index != 0) {
				if (hasRightChild(getParent(index))) {
					if (heap[getRightChild(getParent(index))].compareTo(heap[getLeftChild(getParent(index))]) > 0) {
						index = getRightChild(getParent(index));
					} else {
						index = getLeftChild(getParent(index));
					}
				}
				if (heap[getParent(index)].compareTo(heap[index]) < 0) {
					return false;
				}
				index = getParent(index);
			}
		}
		return true;
	}

	/**
	 * Print the levels of the tree
	 * 
	 * @return - the levels of the tree with level data in each level
	 */
	public String printLevels() {
		int num = 0, level = 0, numLevel = 1;
		String output = "Level " + level + ": ";
		for (int i = 0; i < originalCount; i++) {
			output += heap[i] + ", ";
			num++;
			if (num == numLevel && i != originalCount) {
				numLevel *= 2;
				level++;
				output += "\nLevel " + level + ": ";
				num = 0;
			}
		}
		return output;
	}

	// Tostring method
	public String toString() {
		String str = printLevels() + "\n\n";
		while (!isHeap()) {
			for (int i = count - 1; i > 0; i--) {
				heapUp(i);
			}
		}
		str += printLevels() + "\n\n";
		while(!isHeapInOrder() && count > 0){
			switchElements(0, count-1);
			count--;
			str += printLevels() + "\n\n";
			for(int i = 0; i <= count; i++){
				heapDown(i);
			}
		}
		return str;
	}

}
