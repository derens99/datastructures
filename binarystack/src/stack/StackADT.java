/**
 * Deren Singh. Ms. Stowe. This interface is the interface for stacks.
 * It contains all the methods needed for a stack to fully function.
 */
package stack;

public interface StackADT <T>{
	public void push(T element);//Push something to the stack
	public T pop();//Remove the top element of the stack
	public T peek();//Get the top element of the stack
	public boolean isEmpty();//Determine if the stack is empty
	public int size();//The size of the stack
	public String toString();//Stack toString method
}
