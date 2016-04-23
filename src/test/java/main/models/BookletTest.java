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
    
    private String title1 = "Kissakirja2";
    private Booklet booklet = new Booklet("kk", title1);
    
    public BookletTest() {
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
        assertEquals("@BOOKLET{kk, " +
                "title={Kissakirja2}}",
                booklet.toBibTex());
    }
    
}
