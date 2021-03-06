/**
 * Deren Singh
 * 10/9/2016
 * This class is the linked list class. It only has one instance variable called head, which 
 * is a node. It points to other nodes when there is more than one.
 */
package linkedlist;

import java.io.Serializable;
import java.util.Iterator;
import student.Student;

public class LinkedList <T> implements Iterable, Serializable{
	
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
	
	/** Add an element (Student) alphabetically to a linked list
	 * @param element - the student being alphabetically added
	 */
	public void addAlphabetically(T element){
		ListNode<T> current = head, previous = null;
		ListNode<T> temp = new ListNode<T>(element, current);
		if(head == null){
			addFirst(element);
		}else{
			while(current != null && ((Student)current.getValue()).compareTo((Student)element) <= 0){
				previous = current;
				current = current.getNext();
			}
			if(previous == null){
				addFirst(element);
			}else{
				previous.setNext(temp);
			}
			temp.setNext(current);
		}
	}
	
	/** Search for a student
	 * @param element - the student being searced for
	 * @return - the found student. If not found, throw exception
	 */
	public T search(T element){
		ListNode<T> current = head;
		if(current == null){
			throw new IllegalArgumentException("List is empty!");
		}
		if(current.getNext()==null){
			if(((Student)element).compareTo(((Student)current.getValue()))==0){
				return current.getValue();
			}
		}
		while(current.getNext()!=null){
			if(((Student)element).compareTo(((Student)current.getValue()))==0){
				return current.getValue();
			}
			current = current.getNext();
		}
		throw new IllegalArgumentException("Element not found!");
	}
	
	/** Add a node to the beginning of the linked list
	 * @param element - object getting passed in
	 */
	public void addFirst(T element){
		//ListNode temp = new ListNode(element, head);
		//head = temp;
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
			current.setNext(new ListNode(element, null));
		}
	}
	
	/** Get the first node in the linked list (head)
	 * @return - the first node in the linked list (head)
	 */
	public T getFirst(){
		if(head == null){
			throw new IllegalStateException("List is empty!");
		}
		return head.getValue();
	}
	
	/** Get the last element in the linked list
	 * @return - the last node in the linked list
	 */
	public T getLast(){
		ListNode<T> temp = head;
		if(head == null){
			throw new IllegalStateException("List is empty!");
		}
		while(temp.getNext()!=null){
			temp = temp.getNext();
		}
		return temp.getValue();
	}
	
	//Remove the first element in the linked list
	public void removeFirst(){
		if(head == null){
			throw new IllegalArgumentException("List is empty!");
		}
		if(head != null && head.getNext()==null){
			deleteAll();
		}else{
			head = head.getNext();
		}
	}
	
	//Remove the last element in the linked list
	public void removeLast(){
		if(head != null){
			if(head.getNext()==null){
				deleteAll();
			}else{
				ListNode preLast = head;
				while(preLast.getNext().getNext()!=null)preLast = preLast.getNext();
				preLast.setNext(null);
			}
		}else{
			throw new IllegalArgumentException("List is empty!");
		}
	}
	
	//Delete the linked list
	public void deleteAll(){
		head = null;
	}
	
	/** Print all nodes in linked list
	 * @return - linked list objects toString's appended to one string
	 */
	public String printAll(){
		ListNode<T> temp = head;
		if(head == null){
			throw new IllegalStateException("LinkedList is empty!");
		}
		if(temp.getNext()==null){
			return temp.getValue().toString();
		}
		String str = "";
		while(temp.getNext()!=null){
			str += temp.getValue().toString() + "\n";
			temp = temp.getNext();
		}
		str += temp.getValue().toString() + "\n";
		if(head == null){
			return "";
		}
		return str;
	}

	
	
}
