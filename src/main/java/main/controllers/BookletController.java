
package main.controllers;

import main.models.Booklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.BookletRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("booklets")
public class BookletController {
    @Autowired
    private BookletRepository bookletRepository;
    
    //Simple test for database
    @RequestMapping("/test")
    @ResponseBody
    public String bookRepositoryTest(){
        if(bookletRepository.findAll().isEmpty()){
            Booklet b = new Booklet();
            b.setId("TEST");
            b.setTitle("Test name");
            bookletRepository.save(b);
        }
        
        Booklet r = bookletRepository.findOne(1L);
        return r.toBibTex();
    }
    
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
}
