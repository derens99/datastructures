/** Deren Singh. Ms. Stowe
 * This class implements the queueadt interface. 
 * It makes a queue with the linked list class
 */
package queue;

import linkedlist.LinkedList;

public class LinkedListQueue<T> implements QueueADT<T>{
	
	private LinkedList<T> queue;
	
	public LinkedListQueue() {
		queue = new LinkedList<>();
	}
	
	public void enqueue(T element) {
		queue.addLast(element);
	}

	public T dequeue() {
		if(isEmpty()){
			throw new IllegalStateException("Queue is empty!");
		}
		T toRemove = queue.getFirst();
		queue.removeFirst();
		return toRemove;
	}

	public T peekFront() {
		if(isEmpty()){
			throw new IllegalStateException("Queue is empty!");
		}
		return queue.getFirst();
	}

	public int size() {
		return queue.getSize();
	}

	public boolean isEmpty() {
		return queue.getSize() == 0;
	}
	
	public String toString() {
		if(size()==0){
			return "No elements in queue.";
		}
		return queue.toString();
	}
	
}
