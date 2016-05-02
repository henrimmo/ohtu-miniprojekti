
package main.controllers;

import main.models.Inproceedings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.InproceedingsRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("inproceedings")
public class InproceedingsController {
    @Autowired
    private InproceedingsRepository inproceedingsRepository;
    
    
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("inproceedings", new Inproceedings());
        return "inproceedings";
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Inproceedings inproceedings, Model model) {
        inproceedingsRepository.save(inproceedings);
        model.addAttribute("object", inproceedings);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable String id){
        Inproceedings i = inproceedingsRepository.findOne(id);
        inproceedingsRepository.delete(i);
        
        return "redirect:/";
    }
    
    @Transactional
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editInproceedings(@PathVariable String id, Model model){
        Inproceedings i = inproceedingsRepository.findOne(id);
        model.addAttribute(i);
        
        return "inproceedings";
    }
}
