package linkedlist;

public class CircularLinkedList <T>{
	
	private ListNode<T> head;//First node in circular linked list
	private ListNode<T> current;//Current node in list
	
	public CircularLinkedList(){
		head = null;
		current = head;
	}
	
	/** Add a node to the end of the linked list
	 * @param element - element getting placed at the end
	 */
	public void addLast(T element){
		if(head==null){
			addFirst(element);
			current = head;
		}else if(head != null && head.getNext()==null){
			head.setNext(new ListNode<T>(element, head));
		}else{
			ListNode<T> temp = head;
			while(temp.getNext()!=head){
				temp = temp.getNext();
			}
			temp.setNext(new ListNode<T>(element, head));
		}
		
	}
	
	//Increment current to the next element in the list
	public void getNext(){
		if(current.getNext() != null){
			current = current.getNext();
		}
	}
	
	//Get current
	public ListNode<T> getCurrent(){
		return current;
	}
	
	//Add first
	public void addFirst(T element){
		head = new ListNode<T>(element, head);
	}
	//Print all
	public String printAll(){
		ListNode<T> first = head;
		String str = "";
		if(first.getNext() == null){
			return first.getValue().toString();
		}
		while(first.getNext()!=head){
			str += first.getValue().toString();
			first = first.getNext();
		}
		str += first.getValue().toString();
		return str;
	}
	
	//Get the size of the linked list
	public int getSize(){
		ListNode<T> temp = head;
		int count = 1;
		if(temp == null){
			return 0;
		}
		if(temp.getNext() == null){
			return 1;
		}
		while(temp.getNext() != head){
			temp = temp.getNext();
			count++;
		}
		return count;
	}
	
}
