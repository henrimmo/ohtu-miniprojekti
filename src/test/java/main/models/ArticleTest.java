
package main.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArticleTest {
    private String author1 = "Mr. Puu";
    private String title1 = "Kuuset";
    private String journal1 = "Luonto";
    private int year1 = 2008;
    private Article article = new Article("puu08", author1, title1, journal1, year1);
    
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
        String author = "Sini";
        Article instance = new Article();
        instance.setAuthor(author);
        assertEquals(instance.getAuthor(), "Sini");
    }

    /**
     * Test of setJournal method, of class Article.
     */
    @Test
    public void testSetJournal() {
        String journal = "Colors";
        Article instance = new Article();
        instance.setJournal(journal);
        assertEquals(instance.getJournal(), "Colors");
    }

    /**
     * Test of setTitle method, of class Article.
     */
    @Test
    public void testSetTitle() {
        String title = "Fun";
        Article instance = new Article();
        instance.setTitle(title);
        assertEquals(instance.getTitle(), "Fun");
    }


    /**
     * Test of setYear method, of class Article.
     */
    @Test
    public void testSetYear() {
        int year = 2010;
        Article instance = new Article();
        instance.setYear(year);
        assertEquals(instance.getYear(), 2010);
    }

    /**
     * Test of getAuthor method, of class Article.
     */
    @Test
    public void testGetAuthor() {
        String expResult = "Mr. Puu";
        String result = article.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getJournal method, of class Article.
     */
    @Test
    public void testGetJournal() {
        String expResult = "Luonto";
        String result = article.getJournal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Article.
     */
    @Test
    public void testGetTitle() {
        String expResult = "Kuuset";
        String result = article.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Article.
     */
    @Test
    public void testGetYear() {
        int expResult = 2008;
        int result = article.getYear();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToBibText() {
        assertEquals("@ARTICLE{puu08,\n"
                + "    author = {Mr. Puu},\n" 
                + "    title = {Kuuset},\n"
                + "    journal = {Luonto},\n"
                + "    year = {2008},\n"
                + "}\n",
                article.toBibTex());
    }
    
}
