
package main.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArticleTest {
    
    public ArticleTest() {
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
     * Test of setAuthor method, of class Article.
     */
    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "";
        Article instance = new Article();
        instance.setAuthor(author);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJournal method, of class Article.
     */
    @Test
    public void testSetJournal() {
        System.out.println("setJournal");
        String journal = "";
        Article instance = new Article();
        instance.setJournal(journal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Article.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Article instance = new Article();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVolume method, of class Article.
     */
    @Test
    public void testSetVolume() {
        System.out.println("setVolume");
        int volume = 0;
        Article instance = new Article();
        instance.setVolume(volume);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setYear method, of class Article.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        int year = 0;
        Article instance = new Article();
        instance.setYear(year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthor method, of class Article.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Article instance = new Article();
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJournal method, of class Article.
     */
    @Test
    public void testGetJournal() {
        System.out.println("getJournal");
        Article instance = new Article();
        String expResult = "";
        String result = instance.getJournal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Article.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Article instance = new Article();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolume method, of class Article.
     */
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        Article instance = new Article();
        int expResult = 0;
        int result = instance.getVolume();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYear method, of class Article.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Article instance = new Article();
        int expResult = 0;
        int result = instance.getYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
