
package main.controllers;

import main.models.Booklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.BookletRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("booklets")
public class BookletController {
    @Autowired
    private BookletRepository bookletRepository;
    
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("booklet", new Booklet());
        return "booklet";
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Booklet booklet, Model model) {
        bookletRepository.save(booklet);
        model.addAttribute("object", booklet);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable String id){
        Booklet b = bookletRepository.findOne(id);
        bookletRepository.delete(b);
        
        return "redirect:/";
    }
}
