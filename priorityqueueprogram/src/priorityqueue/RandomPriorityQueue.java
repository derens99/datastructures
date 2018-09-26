package priorityqueue;

import linkedlist.ListNode;

public class RandomPriorityQueue<T extends Comparable<T>> implements PriorityQueueADT<T>{

private ListNode<T> head;//Head node
    
	//Default constructor
    public RandomPriorityQueue(){
        head = null;
    }
    
    /** Check if queue is empty
	 * @return - if queue is empty
	 */
    public boolean isEmpty(){
      return head == null;
    }
    
    /** Add an element to the queue
	 * @param - element getting added
	 */
    public void add(T element){
    	if(head == null){
    		head = new ListNode<T>(element, null);
    	}else{
    		ListNode<T> current = head;
        	while(current.getNext() != null){
        		current = current.getNext();
        	}
        	current.setNext(new ListNode(element, null));
    	}
    	
    }
    
    /** Remove the item with the highest priority in the queue
	 * @return - the item getting removed
	 */
    public T removeMin(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }else{
            ListNode<T> smallest = head, temp = head, prev = null;
            while(temp != null){
                if (temp.getNext() != null && temp.getNext().getValue().compareTo(smallest.getValue()) > 0){
                	smallest = temp.getNext();
                	prev = temp;
                }
                temp = temp.getNext();
            }
            if(smallest != head)
            	prev.setNext(smallest.getNext());
            else
            	head = head.getNext();
            return smallest.getValue();
        }
    }
    
    /** Get the item with the highest priority in the queue
	 * @return - the item with the highest priority
	 */
    public T peekMin(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }else{
        	  ListNode<T> smallest = head;
              ListNode<T> temp = head;
              ListNode<T> prev = null;
              while(temp != null){
                  if (temp.getNext() != null && temp.getNext().getValue().compareTo(smallest.getValue()) > 0){
                  	smallest = temp.getNext();
                  	prev = temp;
                  }
                  temp = temp.getNext();
              }
              return smallest.getValue();
          }
    }
}
