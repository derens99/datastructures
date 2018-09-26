package hashmaplibrary;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable{
	
	private String title, author, borrower, isbn;//Instance variables
	
	//Special constructor for instance variables
	public Book(String t, String a, String i){
		title = t;
		author = a;
		borrower = "";
		isbn = i;
	}
	
	
	/** Compare two objects
	 *@param o - book being compared
	 */
	public int compareTo(Book o) {
		return title.compareTo(o.getTitle());
	}
	
	//Get title
	public String getTitle(){
		return title;
	}
	
	/** Set the borrower
	 * @param s - new borrower
	 */
	public void setBorrower(String s){
		borrower = s;
	}
	
	//Tostring method
	public String toString(){
		return "Title: " + title + "\nAuthor: " + author + 
			   "\nBorrower: " + borrower + "\nISBN: " + isbn;
	}
	
	public String getBorrower(){
		return borrower;
	}
	
	
}
