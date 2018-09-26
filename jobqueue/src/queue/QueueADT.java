/** Deren Singh. Ms. Stowe
 * This interface holds all mthods needed for a queue.
 */
package queue;

public interface QueueADT <T>{
	
	/** Add element to queue
	 * @param element - add object to queue
	 */
	public void enqueue(T element);
	
	/** Remove the item from the queue
	 * @return - the item getting removed
	 */
	public T dequeue();
	
	/** Get the item from the front of the queue
	 * @return - the item at the front of the queue
	 */
	public T peekFront();
	
	/** Get the queues size
	 * @return - the queues size
	 */
	public int size();
	
	/** Check if the queue is empty
	 * @return - boolean of whether it is empty or not
	 */
	public boolean isEmpty();
	
	public String toString();//toString method
	
}
