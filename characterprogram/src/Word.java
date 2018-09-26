/**
 * @author Deren Singh
 * 1/14/2016
 * This class holds the information about a word in a sentence. It will determine if the word is alphanumeric or not. 
 * This class also trim the punctuation off before and after the word if it is alphanumeric.
 */

public class Word {
	
	private String word;//A word in the sentence
	private int count;//How many times the word is in the sentence
	
	//Constructor to initalize variables
	
	/**Constructor to set word variable
	 * It also fixes the word if there is punctuation in it
	 * @param w - the word passed in
	 */
	public Word(String w){
		word = w;
		count = 1;
		fixBegWord();
		fixEndWord();
	}
	
	//getters and setters
	public void setWord(String w){
		word = w;
	}
	
	public String getWord(){
		return word;
	}
	
	public void incrementCount(){
		count++;
	}
	
	public int getCount(){
		return count;
	}
	
	public String toString(){
		return word;
	}
	
	//Method to remove punctuation from the beginning of a word
	public void fixBegWord(){
		int beg = 0;
		if(!wordMadeOfPunctuation()){
			for(int i = 0; i < word.length(); i++){
				if(isCharPunctuation(word.charAt(i))){
					beg++;
				}else{
					System.out.println(word);
					System.out.println(word.substring(beg, word.length()));
					word = word.substring(beg, word.length());
					break;
				}
			}
		}
		
	}
	
	//Method to remove punctuation from the end of a word
	public void fixEndWord(){
		int c = 0;
		if(!wordMadeOfPunctuation()){
			for(int i = word.length()-1; i >= 0; i--){
				if(isCharPunctuation(word.charAt(i))){
					c++;
				}else{
					word = word.substring(0, word.length()-c);
					System.out.println(word);
					break;
				}
			}
		}
		
	}
	
	/** check if the word is alphanumeric
	 * @return - a boolean of whether the word is alphanumeric or not
	 */
	public boolean isWordAlphaNumeric(){
		for(int i = 0; i < word.length(); i++){
			if(!isAlphaNum(word.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	/** determine if the word is made out of only punctuation
	 * @return - a boolean of if the word is made out of only punctuation
	 */
	private boolean wordMadeOfPunctuation(){
		int c = 0;
		for(int i = 0; i < word.length(); i++){
			if(isCharPunctuation(word.charAt(i))){
				c++;
			}
		}
		System.out.println(count);
		System.out.println(word.length());
		if(c == word.length()){
			return true;
		}else{
			return false;
		}
	}

	/** boolean to determine if a character is alphanumeric
	 * @param c - the character entered
	 * @return - a boolean of the character being alphanumeric or not
	 */
	public static boolean isAlphaNum(char c){
			if(c >= 65 && c <= 127){
				return true;
			}else{
				return false;
			}
	}
	
	/** method to check of a character is a punctuation character
	 * @param c - the character entered
	 * @return - boolean of whether the character entered is a punctuation character
	 */
	public static boolean isCharPunctuation(char c){
		return c == '.' || c == ':' || c == ';' || c == '?' || c == '!' || c == ',';
	}
	
}
