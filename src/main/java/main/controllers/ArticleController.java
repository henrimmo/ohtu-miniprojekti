package main.controllers;


import main.models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.ArticleRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

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
        
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("article", new Article());
        return "article";
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Article article, Model model) {
        articleRepository.save(article);
        model.addAttribute("object", article);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable String id){
        Article a = articleRepository.findOne(id);
        articleRepository.delete(a);
        
        return "redirect:/";
    }
    @Transactional
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editArticle(@PathVariable String id, Model model){
        Article a = articleRepository.findOne(id);
        model.addAttribute(a);
        return "article";
    }
}
