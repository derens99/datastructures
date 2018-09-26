package setprogram;

import java.util.Iterator;

public class SetString<T extends Comparable<T>> {
	
	public static String getFrequency(SetADT<Character> set1, String s){
		checkSet(set1);
		String answer = "";
		int count = 0;
		Iterator<Character> iterator = set1.iterator();
		Character current;
		while(iterator.hasNext()){
			current = iterator.next();
			for(int i = 0; i < s.length(); i++){
				if(current.compareTo(s.charAt(i)) == 0){
					count++;
				}
			}
			answer += current.toString() + ": " + count + "\n";
			count=0;
		}
		return answer;
	}
	
	public static<T extends Comparable<T>> String commonLetters(SetADT<T> set1, SetADT<T> set2){
		checkSet(set1, set2);
		SetADT<T> common = SetOperator.intersection(set1, set2);
		return "Common letters: " + common.toString();
	}
	
	public static<T extends Comparable<T>> String allLetters(SetADT<T> set1, SetADT<T> set2){
		checkSet(set1, set2);
		SetADT<T> letters = SetOperator.union(set1, set2);
		return "All letters: " + letters.toString();
	}
	
	public static<T extends Comparable<T>> String removeLetters(SetADT<T> set1, SetADT<T> set2){
		checkSet(set1, set2);
		SetADT<T> letters = SetOperator.intersection(set1, set2);
		Iterator<T> iterator = letters.iterator();
		while(iterator.hasNext()){
			set1.remove(iterator.next());
		}
		return "Set 1: " + set1.toString();
	}
	
	public static<T extends Comparable<T>> String uniqueLetters(SetADT<T> set1, SetADT<T> set2){
		checkSet(set1, set2);
		if(SetOperator.subset(set1, set2)){
			return "String 2 Letters: [" + set2.toString() +"] ARE in String 1";
		}
		return "String 2 Letters: [" + set2.toString() + "] ARE NOT in String 1";
	}
	
	public static<T> void checkSet(SetADT<T> set1, SetADT<T> set2){
		if(set1.isEmpty() || set2.isEmpty()){
			throw new IllegalArgumentException("A set is empty!");
		}
	}
	
	public static<T> void checkSet(SetADT<T> set1){
		if(set1.isEmpty()){
			throw new IllegalArgumentException("A set is empty!");
		}
	}
	
}