package priorityqueue;

public interface PriorityQueueADT <T>{
	
	/** Check if the queue is empty
	 * @return - boolean if the queue is empty
	 */
	public boolean isEmpty();
	
	/** Add an element to the queue
	 * @param element - element being added to queue
	 */
	public void add(T element);
	
	/** Remove the element with the highest priority
	 * @return - the element getting removed
	 */
	public T removeMin();
	
	/** Get the element with the highest priority
	 * @return - the element with the highest priority
	 */
	public T peekMin();
	
}
