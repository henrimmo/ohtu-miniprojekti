
package main.services;

import main.models.Article;
import main.models.Book;
import main.models.Booklet;
import main.models.Inbook;
import main.models.Inproceedings;
import main.repositories.ArticleRepository;
import main.repositories.BookRepository;
import main.repositories.BookletRepository;
import main.repositories.InbookRepository;
import main.repositories.InproceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class DatabaseService {
    
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private InproceedingsRepository inproceedingsRepository;
    @Autowired
    private BookletRepository bookletRepository;
    @Autowired
    private InbookRepository inbookRepository;
    
    public void addAllToModel(Model model){
        model.addAttribute("aList", articleRepository.findAll());
        model.addAttribute("bList", bookRepository.findAll());
        model.addAttribute("iList", inproceedingsRepository.findAll());
        model.addAttribute("blList", bookletRepository.findAll());
        model.addAttribute("ibList", inbookRepository.findAll());
    }
    
    public void addToModelByTag(Model model, String tag){
        model.addAttribute("aList", articleRepository.findByTag(tag));
        model.addAttribute("bList", bookRepository.findByTag(tag));
        model.addAttribute("iList", inproceedingsRepository.findByTag(tag));
        model.addAttribute("blList", bookletRepository.findByTag(tag));
        model.addAttribute("ibList", inbookRepository.findByTag(tag));
    }
    
    public String getAllAsBibtex(){
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
        
        for(Inbook ib: inbookRepository.findAll()){
            generator.addEntry(ib);
        }
        
        return generator.generate();
    }
    
    public String getToBibTexByTag(String tag){
        BibTexGenerator generator = new BibTexGenerator();
        for(Article a: articleRepository.findByTag(tag)){
            generator.addEntry(a);
        }
        for(Book b: bookRepository.findByTag(tag)){
            generator.addEntry(b);
        }
        for(Inproceedings i: inproceedingsRepository.findByTag(tag)){
            generator.addEntry(i);
        }
        for(Booklet bl: bookletRepository.findByTag(tag)){
            generator.addEntry(bl);
        }
        
        for(Inbook ib: inbookRepository.findByTag(tag)){
            generator.addEntry(ib);
        }
        
        return generator.generate();
    }
}
