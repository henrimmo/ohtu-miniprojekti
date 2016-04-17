
package main.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import main.BibTexGenerator;
import main.models.Article;
import main.models.Book;
import main.models.Inproceedings;
import main.repositories.ArticleRepository;
import main.repositories.BookRepository;
import main.repositories.InproceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private InproceedingsRepository inproceedingsRepository;

    @RequestMapping("/bibtex")
    @ResponseBody
    public void getAllBibtext(HttpServletResponse response) throws IOException{
        String filename = "bibtex.bib"; //...
        
        BibTexGenerator generator = new BibTexGenerator();
        for(Article a: articleRepository.findAll()){
            generator.addEntry(a);
        }
        for(Book b: bookRepository.findAll()){
            generator.addEntry(b);
        }
        for(Inproceedings i: inproceedingsRepository.findAll()){
            generator.addEntry(i);
        }
        
        response.setContentType("text/bib");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + filename + "\"");
        response.getOutputStream().print(generator.generate());
    }
    
    @RequestMapping("/addtestdata")
    @ResponseBody
    public String addTestData(){
        Article a1 = new Article("Test Author","Test title","Test Journal",2000);
        Article a2 = new Article("Second Author","Second title","Someother Journal",2001);
        Book b = new Book("Book Author","Book 1","Publisher 1",2016);
        Inproceedings i = new Inproceedings("Inproceedings Author","Inproceedings 1","Booktitle 1",2016);
        
        articleRepository.save(a1);
        articleRepository.save(a2);
        bookRepository.save(b);
        inproceedingsRepository.save(i);
        
        return "OK";
    }
}
