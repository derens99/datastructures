package setprogram;

import java.util.Iterator;

public interface SetADT<T> {
	public boolean isEmpty();
	public int size();
	public boolean add(T element);
	public boolean remove(T element);
	public boolean contains(T element);
	public Iterator<T> iterator();
}
