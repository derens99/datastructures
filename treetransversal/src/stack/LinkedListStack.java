/** Deren Singh. Ms. Stowe
 * This class is a stack class. It uses a linked list to perform
 * regular stack functions
 */
package stack;

import linkedlist.LinkedList;

public class LinkedListStack<T> implements StackADT<T>{
	
	private LinkedList<T> stack;//Stack made of linkedlist
	
	//Default constructor to initialize instance variable
	public LinkedListStack(){
		stack = new LinkedList<T>();
	}
	
	/** Put something on top of the stack
	 * @param element - element being added to stack
	 */
	public void push(T element) {
		stack.addFirst(element);
	}

	/** Remove the first element on the stack
	 * @return - The element being popped off
	 */
	public T pop() {
		T element;
		try{
			element = peek();
		}catch(IllegalStateException e){
			throw new IllegalStateException("Stack is empty!");
		}
		try{
			stack.removeFirst();
		}catch(IllegalArgumentException e){
			throw new IllegalStateException("Stack is empty!");
		}
		return element;
	}
	
	/** Get the element on the top of the stack
	 * @return - the top element on the stack
	 */
	public T peek() {
		try{
			return stack.getFirst();
		}catch(IllegalStateException e){
			throw new IllegalStateException("Stack is empty!");
		}
		
	}

	/** Determine if the stack is empty
	 * @return - boolean whether the stack is empty or not
	 */
	public boolean isEmpty() {
		return stack.getSize()==0;
	}

	/** Determine the size of the stack
	 * @return - the stack size
	 */
	public int size() {
		return stack.getSize();
	}
	
}
