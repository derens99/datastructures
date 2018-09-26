/**
 * Deren Singh
 * 10/9/2016
 * This class is the linked list class. It only has one instance variable called head, which 
 * is a node. It points to other nodes when there is more than one.
 */
package linkedlist;

import java.io.Serializable;
import java.util.Iterator;

public class LinkedList <T extends Comparable<T>> implements Serializable{
	
	private ListNode<T> head;//First node in linked list
	
	//Initialize head
	public LinkedList(){
		head = null;
	}
	
	/** Does the list contain a specific element
	 * @param element - element getting compared
	 * @return - a boolean if the element is in the list
	 */
	public boolean contains(T element){
		ListNode<T> temp = head;
		if(temp == null){
			return false;
		}
		if(temp != null && temp.getNext() == null){
			if(temp.getValue().compareTo(element)==0){
				return true;
			}
			return false;
		}
		while(temp.getNext()!=null){
			temp = temp.getNext();
			if(temp.getValue().compareTo(element)==0){
				return true;
			}
		}
		return false;
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
			throw new IllegalStateException("No elements!");
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
