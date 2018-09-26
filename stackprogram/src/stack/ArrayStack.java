package stack;

public class ArrayStack<T> implements StackADT<T>{
	
	private int top;
	private T[] stack;
	
	public ArrayStack(){
		stack = (T[])(new Object[10]);
		top = -1;
	}
	
	public ArrayStack(int s){
		stack = (T[])(new Object[s]);
		top = -1;
	}

	public void push(T element) {
		if(size() == stack.length){
			copyArray();
		}
		top++;
		stack[top] = element;
	}

	public T pop() {
		if(isEmpty()){
			throw new IllegalStateException("Stack is empty!");
		}
		return stack[top--];
	}

	public T peek() {
		if(isEmpty()){
			throw new IllegalStateException("Stack is empty!");
		}
		return stack[top];
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return top+1;
	}
	
	private void copyArray(){
		T[] array = (T[])(new Object[stack.length*2]);
		for(int i = 0; i < top; i++){
			array[i] = stack[i];
		}
		stack = array;
	}
	
	public String toString(){
		String str = "";
		while(!isEmpty()){
			str += pop() + "\n";
		}
		return str;
	}
	
	public static void validSize(int s){
		if(s <= 0){
			throw new IllegalArgumentException("Invalid size for array!");
		}
	}

}
