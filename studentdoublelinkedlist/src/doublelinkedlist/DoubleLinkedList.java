/**
 * Deren Singh
 * This class is a doubly linked list class where it tracks a current node and 
 * can remove and edit elements as well.
 */
package doublelinkedlist;

import java.io.Serializable;

import doublelinkedlist.DoubleListNode;

public class DoubleLinkedList<T extends Comparable<T>> implements Serializable {

	private DoubleListNode<T> head;// First node in linked list
	private DoubleListNode<T> current;// Current node in list to get next and
										// previous

	// Initialize head
	public DoubleLinkedList() {
		head = null;
		current = null;
	}

	/** Add an element to the linked list
	 * @param t - element getting added to list
	 */
	public void addElement(T t) {
		DoubleListNode<T> next = head;
		DoubleListNode<T> previous = null;
		if (head == null) {
			head = new DoubleListNode<T>(t, null, null);
			current = head;
		} else {
			while (next != null && next.getValue().compareTo(t) <= 0) {
				previous = next;
				next = next.getNext();
			}
			if (previous == null) {
				addFirst(t);
			} else if (next == null) {
				addLast(t, previous);
			} else {
				DoubleListNode<T> temp = new DoubleListNode<T>(t, next, previous);
				previous.setNext(temp);
				next.setPrevious(temp);
				current = temp;
			}
		}
	}
	
	//Delete the current element
	public void deleteCurrent() {
		if (current == head) {
			if (head.getNext() == null) {
				head = null;
				current = head;
			} else {
				head = head.getNext();
				head.setPrevious(null);
				current = head;
			}
			return;
		}
		DoubleListNode<T> prev = current.getPrevious();
		DoubleListNode<T> next = current.getNext();
		prev.setNext(next);
		if (next != null)
			next.setPrevious(prev);
		current = prev;
	}
	
	/** Determine if instance variable "current" can be advanced
	 * @return - boolean whether current can move forward
	 */
	public boolean canMoveNext(){
		return current.getNext() != null;
	}
	
	/** Determine if instance variable "current" can be move backwards
	 * @return - boolean whether current can move back
	 */
	public boolean canMovePrevious(){
		return current.getPrevious() != null;
	}
	
	//Resort list when sort is changed from gpa to name and vice versa
	public void rearrangeList() {
		if (head == null) {
			return;
		}
		DoubleListNode<T> temp = head;
		head = null;
		while (temp != null) {
			addElement(temp.getValue());
			temp = temp.getNext();
		}
		current = head;
	}
	
	/** Get the current list node
	 * @return - current list node
	 */
	public DoubleListNode<T> getCurrentListNode() {
		return current;
	}
	
	//Move current forwards 1
	public void getNext() {
		if (current.getNext() != null) {
			current = current.getNext();
		}
	}
	
	//Move current backwards 1
	public void getPrevious() {
		if (current.getPrevious() != null) {
			current = current.getPrevious();
		}

	}

	/**
	 * Add a node to the beginning of the linked list
	 * 
	 * @param element
	 *            - object getting passed in
	 */
	private void addFirst(T t) {
		head.setPrevious(new DoubleListNode<T>(t, head, null));
		head = head.getPrevious();
		current = head;
	}

	/**
	 * Add a node to the end of the linked list
	 * 
	 * @param element
	 *            - element getting placed at the end
	 */
	private void addLast(T t, DoubleListNode<T> last) {
		DoubleListNode<T> newLast = new DoubleListNode<T>(t, null, last);
		last.setNext(newLast);
		current = newLast;
	}
	
	public boolean isListEmpty(){
		return head == null;
	}

}
