
package main.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import main.services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
    private String lastTag;
    
    @Autowired
    private DatabaseService databaseService;

    @RequestMapping("/bibtex")
    @ResponseBody
    public void getAllBibtext(HttpServletResponse response) throws IOException{
        String filename = "bibtex.bib"; //...
        String result;
        
        if(lastTag==null){
            result = databaseService.getAllAsBibtex();
        }else{
            result = databaseService.getToBibTexByTag(lastTag);
        }
        
        response.setContentType("text/bib");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + filename + "\"");
        response.getOutputStream().print(result);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(value="tag", required=false) String  tag) {
        if(tag==null){
            databaseService.addAllToModel(model);
            lastTag = null;
        }else{
            databaseService.addToModelByTag(model, tag);
            lastTag = tag;
        }
        return "index";
    }
}
