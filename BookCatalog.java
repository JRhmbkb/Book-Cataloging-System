package book;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import book.file.BookFileReader;

import java.util.TreeMap;

/**
 * Represents a catalog of books.
 * @author lbrandon
 *
 */
public class BookCatalog {

	/**
	 * Internal map for storing books.
	 */
	private Map<String, Book> bookMap;
	
	/**
	 * Creates a book catalog and initializes the internal map for storing books.
	 */
	public BookCatalog() {
		this.bookMap = new TreeMap<String, Book>();
	}

	/**
	 * Gets internal book map.
	 * @return book map
	 */
	public Map<String, Book> getBookMap() {
		return this.bookMap;
	}
	
	/**
	 * Adds the given book to the internal map.
	 * Uses book title as key and book itself as value.  If title is null, doesn't add book.
	 * @param book to add
	 */
	public void addBook(Book book) {
		// TODO Implement method
		if (book.getTitle()!= null){
			bookMap.put(book.getTitle(),book);
		}
	}
	
	/**
	 * Gets the book associated with the given title.
	 * Returns null if the book doesn't exist in the catalog.
	 * @param title of book
	 * @return book
	 */
	public Book getBookByTitle(String title) {
		// TODO Implement method

		if (!bookMap.containsKey(title)){return null;}

		return bookMap.get(title);
	}
	
	/**
	 * Gets the book associated with the given author.
	 * Returns null if the book doesn't exist in the catalog.
	 * @param author of book
	 * @return book
	 */
	public Book getBookByAuthor(String author) {
		// TODO Implement method
		//loop through all the books to check the author
		for (Book bookToCheck: bookMap.values()){
			if (bookToCheck.getAuthor().equalsIgnoreCase(author)){
				return bookToCheck;
			}
		}
		return null; //return null if the book doesn't exist in the catalog.
	}
	
	///// DO NOT CHANGE CODE IN MAIN METHOD! /////
	public static void main(String[] args) throws FileNotFoundException {
    	
		//create instance of book catalog
		BookCatalog bookCatalog = new BookCatalog();
		
		//load and parse book files
		List<String> catInTheHat = BookFileReader.parseFile("submit/src/the_cat_in_the_hat_snippet.txt");
		List<String> warAndPeace = BookFileReader.parseFile("submit/src/war_and_peace.txt");
		List<String> siddhartha = BookFileReader.parseFile("submit/src/siddhartha.txt");
		
		//create instances of book with lists above
		Book catInTheHatBook = new Book(catInTheHat);
		Book warAndPeaceBook = new Book(warAndPeace);
		Book siddharthaBook = new Book(siddhartha);
		
		//get lines from books
		System.out.println("\nGET FIRST 3 LINES");
		System.out.println(catInTheHatBook.getLines().subList(0, 3));
		System.out.println(warAndPeaceBook.getLines().subList(0, 3));
		System.out.println(siddharthaBook.getLines().subList(0, 3));

		//get titles of books
		System.out.println("\nGET TITLES");
		String catInTheHatBookTitle = catInTheHatBook.getTitle();
		System.out.println(catInTheHatBookTitle);
		String warAndPeaceBookTitle = warAndPeaceBook.getTitle();
		System.out.println(warAndPeaceBookTitle);
		String siddharthaBookTitle = siddharthaBook.getTitle();
		System.out.println(siddharthaBookTitle);
		
		//get authors of books
		System.out.println("\nGET AUTHORS");
		String catInTheHatBookAuthor = catInTheHatBook.getAuthor();
		System.out.println(catInTheHatBookAuthor);
		String warAndPeaceBookAuthor = warAndPeaceBook.getAuthor();
		System.out.println(warAndPeaceBookAuthor);
		String siddharthaBookAuthor = siddharthaBook.getAuthor();
		System.out.println(siddharthaBookAuthor);
		
		//get total word counts from books
		System.out.println("\nGET TOTAL WORD COUNTS");
		System.out.println(catInTheHatBook.getTotalWordCount());
		System.out.println(warAndPeaceBook.getTotalWordCount());
		System.out.println(siddharthaBook.getTotalWordCount());
		
		//get total word counts from books
		System.out.println("\nGET UNIQUE WORD COUNTS");
		System.out.println(catInTheHatBook.getUniqueWordCount());
		System.out.println(warAndPeaceBook.getUniqueWordCount());
		System.out.println(siddharthaBook.getUniqueWordCount());
		
		//get specific word counts from books
		System.out.println("\nGET SPECIFIC WORD COUNTS");
		System.out.println(catInTheHatBook.getSpecificWordCount("sit"));
		System.out.println(warAndPeaceBook.getSpecificWordCount("love"));
		System.out.println(siddharthaBook.getSpecificWordCount("hate"));
		
		//add books to catalog
		bookCatalog.addBook(catInTheHatBook);
		bookCatalog.addBook(warAndPeaceBook);
		bookCatalog.addBook(siddharthaBook); 

		//get books by title
		System.out.println("\nGET BOOKS BY TITLE");
		System.out.println(bookCatalog.getBookByTitle("The Cat in the Hat").getTitle());
		System.out.println(bookCatalog.getBookByTitle("War and Peace").getTitle());
		System.out.println(bookCatalog.getBookByTitle("Siddhartha").getTitle());
		
		//get books by author
		System.out.println("\nGET BOOKS BY AUTHOR");
		System.out.println(bookCatalog.getBookByAuthor("Dr. Seuss").getAuthor());
		System.out.println(bookCatalog.getBookByAuthor("Leo Tolstoy").getAuthor());
		System.out.println(bookCatalog.getBookByAuthor("Hermann Hesse").getAuthor());
		
	}
}
