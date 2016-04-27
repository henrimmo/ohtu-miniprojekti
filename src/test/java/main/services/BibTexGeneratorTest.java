package main.services;

import main.models.Article;
import main.models.Book;
import org.junit.Test;
import static org.junit.Assert.*;

public class BibTexGeneratorTest {

    @Test
    public void testGenerate() {
        Article article = new main.models.Article("puu08", "Mr. Puu", "Kuuset", "Luonto", 2008);
        Book book = new Book("liisa73", "Liisa", "Viikossa", "Kuustonen", 1873);

        BibTexGenerator generator = new BibTexGenerator();
        generator.addEntry(book);
        generator.addEntry(article);

        String bibtex = generator.generate();
        assertTrue(bibtex.contains(BibTexGenerator.generateEntry(article)));
        assertTrue(bibtex.contains(BibTexGenerator.generateEntry(book)));
    }

    @Test
    public void testEscapeSingleLowerCaseLatters() {
        assertEquals(BibTexGenerator.escape("test åäö"),
                "test {\\aa}\\\"{a}\\\"{o}");
    }

    @Test
    public void testEscapeSingleUpperCaseLatters() {
        assertEquals(BibTexGenerator.escape("TEST ÅÄÖ"),
                "TEST {\\AA}\\\"{A}\\\"{O}");
    }

    @Test
    public void testEscapeMultipleLatters() {
        assertEquals(BibTexGenerator.escape("ä å Ä Ö Å ö"),
                "\\\"{a} {\\aa} \\\"{A} \\\"{O} {\\AA} \\\"{o}");
    }

}
