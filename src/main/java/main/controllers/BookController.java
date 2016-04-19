
package main.controllers;

import main.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import main.repositories.BookRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    
    //Simple test for database
    @RequestMapping("/test")
    @ResponseBody
    public String bookRepositoryTest(){
        if(bookRepository.findAll().isEmpty()){
            Book b = new Book();
            b.setTitle("Test name");
            b.setPublisher("Test publisher");
            b.setAuthor("Test Author");
            b.setYear(2016);
            bookRepository.save(b);
        }
        
        Book r = bookRepository.findOne(1L);
        return r.toBibTex();
    }
    
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
}
