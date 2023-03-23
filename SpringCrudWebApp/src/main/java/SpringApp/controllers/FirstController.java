package SpringApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(Model model,
                             @RequestParam(value = "f", required = false) Integer first,
                             @RequestParam(value = "s", required = false) Integer second,
                             @RequestParam(value = "o", required = false) String operation){
        double result = 0;
        if (first != null && second != null){
            switch (operation){
                case "sum": result = first + second; break;
                case "sub": result = first - second; break;
                case "mul": result = first * second; break;
                case "div": result = first / (float)second; break;
            }
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
