/**
 * Deren Singh
 * Double list node that tracks a current nodes previous and next nodes 
 * as well as its current value
 */
package doublelinkedlist;

import java.io.Serializable;

public class DoubleListNode <T> implements Serializable{
	
	private T value;//Node value
	private DoubleListNode<T> next;//Next node after this one
	private DoubleListNode<T> previous;//Previous node to this one
	
	//Constructor to initialize instance variables
	public DoubleListNode(){value=null;next=null;previous=null;}
	
	/** Special constructor to set instance variables
	 * @param initValue - node initial value
	 * @param initNext - next node after this
	 * @param initPrevious - previous node before this
	 */
	public DoubleListNode(T initValue, DoubleListNode<T> initNext, DoubleListNode<T> initPrevious){
		value=initValue;
		next=initNext;
		previous=initPrevious;
	}
	
	/** Get the current nodes value
	 * @return - node value
	 */
	public T getValue(){return value;}
	
	/** Get the next node
	 * @return - the node after this one
	 */
	public DoubleListNode<T> getNext(){return next;}
	
	/** Get the previous node
	 * @return - the previous node
	 */
	public DoubleListNode<T> getPrevious(){return previous;}
	
	/** Set the currents node value
	 * @param newValue - new current node value being set
	 */
	public void setValue(T newValue){value=newValue;}
	
	/** Set the next node 
	 * @param newNext - node to set the next node
	 */
	public void setNext(DoubleListNode<T> newNext){next=newNext;}
	
	/** Set the previous node
	 * @param newPrevious - node to set the previous node
	 */
	public void setPrevious(DoubleListNode<T> newPrevious){previous=newPrevious;}
	
}
