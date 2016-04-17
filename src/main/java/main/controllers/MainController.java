
package main.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import main.models.Article;
import main.models.Book;
import main.models.Inproceedings;
import main.repositories.ArticleRepository;
import main.repositories.BookRepository;
import main.repositories.InproceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private InproceedingsRepository inproceedingsRepository;

    @RequestMapping("/bibtex")
    @ResponseBody
    public void getAllBibtext(HttpServletResponse response) throws IOException{
        String filename = "bibtex.bib"; //...
        
        String s = "";
        for(Article a: articleRepository.findAll()){
            s += a.toBibText() + "\n";
        }
        for(Book b: bookRepository.findAll()){
            s += b.toBibText() + "\n";
        }
        for(Inproceedings i: inproceedingsRepository.findAll()){
            s += i.toBibText() + "\n";
        }
        
        
        File file = new File(filename);
        PrintWriter out = new PrintWriter(file);
        out.append(s);
        out.close();
        
        InputStream is = new FileInputStream(file);
        response.setContentType("text/bib");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + file.getName() + "\"");
        
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }
    
    @RequestMapping("/addtestdata")
    @ResponseBody
    public String addTestData(){
        Article a1 = new Article("Test Author","Test title","Test Journal",2000);
        Article a2 = new Article("Second Author","Second title","Someother Journal",2001);
        Book b = new Book("Book Author","Book 1","Publisher 1",2016);
        Inproceedings i = new Inproceedings("Inproceedings Author","Inproceedings 1","Booktitle 1",2016);
        
        articleRepository.save(a1);
        articleRepository.save(a2);
        bookRepository.save(b);
        inproceedingsRepository.save(i);
        
        return "OK";
    }
}
