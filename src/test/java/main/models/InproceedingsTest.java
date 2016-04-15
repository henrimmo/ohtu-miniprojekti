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
 * @author Outi
 */
public class InproceedingsTest {
    
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
        System.out.println("setAuthor");
        String author = "";
        Inproceedings instance = new Inproceedings();
        instance.setAuthor(author);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBooktitle method, of class Inproceedings.
     */
    @Test
    public void testSetBooktitle() {
        System.out.println("setBooktitle");
        String booktitle = "";
        Inproceedings instance = new Inproceedings();
        instance.setBooktitle(booktitle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Inproceedings.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Inproceedings instance = new Inproceedings();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setYear method, of class Inproceedings.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        int year = 0;
        Inproceedings instance = new Inproceedings();
        instance.setYear(year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthor method, of class Inproceedings.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Inproceedings instance = new Inproceedings();
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBooktitle method, of class Inproceedings.
     */
    @Test
    public void testGetBooktitle() {
        System.out.println("getBooktitle");
        Inproceedings instance = new Inproceedings();
        String expResult = "";
        String result = instance.getBooktitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Inproceedings.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Inproceedings instance = new Inproceedings();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYear method, of class Inproceedings.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Inproceedings instance = new Inproceedings();
        int expResult = 0;
        int result = instance.getYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
