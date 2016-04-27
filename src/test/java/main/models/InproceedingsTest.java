
package main.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InproceedingsTest {
    private String author1 = "Jouko ja Jutta";
    private String title1 = "Kiertoreitti";
    private String booktitle1 = "Sopulin kulku";
    private int year1 = 2015;
    private Inproceedings inproceedings = new Inproceedings("jj15", author1, title1, booktitle1, year1);
    
    public InproceedingsTest() {
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
        Inproceedings instance = new Inproceedings();
        instance.setAuthor(author);
        assertEquals(instance.getAuthor(), "Herra");
    }

    /**
     * Test of setBooktitle method, of class Inproceedings.
     */
    @Test
    public void testSetBooktitle() {
        String booktitle = "Jaha";
        Inproceedings instance = new Inproceedings();
        instance.setBooktitle(booktitle);
        assertEquals(instance.getBooktitle(), "Jaha");
    }

    /**
     * Test of setTitle method, of class Inproceedings.
     */
    @Test
    public void testSetTitle() {
        String title = "Oho";
        Inproceedings instance = new Inproceedings();
        instance.setTitle(title);
        assertEquals(instance.getTitle(), "Oho");
    }

    /**
     * Test of setYear method, of class Inproceedings.
     */
    @Test
    public void testSetYear() {
        int year = 2000;
        Inproceedings instance = new Inproceedings();
        instance.setYear(year);
        assertEquals(instance.getYear(), 2000);
    }

    /**
     * Test of getAuthor method, of class Inproceedings.
     */
    @Test
    public void testGetAuthor() {
        String expResult = "Jouko ja Jutta";
        String result = inproceedings.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBooktitle method, of class Inproceedings.
     */
    @Test
    public void testGetBooktitle() {
        String expResult = "Sopulin kulku";
        String result = inproceedings.getBooktitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Inproceedings.
     */
    @Test
    public void testGetTitle() {
        String expResult = "Kiertoreitti";
        String result = inproceedings.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Inproceedings.
     */
    @Test
    public void testGetYear() {
        int expResult = 2015;
        int result = inproceedings.getYear();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToBibText() {
        assertEquals("@INPROCEEDINGS{jj15,\n"
                + "    author = {Jouko ja Jutta},\n"
                + "    title = {Kiertoreitti},\n"
                + "    booktitle = {Sopulin kulku},\n"
                + "    year = {2015},\n"
                + "}\n",
                inproceedings.toBibTex());
    }
    
}
