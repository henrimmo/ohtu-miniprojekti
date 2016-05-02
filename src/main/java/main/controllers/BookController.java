
package main.controllers;

import main.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.BookRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    
    
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Book book, Model model) {
        bookRepository.save(book);
        model.addAttribute("object", book);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable String id){
        Book b = bookRepository.findOne(id);
        bookRepository.delete(b);
        
        return "redirect:/";
    }
    
    
    
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable String id, Model model){
        Book b = bookRepository.findOne(id);
        model.addAttribute(b);
        
        return "book";
    }
}
