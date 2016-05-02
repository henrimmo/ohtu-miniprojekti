//
//package main.models;
//
//import main.services.BibTexGenerator;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class ManualTest {
//    
//    private final String title1 = "Kissakirja2";
//    private final Manual manual = new Manual("kk", title1);
//    
//    public ManualTest() {
//    }
//    
//    /**
//     * Test of setTitle method, of class Manual.
//     */
//    @Test
//    public void testSetTitle() {
//        String title = "Oravat kuussa";
//        Manual instance = new Manual();
//        instance.setTitle(title);
//        assertEquals(instance.getTitle(), "Oravat kuussa");
//    }
//
//    /**
//     * Test of getTitle method, of class Manual.
//     */
//    @Test
//    public void testGetTitle() {
//        String expResult = "Kissakirja2";
//        String result = manual.getTitle();
//        assertEquals(expResult, result);
//    }
//
//    
//    @Test
//    public void testToBibText() {
//        String bibTex = BibTexGenerator.generateEntry(manual);
//        assertTrue(bibTex.contains("@booklet{kk"));
//        assertTrue(bibTex.contains("title = {Kissakirja2}"));
//    }
//    
//}

package main.models;

import main.services.BibTexGenerator;
import org.junit.Test;
import static org.junit.Assert.*;

public class ManualTest {
    
    private final String title1 = "Kissakirja2";
    private final Manual manual = new Manual("kk", title1);
    
    public ManualTest() {
    }
    
    /**
     * Test of setTitle method, of class Manual.
     */
    @Test
    public void testSetTitle() {
        String title = "Oravat kuussa";
        Manual instance = new Manual();
        instance.setTitle(title);
        assertEquals(instance.getTitle(), "Oravat kuussa");
    }

    /**
     * Test of getTitle method, of class Manual.
     */
    @Test
    public void testGetTitle() {
        String expResult = "Kissakirja2";
        String result = manual.getTitle();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testToBibText() {
        String bibTex = BibTexGenerator.generateEntry(manual);
        assertTrue(bibTex.contains("@manual{kk"));
        assertTrue(bibTex.contains("title = {Kissakirja2}"));
    }
    
}
