package setprogram;

import java.util.Iterator;

import linkedlist.LinkedList;

public class LinkedListSet<T extends Comparable<T>> implements SetADT<T>{
	
	private LinkedList<T> set;
	
	public LinkedListSet(){
		set = new LinkedList<>();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		Iterator<T> iterator = iterator();
        int count = 0;
        while(iterator.hasNext()){
        	iterator.next();
            count++;
        }
        return count;
	}

	public boolean add(T element) {
		if(contains(element)){
			return false;
		}
		set.addLast(element);
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
			if(iterator.next().compareTo(element)==0){
				return true;
			}
		}
		return false;
	}
	
	

	public Iterator<T> iterator() {
		return set.iterator();
	}
	
	public String toString(){
		return set.toString();
	}
	
}
