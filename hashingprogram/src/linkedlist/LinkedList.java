/**
 * Deren Singh
 * 10/9/2016
 * This class is the linked list class. It only has one instance variable called head, which 
 * is a node. It points to other nodes when there is more than one.
 */
package linkedlist;

import java.io.Serializable;
import java.util.Iterator;

public class LinkedList <T extends Comparable<T>> implements Iterable, Serializable{
	
	private ListNode<T> head;//First node in linked list
	
	//Initialize head
	public LinkedList(){
		head = null;
	}
	
	/** Get the iterator for this linked list class
	 * @return - the iterator for the linked list
	 */
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	public String searchItem(T element){
		if(head == null){
			throw new IllegalArgumentException("head is null!");
		}
		int c = 1;
		ListNode<T> current = head;
		if(current.getNext() == null){
			if(element.compareTo(current.getValue()) == 0){
				return "Item found in: " + c + " steps."; 
			}
		}
		while(current.getNext() != null){
			if(element.compareTo(current.getValue()) == 0){
				return "Item found in: " + c + " steps."; 
			}
			current = current.getNext();
		}
		throw new IllegalArgumentException("Item not found!!");
		
	}
	
	//Iterator class
	public class LinkedListIterator implements Iterator<T>{
		
		ListNode<T> current, previous;//Current and previous nodes
		boolean canRemove = false;//Whether the list can remove a node or not
		
		public LinkedListIterator(){
			current = new ListNode<T>(null, head);
			previous = null;
		}
		
		/** Determine if there is another node after current
		 * @return - if there is a node after current node
		 */
		public boolean hasNext() {
			return current.getNext() != null;
		}
		
		/** Return the current element and advance current to the next node
		 * @return - the current node's value
		 */
		public T next() {
			if(hasNext()==false){
				throw new IllegalStateException("hasNext was false!");
			}
			canRemove = true;
			previous = current;
			current = current.getNext();
			return current.getValue();
		}
		
		//Remove the most recently returned object
		public void remove(){
			if(canRemove == false){
				throw new IllegalStateException("next() was not called first!");
			}
			if(previous.getValue()==null){
				head = head.getNext();
			}else{
				previous.setNext(current.getNext());
			}
			canRemove=false;
		}
		
	}
	
	/** Add a node to the beginning of the linked list
	 * @param element - object getting passed in
	 */
	public void addFirst(T element){
		head = new ListNode<T>(element, head);
	}
	
	/** Add a node to the end of the linked list
	 * @param element - element getting placed at the end
	 */
	public void addLast(T element){
		if(head==null){
			addFirst(element);
		}else{
			ListNode<T> current = head;
			while(current.getNext()!=null){
				current = current.getNext();
			}
			current.setNext(new ListNode<T>(element, null));
		}
	}
	
	//Delete the linked list
	public void deleteAll(){
		head = null;
	}
	
	//toString method
	public String toString(){
		ListNode<T> temp = head;
		if(head == null){
			throw new IllegalStateException("LinkedList is empty!");
		}
		if(temp.getNext()==null){
			return temp.getValue().toString();
		}
		String str = "";
		while(temp.getNext()!=null){
			str += temp.getValue().toString() + " ";
			temp = temp.getNext();
		}
		str += temp.getValue().toString() + " ";
		if(head == null){
			return "";
		}
		return str;
	}

	
	
}
