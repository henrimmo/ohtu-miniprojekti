package main;




import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class TestController {
    
    @RequestMapping("/")
    public String test(){
        return "Pallot - ohtu-miniprojekti";
    }
}
