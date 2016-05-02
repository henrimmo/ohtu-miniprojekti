package main.controllers;


import main.models.Article;
import main.models.Book;
import main.models.Inproceedings;
import main.repositories.ArticleRepository;
import main.repositories.BookRepository;
import main.repositories.BookletRepository;
import main.repositories.InbookRepository;
import main.repositories.InproceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Profile("dev")
@Controller
public class TestController {
    
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private InproceedingsRepository inproceedingsRepository;
    
    @RequestMapping(value = "/addtestdata")
    @ResponseBody
    public String addTestData(MainController mainController) {
        Article a1 = new Article("test00", "Test Author", "Test title", "Test Journal", 2000);
        a1.setTag("test1");
        Article a2 = new Article("second01", "Second Author", "Second title", "Someother Journal", 2001);
        a2.setTag("test2");
        Book b = new Book("book16", "Book Author", "Book 1", "Publisher 1", 2016);
        b.setTag("test1");
        Inproceedings i = new Inproceedings("inp16", "Inproceedings Author", "Inproceedings 1", "Booktitle 1", 2016);
        articleRepository.save(a1);
        articleRepository.save(a2);
        bookRepository.save(b);
        inproceedingsRepository.save(i);
        return "OK";
    }

    @RequestMapping(value = "/deletetestdata", method = RequestMethod.GET)
    @ResponseBody
    public String deleteTestD(MainController mainController) {
        Article a1 = articleRepository.findOne("test00");
        Article a2 = articleRepository.findOne("second01");
        Book b = bookRepository.findOne("book16");
        Inproceedings i = inproceedingsRepository.findOne("inp16");
        articleRepository.delete(a1);
        articleRepository.delete(a2);
        bookRepository.delete(b);
        inproceedingsRepository.delete(i);
        
        return "OK";
    }
}
