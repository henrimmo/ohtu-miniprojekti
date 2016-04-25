
package main.controllers;


import main.models.Inbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.InbookRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("inbooks")
public class InbookController {
    @Autowired
    private InbookRepository inbookRepository;
    

    
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("inbook", new Inbook());
        return "inbook";
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Inbook inbook, Model model) {
        inbookRepository.save(inbook);
        model.addAttribute("object", inbook);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable String id){
        Inbook b = inbookRepository.findOne(id);
        inbookRepository.delete(b);
        
        return "redirect:/";
    }
    
   
}
