package book;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import book.file.BookFileReader;

class BookTest {
	
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
	void testBook() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create empty list and book
		List<String> bookLines = new ArrayList<String>();
		Book book = new Book(bookLines);
		
		//confirm book lines is empty
		assertEquals(0, book.getLines().size());
		
		//create array with first 3 expected lines of cat in the hat snippet
		String[] expectedLines1Array = {
			"Title: The Cat in the Hat",
			"Author: Dr. Seuss",
			"The sun did not shine."
		};
		List<String> expectedLines1 = new ArrayList<String>(Arrays.asList(expectedLines1Array));
				
		//compare to first 3 actual lines from
		assertEquals(expectedLines1, this.catInTheHatBook.getLines().subList(0, 3));
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Get and compare the lines for war and peace and siddhartha book objects

		//create array with first 3 expected lines of siddhartha
		String[] expectedLines2Array = {
				"Title: Siddhartha",
				"Author: Hermann Hesse",
				"Translator: Gunther Olesch, Anke Dreher, Amy Coulter, Stefan Langer and Semyon Chaichenets"
		};
		List<String> expectedLines2 = new ArrayList<String>(Arrays.asList(expectedLines2Array));

		//compare to first 3 actual lines from
		assertEquals(expectedLines2, this.siddharthaBook.getLines().subList(0, 3));


		//create array with first 3 expected lines of war and peace
		String[] expectedLines3Array = {
				"Title: War and Peace",
				"Author: Leo Tolstoy",
				"Translators: Louise and Aylmer Maude"
		};
		List<String> expectedLines3 = new ArrayList<String>(Arrays.asList(expectedLines3Array));

		//compare to first 3 actual lines from
		assertEquals(expectedLines3, this.warAndPeaceBook.getLines().subList(0, 3));
	}

	@Test
	void testGetTitle() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list and book
		//with book title
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("Title: Test Book Title");
		Book book = new Book(bookLines);
		
		//confirm book title
		assertEquals("Test Book Title", book.getTitle());
		
		//create list and book
		//with book title with whitespace before it
		bookLines = new ArrayList<String>();
		bookLines.add("Title:    A Different Book Title");
		book = new Book(bookLines);
		
		//confirm book title
		assertEquals("A Different Book Title", book.getTitle());
		
		//confirm book title
		assertEquals("The Cat in the Hat", this.catInTheHatBook.getTitle());

		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////

		
		// TODO insert 2 additional test cases
        // Hint(s): Confirm the book titles of war and peace and siddhartha book objects
		assertEquals("War and Peace", this.warAndPeaceBook.getTitle());
		assertEquals("Siddhartha", this.siddharthaBook.getTitle());
	}

	@Test
	void testGetAuthor() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list and book
		//with book author
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("Author: Joseph Berry");
		Book book = new Book(bookLines);
		
		//confirm book author
		assertEquals("Joseph Berry", book.getAuthor());
		
		//create list and book
		//with book author with whitespace before it
		bookLines = new ArrayList<String>();
		bookLines.add("Author:    Rhonda Fierri");
		book = new Book(bookLines);
		
		//confirm book author
		assertEquals("Rhonda Fierri", book.getAuthor());
		
		//confirm book author
		assertEquals("Dr. Seuss", this.catInTheHatBook.getAuthor());
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Confirm the authors of war and peace and siddhartha book objects
		assertEquals("Hermann Hesse", this.siddharthaBook.getAuthor());
		assertEquals("Leo Tolstoy", this.warAndPeaceBook.getAuthor());
	}
	
	@Test
	void testGetTotalWordCount() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list and book
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("one two three");
		Book book = new Book(bookLines);
		
		//confirm total word count
		assertEquals(3, book.getTotalWordCount());
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("one two three.  four five six.");
		book = new Book(bookLines);
		
		//confirm total word count
		assertEquals(6, book.getTotalWordCount());
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("Title: My Book Title");
		bookLines.add("Author: My Book Author");
		bookLines.add("one, two, three.  four, five, six.");
		book = new Book(bookLines);
		
		//confirm total word count
		assertEquals(14, book.getTotalWordCount());
		
		//confirm approximate total word count
		assertTrue(this.catInTheHatBook.getTotalWordCount() >= 100 && this.catInTheHatBook.getTotalWordCount() <= 120);

		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////

		
		// TODO insert 2 additional test cases
        // Hint(s): Confirm approximate total word count for war and peace and siddhartha book objects
		assertTrue(this.siddharthaBook.getTotalWordCount() >= 42000 && this.siddharthaBook.getTotalWordCount() <= 43000);
		assertTrue(this.warAndPeaceBook.getTotalWordCount() >= 580000 && this.warAndPeaceBook.getTotalWordCount() <= 590000);
	}

	@Test
	void testGetUniqueWordCount() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list and book
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("one two three");
		Book book = new Book(bookLines);
		
		//confirm unique word count
		assertEquals(3, book.getUniqueWordCount());
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("one two three.  four five six.  ONE.");
		book = new Book(bookLines);
		
		//confirm unique word count
		assertEquals(6, book.getUniqueWordCount());
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("Title: My Book title");
		bookLines.add("Author: My book author");
		bookLines.add("one, two, three.  four, five, six.");
		book = new Book(bookLines);
		
		//confirm unique word count
		assertEquals(10, book.getUniqueWordCount());
		
		//confirm approximate unique word count
		assertTrue(this.catInTheHatBook.getUniqueWordCount() >= 50 && this.catInTheHatBook.getUniqueWordCount() <= 60);

		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////

		
		// TODO insert 2 additional test cases
        // Hint(s): Confirm approximate unique word count for war and peace and siddhartha book objects
		assertTrue(this.warAndPeaceBook.getUniqueWordCount() >= 18000 && this.warAndPeaceBook.getUniqueWordCount() <= 19000);
		assertTrue(this.siddharthaBook.getUniqueWordCount() >= 4000 && this.siddharthaBook.getUniqueWordCount() <= 4100);
	}

	@Test
	void testGetSpecificWordCount() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list and book
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("one two three");
		Book book = new Book(bookLines);
		
		//confirm unique word count
		assertEquals(1, book.getSpecificWordCount("three"));
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("one two three.  four five six. ONE.");
		book = new Book(bookLines);
		
		//confirm unique word count
		assertEquals(2, book.getSpecificWordCount("one"));
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("Title: My Book title");
		bookLines.add("Author: My book author");
		bookLines.add("Review: GREAT BOOK!");
		book = new Book(bookLines);
		
		//confirm unique word count
		assertEquals(3, book.getSpecificWordCount("book"));
		
		//confirm approximate specific word count
		assertTrue(this.catInTheHatBook.getSpecificWordCount("sit") >= 3 && this.catInTheHatBook.getSpecificWordCount("sit") <= 5);
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Confirm approximate specific word count for war and peace and siddhartha book objects
		assertTrue(this.warAndPeaceBook.getSpecificWordCount("love") >= 450 && this.warAndPeaceBook.getSpecificWordCount("love") <= 460);
		assertTrue(this.siddharthaBook.getSpecificWordCount("hate") > 4 && this.siddharthaBook.getSpecificWordCount("hate") < 6);
	}

}
