package priorityqueue;

import linkedlist.ListNode;

public class SortedPriorityQueue<T extends Comparable<T>> implements PriorityQueueADT<T>{
	
	private ListNode<T> head;//Head node
	 
	//Default constructor
	public SortedPriorityQueue(){
		head = null;
	}
	
	
	/** Check if queue is empty
	 * @return - if queue is empty
	 */
	public boolean isEmpty() {
		return head==null;
	}

	/** Add an element to the queue
	 * @param - element getting added
	 */
	public void add(T element) {
		ListNode<T> current = head;
        ListNode<T> previous = null;
        ListNode<T> temp = new ListNode<T>(element, current);
        if(head == null){
            head = new ListNode<T>(element, head);
        }else{
            while(current != null && (current.getValue().compareTo(element)) >= 0){
                previous = current;
                current = current.getNext();
            }
            if(previous == null){
                head = new ListNode<T>(element, head);
            }else{
                previous.setNext(temp);
            }
            temp.setNext(current);
        }
	}

	/** Remove the item with the highest priority in the queue
	 * @return - the item getting removed
	 */
	public T removeMin() {
		if(isEmpty()){
			throw new IllegalArgumentException("Queue is empty!");
		}
		T value = head.getValue();
		head = head.getNext();
		return value;
	}

	/** Get the item with the highest priority in the queue
	 * @return - the item with the highest priority
	 */
	public T peekMin() {
		if(isEmpty()){
			throw new IllegalArgumentException("Queue is empty!");
		}
		return head.getValue();
	}

	

}
