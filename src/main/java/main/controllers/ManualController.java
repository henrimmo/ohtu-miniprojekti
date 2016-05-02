
package main.controllers;

import main.models.Manual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.ManualRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("manuals")
public class ManualController {
    @Autowired
    private ManualRepository manualRepository;
    
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("manual", new Manual());
        return "manual";
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Manual manual, Model model) {
        manualRepository.save(manual);
        model.addAttribute("object", manual);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable String id){
        Manual m = manualRepository.findOne(id);
        manualRepository.delete(m);
        
        return "redirect:/";
    }
}
