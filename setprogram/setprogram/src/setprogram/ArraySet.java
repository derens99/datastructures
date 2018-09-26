package setprogram;

import java.util.Iterator;

public class ArraySet<T extends Comparable<T>> implements SetADT<T>{
	
	private T[] set;//Set of unique elements using static array
	private int count;//Number of elements in set
	
	private static final int SIZE = 10;//Default size of arrayset
	
	public ArraySet(){
		set = (T[]) (new Comparable[SIZE]);
		count = 0;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}
	
	public boolean add(T element) {
		if(size() == set.length){
			expandArray();
		}
		if(contains(element)){
			return false;
		}
		set[count] = element;
		count++;
		return true;
	}

	public boolean remove(T element) {
		if(isEmpty()){
			throw new IllegalArgumentException("Set is empty!");
		}
		Iterator<T> iterator = iterator();
		while(iterator.hasNext()){
			if(iterator.next().compareTo(element) == 0){
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public boolean contains(T element) {
		Iterator<T> iterator = iterator();
		while(iterator.hasNext()){
			if(iterator.next().compareTo(element) == 0){
				return true;
			}
		}
		return false;
	}
	
	//Expand the heap array to double its size
	public void expandArray() {
		T[] array = (T[]) (new Object[set.length * 2]);
		for (int i = 0; i < set.length; i++) {
			array[i] = set[i];			}
		set = array;
	}
	
	public static void removeIndexInArray(Object[] arr, int index, int c){
		for(int i = index; i < c; i++){
			arr[i] = arr[i+1];
		}
	}
	
	public Iterator<T> iterator() {
		return new ArraySetIterator();
	}
	
	public String toString(){
		Iterator<T> iterator = iterator();
		String str = "";
		while(iterator.hasNext()){
			str += iterator.next() + " ";
		}
		return str;
	}
	
	public class ArraySetIterator implements Iterator<T>{
		
		private int current, previous;
		private boolean canRemove;
		
		public ArraySetIterator(){
			current = -1;
			previous = -1;
			canRemove = false;
		}
		
		public boolean hasNext() {
			return set[current+1] != null;
		}

		public T next() {
			previous = current;
			current+=1;
			canRemove = true;
			return set[current];
		}
		
		public void remove(){
			if(canRemove==false){
				throw new IllegalStateException("next() was not called first!");
			}
			T temp = set[current];
			removeIndexInArray(set, current, count);
		}
	}
	
}
