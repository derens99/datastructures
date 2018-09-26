/**
 * @author Deren Singh
 * 1/14/2016
 * This class holds a sentence the user enters. It counts how many words and characters are in the sentence. It also splits 
 * the sentence up into an arraylist full of words. Lastly, it can check a sentence's validity.
 */

import java.util.ArrayList;

public class Sentence {
	
	private String sentence;//The sentence the user enters
	
	/** Constructor to set the sentence variable to the passed in sentence
	 * @param s - the sentence the user is passing in
	 */
	public Sentence(String s) {
		sentence = s.trim();
		sentence = sentence.replace('\t', ' ');
		sentence = sentence.replace('\n', ' ');
	}
	
	//Getter and setter
	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	/** Method to get the total amount of characters in the program
	 * @return - an integer of the total amount of characters entered
	 */
	private int getCharacters(){
		int count = 0;
		for(int i = 0; i < sentence.length(); i++){
			if(sentence.charAt(i) != ' '){
				count++;
			}
		}
		return count;
	}
	
	/** Method to split the sentence up into an arraylist of words
	 * @param target - the character where the method splits the words up
	 * @return - an arraylist of words from the sentence
	 */
	private ArrayList<Word> mySplit(String target){
		int beg = 0;
		int pos = sentence.indexOf(target);
		ArrayList<Word> words = new ArrayList<Word>();
		while(pos >= beg){
			if(pos>beg){
				
				words.add(new Word(sentence.substring(beg, pos)));
			}
			beg = pos + target.length();
			//words.add(target);
			pos = sentence.indexOf(target, beg);
		}
		if(beg<sentence.length()){
			words.add(new Word(sentence.substring(beg)));
		}
		
		return words;
	}
	
	/** Checks if a words is already in the array, if it is, add the count.
	 * @param s - the word getting checked
	 * @param ws - the arraylist the word is in
	 */
	private void addWord(String s, ArrayList<Word> ws){
		for(Word w: ws){
			if(w.getWord().equalsIgnoreCase(s)){
				w.incrementCount();
				return;
			}
		}
		
		ws.add(new Word(s));
	}
	
	/** Removes repeated words
	 * @param sentence - arraylist of words
	 * @return - a new arraylist of fixed words
	 */
	public ArrayList<Word> fix(ArrayList<Word> sentence){
		ArrayList<Word> ws = new ArrayList<>();
		for(Word w: sentence){
			addWord(w.getWord(), ws);
		}
		return ws;
	}
	
	/** Method to print the array
	 * @return - a string of words with the count next to them
	 */
	public String printWords(){
		//Deletes repeats
		String str = "";
		mySplit(" ");
		fix(mySplit(" "));
		
		//Prints fixed array
		for(Word w: fix(mySplit(" "))){
			str += w.getWord() + "\t\t" + w.getCount() +"\n";
		}
		
		return str;
	}
	
	//To string method
	//@return - a string of the information about the sentence
	public String toString(){
		String str="";
		printWords();
		str += getCharacters() + " characters\n" + 
		mySplit(" ").size() + " words\n" + printWords();
		return str;
		
	}
	
	/** Method to check if a sentence is valid or not
	 * @param s - the sentence getting checked
	 */
	public static void validSentence(String s){
		s = s.trim();
		if(s.equals("") || s.equals("\t") || s.equals("\n")){
			throw new IllegalStateException("Invalid Entry!");
		}
	}

}
