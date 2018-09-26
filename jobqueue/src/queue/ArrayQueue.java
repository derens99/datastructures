/** Deren Singh. Ms. Stowe
 * This class implements the queueadt interface. 
 * It makes a queue with a static array
 */
package queue;

public class ArrayQueue<T> implements QueueADT<T>{
	
	private T[] queue;
	private int front, end, size;
	
	public ArrayQueue(){
		queue = (T[])(new Object[10]);
		front = size = 0;
		end = -1;
	}
	
	public ArrayQueue(int s){
		queue = (T[])(new Object[s]);
		front = size = 0;
		end = -1;
	}

	public void enqueue(T element) {
		end++;
		if(size == queue.length){
			copyArray();
		}
		if(end == queue.length){
			end = 0;
		}
		queue[end] = element;
		size++;
	}

	public T dequeue() {
		if(isEmpty()){
			throw new IllegalStateException("Stack is empty!");
		}
		T temp = queue[front];
		front++;
		if(front == queue.length){
			front = 0;
		}
		size--;
		return temp;
	}

	public T peekFront() {
		if(isEmpty()){
			throw new IllegalStateException("Stack is empty!");
		}
		return queue[front];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	private void copyArray(){
		T[] array = (T[])(new Object[queue.length*2]);
		int front2 = front;
		for(int i = 0; i < size; i++){
			if(front2 == queue.length){
				front2 = 0;
			}
			array[i] = queue[front2];
			front2++;
		}
		front = 0;
		end = size;
		queue = array;
	}
	
	public String toString(){
		if(isEmpty()){
			throw new IllegalStateException("Stack is empty!");
		}
		String str = "";
		if(front == end){
			str = queue[front].toString();
		}else{
			int temp = front;
			for(int i = 0; i < size; i++){
				if(temp == queue.length){
					temp = 0;
				}
				str += queue[temp] + "\n";
				temp++;
			}
		}
		return str;
	}
	
	public static void validSize(int s){
		if(s <= 0){
			throw new IllegalArgumentException("Invalid array size!");
		}
	}
	
}
