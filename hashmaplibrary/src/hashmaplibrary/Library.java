package hashmaplibrary;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Library implements Serializable{
	
	private HashMap<String, Book> books;//Hash map of books and isbn
	private HashMap<Integer, LibraryCard> libraryCards;//hash map of library cards and card number
	
	//Default constructor
	public Library(){
		books = new HashMap<>();
		libraryCards = new HashMap<>();
	}
	
	
	/** Add a book to the hashmap
	 * @param b - book being added
	 * @param isbn - isbn correlated to each book
	 */
	public void addBook(Book b, String isbn){
		books.put(isbn, b);
	}
	
	/** Library card being added
	 * @param card - card being added
	 * @param number - number being added
	 */
	public void addLibraryCard(LibraryCard card, int number){
		libraryCards.put(number, card);
	}
	
	/** List the books alphabetically
	 * @return - a string of all books lsited alphabetically
	 */
	public String listAlphabetically(){
		String str = "Books:\n";
		TreeSet<Book> titles = new TreeSet<>();
		titles.addAll(books.values());
		Iterator<Book> it = titles.iterator();
		if(!it.hasNext()){
			throw new IllegalStateException("Map is empty!");
		}
		while(it.hasNext()){
			str += it.next().getTitle() + "\n";
		}
		return str;
	}
	
	/** List the isbn's of the book
	 * @return - a string of all isbn's
	 */
	public String listISBNs(){
		Set<String> isbns = books.keySet();
		Iterator<String> it = isbns.iterator();
		if(!it.hasNext()){
			throw new IllegalStateException("Map is empty!");
		}
		String str = "ISBN's: \n";
		while(it.hasNext()){
			str += it.next() + "\n";
		}
		return str;
	}
	
	/** List the names of all the people with cards
	 * @return - a string of all cards and names
	 */
	public String listNames(){
		String str = "Names:\n";
		TreeSet<LibraryCard> names = new TreeSet<>();
		names.addAll(libraryCards.values());
		Iterator<LibraryCard> it = names.iterator();
		if(!it.hasNext()){
			throw new IllegalStateException("Map is empty!");
		}
		while(it.hasNext()){
			str += it.next().getName() + "\n";
		}
		return str;
	}
	
	/** List the numbers of the cards
	 * @return - numbers on cards
	 */
	public String listNumbers(){
		Set<Integer> numbers = libraryCards.keySet();
		Iterator<Integer> iterator = numbers.iterator();
		String str = "Numbers: \n";
		if(!iterator.hasNext()){
			throw new IllegalStateException("Map is empty!");
		}
		while(iterator.hasNext()){
			str += iterator.next() + "\n";
		}
		return str;
	}
	
	/** Get all the loaned books
	 * @return - a string of all books loaned out of the library
	 */
	public String listLoanedBooks(){
		Iterator<LibraryCard> it = libraryCards.values().iterator();
		String str = "";
		if(!it.hasNext()){
			throw new IllegalStateException("Map is empty!");
		}
		while(it.hasNext()){
			Iterator<Book> iterator = it.next().getBooksOnLoan().iterator();
			while(iterator.hasNext()){
				str += iterator.next().toString() + "\n";
			}
		}
		if(str.equals("")){
			return "No loaned books.";
		}
		return str;
	}
	
	/** Check a book out of the library
	 * @param isbn - isbn of book
	 * @param card - card number of library card
	 * @param name - name of the card
	 */
	public void checkOutBook(String isbn, int card) {
		checkBook(isbn);
		if(!books.get(isbn).getBorrower().equals("")){
			throw new IllegalArgumentException("Book already checked out!");
		}
        libraryCards.get(card).addLoanedBook(books.get(isbn));
        books.get(isbn).setBorrower(libraryCards.get(card).getName());
    }
	
	/** Return a book back to the library
	 * @param isbn - book isbn key
	 * @param card - card number
	 */
	public void returnBook(String isbn, int card){
		checkBook(isbn);
        checkCard(card);
        if(books.get(isbn).getBorrower().equals("")){
        	throw new IllegalArgumentException("Book isn't borrowed!");
        }
        books.get(isbn).setBorrower("");
        libraryCards.get(card).removeBook(books.get(isbn));
	}
	
	/** Check if a book is in the library
	 * @param isbn - book isbn
	 */
	public void checkBook(String isbn){
		if(books.containsKey(isbn)==false){
			throw new IllegalArgumentException("Book not found!");
		}
	}
	
	/** Check if a card is existent
	 * @param card - card number
	 */
	public void checkCard(int card){
		if(libraryCards.containsKey(card)==false){
			throw new IllegalArgumentException("Card not found!");
		}
	}
	
}
