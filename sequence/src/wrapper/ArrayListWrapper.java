/**
 * Deren Singh
 * 9/27/2016
 * This class wraps the arraylist so it uses the listiterator class to 
 * access information. It holds a type and an arraylist.
 */
package wrapper;
import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListWrapper <T>{
	private T type;//The data type 
	private ArrayList<T> arrayList;//the arraylist
	
	//Constructor to initialize arraylist
	public ArrayListWrapper(){
		arrayList = new ArrayList<>();
	}
	
	/** Get the arraylist
	 * @return - the arraylist
	 */
	public ArrayList<T> getArrayList(){
		return arrayList;
	}
	
	/** Add an element to the arraylist
	 * @param e - the element getting added
	 * @param index - index where to add the element
	 */
	public void add(T e, int index){
		int c = 0;
		ListIterator<T> iterator = arrayList.listIterator();
		while(iterator.hasNext()){
			if(c == index){
				break;
			}else{
				iterator.next();
				c++;
			}
		}
		iterator.add(e);
	}
	
	/**Delete an element at a certain index
	 * @param index - where to delete the element
	 */
	public void delete(int index){
		int c = 0;
		ListIterator<T> iterator = arrayList.listIterator();
		while(iterator.hasNext()){
			if(index == c){
				iterator.next();
				iterator.remove();
				break;
			}else{
				iterator.next();
				c++;
			}
		}
	}
	
	/** Change an element at a certain index
	 * @param index - where the element is getting swapped 
	 * @param e - the new element putting in place of the old one
	 */
	public void change(int index, T e){
		add(e, index);
		delete(index+1);
	}
	
	/** Get the size of the arraylist
	 * @return - the size
	 */
	public int getSize(){
		ListIterator<T> iterator = arrayList.listIterator();
		int size = 0;
		while(iterator.hasNext()){
			iterator.next();
			size++;
		}
		return size;
		
	}
	
	//Method to reset the arraylist
	public void reinstantiate(){
		arrayList = new ArrayList<>();
	}
	
}
