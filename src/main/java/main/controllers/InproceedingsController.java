
package main.controllers;

import main.models.Inproceedings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.InproceedingsRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("inproceedings")
public class InproceedingsController {
    @Autowired
    private InproceedingsRepository inproceedingsRepository;
    
    //Simple test for database
    @RequestMapping("/test")
    @ResponseBody
    public String inproceedingsRepositoryTest(){
        if(inproceedingsRepository.findAll().isEmpty()){
            Inproceedings i = new Inproceedings();
            i.setTitle("Test name");
            i.setBooktitle("Test booktitle");
            i.setAuthor("Test Author");
            i.setYear(2016);
            inproceedingsRepository.save(i);
        }
        
        Inproceedings r = inproceedingsRepository.findOne(1L);
        return r.toBibTex();
    }
    
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
}
