
package main.models;

import main.services.BibTexGenerator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IncollectionTest {
    private String author1 = "Jouko ja Jutta";
    private String title1 = "Kiertoreitti";
    private String booktitle1 = "Sopulin kulku";
    private String publisher1 = "Elukat";
    private int year1 = 2015;
    private Incollection incollection = new Incollection("jj15", author1, title1, booktitle1, publisher1, year1);
    
    public IncollectionTest() {
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
     * Test of setAuthor method, of class Inproceedings.
     */
    @Test
    public void testSetAuthor() {
        String author = "Herra";
        Incollection instance = new Incollection();
        instance.setAuthor(author);
        assertEquals(instance.getAuthor(), "Herra");
    }

    /**
     * Test of setBooktitle method, of class Inproceedings.
     */
    @Test
    public void testSetBooktitle() {
        String booktitle = "Jaha";
        Incollection instance = new Incollection();
        instance.setBooktitle(booktitle);
        assertEquals(instance.getBooktitle(), "Jaha");
    }

    /**
     * Test of setTitle method, of class Inproceedings.
     */
    @Test
    public void testSetTitle() {
        String title = "Oho";
        Incollection instance = new Incollection();
        instance.setTitle(title);
        assertEquals(instance.getTitle(), "Oho");
    }

    /**
     * Test of setYear method, of class Inproceedings.
     */
    @Test
    public void testSetYear() {
        int year = 2000;
        Incollection instance = new Incollection();
        instance.setYear(year);
        assertEquals(instance.getYear(), 2000);
    }
    
    @Test
    public void testSetPublisher() {
        String publisher = "Moi";
        Incollection instance = new Incollection();
        instance.setTitle(publisher);
        assertEquals(instance.getTitle(), "Moi");
    }
    
    @Test
    public void testGetPublisher() {
        String expResult = "Elukat";
        String result = incollection.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAuthor method, of class Inproceedings.
     */
    @Test
    public void testGetAuthor() {
        String expResult = "Jouko ja Jutta";
        String result = incollection.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBooktitle method, of class Inproceedings.
     */
    @Test
    public void testGetBooktitle() {
        String expResult = "Sopulin kulku";
        String result = incollection.getBooktitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Inproceedings.
     */
    @Test
    public void testGetTitle() {
        String expResult = "Kiertoreitti";
        String result = incollection.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Inproceedings.
     */
    @Test
    public void testGetYear() {
        int expResult = 2015;
        int result = incollection.getYear();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToBibText() {
        String bibTex = BibTexGenerator.generateEntry(incollection);
        assertTrue(bibTex.contains("@incollection{jj15"));
        assertTrue(bibTex.contains("author = {Jouko ja Jutta}"));
        assertTrue(bibTex.contains("title = {Kiertoreitti}"));
        assertTrue(bibTex.contains("booktitle = {Sopulin kulku}"));
        assertTrue(bibTex.contains("publisher = {Elukat}"));
        assertTrue(bibTex.contains("year = {2015}"));
    }
    
}
