package stack;

public class ArrayStack<T> implements StackADT<T>{
	
	private int top;//The top index of the stack
	private T[] stack;//Array of elements for the stack
	
	//Default constructor to initialize instance variables
	public ArrayStack(){
		stack = (T[])(new Integer[10]);
		top = 0;
	}
	//Special constructor to set instance variable
	public ArrayStack(int s){
		stack = (T[])(new Integer[s]);
		top = 0;
	}
	/** Put something on top of the stack
	 * @param element - element being added to stack
	 */
	public void push(T element) {
		if(top == stack.length){
			copyArray();
		}
		stack[top] = element;
		top++;
	}
	/** Remove the first element on the stack
	 * @return - The element being popped off
	 */
	public T pop() {
		top--;
		return stack[top];
	}
	/** Get the element on the top of the stack
	 * @return - the top element on the stack
	 */
	public T peek() {
		return stack[top];
	}
	/** Determine if the stack is empty
	 * @return - boolean whether the stack is empty or not
	 */
	public boolean isEmpty() {
		return top == 0;
	}
	/** Determine the size of the stack
	 * @return - the stack size
	 */
	public int size() {
		return top;
	}
	//Increase the array size of the top reaches array.length
	private void copyArray(){
		T[] array = (T[])(new Integer[stack.length*2]);
		for(int i = 0; i < stack.length; i++){
			array[i] = stack[i];
		}
		stack = array;
	}
	
	
	/** Check if number is valid
	 * @param s - number getting entered
	 */
	public static void validBinaryNumber(Integer s){
		if(s < 0){
			throw new IllegalArgumentException("Decimal Number cannot be less than 0!");
		}
	}
	
	/** Check if array size is valid
	 * @param s - array size getting checked
	 */
	public static void validArraySize(Integer s){
		if(s <= 0){
			throw new IllegalArgumentException("Array size cannpt be less than or equal to 0!");
		}
	}

}
