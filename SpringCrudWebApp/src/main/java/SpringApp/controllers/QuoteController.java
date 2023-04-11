package SpringApp.controllers;

import SpringApp.models.QuotesAPI;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/quote")
public class QuoteController {

    @GetMapping
    public String getQuote(Model model){
        QuotesAPI quotesAPI = new QuotesAPI();
        JSONObject json = quotesAPI.getQuoteFromAPI();
        if (json != null){
            model.addAttribute("quote", json.getString("quoteText"));
            model.addAttribute("quoteAuthor", json.getString("quoteAuthor"));
            return "quote/showQuote";
        }else return "second/error";
    }
}
