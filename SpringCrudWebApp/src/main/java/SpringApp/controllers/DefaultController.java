package SpringApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DefaultController {

    @GetMapping("")
    public String security(){
        return "second/security";
    }

    @PostMapping("/login")
    public String auth(){
        return "first/default";
    }
}
