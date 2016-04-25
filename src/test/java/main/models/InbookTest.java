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
public class InbookTest {
    private String author1 = "Jouko ja Jutta";
    private String title1 = "Kiertoreitti";
    private String chapter1 = "2";
    private String publisher1 ="WSOY";
    private int year1 = 2015;
    private Inbook inbook = new Inbook("jj15", author1, title1, chapter1, publisher1, year1);
    
    public InbookTest() {
    }
    

    
    @Test
    public void testToBibText() {
        assertEquals("@INBOOK{jj15, author={Jouko ja Jutta}, " +
                "title={Kiertoreitti}, chapter={2}, publisher={WSOY}, year={2015},}",
                inbook.toBibTex());
    }
    
}
