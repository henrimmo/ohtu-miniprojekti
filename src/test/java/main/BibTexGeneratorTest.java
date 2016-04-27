package main;

import main.services.BibTexGenerator;
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
        assertTrue(bibtex.contains(article.toBibTex()));
        assertTrue(bibtex.contains(book.toBibTex()));
    }

}
