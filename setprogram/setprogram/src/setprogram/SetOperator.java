package setprogram;

import java.util.Iterator;

public class SetOperator {
	
	public static<T> boolean equals(SetADT<T> s1, SetADT<T> s2){
		if(s1.size() != s2.size()){
			return false;
		}
		if(s1 == null || s2 == null){
			return false;
		}
		Iterator<T> iterator = s1.iterator();
		while(iterator.hasNext()){
			if(s2.contains(iterator.next())==false){
				return false;
			}
		}
		return true;
	}
	
	public static<T extends Comparable<T>> SetADT<T> intersection(SetADT<T> s1, SetADT<T> s2){
		ArraySet<T> set = new ArraySet<>();
		Iterator<T> iterator = s1.iterator();
		T temp;
		while(iterator.hasNext()){
			temp = iterator.next();
			if(s2.contains(temp)){
				set.add(temp);
			}
		}
		return set;	
	}
	
	public static<T extends Comparable<T>> SetADT<T> union(SetADT<T> s1, SetADT<T> s2){
		ArraySet<T> set = new ArraySet<>();
		Iterator<T> iterator = s1.iterator();
		Iterator<T> iterator2 = s2.iterator();
		while(iterator.hasNext()){
			set.add(iterator.next());
		}
		while(iterator2.hasNext()){
			set.add(iterator2.next());
		}
		return set;	
	}
	
	public static<T extends Comparable<T>> boolean subset(SetADT<T> s1, SetADT<T> s2){
		Iterator<T> iterator = s2.iterator();
		while(iterator.hasNext()){
			if(s1.contains(iterator.next()) == false){
				return false;
			}
		}
		return true;
	}
	
}
