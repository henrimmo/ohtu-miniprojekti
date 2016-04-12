package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import repositories.ArticleRepository;

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
    
    
}
