package main.controllers;

import main.models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.ArticleRepository;

@Controller
@RequestMapping("articles")
public class ArticleController {
    
    /*
    Artikkeleitä voidaan hakea esim:
    kaikki artikkelit:          articleRepository.findAll();
    id:n perusteella(long):     articleRepository.findOne(id);
    jonkin kentän perusteella:  articleRepository.findBy[kentän nimi](etsittävän kentän arvo);
    
    Että ne saataisiin näkymälle ne pitää tallettaa modeliin
    (ks. http://wepa-2014.herokuapp.com/material/public_html/index.html#viikko1 kohta 3.4 tietokantojen käyttäminen)
    */
    @Autowired
    private ArticleRepository articleRepository;
    
    //Simple test for database
    @RequestMapping("/test")
    public String articleRepositoryTest(){
        if(articleRepository.findAll().isEmpty()){
            Article a = new Article();
            a.setTitle("Test name");
            a.setJournal("Test journal");
            a.setAuthor("Test Author");
            a.setVolume(1);
            a.setYear(2016);
            articleRepository.save(a);
        }
        
        Article r = articleRepository.findOne(1L);
        return r.getTitle() + ", " + r.getAuthor();
    }
}
