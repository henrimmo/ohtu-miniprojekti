
package main.services;

import main.models.*;
import main.repositories.*;
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
    @Autowired
    private ManualRepository manualRepository;
    @Autowired
    private IncollectionRepository incollectionRepository;
    
    public void addAllToModel(Model model){
        model.addAttribute("aList", articleRepository.findAll());
        model.addAttribute("bList", bookRepository.findAll());
        model.addAttribute("iList", inproceedingsRepository.findAll());
        model.addAttribute("blList", bookletRepository.findAll());
        model.addAttribute("ibList", inbookRepository.findAll());
        model.addAtrribute("mList", manualRepository.findAll());
        model.addAtrribute("incList", incollectionRepository.findAll());
    }
    
    public void addToModelByTag(Model model, String tag){
        model.addAttribute("aList", articleRepository.findByTag(tag));
        model.addAttribute("bList", bookRepository.findByTag(tag));
        model.addAttribute("iList", inproceedingsRepository.findByTag(tag));
        model.addAttribute("blList", bookletRepository.findByTag(tag));
        model.addAttribute("ibList", inbookRepository.findByTag(tag));
        model.addAtrribute("mList", manualRepository.findByTag(tag));
        model.addAtrribute("incList", incollectionRepository.findByTag(tag));
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
        
        for(Manual m: manualRepository.findAll()){
            generator.addEntry(m);
        }
        
        for(Incollection i: incollectionRepository.findAll()){
            generator.addEntry(i);
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
        
        for(Manual m: manualRepository.findByTag(tag)){
            generator.addEntry(m);
        }
        
        for(Incollection i: incollectionRepository.findByTag(tag)){
            generator.addEntry(i);
        }
        
        return generator.generate();
    }
}
