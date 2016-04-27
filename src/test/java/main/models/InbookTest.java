/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.models;

import main.services.BibTexGenerator;
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
    private String publisher1 ="WSÖY";
    private int year1 = 2015;
    private Inbook inbook = new Inbook("jj15", author1, title1, chapter1, publisher1, year1);
    
    public InbookTest() {
    }
    

    
    @Test
    public void testToBibText() {
        String bibTex = BibTexGenerator.generateEntry(inbook);
        assertTrue(bibTex.contains("@inbook{jj15,"));
        assertTrue(bibTex.contains("author = {Jouko ja Jutta}"));
        assertTrue(bibTex.contains("title = {Kiertoreitti}"));
        assertTrue(bibTex.contains("chapter = {2}"));
        assertTrue(bibTex.contains("publisher = {WS\\\"{O}Y}"));
        assertTrue(bibTex.contains("year = {2015}"));
    }
    
}
