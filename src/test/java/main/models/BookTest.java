
package main.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    private String author1 = "Liisa";
    private String title1 = "Viikossa";
    private String publisher1 = "Kuustonen";
    private int year1 = 1873;
    private Book book = new Book(author1, title1, publisher1, year1);
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setAuthor method, of class Book.
     */
    @Test
    public void testSetAuthor() {
        String author = "Seppo";
        Book instance = new Book();
        instance.setAuthor(author);
        assertEquals(instance.getAuthor(), "Seppo");
    }

    /**
     * Test of setPublisher method, of class Book.
     */
    @Test
    public void testSetPublisher() {
        String publisher = "Otava";
        Book instance = new Book();
        instance.setPublisher(publisher);
        assertEquals(instance.getPublisher(), "Otava");
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @Test
    public void testSetTitle() {
        String title = "Oravat kuussa";
        Book instance = new Book();
        instance.setTitle(title);
        assertEquals(instance.getTitle(), "Oravat kuussa");
    }

    /**
     * Test of setYear method, of class Book.
     */
    @Test
    public void testSetYear() {
        int year = 1999;
        Book instance = new Book();
        instance.setYear(year);
        assertEquals(instance.getYear(), 1999);
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
        String expResult = "Liisa";
        String result = book.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPublisher method, of class Book.
     */
    @Test
    public void testGetPublisher() {
        String expResult = "Kuustonen";
        String result = book.getPublisher();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        String expResult = "Viikossa";
        String result = book.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Book.
     */
    @Test
    public void testGetYear() {
        int expResult = 1873;
        int result = book.getYear();
        assertEquals(expResult, result);
    }
    
}
