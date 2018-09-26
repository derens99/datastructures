package hashmaplibrary;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class LibraryCard implements Comparable<LibraryCard>, Serializable{
	
	private int cardNumber;//Card number
	private String name;//name on card
	private Set<Book> booksOnLoan;//Set of books on loan for card
	
	/** Special constructor for library card
	 * @param n - card number
	 * @param na - card name
	 */
	public LibraryCard(int n, String na){
		cardNumber = n;
		name = na;
		booksOnLoan = new HashSet<>();
	}
	
	//Getters and setters
	public String getName(){
		return name;
	}
	
	public Set<Book> getBooksOnLoan(){
		return booksOnLoan;
	}
	
	public void addLoanedBook(Book b){
		booksOnLoan.add(b);
	}
	
	public void removeBook(Book b){
		booksOnLoan.remove(b);
	}

	public int compareTo(LibraryCard o) {
		return name.compareTo(o.getName());
	}
	
	public String toString(){
		return "Name: " + name + "\nCard Number: " + cardNumber+"\n";
	}
	
}
