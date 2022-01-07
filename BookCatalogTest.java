package book;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import book.file.BookFileReader;

class BookCatalogTest {

	// lists to store lines from different loaded book files
	List<String> catInTheHat;
	List<String> warAndPeace;
	List<String> siddhartha;

	// book objects to be created from lines 
	Book catInTheHatBook;
	Book warAndPeaceBook;
	Book siddharthaBook;
		
	@BeforeEach
	void setUp() throws Exception {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////

		//load and parse cat in the hat snippet book file
		this.catInTheHat = BookFileReader.parseFile("submit/src/the_cat_in_the_hat_snippet.txt");
		
		//create book object from list of lines from cat in the hat snippet
		this.catInTheHatBook = new Book(this.catInTheHat);
		
		//load and parse war and peace book file
		this.warAndPeace = BookFileReader.parseFile("submit/src/war_and_peace.txt");
		
		//create book object from list of lines from war and peace
		this.warAndPeaceBook = new Book(this.warAndPeace);
		
		//load and parse siddhartha book file
		this.siddhartha = BookFileReader.parseFile("submit/src/siddhartha.txt");
		
		//create book object from list of lines from siddhartha
		this.siddharthaBook = new Book(this.siddhartha);
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
				
	}

	@Test
	void testAddBook() {
		
		//////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! /////
		
		BookCatalog bookCatalog = new BookCatalog();

		//create book with title, and add to catalog
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("Title: Test Book Title");
		Book book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//catalog should contain 1 book
		assertEquals(1, bookCatalog.getBookMap().size());
		
		//create another book with title, and add to catalog
		bookLines = new ArrayList<String>();
		bookLines.add("Title:    Another Book Title");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//catalog should contain 2 books
		assertEquals(2, bookCatalog.getBookMap().size());
		
		
		//add cat in the hat
		bookCatalog.addBook(this.catInTheHatBook);

		//catalog should contain 3 books
		assertEquals(3, bookCatalog.getBookMap().size());
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! /////
		//////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Add war and peace and siddhartha book objects and check bookmap
		//add cat in the hat
		bookCatalog.addBook(this.siddharthaBook);

		//catalog should contain 3 books
		assertEquals(4, bookCatalog.getBookMap().size());

		//add cat in the hat
		bookCatalog.addBook(this.warAndPeaceBook);

		//catalog should contain 3 books
		assertEquals(5, bookCatalog.getBookMap().size());
	}

	@Test
	void testGetBookByTitle() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create book catalog
		BookCatalog bookCatalog = new BookCatalog();
		
		//create book with title and add to catalog
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("Title: Test Book Title");
		Book book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		Book catalogBook = bookCatalog.getBookByTitle("Test Book Title");
		
		//test book
		assertEquals("Test Book Title", catalogBook.getTitle());
		
		//create another book and add to catalog
		bookLines = new ArrayList<String>();
		bookLines.add("Title:     Another Book Title");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		catalogBook = bookCatalog.getBookByTitle("Another Book Title");
		
		//test book
		assertEquals("Another Book Title", catalogBook.getTitle());
		
		//add cat in the hat
		bookCatalog.addBook(this.catInTheHatBook);

		//get book from catalog
		catalogBook = bookCatalog.getBookByTitle("The Cat in the Hat");
		
		//test book
		assertEquals("The Cat in the Hat", catalogBook.getTitle());
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! /////
		//////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Add war and peace and siddhartha book objects and get them by title

		//add war and peace
		bookCatalog.addBook(this.warAndPeaceBook);

		//get book from catalog
		catalogBook = bookCatalog.getBookByTitle("War and Peace");

		//test book
		assertEquals("War and Peace", catalogBook.getTitle());

		//add siddharthaBook
		bookCatalog.addBook(this.siddharthaBook);

		//get book from catalog
		catalogBook = bookCatalog.getBookByTitle("Siddhartha");

		//test book
		assertEquals("Siddhartha", catalogBook.getTitle());
	}

	@Test
	void testGetBookByAuthor() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create book catalog
		BookCatalog bookCatalog = new BookCatalog();
		
		//create book with title and author and add to catalog
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("Title: My Book Title");
		bookLines.add("Author: Joseph Berry");
		Book book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		Book catalogBook = bookCatalog.getBookByAuthor("Joseph Berry");
		
		//test book
		assertEquals("Joseph Berry", catalogBook.getAuthor());
		
		//create another book and add to catalog
		bookLines = new ArrayList<String>();
		bookLines.add("Title:     My Other Book Title");
		bookLines.add("Author:    Rhonda Fierri");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		catalogBook = bookCatalog.getBookByAuthor("Rhonda Fierri");
		
		//test book
		assertEquals("Rhonda Fierri", catalogBook.getAuthor());
		
		//add cat in the hat
		bookCatalog.addBook(this.catInTheHatBook);

		//get book from catalog
		catalogBook = bookCatalog.getBookByAuthor("Dr. Seuss");
		
		//test book
		assertEquals("Dr. Seuss", catalogBook.getAuthor());

		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////

		
		// TODO insert 2 additional test cases
        // Hint(s): Add war and peace and siddhartha book objects and get them by author

		//add war and peace
		bookCatalog.addBook(this.warAndPeaceBook);

		//get book from catalog
		catalogBook = bookCatalog.getBookByAuthor("Leo Tolstoy");

		//test book
		assertEquals("Leo Tolstoy", catalogBook.getAuthor());

		//add siddharthaBook
		bookCatalog.addBook(this.siddharthaBook);

		//get book from catalog
		catalogBook = bookCatalog.getBookByAuthor("Hermann Hesse");

		//test book
		assertEquals("Hermann Hesse", catalogBook.getAuthor());
	}

}