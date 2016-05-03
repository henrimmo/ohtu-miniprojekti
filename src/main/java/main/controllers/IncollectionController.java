
package main.controllers;

import main.models.Incollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.IncollectionRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("incollections")
public class IncollectionController {
    @Autowired
    private IncollectionRepository incollectionRepository;
    
    
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("incollection", new Incollection());
        return "incollection";
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Incollection incollection, Model model) {
        incollectionRepository.save(incollection);
        model.addAttribute("object", incollection);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable String id){
        Incollection i = incollectionRepository.findOne(id);
        incollectionRepository.delete(i);
        
        return "redirect:/";
    }
}
