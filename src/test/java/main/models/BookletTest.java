/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henri
 */
public class BookletTest {
    
    private String cite = "SWEBOK";
    private String title1 = "Kissakirja2";
    private Booklet booklet = new Booklet(cite, title1);
    
    public BookletTest() {
    }
    
    /**
     * Test of setCite method, of class Booklet.
     */
    @Test
    public void testSetCite() {
        String publisher = "COMP";
        Booklet instance = new Booklet();
        instance.setCite(publisher);
        assertEquals(instance.getCite(), "COMP");
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @Test
    public void testSetTitle() {
        String title = "Oravat kuussa";
        Booklet instance = new Booklet();
        instance.setTitle(title);
        assertEquals(instance.getTitle(), "Oravat kuussa");
    }


    /**
     * Test of getCite method, of class Booklet.
     */
    @Test
    public void testGetCite() {
        String expResult = "SWEBOK";
        String result = booklet.getCite();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Booklet.
     */
    @Test
    public void testGetTitle() {
        String expResult = "Kissakirja2";
        String result = booklet.getTitle();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testToBibText() {
        assertEquals("@BOOKLET{SWEBOK, " +
                "title={Kissakirja2}}",
                booklet.toBibTex());
    }
    
}
