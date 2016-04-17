
package main.controllers;

import main.repositories.ArticleRepository;
import main.repositories.BookRepository;
import main.repositories.InproceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("list")
public class ListController {
    
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private InproceedingsRepository inproceedingsRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("aList", articleRepository.findAll());
        model.addAttribute("bList", bookRepository.findAll());
        model.addAttribute("iList", inproceedingsRepository.findAll());
        return "list";
    }
    
}
