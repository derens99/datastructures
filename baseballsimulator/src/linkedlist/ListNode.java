package linkedlist;

public class ListNode <T>{
	
	private T value;//Current node object value
	private ListNode<T> next;//This node pointing to its next one
	
	//Initialize list node objects
	public ListNode(){value = null;next=null;}
	
	/** Special constructor to set instance variables
	 * @param initValue - value passed it
	 * @param initNext - next node this points to
	 */
	public ListNode(T initValue, ListNode<T> initNext)
	{
		value=initValue;
		next = initNext;
	}
	
	/** Get the value of this node
	 * @return - value
	 */
	public T getValue(){return value;}
	
	/** Get the next node
	 * @return - the node after this one
	 */
	public ListNode<T> getNext(){return next;}
	
	/** Set this nodes value
	 * @param newValue - passed in node
	 */
	public void setValue(T newValue){value=newValue;}
	
	/** Set this nodes pointer to a new one
	 * @param newNext - the new node this is pointing to
	 */
	public void setNext(ListNode<T> newNext){next=newNext;}
	
	
}
