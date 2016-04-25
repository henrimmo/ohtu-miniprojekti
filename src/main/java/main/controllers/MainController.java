
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
import main.models.Booklet;
import main.models.Inproceedings;
import main.repositories.ArticleRepository;
import main.repositories.BookRepository;
import main.repositories.BookletRepository;
import main.repositories.InproceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
    
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private InproceedingsRepository inproceedingsRepository;
    @Autowired
    private BookletRepository bookletRepository;

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
        for(Booklet bl: bookletRepository.findAll()){
            generator.addEntry(bl);
        }
        
        response.setContentType("text/bib");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + filename + "\"");
        response.getOutputStream().print(generator.generate());
    }
    
    @RequestMapping("/addtestdata")
    @ResponseBody
    public String addTestData(){
        Article a1 = new Article("test00", "Test Author","Test title","Test Journal",2000);
        Article a2 = new Article("second01","Second Author","Second title","Someother Journal",2001);
        Book b = new Book("book16","Book Author","Book 1","Publisher 1",2016);
        Inproceedings i = new Inproceedings("inp16","Inproceedings Author","Inproceedings 1","Booktitle 1",2016);
        
        articleRepository.save(a1);
        articleRepository.save(a2);
        bookRepository.save(b);
        inproceedingsRepository.save(i);
        
        return "OK";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("aList", articleRepository.findAll());
        model.addAttribute("bList", bookRepository.findAll());
        model.addAttribute("iList", inproceedingsRepository.findAll());
        model.addAttribute("blList", bookletRepository.findAll());
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTest(){
        Article a1 = new Article("test00", "Test Author","Test title","Test Journal",2000);
        Article a2 = new Article("second01","Second Author","Second title","Someother Journal",2001);
        
        articleRepository.save(a1);
        articleRepository.save(a2);
        articleRepository.delete(articleRepository.findOne(Long.parseLong(a2.getId())));
        
        return "OK";
    }
}
