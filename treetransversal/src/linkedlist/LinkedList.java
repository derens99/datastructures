/**
 * Deren Singh
 * 10/9/2016
 * This class is the linked list class. It only has one instance variable called head, which 
 * is a node. It points to other nodes when there is more than one.
 */
package linkedlist;

import java.io.Serializable;
import java.util.Iterator;

public class LinkedList<T> implements Serializable {

	private ListNode<T> head;// First node in linked list

	// Initialize head
	public LinkedList() {
		head = null;
	}

	/** Add a node to the beginning of the linked list
	 * @param element - object getting passed in
	 */
	public void addFirst(T element){
		//ListNode temp = new ListNode(element, head);
		//head = temp;
			head = new ListNode<T>(element, head);
	}

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
	
	/**
	 * Get the first node in the linked list (head)
	 * 
	 * @return - the first node in the linked list (head)
	 */
	public T getFirst() {
		if (head == null) {
			throw new IllegalStateException("List is empty!");
		}
		return head.getValue();
	}

	// Remove the first element in the linked list
	public void removeFirst() {
		if (head == null) {
			throw new IllegalArgumentException("List is empty!");
		}
		if (head != null && head.getNext() == null) {
			deleteAll();
		} else {
			head = head.getNext();
		}
	}

	// Delete the linked list
	public void deleteAll() {
		head = null;
	}


	public int getSize() {
		ListNode<T> temp = head;
		if (temp == null) {
			return 0;
		}
		int c = 1;
		while (temp.getNext() != null) {
			c++;
			temp = temp.getNext();
		}
		return c;
	}

}
